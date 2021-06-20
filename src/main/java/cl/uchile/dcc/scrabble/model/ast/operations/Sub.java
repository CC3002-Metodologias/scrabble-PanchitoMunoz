package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.ast.interfaces.NumberAST;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractNumberOperation;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * TODO: Documentar
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/15 11:43
 */
public class Sub extends AbstractNumberOperation {

    /**
     * Constructor. It can receive an {@code Operation} or a {@code SNumber}.
     *
     * @param leftValue  left value, it can be an {@code Operation} or a {@code SNumber}.
     * @param rightValue right value, it can be an {@code Operation} or a {@code SNumber}.
     */
    public Sub(NumberAST leftValue, NumberAST rightValue) {
        super(leftValue, rightValue);
    }

    /**
     * Compute the operation between 2 {@code WType} and returns its operation.
     *
     * @param value1 the value at the left
     * @param value2 the value at the right
     * @return the value computed
     */
    @Override
    protected SType mainOperation(WType value1, WType value2) {
        return value1.sub(value2).getAdaptee();
    }

    /**
     * Returns the {@code String} representation of the current {@code AST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code AST} as {@code String}
     */
    @Override
    public String asString(int space) {
        return asString(space, "-", "Sub");
    }
}
