package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.ast.interfaces.TypeAST;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractTypeOperation;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * TODO: Documentar
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/14 9:54
 */
public class Add extends AbstractTypeOperation {

    /**
     * Constructor. It can receive an {@code Operation} or a {@code SType}.
     *
     * @param leftValue  left value, it can be an {@code Operation} or a {@code SType}.
     * @param rightValue rightValue right value, it can be an {@code Operation} or a {@code SType}.
     */
    public Add(TypeAST leftValue, TypeAST rightValue) {
        super(leftValue, rightValue);
    }

    /**
     * Returns the {@code String} representation of the current {@code AST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code AST} as {@code String}
     */
    @Override
    public String asString(int space) {
        return asString(space, "+", "Add");
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
        return value1.add(value2).getAdaptee();
    }
}
