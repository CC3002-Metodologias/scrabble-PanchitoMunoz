package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_classes.AbstractWType;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.type_interfaces.WLogical;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * A class to wrap a {@code TypeBool}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:00
 * @see TypeBool
 */
public class WBool extends AbstractWType implements WLogical {

    private final TypeBool typeBool;

    /**
     * Constructor.
     *
     * @param typeBool a type bool
     */
    public WBool(TypeBool typeBool) {
        this.typeBool = typeBool;
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    protected SType getAdaptee() {
        return this.typeBool;
    }

    /**
     * To use template pattern in {@code asString}.
     *
     * @return the current {@code AST} as {@code String} without spaces.
     */
    @Override
    protected String asString() {
        return String.valueOf(this.typeBool.getValue());
    }

    /**
     * Returns the sum
     *
     * @param wType other type to sum
     * @return the sum
     */
    @Override
    public WType add(WType wType) {
        return wType.addWithBool(this);
    }

    /**
     * Returns the disjunction between logicals
     *
     * @param wLogical another logical
     * @return the disjunction
     */
    @Override
    public WLogical and(WLogical wLogical) {
        return wLogical.andWithBool(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param wLogical another logical
     * @return the conjunction
     */
    @Override
    public WLogical or(WLogical wLogical) {
        return wLogical.orWithBool(this);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithString(WString wString) {
        TypeString computed = this.getAdaptee().addWithString((TypeString) wString.getAdaptee());
        return new WString(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithBool(WBool wBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithBinary(WBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithFloat(WFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithInt(WInt wInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WLogical andWithBool(WBool wBool) {
        TypeBool computed = (TypeBool) ((TypeBool) this.getAdaptee()).andWithBool(
            (TypeBool) wBool.getAdaptee());
        return new WBool(computed);
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WLogical andWithBinary(WBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeBool) this.getAdaptee()).andWithBinary(
            (TypeBinary) wBinary.getAdaptee());
        return new WBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WLogical orWithBool(WBool wBool) {
        TypeBool computed = (TypeBool) ((TypeBool) this.getAdaptee()).orWithBool(
            (TypeBool) wBool.getAdaptee());
        return new WBool(computed);
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WLogical orWithBinary(WBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeBool) this.getAdaptee()).orWithBinary(
            (TypeBinary) wBinary.getAdaptee());
        return new WBinary(computed);
    }
}
