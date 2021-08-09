package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HNumber;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class for a general Number.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 15:31
 */
public abstract class AbstractHiddenNumber extends AbstractHiddenType implements HNumber {

    private final double valueAsDouble;

    /**
     * Constructor.
     *
     * @param valueAsDouble a value as double
     */
    protected AbstractHiddenNumber(double valueAsDouble) {
        this.valueAsDouble = valueAsDouble;
    }

    /**
     * Get value as double
     *
     * @return Get value as double
     */
    public double getValueAsDouble() {
        return this.valueAsDouble;
    }

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    @Override
    public final HFloat toHiddenFloat() {
        return HTypeFactory.createHiddenFloat(this.getValueAsDouble());
    }

    /**
     * Gets the value as a {@code SNumber}
     *
     * @return the value as a {@code SNumber}
     */
    @Override
    public SNumber asSNumber() {
        return (SNumber) this.asSType();
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
    public int compareTo(@NotNull HNumber o) {
        return Double.compare(this.getValueAsDouble(), o.getValueAsDouble());
    }

    /**
     * Returns a {@code HiddenBool} if the parameter {@code other} is equals.
     *
     * @param other other {@code HType}
     * @return a {@code HBool}
     */
    @Override
    public HBool equalsTo(HType other) {
        return other.getBridge().equalsWithNumber(this);
    }

    /**
     * Returns a {@code HiddenBool} if the parameter {@code other} is greater equals than the
     * current.
     *
     * @param other other {@code HType}
     * @return a {@code HBool}
     */
    @Override
    public HBool greaterEquals(HType other) {
        return other.getBridge().greaterEqualsWithNumber(this);
    }

    /**
     * Returns a {@code HiddenBool} if the parameter {@code other} is greater than the current.
     *
     * @param other other {@code HType}
     * @return a {@code HBool}
     */
    @Override
    public HBool greaterThan(HType other) {
        return other.getBridge().greaterThanWithNumber(this);
    }

    /**
     * Returns a {@code HiddenBool} if the parameter {@code other} is lower equals than the
     * current.
     *
     * @param other other {@code HType}
     * @return a {@code HBool}
     */
    @Override
    public HBool lowerEquals(HType other) {
        return other.getBridge().lowerEqualsWithNumber(this);
    }

    /**
     * Returns a {@code HiddenBool} if the parameter {@code other} is lower than the current.
     *
     * @param other other {@code HType}
     * @return a {@code HBool}
     */
    @Override
    public HBool lowerThan(HType other) {
        return other.getBridge().lowerThanWithNumber(this);
    }
}
