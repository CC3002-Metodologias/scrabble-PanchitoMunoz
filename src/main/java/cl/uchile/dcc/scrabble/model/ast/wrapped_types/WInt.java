package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_classes.AbstractWNumber;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.type_interfaces.WNumber;
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
public class WInt extends AbstractWNumber {

    private final TypeInt typeInt;

    /**
     * Constructor.
     *
     * @param typeInt a type int
     */
    public WInt(TypeInt typeInt) {
        this.typeInt = typeInt;
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
    public WType addWithBinary(WBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeInt) this.getAdaptee())
            .addWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WBinary(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithFloat(WFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((TypeInt) this.getAdaptee())
            .addWithFloat((TypeFloat) wFloat.getAdaptee());
        return new WFloat(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithInt(WInt wInt) {
        TypeInt computed = (TypeInt) ((TypeInt) this.getAdaptee())
            .addWithInt((TypeInt) wInt.getAdaptee());
        return new WInt(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WNumber subWithBinary(WBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeInt) this.getAdaptee())
            .subWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WBinary(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WNumber subWithFloat(WFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((TypeInt) this.getAdaptee())
            .subWithFloat((TypeFloat) wFloat.getAdaptee());
        return new WFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WNumber subWithInt(WInt wInt) {
        TypeInt computed = (TypeInt) ((TypeInt) this.getAdaptee())
            .subWithInt((TypeInt) wInt.getAdaptee());
        return new WInt(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WNumber multWithBinary(WBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeInt) this.getAdaptee())
            .multWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WBinary(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WNumber multWithFloat(WFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((TypeInt) this.getAdaptee())
            .multWithFloat((TypeFloat) wFloat.getAdaptee());
        return new WFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WNumber multWithInt(WInt wInt) {
        TypeInt computed = (TypeInt) ((TypeInt) this.getAdaptee())
            .multWithInt((TypeInt) wInt.getAdaptee());
        return new WInt(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WNumber divWithBinary(WBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeInt) this.getAdaptee())
            .divWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WBinary(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WNumber divWithFloat(WFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((TypeInt) this.getAdaptee())
            .divWithFloat((TypeFloat) wFloat.getAdaptee());
        return new WFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WNumber divWithInt(WInt wInt) {
        TypeInt computed = (TypeInt) ((TypeInt) this.getAdaptee())
            .divWithInt((TypeInt) wInt.getAdaptee());
        return new WInt(computed);
    }
}
