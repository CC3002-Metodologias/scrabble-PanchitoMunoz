package cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_types;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBool;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedInt;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedString;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import java.util.HashMap;

/**
 * An abstract class to wrap a generic {@code SType}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 23:54
 * @see SType
 */
public abstract class AbstractWrappedType implements WType {

    /**
     * Calculate the {@code SType} result of performing all operations
     *
     * @return SType result of operations.
     */
    @Override
    public SType calculate() {
        return this.getAdaptee();  // Using template pattern
    }

    /**
     * Returns the {@code String} representation of the current {@code AST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code AST} as {@code String}
     */
    @Override
    public String asString(int space) {
        String tab = " ".repeat(space);
        return tab + asString();
    }

    /**
     * To use template pattern in {@code asString}.
     *
     * @return the current {@code AST} as {@code String} without spaces.
     */
    protected String asString() {
        return this.getAdaptee().asString(0);
    }

    /**
     * Transform a {@code SType} into its equivalent {@code WType}. If the argument is a {@code
     * WType} or an {@code AST}, it does nothing.
     *
     * @return a transformation
     */
    @Override
    public AST toWrapType() {
        return this;
    }

    /**
     * Returns a hash code value for the object. This method is supported for the benefit of hash
     * tables such as those provided by {@link HashMap}.
     * <p>
     * The general contract of {@code hashCode} is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     *     an execution of a Java application, the {@code hashCode} method
     *     must consistently return the same integer, provided no information
     *     used in {@code equals} comparisons on the object is modified.
     *     This integer need not remain consistent from one execution of an
     *     application to another execution of the same application.
     * <li>If two objects are equal according to the {@code equals(Object)}
     *     method, then calling the {@code hashCode} method on each of
     *     the two objects must produce the same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     *     according to the {@link Object#equals(Object)}
     *     method, then calling the {@code hashCode} method on each of the
     *     two objects must produce distinct integer results.  However, the
     *     programmer should be aware that producing distinct integer results
     *     for unequal objects may improve the performance of hash tables.
     * </ul>
     *
     * @return a hash code value for this object.
     * @implSpec As far as is reasonably practical, the {@code hashCode} method defined by class
     * {@code Object} returns distinct integers for distinct objects.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    @Override
    public int hashCode() {
        return this.getAdaptee().hashCode();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     *     {@code x}, {@code x.equals(x)} should return
     *     {@code true}.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     *     {@code x} and {@code y}, {@code x.equals(y)}
     *     should return {@code true} if and only if
     *     {@code y.equals(x)} returns {@code true}.
     * <li>It is <i>transitive</i>: for any non-null reference values
     *     {@code x}, {@code y}, and {@code z}, if
     *     {@code x.equals(y)} returns {@code true} and
     *     {@code y.equals(z)} returns {@code true}, then
     *     {@code x.equals(z)} should return {@code true}.
     * <li>It is <i>consistent</i>: for any non-null reference values
     *     {@code x} and {@code y}, multiple invocations of
     *     {@code x.equals(y)} consistently return {@code true}
     *     or consistently return {@code false}, provided no
     *     information used in {@code equals} comparisons on the
     *     objects is modified.
     * <li>For any non-null reference value {@code x},
     *     {@code x.equals(null)} should return {@code false}.
     * </ul>
     * <p>
     * The {@code equals} method for class {@code Object} implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values {@code x} and
     * {@code y}, this method returns {@code true} if and only
     * if {@code x} and {@code y} refer to the same object
     * ({@code x == y} has the value {@code true}).
     * <p>
     * Note that it is generally necessary to override the {@code hashCode}
     * method whenever this method is overridden, so as to maintain the
     * general contract for the {@code hashCode} method, which states
     * that equal objects must have equal hash codes.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WType)) {
            return false;
        }
        WType wType = (WType) obj;
        return this.getAdaptee().equals(wType.getAdaptee());
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithString(WrappedString wString) {
        TypeString computed = this.getAdaptee().addWithString(
            (TypeString) wString.getAdaptee());
        return new WrappedString(computed);
    }

    /**
     * To use double dispatch in {@code add}
     *
     */
    @Override
    public WType addWithBool(WrappedBool wBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     *
     */
    @Override
    public WType addWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     *
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
    public WType andWithString(WrappedString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WType andWithBool(WrappedBool wBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WType andWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WType andWithFloat(WrappedFloat wrappedFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WType andWithInt(WrappedInt wrappedInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WType divWithString(WrappedString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WType divWithBool(WrappedBool wrappedBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WType divWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WType divWithFloat(WrappedFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WType divWithInt(WrappedInt wInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WType multWithString(WrappedString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WType multWithBool(WrappedBool wrappedBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WType multWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WType multWithFloat(WrappedFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WType multWithInt(WrappedInt wInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WType orWithString(WrappedString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WType orWithBool(WrappedBool wBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WType orWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WType orWithFloat(WrappedFloat wrappedFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WType orWithInt(WrappedInt wrappedInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithString(WrappedString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithBool(WrappedBool wrappedBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithFloat(WrappedFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithInt(WrappedInt wInt) {
        return null;
    }
}
