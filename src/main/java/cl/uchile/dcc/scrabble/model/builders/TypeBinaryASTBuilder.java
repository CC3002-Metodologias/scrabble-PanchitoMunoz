package cl.uchile.dcc.scrabble.model.builders;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.builders.abstract_classes.AbstractIntegerASTBuilder;
import cl.uchile.dcc.scrabble.model.builders.interfaces.BinaryASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;

/**
 * A class to build an {@code AST} that will return an {@code TypeBinary}.
 *
 * @see AST
 * @see TypeBinary
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/02 19:42
 */
public class TypeBinaryASTBuilder extends AbstractIntegerASTBuilder implements BinaryASTBuilder {

    /**
     * Constructor. Only used by the developer.
     *
     * @param valueToBuild a value to build.
     */
    public TypeBinaryASTBuilder(Operation valueToBuild) {
        super(valueToBuild);
    }
}
