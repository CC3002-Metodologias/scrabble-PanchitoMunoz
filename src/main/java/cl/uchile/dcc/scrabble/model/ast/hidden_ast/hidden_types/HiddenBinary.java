package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.abstract_types.AbstractHiddenType;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * A class to wrap a {@code TypeBinary}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:01
 * @see TypeBinary
 */
public class HiddenBinary extends AbstractHiddenType {

    private final TypeBinary typeBinary;

    /**
     * Constructor.
     *
     * @param typeBinary a Type Binary
     */
    public HiddenBinary(TypeBinary typeBinary) {
        this.typeBinary = typeBinary;
    }

    /**
     * Constructor
     *
     * @param value a string binary
     */
    public HiddenBinary(String value) {
        this(new TypeBinary(value));
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeBinary getAdaptee() {
        return new TypeBinary(this.typeBinary.getValue());
    }

    @Override
    public String toString() {
        return "HiddenBinary{" +
            "value=" + typeBinary.getValue() +
            '}';
    }

    /**
     * Transform the current instance to a {@code HiddenBinary}.
     *
     * @return a {@code HiddenBinary} equivalent
     */
    @Override
    public HiddenBinary toWrappedBinary() {
        TypeBinary computed = this.typeBinary.toTypeBinary();
        return new HiddenBinary(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    @Override
    public HiddenFloat toWrappedFloat() {
        TypeFloat computed = this.typeBinary.toTypeFloat();
        return new HiddenFloat(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt} equivalent
     */
    @Override
    public HiddenInt toWrappedInt() {
        TypeInt computed = this.typeBinary.toTypeInt();
        return new HiddenInt(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    @Override
    public HiddenString toWrappedString() {
        TypeString computed = this.typeBinary.toTypeString();
        return new HiddenString(computed);
    }

    /**
     * Returns the sum
     *
     * @param hType other type to sum
     * @return the sum
     */
    @Override
    public HType add(HType hType) {
        return hType.addWithBinary(this);
    }

    /**
     * Returns the disjunction between logicals
     *
     * @param hType another logical
     * @return the disjunction
     */
    @Override
    public HType and(HType hType) {
        return hType.andWithBinary(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param hType another number
     * @return the division
     */
    @Override
    public HType div(HType hType) {
        return hType.divWithBinary(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param hType another number
     * @return the multiplication
     */
    @Override
    public HType mult(HType hType) {
        return hType.multWithBinary(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param hType another logical
     * @return the conjunction
     */
    @Override
    public HType or(HType hType) {
        return hType.orWithBinary(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param hType another number
     * @return the subtraction
     */
    @Override
    public HType sub(HType hType) {
        return hType.subWithBinary(this);
    }

    /**
     * Returns the negation of the current instance
     *
     * @return the negation.
     */
    @Override
    public HType neg() {
        return new HiddenBinary(this.typeBinary.neg());
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public HType addWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.addWithBinary(wBinary.getAdaptee());
        return new HiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public HType addWithFloat(HiddenFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeBinary.addWithFloat(wFloat.getAdaptee());
        return new HiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public HType addWithInt(HiddenInt wInt) {
        TypeInt computed = (TypeInt) this.typeBinary.addWithInt(wInt.getAdaptee());
        return new HiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public HType subWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.subWithBinary(wBinary.getAdaptee());
        return new HiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public HType subWithFloat(HiddenFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeBinary.subWithFloat(wFloat.getAdaptee());
        return new HiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public HType subWithInt(HiddenInt wInt) {
        TypeInt computed = (TypeInt) this.typeBinary.subWithInt(wInt.getAdaptee());
        return new HiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public HType multWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.multWithBinary(wBinary.getAdaptee());
        return new HiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public HType multWithFloat(HiddenFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeBinary.multWithFloat(wFloat.getAdaptee());
        return new HiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public HType multWithInt(HiddenInt wInt) {
        TypeInt computed = (TypeInt) this.typeBinary.multWithInt(wInt.getAdaptee());
        return new HiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public HType divWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.divWithBinary(wBinary.getAdaptee());
        return new HiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public HType divWithFloat(HiddenFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeBinary.divWithFloat(wFloat.getAdaptee());
        return new HiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public HType divWithInt(HiddenInt wInt) {
        TypeInt computed = (TypeInt) this.typeBinary.divWithInt(wInt.getAdaptee());
        return new HiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public HType andWithBool(HiddenBool wBool) {
        TypeBinary computed = (TypeBinary) this.typeBinary.andWithBool(wBool.getAdaptee());
        return new HiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public HType andWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.andWithBinary(wBinary.getAdaptee());
        return new HiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public HType orWithBool(HiddenBool wBool) {
        TypeBinary computed = (TypeBinary) this.typeBinary.orWithBool(wBool.getAdaptee());
        return new HiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public HType orWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.orWithBinary(wBinary.getAdaptee());
        return new HiddenBinary(computed);
    }
}
