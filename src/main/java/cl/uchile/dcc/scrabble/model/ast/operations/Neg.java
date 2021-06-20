package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.ast.interfaces.LogicalAST;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractLogicalOperation;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 11:53
 */
public class Neg extends AbstractLogicalOperation {

    /**
     * Default constructor for unary operations. It can receive an {@code Operation} or a {@code
     * Logical AST}.
     *
     * @param value a value, it can be an {@code Operation} or a {@code SLogical}.
     */
    public Neg(LogicalAST value) {
        super(value);
    }

    /**
     * Returns the {@code String} representation of the current {@code AST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code AST} as {@code String}
     */
    @Override
    public String asString(int space) {
        String tab = " ".repeat(space);
        return tab + "Neg" + "(\n"
            + this.getLeftChildren().asString(space + 2) + '\n'
            + tab + ')';
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
        return value1.neg().getAdaptee();
    }
}
