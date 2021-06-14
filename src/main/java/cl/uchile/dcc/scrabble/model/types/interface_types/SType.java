package cl.uchile.dcc.scrabble.model.types.interface_types;

import cl.uchile.dcc.scrabble.model.WrapTransformation;
import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.operations.add.IAddWithStr;

/**
 * An interface for the sole purpose of representing any type.
 *
 * @author Francisco Muñoz Guajardo
 */
public interface SType extends WrapTransformation, AST, IAddWithStr {

    /**
     * Transforms the current type to a TypeString.
     *
     * @return TypeString with a value equivalent to the current type.
     */
    TypeString toTypeString();
}
