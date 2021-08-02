package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComposite;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTLeaf;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.iterators.LeafIterable;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenSetterVisitor;
import java.util.HashMap;

/**
 * Abstract class for a general operation in the hidden types.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/21 17:16
 */
public abstract class AbstractHiddenOperator
    implements HiddenOperator {

    private final HiddenASTComponent firstChildren;
    private final String operatorName;

    /**
     * Default constructor. It can receive any {@code HiddenASTComponent}.
     *
     * @param firstChildren the first value. It can be any {@code HiddenASTComponent}.
     * @param operatorName  the operator's name.
     */
    public AbstractHiddenOperator(HiddenASTComponent firstChildren, String operatorName) {
        this.firstChildren = firstChildren;
        this.operatorName = operatorName;
    }

    /**
     * A String representation of the current instance.
     *
     * @return a string representation
     */
    @Override
    public final String toString() {
        return asString(0);
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
        if (!(o instanceof HiddenASTComposite)) {
            return false;
        }

        HiddenASTComposite that = (HiddenASTComposite) o;

        if (!getFirstChildren().equals(that.getFirstChildren())) {
            return false;
        }
        return getOperatorName().equals(that.getOperatorName());
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
        int result = getFirstChildren().hashCode();
        result = 31 * result + getOperatorName().hashCode();
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
    public HiddenOperator clone() throws CloneNotSupportedException {
        return (HiddenOperator) super.clone();
    }

    /**
     * Get the first children
     *
     * @return the first children
     */
    @Override
    public final HiddenASTComponent getFirstChildren() {
        return this.firstChildren;
    }

    /**
     * Get the operator name
     *
     * @return the operator name
     */
    @Override
    public final String getOperatorName() {
        return this.operatorName;
    }

    /**
     * Calculate the first children.
     *
     * @return the first children calculated.
     */
    public final HType firstChildrenCalculated() {
        return getFirstChildren().calculate();
    }

    /**
     * Sets the variable in an {@code HiddenOperator}.
     *
     * @param name  the name of the variable
     * @param value the current value to set
     */
    @Override
    public final void setVariable(String name, HiddenASTComponent value) {
        HiddenSetterVisitor visitor = new HiddenSetterVisitor(name, value);
        for (HiddenASTLeaf leaf : this.leafIterable()) {
            leaf.accept(visitor);
        }
    }

    /**
     * Returns an iterable to iterates for each leaf in the {@code HiddenASTComponent}.
     *
     * @return an iterable that iterates by the leaves.
     */
    public final LeafIterable leafIterable() {
        return new LeafIterable(this);
    }

    /**
     * Returns the number of vertices in the current {@code HiddenASTComponent}
     *
     * @return the number of vertices
     */
    @Override
    public int size() {
        return 1 + getFirstChildren().size();
    }
}
