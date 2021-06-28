package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.abstract_classes;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.HiddenAST;

/**
 * Abstract class for binary operations in the hidden types.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 13:31
 */
public abstract class AbstractHiddenBinaryOperation extends AbstractHiddenOperation {

    /**
     * Default constructor. It can receive an {@code HiddenOperation} or a {@code HType}.
     *
     * @param leftValue  left value, it can be an {@code HiddenOperation} or a {@code HType}.
     * @param rightValue right value, it can be an {@code HiddenOperation} or a {@code HType}.
     */
    public AbstractHiddenBinaryOperation(
        HiddenAST leftValue, HiddenAST rightValue,
        String operatorName, String operatorSymbol) {
        super(leftValue, rightValue);
        super.setOperatorName(operatorName);
        super.setOperatorSymbol(operatorSymbol);
    }
}
