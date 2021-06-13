package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_classes.AbstractWNumber;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.type_interfaces.WNumber;
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
public class WFloat extends AbstractWNumber {

    private final TypeFloat typeFloat;

    /**
     * Constructor.
     *
     * @param typeFloat a type float
     */
    public WFloat(TypeFloat typeFloat) {
        this.typeFloat = typeFloat;
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
     * To use template pattern in {@code asString}.
     *
     * @return the current {@code AST} as {@code String} without spaces.
     */
    @Override
    protected String asString() {
        return String.valueOf(this.typeFloat.getValue());
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
     * @param wNumber another number
     * @return the division
     */
    @Override
    public WNumber div(WNumber wNumber) {
        return wNumber.divWithFloat(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param wNumber another number
     * @return the multiplication
     */
    @Override
    public WNumber mult(WNumber wNumber) {
        return wNumber.multWithFloat(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param wNumber another number
     * @return the subtraction
     */
    @Override
    public WNumber sub(WNumber wNumber) {
        return wNumber.subWithFloat(this);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithFloat(WFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((SNumber) this.getAdaptee()).addWithFloat(
            (TypeFloat) wFloat.getAdaptee());
        return new WFloat(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithInt(WInt wInt) {
        TypeFloat computed = (TypeFloat) ((SNumber) this.getAdaptee()).addWithInt(
            (TypeInt) wInt.getAdaptee());
        return new WFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WNumber subWithFloat(WFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((SNumber) this.getAdaptee()).subWithFloat(
            (TypeFloat) wFloat.getAdaptee());
        return new WFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WNumber subWithInt(WInt wInt) {
        TypeFloat computed = (TypeFloat) ((SNumber) this.getAdaptee()).subWithInt(
            (TypeInt) wInt.getAdaptee());
        return new WFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WNumber multWithFloat(WFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((SNumber) this.getAdaptee()).multWithFloat(
            (TypeFloat) wFloat.getAdaptee());
        return new WFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WNumber multWithInt(WInt wInt) {
        TypeFloat computed = (TypeFloat) ((SNumber) this.getAdaptee()).multWithInt(
            (TypeInt) wInt.getAdaptee());
        return new WFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WNumber divWithFloat(WFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((SNumber) this.getAdaptee()).divWithFloat(
            (TypeFloat) wFloat.getAdaptee());
        return new WFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WNumber divWithInt(WInt wInt) {
        TypeFloat computed = (TypeFloat) ((SNumber) this.getAdaptee()).divWithInt(
            (TypeInt) wInt.getAdaptee());
        return new WFloat(computed);
    }
}
