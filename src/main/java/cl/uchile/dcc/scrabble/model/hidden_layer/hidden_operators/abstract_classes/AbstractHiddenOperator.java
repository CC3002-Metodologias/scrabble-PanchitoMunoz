package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.abstract_classes;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComposite;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTLeaf;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.iterators.LeafIterable;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenSetterVisitor;
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
     * Calculate the {@code HType} result of performing all operations
     *
     * @return {@code HType} result of operations.
     */
    @Override
    public HType calculate() {
        return mainOperation(firstChildrenCalculated());
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
     * Compute the main operation of the {@code HiddenOperation}. To use template pattern in {@code
     * calculate}.
     *
     * @param value1 the value at the left
     * @return the value computed
     */
    protected abstract HType mainOperation(HType value1);

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
