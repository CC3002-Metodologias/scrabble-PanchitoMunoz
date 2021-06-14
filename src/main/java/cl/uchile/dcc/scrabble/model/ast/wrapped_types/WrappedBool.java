package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_types.AbstractWrappedType;
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
public class WrappedBool extends AbstractWrappedType {

    private final TypeBool typeBool;

    /**
     * Constructor.
     *
     * @param typeBool a type bool
     */
    public WrappedBool(TypeBool typeBool) {
        this.typeBool = typeBool;
    }

    /**
     * Constructor.
     *
     * @param value a boolean
     */
    public WrappedBool(boolean value) {
        this.typeBool = new TypeBool(value);
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
     * @param wType another logical
     * @return the disjunction
     */
    @Override
    public WType and(WType wType) {
        return wType.andWithBool(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param wType another logical
     * @return the conjunction
     */
    @Override
    public WType or(WType wType) {
        return wType.orWithBool(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param wType another number
     * @return the division
     */
    @Override
    public WType div(WType wType) {
        return wType.divWithBool(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param wType another number
     * @return the multiplication
     */
    @Override
    public WType mult(WType wType) {
        return wType.multWithBool(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param wType another number
     * @return the subtraction
     */
    @Override
    public WType sub(WType wType) {
        return wType.subWithBool(this);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithString(WrappedString wString) {
        TypeString computed = this.getAdaptee().addWithString((TypeString) wString.getAdaptee());
        return new WrappedString(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithBool(WrappedBool wBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithFloat(WrappedFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithInt(WrappedInt wInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WType andWithBool(WrappedBool wBool) {
        TypeBool computed = (TypeBool) ((TypeBool) this.getAdaptee()).andWithBool(
            (TypeBool) wBool.getAdaptee());
        return new WrappedBool(computed);
    }

    /**
     * To use double dispatch in {@code and}
     *
     *
     */
    @Override
    public WType andWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeBool) this.getAdaptee()).andWithBinary(
            (TypeBinary) wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     *
     *
     */
    @Override
    public WType orWithBool(WrappedBool wBool) {
        TypeBool computed = (TypeBool) ((TypeBool) this.getAdaptee()).orWithBool(
            (TypeBool) wBool.getAdaptee());
        return new WrappedBool(computed);
    }

    /**
     * To use double dispatch in {@code or}
     *
     *
     */
    @Override
    public WType orWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) ((TypeBool) this.getAdaptee()).orWithBinary(
            (TypeBinary) wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }
}
