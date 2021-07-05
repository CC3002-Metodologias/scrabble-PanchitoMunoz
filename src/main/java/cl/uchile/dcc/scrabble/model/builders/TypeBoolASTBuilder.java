package cl.uchile.dcc.scrabble.model.builders;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.builders.abstract_classes.AbstractTypeASTBuilder;
import cl.uchile.dcc.scrabble.model.builders.interfaces.BoolASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.types.TypeBool;

/**
 * A class to build an {@code AST} that will return an {@code TypeBool}.
 *
 * @see AST
 * @see TypeBool
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/02 19:40
 */
public class TypeBoolASTBuilder extends AbstractTypeASTBuilder implements BoolASTBuilder {

    /**
     * Constructor. Only used by the developer.
     *
     * @param valueToBuild a value to build.
     */
    protected TypeBoolASTBuilder(Operation valueToBuild) {
        super(valueToBuild);
    }

    /**
     * Transform the {@code AST} in the builder into a {@code TypeBoolASTBuilder}.
     *
     * @return a {@code TypeBoolASTBuilder}.
     */
    public final TypeBoolASTBuilder toTypeBool() {
        return new TypeBoolASTBuilder(this.build().toTypeBool());
    }
}
