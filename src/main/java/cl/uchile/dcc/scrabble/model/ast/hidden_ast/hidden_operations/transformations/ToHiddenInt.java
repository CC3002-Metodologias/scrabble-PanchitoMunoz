package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.transformations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.abstract_classes.AbstractHiddenOperation;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.abstract_classes.AbstractHiddenTransformation;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;

/**
 * A class to add a node in the {@code HiddenAST}. It is equivalent to compute the {@code toHiddenInt} method.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 23:32
 */
public class ToHiddenInt extends AbstractHiddenTransformation {

    /**
     * Constructor with one parameter. It can receive an {@code HiddenOperation} or a {@code HType}.
     *
     * @param value a value. It can receive an {@code HiddenOperation} or a {@code HType}.
     */
    public ToHiddenInt(HiddenAST value) {
        super(value);
    }

    /**
     * Command name as {@code String}. To use template pattern in {@code asString}.
     *
     * @return Command name as String
     */
    @Override
    protected String commandName() {
        return "Int";
    }

    /**
     * Compute the unary operation. To use template pattern in {@code mainOperation}.
     *
     * @param value a value
     * @return the value computed
     */
    @Override
    protected HiddenInt mainUnaryOperation(HType value) {
        return value.toHiddenInt();
    }
}
