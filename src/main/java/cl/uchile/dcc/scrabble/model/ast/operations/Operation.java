package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeBinary;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeBool;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeFloat;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeInt;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeString;

/**
 * This interface is to define the different types of operations that exists. This is the composite
 * part of {@code HiddenAST}, using the composite pattern
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 23:47
 * @see HiddenAST
 */
public interface Operation extends AST {

    /**
     * Transform the current instance into a {@code TypeBinary}.
     *
     * @return a {@code TypeBinary}
     */
    default Operation toTypeBinary() {
        return new ToTypeBinary(this);
    }

    /**
     * Transform the current instance into a {@code TypeBool}.
     *
     * @return a {@code TypeBool}
     */
    default Operation toTypeBool() {
        return new ToTypeBool(this);
    }

    /**
     * Transform the current instance into a {@code TypeFloat}.
     *
     * @return a {@code TypeFloat}
     */
    default Operation toTypeFloat() {
        return new ToTypeFloat(this);
    }

    /**
     * Transform the current instance into a {@code TypeInt}.
     *
     * @return a {@code TypeInt}
     */
    default Operation toTypeInt() {
        return new ToTypeInt(this);
    }

    /**
     * Transform the current instance into a {@code TypeString}.
     *
     * @return a {@code TypeString}
     */
    default Operation toTypeString() {
        return new ToTypeString(this);
    }
}
