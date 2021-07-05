package cl.uchile.dcc.scrabble.model.builders;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.builders.abstract_classes.AbstractIntegerASTBuilder;
import cl.uchile.dcc.scrabble.model.builders.interfaces.IntASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.types.TypeInt;

/**
 * A class to build an {@code AST} that will return an {@code TypeInt}.
 *
 * @see AST
 * @see TypeInt
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/02 19:42
 */
public class TypeIntASTBuilder extends AbstractIntegerASTBuilder implements IntASTBuilder {

    /**
     * Constructor. Only used by the developer.
     *
     * @param valueToBuild a value to build.
     */
    public TypeIntASTBuilder(Operation valueToBuild) {
        super(valueToBuild);
    }
}
