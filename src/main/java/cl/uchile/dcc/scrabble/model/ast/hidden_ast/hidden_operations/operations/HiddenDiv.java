package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.abstract_classes.AbstractHiddenBinaryOperation;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.abstract_classes.AbstractHiddenOperation;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.operations.Div;

/**
 * A class to add a node in the {@code HiddenAST}. It is equivalent to compute the {@code div} method. This class will be adapted by the {@code Div} class.
 *
 * @see Div
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/21 17:33
 */
public class HiddenDiv extends AbstractHiddenBinaryOperation {

    /**
     * Default constructor. It can receive an {@code HiddenOperation} or a {@code HType}.
     *
     * @param leftValue  left value, it can be an {@code HiddenOperation} or a {@code HType}.
     * @param rightValue right value, it can be an {@code HiddenOperation} or a {@code HType}.
     */
    public HiddenDiv(HiddenAST leftValue, HiddenAST rightValue) {
        super(leftValue, rightValue, "Div", "/");
    }

    /**
     * Compute the operation between 2 {@code HType} and returns its operation. To use template
     * pattern.
     *
     * @param value1 the value at the left
     * @param value2 the value at the right
     * @return the value computed
     */
    @Override
    protected HType mainOperation(HType value1, HType value2) {
        return value1.div(value2);
    }
}
