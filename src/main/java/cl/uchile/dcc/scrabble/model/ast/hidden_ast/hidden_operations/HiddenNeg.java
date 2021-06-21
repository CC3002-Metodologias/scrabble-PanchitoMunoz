package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedBool;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/21 17:33
 */
public class HiddenNeg extends AbstractHiddenOperation {

    /**
     * Default constructor. It can receive an {@code HiddenOperation} or a {@code WType}.
     *
     * @param value left value, it can be an {@code HiddenOperation} or a {@code WType}.
     */
    public HiddenNeg(HiddenAST value) {
        super(value, new WrappedBool(true));
    }

    /**
     * Compute the operation between 2 {@code WType} and returns its operation. To use template
     * pattern.
     *
     * @param value1 the value at the left
     * @param value2 the value at the right
     * @return the value computed
     */
    @Override
    protected WType mainOperation(WType value1, WType value2) {
        return value1.neg();
    }

    /**
     * Returns the {@code String} representation of the current {@code HiddenAST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenAST} as {@code String}
     */
    @Override
    public String asString(int space) {
        String tab = " ".repeat(space);
        return tab + "Neg" + "(\n"
            + this.getLeftChildren().asString(space + 2) + '\n'
            + tab + ')';
    }
}
