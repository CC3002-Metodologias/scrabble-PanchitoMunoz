package cl.uchile.dcc.scrabble.model.ast.builders;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.builders.abstract_classes.AbstractTypeASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.builders.interfaces.StringASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * A class to build an {@code AST} that will return an {@code TypeString}.
 *
 * @see AST
 * @see TypeString
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/02 19:38
 */
public class TypeStringASTBuilder extends AbstractTypeASTBuilder implements StringASTBuilder {

    /**
     * Constructor. Only used by the developer.
     *
     * @param valueToBuild a value to build.
     */
    public TypeStringASTBuilder(Operation valueToBuild) {
        super(valueToBuild);
    }
}
