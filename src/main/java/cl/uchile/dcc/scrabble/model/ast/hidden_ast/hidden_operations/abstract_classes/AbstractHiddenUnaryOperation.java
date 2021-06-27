package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.abstract_classes;

import static cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory.createHiddenBool;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;

/**
 * Abstract class for unary operations in the hidden types.
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
        super(value, HTypeFactory.createHiddenNull());
    }

    /**
     * Right value as {@code String}. To use template pattern in {@code asString}.
     *
     * @param space number of space
     * @return right value as {@code String}
     */
    @Override
    protected final String rightValueAsString(int space) {
        return "";  // Don't used
    }

    /**
     * Compute the operation between 2 {@code HType} and returns its operation. To use template
     * pattern in {@code calculate}.
     *
     * @param value1 the value at the left
     * @param value2 the value at the right
     * @return the value computed
     */
    @Override
    protected final HType mainOperation(HType value1, HType value2) {
        return mainUnaryOperation(value1);
    }

    /**
     * Compute the unary operation. To use template pattern in {@code mainOperation}.
     *
     * @param value a value
     * @return the value computed
     */
    protected abstract HType mainUnaryOperation(HType value);
}
