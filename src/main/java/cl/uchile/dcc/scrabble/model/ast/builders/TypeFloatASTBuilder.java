package cl.uchile.dcc.scrabble.model.ast.builders;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.builders.abstract_classes.AbstractNumberASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.builders.interfaces.FloatASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * A class to build an {@code AST} that will return an {@code TypeFloat}.
 *
 * @see AST
 * @see TypeFloat
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/02 19:41
 */
public class TypeFloatASTBuilder extends AbstractNumberASTBuilder implements FloatASTBuilder {

    /**
     * Constructor. Only used by the developer.
     *
     * @param valueToBuild a value to build.
     */
    public TypeFloatASTBuilder(Operation valueToBuild) {
        super(valueToBuild);
    }
}
