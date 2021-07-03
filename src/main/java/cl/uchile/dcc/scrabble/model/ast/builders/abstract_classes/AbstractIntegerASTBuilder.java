package cl.uchile.dcc.scrabble.model.ast.builders.abstract_classes;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.builders.TypeBinaryASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.builders.TypeIntASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.builders.interfaces.IntegerASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.builders.interfaces.NumberASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;

/**
 * Abstract class for an integer type in {@code AST} builder.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/02 19:55
 */
public abstract class AbstractIntegerASTBuilder
    extends AbstractNumberASTBuilder implements IntegerASTBuilder {

    /**
     * Constructor. Only used by the developer.
     *
     * @param valueToBuild a value to build.
     */
    protected AbstractIntegerASTBuilder(Operation valueToBuild) {
        super(valueToBuild);
    }

    /**
     * Transform the {@code AST} in the builder into a {@code TypeIntASTBuilder}.
     *
     * @return a {@code TypeIntASTBuilder}.
     */
    public final TypeIntASTBuilder toTypeInt() {
        return new TypeIntASTBuilder(this.build().toTypeInt());
    }

    /**
     * Transform the {@code AST} in the builder into a {@code TypeBinaryASTBuilder}.
     *
     * @return a {@code TypeBinaryASTBuilder}.
     */
    public final TypeBinaryASTBuilder toTypeBinary() {
        return new TypeBinaryASTBuilder(this.build().toTypeBinary());
    }
}
