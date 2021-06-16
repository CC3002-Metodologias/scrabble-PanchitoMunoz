package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_types.AbstractWrappedType;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * A class to wrap a {@code TypeBinary}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:01
 * @see TypeBinary
 */
public class WrappedBinary extends AbstractWrappedType {

    private final TypeBinary typeBinary;

    /**
     * Constructor.
     *
     * @param typeBinary a Type Binary
     */
    public WrappedBinary(TypeBinary typeBinary) {
        this.typeBinary = typeBinary;
    }

    /**
     * Constructor
     *
     * @param value a string binary
     */
    public WrappedBinary(String value) {
        this.typeBinary = new TypeBinary(value);
    }

    /**
     * Returns the adaptee, specifying the current type inside.
     *
     * @return a new instance of {@code TypeBinary}
     */
    protected TypeBinary getRawAdaptee() {
        return new TypeBinary(this.typeBinary.getValue());
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public SType getAdaptee() {
        return this.getRawAdaptee();
    }

    @Override
    public String toString() {
        return "WrappedBinary{" +
            "value=" + typeBinary.getValue() +
            '}';
    }

    /**
     * Transform the current instance to a {@code WrappedBinary}.
     *
     * @return a {@code WrappedBinary} equivalent
     */
    @Override
    public WrappedBinary toWrappedBinary() {
        TypeBinary computed = this.typeBinary.toTypeBinary();
        return new WrappedBinary(computed);
    }

    /**
     * Transform the current instance to a {@code WrappedFloat}.
     *
     * @return a {@code WrappedFloat} equivalent
     */
    @Override
    public WrappedFloat toWrappedFloat() {
        TypeFloat computed = this.typeBinary.toTypeFloat();
        return new WrappedFloat(computed);
    }

    /**
     * Transform the current instance to a {@code WrappedInt}.
     *
     * @return a {@code WrappedInt} equivalent
     */
    @Override
    public WrappedInt toWrappedInt() {
        TypeInt computed = this.typeBinary.toTypeInt();
        return new WrappedInt(computed);
    }

    /**
     * Transform the current instance to a {@code WrappedString}.
     *
     * @return a {@code WrappedString} equivalent
     */
    @Override
    public WrappedString toWrappedString() {
        TypeString computed = this.typeBinary.toTypeString();
        return new WrappedString(computed);
    }

    /**
     * Returns the sum
     *
     * @param wType other type to sum
     * @return the sum
     */
    @Override
    public WType add(WType wType) {
        return wType.addWithBinary(this);
    }

    /**
     * Returns the disjunction between logicals
     *
     * @param wType another logical
     * @return the disjunction
     */
    @Override
    public WType and(WType wType) {
        return wType.andWithBinary(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param wType another number
     * @return the division
     */
    @Override
    public WType div(WType wType) {
        return wType.divWithBinary(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param wType another number
     * @return the multiplication
     */
    @Override
    public WType mult(WType wType) {
        return wType.multWithBinary(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param wType another logical
     * @return the conjunction
     */
    @Override
    public WType or(WType wType) {
        return wType.orWithBinary(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param wType another number
     * @return the subtraction
     */
    @Override
    public WType sub(WType wType) {
        return wType.subWithBinary(this);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.addWithBinary(wBinary.getRawAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeBinary.addWithFloat(wFloat.getRawAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithInt(WrappedInt wInt) {
        TypeInt computed = (TypeInt) this.typeBinary.addWithInt(wInt.getRawAdaptee());
        return new WrappedInt(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.subWithBinary(wBinary.getRawAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeBinary.subWithFloat(wFloat.getRawAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithInt(WrappedInt wInt) {
        TypeInt computed = (TypeInt) this.typeBinary.subWithInt(wInt.getRawAdaptee());
        return new WrappedInt(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WType multWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.multWithBinary(wBinary.getRawAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WType multWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeBinary.multWithFloat(wFloat.getRawAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WType multWithInt(WrappedInt wInt) {
        TypeInt computed = (TypeInt) this.typeBinary.multWithInt(wInt.getRawAdaptee());
        return new WrappedInt(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WType divWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.divWithBinary(wBinary.getRawAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WType divWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeBinary.divWithFloat(wFloat.getRawAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WType divWithInt(WrappedInt wInt) {
        TypeInt computed = (TypeInt) this.typeBinary.divWithInt(wInt.getRawAdaptee());
        return new WrappedInt(computed);
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WType andWithBool(WrappedBool wBool) {
        TypeBinary computed = (TypeBinary) this.typeBinary.andWithBool(wBool.getRawAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WType andWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.andWithBinary(wBinary.getRawAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WType orWithBool(WrappedBool wBool) {
        TypeBinary computed = (TypeBinary) this.typeBinary.orWithBool(wBool.getRawAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WType orWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.orWithBinary(wBinary.getRawAdaptee());
        return new WrappedBinary(computed);
    }
}
