package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_types.AbstractWrappedType;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * A class to wrap a {@code TypeFloat}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:02
 * @see TypeFloat
 */
public class WrappedFloat extends AbstractWrappedType {

    private final TypeFloat typeFloat;

    /**
     * Constructor.
     *
     * @param typeFloat a type float
     */
    public WrappedFloat(TypeFloat typeFloat) {
        this.typeFloat = typeFloat;
    }

    /**
     * Constructor.
     *
     * @param value a double
     */
    public WrappedFloat(double value) {
        this.typeFloat = new TypeFloat(value);
    }

    /**
     * Returns the adaptee, specifying the current type inside.
     *
     * @return a new instance of {@code TypeFloat}
     */
    protected TypeFloat getRawAdaptee() {
        return new TypeFloat(this.typeFloat.getValue());
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
        return "WrappedFloat{" +
            "value=" + typeFloat.getValue() +
            '}';
    }

    /**
     * Transform the current instance to a {@code WrappedFloat}.
     *
     * @return a {@code WrappedFloat} equivalent
     */
    @Override
    public WrappedFloat toWrappedFloat() {
        TypeFloat computed = this.typeFloat.toTypeFloat();
        return new WrappedFloat(computed);
    }

    /**
     * Transform the current instance to a {@code WrappedString}.
     *
     * @return a {@code WrappedString} equivalent
     */
    @Override
    public WrappedString toWrappedString() {
        TypeString computed = this.typeFloat.toTypeString();
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
        return wType.addWithFloat(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param wType another number
     * @return the division
     */
    @Override
    public WType div(WType wType) {
        return wType.divWithFloat(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param wType another number
     * @return the multiplication
     */
    @Override
    public WType mult(WType wType) {
        return wType.multWithFloat(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param wType another number
     * @return the subtraction
     */
    @Override
    public WType sub(WType wType) {
        return wType.subWithFloat(this);
    }

    /**
     * Returns the disjunction between logicals
     *
     * @param wType another logical
     * @return the disjunction
     */
    @Override
    public WType and(WType wType) {
        return wType.andWithFloat(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param wType another logical
     * @return the conjunction
     */
    @Override
    public WType or(WType wType) {
        return wType.orWithFloat(this);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeFloat.addWithFloat(wFloat.getRawAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithInt(WrappedInt wInt) {
        TypeFloat computed = (TypeFloat) this.typeFloat.addWithInt(wInt.getRawAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeFloat.subWithFloat(wFloat.getRawAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     *
     *
     */
    @Override
    public WType subWithInt(WrappedInt wInt) {
        TypeFloat computed = (TypeFloat) this.typeFloat.subWithInt(wInt.getRawAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     */
    @Override
    public WType multWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeFloat.multWithFloat(wFloat.getRawAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     */
    @Override
    public WType multWithInt(WrappedInt wInt) {
        TypeFloat computed = (TypeFloat) this.typeFloat.multWithInt(wInt.getRawAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     */
    @Override
    public WType divWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeFloat.divWithFloat(wFloat.getRawAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     */
    @Override
    public WType divWithInt(WrappedInt wInt) {
        TypeFloat computed = (TypeFloat) this.typeFloat.divWithInt(wInt.getRawAdaptee());
        return new WrappedFloat(computed);
    }
}
