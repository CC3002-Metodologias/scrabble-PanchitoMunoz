package cl.uchile.dcc.scrabble.model.types.abstract_types;

import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HNumber;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class for the general numbers used.
 *
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractNumber extends AbstractType implements SNumber {

    public AbstractNumber(HNumber adaptee) {
        super(adaptee);
    }

    /**
     * Transform the current {@code SType} as a {@code HType}.
     *
     * @return a transformation
     */
    @Override
    public HNumber asHType() {
        return (HNumber) super.asHType();
    }

    /**
     * Returns the value as {@code double}.
     *
     * @return the current value as {@code double}
     */
    @Override
    public final double getValueAsDouble() {
        return this.asHType().getValueAsDouble();
    }

    /**
     * Transforms the current type to a {@code TypeFloat}.
     *
     * @return {@code TypeFloat} with a value equivalent to the current type.
     */
    @Override
    public final TypeFloat toTypeFloat() {
        return STypeFactory.createTypeFloat(this.getValueAsDouble());
    }

    /**
     * Compares this object with the specified object for order.  Returns a negative integer, zero,
     * or a positive integer as this object is less than, equal to, or greater than the specified
     * object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))} for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff {@code y.compareTo(x)} throws
     * an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any class that implements
     * the {@code Comparable} interface and violates this condition should clearly indicate this
     * fact.  The recommended language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal
     * to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared
     *                              to this object.
     */
    @Override
    public final int compareTo(@NotNull SNumber o) {
        return this.asHType().compareTo(o.asHType());
    }
}
