package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HiddenAST;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/21 17:33
 */
public class HiddenDiv extends AbstractHiddenOperation {

    /**
     * Default constructor. It can receive an {@code HiddenOperation} or a {@code HType}.
     *
     * @param leftValue  left value, it can be an {@code HiddenOperation} or a {@code HType}.
     * @param rightValue right value, it can be an {@code HiddenOperation} or a {@code HType}.
     */
    public HiddenDiv(HiddenAST leftValue, HiddenAST rightValue) {
        super(leftValue, rightValue);
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

    /**
     * Returns the {@code String} representation of the current {@code HiddenAST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenAST} as {@code String}
     */
    @Override
    public String asString(int space) {
        return asStringForOperations(space, "/", "Div");
    }
}
