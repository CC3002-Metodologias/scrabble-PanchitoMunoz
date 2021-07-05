package cl.uchile.dcc.scrabble.model.builders.abstract_classes;

import cl.uchile.dcc.scrabble.model.builders.TypeStringASTBuilder;
import cl.uchile.dcc.scrabble.model.builders.interfaces.TypeASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;

/**
 * Abstract class for a general type in {@code AST} builder.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/02 19:25
 */
public abstract class AbstractTypeASTBuilder implements TypeASTBuilder {

    private final Operation valueToBuild;

    /**
     * Constructor. Only used by the developer.
     *
     * @param valueToBuild a value to build.
     */
    protected AbstractTypeASTBuilder(Operation valueToBuild) {
        this.valueToBuild = valueToBuild;
    }

    /**
     * Builds the {@code AST}.
     *
     * @return the {@code AST} built.
     */
    @Override
    public final Operation build() {
        return valueToBuild;
    }

    /**
     * Transform the {@code AST} in the builder into a {@code TypeStringASTBuilder}.
     *
     * @return a {@code TypeStringASTBuilder}.
     */
    public final TypeStringASTBuilder toTypeString() {
        return new TypeStringASTBuilder(this.build().toTypeString());
    }
}
