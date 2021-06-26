package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.abstract_classes;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.HiddenAST;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 13:31
 */
public abstract class AbstractHiddenUnaryOperation extends AbstractHiddenOperation {

    /**
     * Constructor with one parameter. It can receive an {@code HiddenOperation} or a {@code HType}.
     *
     * @param value a value. It can receive an {@code HiddenOperation} or a {@code HType}.
     */
    public AbstractHiddenUnaryOperation(HiddenAST value) {
        super(value);
    }
}
