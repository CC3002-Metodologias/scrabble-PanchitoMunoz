package cl.uchile.dcc.scrabble.model.types.interface_types;

import cl.uchile.dcc.scrabble.model.ast.interfaces.TypeAST;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.operations.add.IAddWithStr;

/**
 * An interface for the sole purpose of representing any type.
 *
 * @author Francisco Muñoz Guajardo
 */
public interface SType extends TypeAST, IAddWithStr {

    /**
     * Transforms the current type to a TypeString.
     *
     * @return TypeString with a value equivalent to the current type.
     */
    TypeString toTypeString();
}
