package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.transformations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.abstract_classes.AbstractHiddenOperation;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.abstract_classes.AbstractHiddenTransformation;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeBool;

/**
 * A class to add a node in the {@code HiddenAST}. It is equivalent to compute the {@code toHiddenBool} method. This class will be adapted by the {@code ToTypeBool} class.
 *
 * @see ToTypeBool
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 23:31
 */
public class ToHiddenBool extends AbstractHiddenTransformation {

    /**
     * Constructor with one parameter. It can receive an {@code HiddenOperation} or a {@code HType}.
     *
     * @param value a value. It can receive an {@code HiddenOperation} or a {@code HType}.
     */
    public ToHiddenBool(HiddenAST value) {
        super(value);
    }

    /**
     * Command name as {@code String}. To use template pattern in {@code asString}.
     *
     * @return Command name as String
     */
    @Override
    protected String commandName() {
        return "Bool";
    }

    /**
     * Compute the unary operation. To use template pattern in {@code mainOperation}.
     *
     * @param value a value
     * @return the value computed
     */
    @Override
    protected HiddenBool mainUnaryOperation(HType value) {
        return value.toHiddenBool();
    }
}
