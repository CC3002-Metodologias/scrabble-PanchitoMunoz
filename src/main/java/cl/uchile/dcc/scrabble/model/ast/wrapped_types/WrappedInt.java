package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_types.AbstractWrappedType;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * A class to wrap a {@code TypeInt}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:02
 * @see TypeInt
 */
public class WrappedInt extends AbstractWrappedType {

    private final TypeInt typeInt;

    /**
     * Constructor.
     *
     * @param typeInt a type int
     */
    public WrappedInt(TypeInt typeInt) {
        this.typeInt = typeInt;
    }

    /**
     * Constructor.
     *
     * @param value an int
     */
    public WrappedInt(int value) {
        this.typeInt = new TypeInt(value);
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    protected SType getAdaptee() {
        return this.typeInt;
    }

    /**
     * Returns the sum
     *
     * @param wType other type to sum
     * @return the sum
     */
    @Override
    public WType add(WType wType) {
        return wType.addWithInt(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param wType another number
     * @return the division
     */
    @Override
    public WType div(WType wType) {
        return wType.divWithInt(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param wType another number
     * @return the multiplication
     */
    @Override
    public WType mult(WType wType) {
        return wType.multWithInt(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param wType another number
     * @return the subtraction
     */
    @Override
    public WType sub(WType wType) {
        return wType.subWithInt(this);
    }

    /**
     * Returns the disjunction between logicals
     *
     * @param wType another logical
     * @return the disjunction
     */
    @Override
    public WType and(WType wType) {
        return wType.andWithInt(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param wType another logical
     * @return the conjunction
     */
    @Override
    public WType or(WType wType) {
        return wType.orWithInt(this);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeInt) this.getAdaptee())
            .addWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((TypeInt) this.getAdaptee())
            .addWithFloat((TypeFloat) wFloat.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithInt(WrappedInt wInt) {
        TypeInt computed = (TypeInt) ((TypeInt) this.getAdaptee())
            .addWithInt((TypeInt) wInt.getAdaptee());
        return new WrappedInt(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeInt) this.getAdaptee())
            .subWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     *
     *
     */
    @Override
    public WType subWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((TypeInt) this.getAdaptee())
            .subWithFloat((TypeFloat) wFloat.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     *
     *
     */
    @Override
    public WType subWithInt(WrappedInt wInt) {
        TypeInt computed = (TypeInt) ((TypeInt) this.getAdaptee())
            .subWithInt((TypeInt) wInt.getAdaptee());
        return new WrappedInt(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     */
    @Override
    public WType multWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeInt) this.getAdaptee())
            .multWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     */
    @Override
    public WType multWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((TypeInt) this.getAdaptee())
            .multWithFloat((TypeFloat) wFloat.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     */
    @Override
    public WType multWithInt(WrappedInt wInt) {
        TypeInt computed = (TypeInt) ((TypeInt) this.getAdaptee())
            .multWithInt((TypeInt) wInt.getAdaptee());
        return new WrappedInt(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     */
    @Override
    public WType divWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeInt) this.getAdaptee())
            .divWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     */
    @Override
    public WType divWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((TypeInt) this.getAdaptee())
            .divWithFloat((TypeFloat) wFloat.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     */
    @Override
    public WType divWithInt(WrappedInt wInt) {
        TypeInt computed = (TypeInt) ((TypeInt) this.getAdaptee())
            .divWithInt((TypeInt) wInt.getAdaptee());
        return new WrappedInt(computed);
    }
}
