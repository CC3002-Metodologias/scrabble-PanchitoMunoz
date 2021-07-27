package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.abstract_classes;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.AbstractHiddenASTComposite;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTLeaf;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.iterators.LeafIterable;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenSetterVisitor;

/**
 * Abstract class for a general operation in the hidden types.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/21 17:16
 */
public abstract class AbstractHiddenOperator
    extends AbstractHiddenASTComposite
    implements HiddenOperator {

    private final String operatorSymbol;

    /**
     * Default constructor. It can receive an {@code HiddenOperator} or a {@code HType}.
     *
     * @param leftValue      left value, it can be an {@code HiddenOperator} or a {@code HType}.
     * @param rightValue     right value, it can be an {@code HiddenOperator} or a {@code HType}.
     * @param operatorName   the operator's name
     * @param operatorSymbol the operator's symbol
     */
    public AbstractHiddenOperator(
        HiddenASTComponent leftValue, HiddenASTComponent rightValue,
        String operatorName, String operatorSymbol) {
        super(leftValue, rightValue, HTypeFactory.createHiddenNull(), operatorName);
        this.operatorSymbol = operatorSymbol;
    }

    /**
     * Gets the left children.
     *
     * @return the left children
     */
    @Override
    public HiddenASTComponent getLeftChildren() {
        return (HiddenASTComponent) getFirstChildren();
    }

    /**
     * Gets the right children.
     *
     * @return the right children
     */
    @Override
    public HiddenASTComponent getRightChildren() {
        return (HiddenASTComponent) getSecondChildren();
    }

    /**
     * Returns the {@code String} representation of the current {@code HiddenASTComponent}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenASTComponent} as {@code String}
     */
    @Override
    public final String asString(int space) {
        String tab = " ".repeat(space);
        if (!isTransformation()) {
            return tab + getOperatorName() + "(\n"
                + getLeftChildren().asString(space + 2) + rightValueAsString(space) + '\n'
                + tab + ')';
        } else {
            return getLeftChildren().asString(space) + '.' + getOperatorName() + "()";
        }
    }

    /**
     * Right value as {@code String}.
     * To use template pattern in {@code asString}.
     *
     * @param space number of space
     * @return right value as {@code String}
     */
    protected String rightValueAsString(int space) {
        return ' ' + operatorSymbol + '\n'
            + getRightChildren().asString(space + 2);
    }

    /**
     * Returns true if the operation is a transformation, false otherwise.
     * To use template pattern in {@code asString}.
     *
     * @return true if the operation is a transformation, false otherwise.
     */
    protected boolean isTransformation() {
        return false;  // Usually is false
    }

    /**
     * Calculate the {@code HType} result of performing all operations
     *
     * @return {@code HType} result of operations.
     */
    @Override
    public final HType calculate() {
        HType leftCalculated = getLeftChildren().calculate();
        HType rightCalculated = getRightChildren().calculate();
        return mainOperation(leftCalculated, rightCalculated);
    }

    /**
     * Compute the operation between 2 {@code HType} and returns its operation. To use template
     * pattern in {@code calculate}.
     *
     * @param value1 the value at the left
     * @param value2 the value at the right
     * @return the value computed
     */
    protected abstract HType mainOperation(HType value1, HType value2);

    /**
     * Sets the variable in an {@code HiddenOperator}.
     *
     * @param name  the name of the variable
     * @param value the current value to set
     */
    @Override
    public void setVariable(String name, HiddenASTComponent value) {
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
    public LeafIterable leafIterable() {
        return new LeafIterable(this);
    }
}
