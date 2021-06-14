package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_types.AbstractWrappedType;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
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
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    protected SType getAdaptee() {
        return this.typeFloat;
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
        TypeFloat computed = (TypeFloat) ((SNumber) this.getAdaptee()).addWithFloat(
            (TypeFloat) wFloat.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithInt(WrappedInt wInt) {
        TypeFloat computed = (TypeFloat) ((SNumber) this.getAdaptee()).addWithInt(
            (TypeInt) wInt.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((SNumber) this.getAdaptee()).subWithFloat(
            (TypeFloat) wFloat.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     *
     *
     */
    @Override
    public WType subWithInt(WrappedInt wInt) {
        TypeFloat computed = (TypeFloat) ((SNumber) this.getAdaptee()).subWithInt(
            (TypeInt) wInt.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     */
    @Override
    public WType multWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((SNumber) this.getAdaptee()).multWithFloat(
            (TypeFloat) wFloat.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     */
    @Override
    public WType multWithInt(WrappedInt wInt) {
        TypeFloat computed = (TypeFloat) ((SNumber) this.getAdaptee()).multWithInt(
            (TypeInt) wInt.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     */
    @Override
    public WType divWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((SNumber) this.getAdaptee()).divWithFloat(
            (TypeFloat) wFloat.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     */
    @Override
    public WType divWithInt(WrappedInt wInt) {
        TypeFloat computed = (TypeFloat) ((SNumber) this.getAdaptee()).divWithInt(
            (TypeInt) wInt.getAdaptee());
        return new WrappedFloat(computed);
    }
}
