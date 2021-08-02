package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.AbstractHiddenOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import java.util.HashMap;

/**
 * Abstract class for binary operations in the hidden types.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 13:31
 */
public abstract class AbstractHiddenBinaryOperator
    extends AbstractHiddenOperator
    implements HiddenBinaryOperator {

    private final HiddenASTComponent secondChildren;
    private final String operatorSymbol;

    /**
     * Default constructor. It can receive any {@code HiddenASTComponent}.
     *
     * @param firstChildren  the first value. It can be any {@code HiddenASTComponent}.
     * @param secondChildren the second value. It can be any {@code HiddenASTComponent}.
     * @param operatorName   the operator's name.
     * @param operatorSymbol the operator's symbol.
     */
    public AbstractHiddenBinaryOperator(
        HiddenASTComponent firstChildren, HiddenASTComponent secondChildren,
        String operatorName, String operatorSymbol) {
        super(firstChildren, operatorName);
        this.secondChildren = secondChildren;
        this.operatorSymbol = operatorSymbol;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractHiddenBinaryOperator)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        AbstractHiddenBinaryOperator that = (AbstractHiddenBinaryOperator) o;

        if (!getSecondChildren().equals(that.getSecondChildren())) {
            return false;
        }
        return getOperatorSymbol().equals(that.getOperatorSymbol());
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getSecondChildren().hashCode();
        result = 31 * result + getOperatorSymbol().hashCode();
        return result;
    }

    /**
     * Creates and returns a copy of this object.  The precise meaning of "copy" may depend on the
     * class of the object. The general intent is that, for any object {@code x}, the expression:
     * <blockquote>
     * <pre>
     * x.clone() != x</pre></blockquote>
     * will be true, and that the expression:
     * <blockquote>
     * <pre>
     * x.clone().getClass() == x.getClass()</pre></blockquote>
     * will be {@code true}, but these are not absolute requirements. While it is typically the case
     * that:
     * <blockquote>
     * <pre>
     * x.clone().equals(x)</pre></blockquote>
     * will be {@code true}, this is not an absolute requirement.
     * <p>
     * By convention, the returned object should be obtained by calling {@code super.clone}.  If a
     * class and all of its superclasses (except {@code Object}) obey this convention, it will be
     * the case that {@code x.clone().getClass() == x.getClass()}.
     * <p>
     * By convention, the object returned by this method should be independent of this object (which
     * is being cloned).  To achieve this independence, it may be necessary to modify one or more
     * fields of the object returned by {@code super.clone} before returning it.  Typically, this
     * means copying any mutable objects that comprise the internal "deep structure" of the object
     * being cloned and replacing the references to these objects with references to the copies.  If
     * a class contains only primitive fields or references to immutable objects, then it is usually
     * the case that no fields in the object returned by {@code super.clone} need to be modified.
     * <p>
     * The method {@code clone} for class {@code Object} performs a specific cloning operation.
     * First, if the class of this object does not implement the interface {@code Cloneable}, then a
     * {@code CloneNotSupportedException} is thrown. Note that all arrays are considered to
     * implement the interface {@code Cloneable} and that the return type of the {@code clone}
     * method of an array type {@code T[]} is {@code T[]} where T is any reference or primitive
     * type. Otherwise, this method creates a new instance of the class of this object and
     * initializes all its fields with exactly the contents of the corresponding fields of this
     * object, as if by assignment; the contents of the fields are not themselves cloned. Thus, this
     * method performs a "shallow copy" of this object, not a "deep copy" operation.
     * <p>
     * The class {@code Object} does not itself implement the interface {@code Cloneable}, so
     * calling the {@code clone} method on an object whose class is {@code Object} will result in
     * throwing an exception at run time.
     *
     * @return a clone of this instance.
     * @throws CloneNotSupportedException if the object's class does not support the {@code
     *                                    Cloneable} interface. Subclasses that override the {@code
     *                                    clone} method can also throw this exception to indicate
     *                                    that an instance cannot be cloned.
     * @see Cloneable
     */
    @Override
    public HiddenBinaryOperator clone() throws CloneNotSupportedException {
        return (HiddenBinaryOperator) super.clone();
    }

    /**
     * Returns the {@code String} representation of the current {@code HiddenASTComponent}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenASTComponent} as {@code String}
     */
    @Override
    public String asString(int space) {
        String tab = " ".repeat(space);
        return tab + getOperatorName() + "(\n"
            + getFirstChildren().asString(space + 2) + ' ' + getOperatorSymbol() + '\n'
            + getSecondChildren().asString(space + 2) + '\n'
            + tab + ')';
    }

    /**
     * Returns the number of vertices in the current {@code HiddenASTComponent}
     *
     * @return the number of vertices
     */
    @Override
    public final int size() {
        return super.size() + getSecondChildren().size();
    }

    /**
     * Returns the second children.
     *
     * @return the second children
     */
    @Override
    public final HiddenASTComponent getSecondChildren() {
        return secondChildren;
    }

    /**
     * Returns the operator's symbol.
     *
     * @return the operator's symbol
     */
    public final String getOperatorSymbol() {
        return operatorSymbol;
    }

    /**
     * Returns the second children calculated.
     *
     * @return the second children calculated.
     */
    protected final HType secondChildrenCalculated() {
        return getSecondChildren().calculate();
    }

    /**
     * The main operation to use template pattern in {@code calculate}.
     *
     * @param value1 the first value
     * @param value2 the second value
     * @return the first value computed with the second value.
     */
    protected abstract HType mainOperation(HType value1, HType value2);

    /**
     * Calculate the {@code HType} result of performing all operations
     *
     * @return {@code HType} result of operations.
     */
    @Override
    public final HType calculate() {
        return mainOperation(firstChildrenCalculated(), secondChildrenCalculated());
    }
}
