package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types;

import static cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory.createHiddenBinary;
import static cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory.createHiddenFloat;
import static cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory.createHiddenInt;
import static cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory.createHiddenString;
import static cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory.createInt;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.abstract_types.AbstractHiddenType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HType;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * A class to wrap a {@code TypeInt}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:02
 * @see TypeInt
 */
public class HiddenInt extends AbstractHiddenType {

    private final TypeInt typeInt;

    /**
     * Constructor.
     *
     * @param typeInt a type int
     */
    public HiddenInt(TypeInt typeInt) {
        this.typeInt = createInt(typeInt);
    }

    /**
     * Constructor.
     *
     * @param value an int
     */
    public HiddenInt(int value) {
        this(createInt(value));
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeInt toSType() {
        return createInt(typeInt);
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
    public HiddenBinary toHiddenBinary() {
        TypeBinary computed = this.typeInt.toTypeBinary();
        return createHiddenBinary(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    @Override
    public HiddenFloat toHiddenFloat() {
        TypeFloat computed = this.typeInt.toTypeFloat();
        return createHiddenFloat(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt} equivalent
     */
    @Override
    public HiddenInt toHiddenInt() {
        TypeInt computed = this.typeInt.toTypeInt();
        return createHiddenInt(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    @Override
    public HiddenString toHiddenString() {
        TypeString computed = this.typeInt.toTypeString();
        return createHiddenString(computed);
    }

    /**
     * Returns the sum
     *
     * @param hType other type to sum
     * @return the sum
     */
    @Override
    public HType add(HType hType) {
        return hType.addWithInt(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param hType another number
     * @return the division
     */
    @Override
    public HType div(HType hType) {
        return hType.divWithInt(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param hType another number
     * @return the multiplication
     */
    @Override
    public HType mult(HType hType) {
        return hType.multWithInt(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param hType another number
     * @return the subtraction
     */
    @Override
    public HType sub(HType hType) {
        return hType.subWithInt(this);
    }

    /**
     * Returns the disjunction between logicals
     *
     * @param hType another logical
     * @return the disjunction
     */
    @Override
    public HType and(HType hType) {
        return hType.andWithInt(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param hType another logical
     * @return the conjunction
     */
    @Override
    public HType or(HType hType) {
        return hType.orWithInt(this);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public HType addWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeInt.addWithBinary(wBinary.toSType());
        return createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public HType addWithFloat(HiddenFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeInt.addWithFloat(wFloat.toSType());
        return createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public HType addWithInt(HiddenInt wInt) {
        TypeInt computed = (TypeInt) this.typeInt.addWithInt(wInt.toSType());
        return createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public HType subWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeInt.subWithBinary(wBinary.toSType());
        return createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     *
     *
     */
    @Override
    public HType subWithFloat(HiddenFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeInt.subWithFloat(wFloat.toSType());
        return createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     *
     *
     */
    @Override
    public HType subWithInt(HiddenInt wInt) {
        TypeInt computed = (TypeInt) this.typeInt.subWithInt(wInt.toSType());
        return createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     */
    @Override
    public HType multWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeInt.multWithBinary(wBinary.toSType());
        return createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     */
    @Override
    public HType multWithFloat(HiddenFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeInt.multWithFloat(wFloat.toSType());
        return createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     */
    @Override
    public HType multWithInt(HiddenInt wInt) {
        TypeInt computed = (TypeInt) this.typeInt.multWithInt(wInt.toSType());
        return createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     */
    @Override
    public HType divWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeInt.divWithBinary(wBinary.toSType());
        return createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     */
    @Override
    public HType divWithFloat(HiddenFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeInt.divWithFloat(wFloat.toSType());
        return createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     */
    @Override
    public HType divWithInt(HiddenInt wInt) {
        TypeInt computed = (TypeInt) this.typeInt.divWithInt(wInt.toSType());
        return createHiddenInt(computed);
    }
}
