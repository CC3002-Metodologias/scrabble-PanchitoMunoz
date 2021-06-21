package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_types.AbstractWrappedType;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeString;

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
        this(new TypeBool(value));
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeBool getAdaptee() {
        return new TypeBool(this.typeBool.getValue());
    }

    @Override
    public String toString() {
        return "WrappedBool{" +
            "value=" + typeBool.getValue() +
            '}';
    }

    /**
     * Transform the current instance to a {@code WrappedBool}.
     *
     * @return a {@code WrappedBool} equivalent
     */
    @Override
    public WrappedBool toWrappedBool() {
        TypeBool computed = this.typeBool.toTypeBool();
        return new WrappedBool(computed);
    }

    /**
     * Transform the current instance to a {@code WrappedString}.
     *
     * @return a {@code WrappedString} equivalent
     */
    @Override
    public WrappedString toWrappedString() {
        TypeString computed = this.typeBool.toTypeString();
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
     * Returns the negation of the current instance
     *
     * @return the negation.
     */
    @Override
    public WType neg() {
        return new WrappedBool((TypeBool) this.typeBool.neg());
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WType andWithBool(WrappedBool wBool) {
        TypeBool computed = (TypeBool) this.typeBool.andWithBool(wBool.getAdaptee());
        return new WrappedBool(computed);
    }

    /**
     * To use double dispatch in {@code and}
     *
     *
     */
    @Override
    public WType andWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBool.andWithBinary(wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     *
     *
     */
    @Override
    public WType orWithBool(WrappedBool wBool) {
        TypeBool computed = (TypeBool) this.typeBool.orWithBool(wBool.getAdaptee());
        return new WrappedBool(computed);
    }

    /**
     * To use double dispatch in {@code or}
     *
     *
     */
    @Override
    public WType orWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBool.orWithBinary(wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }
}
