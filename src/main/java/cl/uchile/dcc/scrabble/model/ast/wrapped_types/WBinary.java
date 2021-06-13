package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_classes.AbstractWNumber;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.type_interfaces.WLogical;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.type_interfaces.WNumber;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * A class to wrap a {@code TypeBinary}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:01
 * @see TypeBinary
 */
public class WBinary extends AbstractWNumber implements WLogical {

    private final TypeBinary typeBinary;

    public WBinary(TypeBinary typeBinary) {
        this.typeBinary = typeBinary;
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    protected SType getAdaptee() {
        return this.typeBinary;
    }

    /**
     * To use template pattern in {@code asString}.
     *
     * @return the current {@code AST} as {@code String} without spaces.
     */
    @Override
    protected String asString() {
        return this.typeBinary.getValue();
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
     * @param wLogical another logical
     * @return the disjunction
     */
    @Override
    public WLogical and(WLogical wLogical) {
        return wLogical.andWithBinary(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param wNumber another number
     * @return the division
     */
    @Override
    public WNumber div(WNumber wNumber) {
        return wNumber.divWithBinary(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param wNumber another number
     * @return the multiplication
     */
    @Override
    public WNumber mult(WNumber wNumber) {
        return wNumber.multWithBinary(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param wLogical another logical
     * @return the conjunction
     */
    @Override
    public WLogical or(WLogical wLogical) {
        return wLogical.orWithBinary(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param wNumber another number
     * @return the subtraction
     */
    @Override
    public WNumber sub(WNumber wNumber) {
        return wNumber.subWithBinary(this);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithBinary(WBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeBinary) this.getAdaptee())
            .addWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WBinary(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithFloat(WFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((TypeBinary) this.getAdaptee())
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
        TypeBinary computed = (TypeBinary) ((TypeBinary) this.getAdaptee())
            .subWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WBinary(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WNumber subWithFloat(WFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((TypeBinary) this.getAdaptee())
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
        TypeBinary computed = (TypeBinary) ((TypeBinary) this.getAdaptee())
            .multWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WBinary(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WNumber multWithFloat(WFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((TypeBinary) this.getAdaptee())
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
        TypeBinary computed = (TypeBinary) ((TypeBinary) this.getAdaptee())
            .divWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WBinary(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WNumber divWithFloat(WFloat wFloat) {
        TypeFloat computed = (TypeFloat) ((TypeBinary) this.getAdaptee())
            .divWithFloat((TypeFloat) wFloat.getAdaptee());
        return new WFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WNumber divWithInt(WInt wInt) {
        TypeInt computed = (TypeInt) ((TypeInt) this.getAdaptee()).divWithInt(
            (TypeInt) wInt.getAdaptee());
        return new WInt(computed);
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WLogical andWithBool(WBool wBool) {
        TypeBinary computed = (TypeBinary) ((TypeBinary) this.getAdaptee()).andWithBool(
            (TypeBool) wBool.getAdaptee());
        return new WBinary(computed);
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WLogical andWithBinary(WBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeBinary) this.getAdaptee()).andWithBinary(
            (TypeBinary) wBinary.getAdaptee());
        return new WBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WLogical orWithBool(WBool wBool) {
        TypeBinary computed = (TypeBinary) ((TypeBinary) this.getAdaptee()).orWithBool(
            (TypeBool) wBool.getAdaptee());
        return new WBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WLogical orWithBinary(WBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeBinary) this.getAdaptee()).orWithBinary(
            (TypeBinary) wBinary.getAdaptee());
        return new WBinary(computed);
    }
}
