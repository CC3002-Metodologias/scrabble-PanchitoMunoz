package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types.AbstractHiddenNumber;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge.HiddenFloatBridge;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeString;

// TODO: trasladar la lógica de las operaciones aquí y dejar SType como un adaptador
/**
 * A class to wrap a {@code TypeFloat}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:02
 * @see TypeFloat
 */
public class HiddenFloat extends AbstractHiddenNumber {

    private final TypeFloat typeFloat;
    private final HiddenFloatBridge bridge;

    /**
     * Constructor.
     *
     * @param typeFloat a type float
     */
    public HiddenFloat(TypeFloat typeFloat) {
        super(typeFloat);
        this.typeFloat = STypeFactory.createTypeFloat(typeFloat);
        this.bridge = new HiddenFloatBridge(this);
    }

    /**
     * Constructor.
     *
     * @param value a double
     */
    public HiddenFloat(double value) {
        this(STypeFactory.createTypeFloat(value));
    }

    /**
     * Returns the visitor
     *
     * @return a visitor
     */
    @Override
    public HiddenFloatBridge getBridge() {
        return bridge;
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeFloat asSType() {
        return STypeFactory.createTypeFloat(typeFloat);
    }

    @Override
    public String toString() {
        return "HiddenFloat{" +
            "value=" + typeFloat.getValue() +
            '}';
    }

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    @Override
    public HType toHiddenFloat() {
        TypeFloat computed = this.typeFloat.toTypeFloat();
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    @Override
    public HType toHiddenString() {
        TypeString computed = this.typeFloat.toTypeString();
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
        return hType.getBridge().addWithFloat(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param hType another number
     * @return the division
     */
    @Override
    public HType div(HType hType) {
        return hType.getBridge().divWithFloat(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param hType another number
     * @return the multiplication
     */
    @Override
    public HType mult(HType hType) {
        return hType.getBridge().multWithFloat(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param hType another number
     * @return the subtraction
     */
    @Override
    public HType sub(HType hType) {
        return hType.getBridge().subWithFloat(this);
    }
}
