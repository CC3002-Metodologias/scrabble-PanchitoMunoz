package cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.abstract_types.AbstractWrappedType;
import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * A class to wrap a {@code TypeString}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 23:57
 * @see TypeString
 */
public class WrappedString extends AbstractWrappedType {

    private final TypeString typeString;

    /**
     * Constructor.
     *
     * @param typeString a type string.
     */
    public WrappedString(TypeString typeString) {
        this.typeString = typeString;
    }

    /**
     * Constructor.
     *
     * @param value a string
     */
    public WrappedString(String value) {
        this(new TypeString(value));
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeString getAdaptee() {
        return new TypeString(this.typeString.getValue());
    }

    @Override
    public String toString() {
        return "WrappedString{" +
            "value='" + typeString.getValue() + '\'' +
            '}';
    }

    /**
     * Transform the current instance to a {@code WrappedString}.
     *
     * @return a {@code WrappedString} equivalent
     */
    @Override
    public WrappedString toWrappedString() {
        TypeString computed = this.typeString.toTypeString();
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
        return wType.addWithString(this);
    }

    /**
     * Returns the disjunction between logicals
     *
     * @param wType another logical
     * @return the disjunction
     */
    @Override
    public WType and(WType wType) {
        return wType.andWithString(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param wType another number
     * @return the division
     */
    @Override
    public WType div(WType wType) {
        return wType.divWithString(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param wType another number
     * @return the multiplication
     */
    @Override
    public WType mult(WType wType) {
        return wType.multWithString(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param wType another logical
     * @return the conjunction
     */
    @Override
    public WType or(WType wType) {
        return wType.orWithString(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param wType another number
     * @return the subtraction
     */
    @Override
    public WType sub(WType wType) {
        return wType.subWithString(this);
    }
}
