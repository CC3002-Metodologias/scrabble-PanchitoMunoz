package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.abstract_classes;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.HiddenAST;

/**
 * Abstract class for the hidden transformations.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 13:31
 */
public abstract class AbstractHiddenTransformation extends AbstractHiddenUnaryOperation {

    /**
     * Constructor with one parameter. It can receive an {@code HiddenOperation} or a {@code HType}.
     *
     * @param value a value. It can receive an {@code HiddenOperation} or a {@code HType}.
     */
    public AbstractHiddenTransformation(HiddenAST value) {
        super(value);
    }

    /**
     * Command name as {@code String}. To use template pattern in {@code asString}.
     *
     * @return Command name as String
     */
    @Override
    protected abstract String commandName();

    /**
     * Returns true if the operation is a transformation, false otherwise. To use template pattern
     * in {@code asString}.
     *
     * @return true if the operation is a transformation, false otherwise.
     */
    @Override
    protected boolean isTransformation() {
        return true;
    }

    /**
     * Operator name as {@code String}. To use template pattern in {@code asString}.
     *
     * @return Operator name as {@code String}.
     */
    @Override
    protected final String operatorName() {
        return null;
    }
}
