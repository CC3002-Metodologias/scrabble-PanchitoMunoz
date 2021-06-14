package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_types.AbstractWrappedNumber;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.interfaces_types.WNumber;
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
public class WrappedInt extends AbstractWrappedNumber {

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
     * To use template pattern in {@code asString}.
     *
     * @return the current {@code AST} as {@code String} without spaces.
     */
    @Override
    protected String asString() {
        return String.valueOf(this.typeInt.getValue());
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
     * @param wNumber another number
     * @return the division
     */
    @Override
    public WNumber div(WNumber wNumber) {
        return wNumber.divWithInt(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param wNumber another number
     * @return the multiplication
     */
    @Override
    public WNumber mult(WNumber wNumber) {
        return wNumber.multWithInt(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param wNumber another number
     * @return the subtraction
     */
    @Override
    public WNumber sub(WNumber wNumber) {
        return wNumber.subWithInt(this);
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
    public WNumber subWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeInt) this.getAdaptee())
            .subWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WNumber subWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((TypeInt) this.getAdaptee())
            .subWithFloat((TypeFloat) wFloat.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WNumber subWithInt(WrappedInt wInt) {
        TypeInt computed = (TypeInt) ((TypeInt) this.getAdaptee())
            .subWithInt((TypeInt) wInt.getAdaptee());
        return new WrappedInt(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WNumber multWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeInt) this.getAdaptee())
            .multWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WNumber multWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((TypeInt) this.getAdaptee())
            .multWithFloat((TypeFloat) wFloat.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WNumber multWithInt(WrappedInt wInt) {
        TypeInt computed = (TypeInt) ((TypeInt) this.getAdaptee())
            .multWithInt((TypeInt) wInt.getAdaptee());
        return new WrappedInt(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WNumber divWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeInt) this.getAdaptee())
            .divWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WNumber divWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((TypeInt) this.getAdaptee())
            .divWithFloat((TypeFloat) wFloat.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WNumber divWithInt(WrappedInt wInt) {
        TypeInt computed = (TypeInt) ((TypeInt) this.getAdaptee())
            .divWithInt((TypeInt) wInt.getAdaptee());
        return new WrappedInt(computed);
    }
}
