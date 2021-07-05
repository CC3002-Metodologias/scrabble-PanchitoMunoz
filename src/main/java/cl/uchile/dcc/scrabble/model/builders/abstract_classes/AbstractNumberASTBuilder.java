package cl.uchile.dcc.scrabble.model.builders.abstract_classes;

import cl.uchile.dcc.scrabble.model.builders.TypeFloatASTBuilder;
import cl.uchile.dcc.scrabble.model.builders.interfaces.NumberASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;

/**
 * Abstract class for a number type in {@code AST} builder.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/02 19:45
 */
public abstract class AbstractNumberASTBuilder
    extends AbstractTypeASTBuilder implements NumberASTBuilder {

    /**
     * Constructor. Only used by the developer.
     *
     * @param valueToBuild a value to build.
     */
    protected AbstractNumberASTBuilder(Operation valueToBuild) {
        super(valueToBuild);
    }


    /**
     * Transform the {@code AST} in the builder into a {@code TypeFloatASTBuilder}.
     *
     * @return a {@code TypeFloatASTBuilder}.
     */
    public final TypeFloatASTBuilder toTypeFloat() {
        return new TypeFloatASTBuilder(this.build().toTypeFloat());
    }
}
