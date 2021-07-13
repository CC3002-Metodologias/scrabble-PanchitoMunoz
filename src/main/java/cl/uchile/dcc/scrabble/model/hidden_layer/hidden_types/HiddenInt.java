package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types.AbstractHiddenInteger;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.operation_visitor.HiddenBoolVisitor;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.operation_visitor.HiddenIntVisitor;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.operation_visitor.HiddenTypeVisitor;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.TypeString;

// TODO: trasladar la lógica de las operaciones aquí y dejar SType como un adaptador
/**
 * A class to wrap a {@code TypeInt}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:02
 * @see TypeInt
 */
public class HiddenInt extends AbstractHiddenInteger {

    private final TypeInt typeInt;
    private final HiddenIntVisitor visitor;

    /**
     * Constructor.
     *
     * @param typeInt a type int
     */
    public HiddenInt(TypeInt typeInt) {
        super(typeInt);
        this.typeInt = STypeFactory.createTypeInt(typeInt);
        this.visitor = new HiddenIntVisitor(this);
    }

    /**
     * Constructor.
     *
     * @param value an int
     */
    public HiddenInt(int value) {
        this(STypeFactory.createTypeInt(value));
    }

    /**
     * Returns the visitor
     *
     * @return a visitor
     */
    @Override
    public HiddenIntVisitor getVisitor() {
        return visitor;
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeInt asSType() {
        return STypeFactory.createTypeInt(typeInt);
    }

    @Override
    public String toString() {
        return "HiddenInt{" +
            "value=" + typeInt.getValue() +
            '}';
    }

    /**
     * Transform the current instance to a {@code HiddenBinary}.
     *
     * @return a {@code HiddenBinary} equivalent
     */
    @Override
    public HType toHiddenBinary() {
        TypeBinary computed = this.typeInt.toTypeBinary();
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    @Override
    public HType toHiddenFloat() {
        TypeFloat computed = this.typeInt.toTypeFloat();
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt} equivalent
     */
    @Override
    public HType toHiddenInt() {
        TypeInt computed = this.typeInt.toTypeInt();
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    @Override
    public HType toHiddenString() {
        TypeString computed = this.typeInt.toTypeString();
        return HTypeFactory.createHiddenString(computed);
    }

    /**
     * Returns the sum
     *
     * @param hType other type to sum
     * @return the sum
     */
    @Override
    public HType add(HType hType) {
        return hType.getVisitor().addWithInt(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param hType another number
     * @return the division
     */
    @Override
    public HType div(HType hType) {
        return hType.getVisitor().divWithInt(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param hType another number
     * @return the multiplication
     */
    @Override
    public HType mult(HType hType) {
        return hType.getVisitor().multWithInt(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param hType another number
     * @return the subtraction
     */
    @Override
    public HType sub(HType hType) {
        return hType.getVisitor().subWithInt(this);
    }
}
