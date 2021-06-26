package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.abstract_classes;

import static cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory.createHiddenBool;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.HiddenOperation;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.HiddenAST;

/**
 * todo: documentar
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/21 17:16
 */
public abstract class AbstractHiddenOperation implements HiddenOperation {

    private final HiddenAST leftChildren;
    private final HiddenAST rightChildren;

    /**
     * Default constructor. It can receive an {@code HiddenOperation} or a {@code HType}.
     *
     * @param leftValue  left value, it can be an {@code HiddenOperation} or a {@code HType}.
     * @param rightValue right value, it can be an {@code HiddenOperation} or a {@code HType}.
     */
    public AbstractHiddenOperation(HiddenAST leftValue, HiddenAST rightValue) {
        leftChildren = leftValue;
        rightChildren = rightValue;
    }

    /**
     * A String representation of the current instance.
     *
     * @return a string representation
     */
    @Override
    public String toString() {
        return asString(0);
    }

    /**
     * Returns the {@code String} representation of the current {@code HiddenAST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenAST} as {@code String}
     */
    @Override
    public final String asString(int space) {
        String tab = " ".repeat(space);
        if (!isTransformation()) {
            return tab + operatorName() + "(\n"
                + leftChildren.asString(space + 2)
                + rightValueAsString(space) + '\n'
                + tab + ')';
        } else {
            return leftChildren.asString(space) + ".toType" + commandName() + "()";
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
        return ' ' + operatorSymbol() + '\n'
            + rightChildren.asString(space + 2) ;
    }

    /**
     * Command name as {@code String}. To use template pattern in {@code asString}.
     *
     * @return Command name as String
     */
    protected String commandName() {
        return "";  // Usually don't used
    }

    /**
     * Operator symbol as {@code String}. To use template pattern in {@code asString}.
     *
     * @return Operator symbol as {@code String}
     */
    protected String operatorSymbol() {
        return "";  // Usually don't used
    }

    /**
     * Operator name as {@code String}. To use template pattern in {@code asString}.
     *
     * @return Operator name as {@code String}.
     */
    protected abstract String operatorName();

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
     * Calculate the {@code SType} result of performing all operations
     *
     * @return SType result of operations.
     */
    @Override
    public final HType calculate() {
        HType leftCalculated = leftChildren.calculate();
        HType rightCalculated = rightChildren.calculate();
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
}
