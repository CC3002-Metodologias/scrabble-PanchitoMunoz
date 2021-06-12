package cl.uchile.dcc.scrabble.model.types.interface_types;

import cl.uchile.dcc.scrabble.model.operations.INeg;
import cl.uchile.dcc.scrabble.model.operations.LogicalOperations;
import cl.uchile.dcc.scrabble.model.operations.and.IAndWithBinary;
import cl.uchile.dcc.scrabble.model.operations.and.IAndWithBool;
import cl.uchile.dcc.scrabble.model.operations.or.IOrWithBinary;
import cl.uchile.dcc.scrabble.model.operations.or.IOrWithBool;

/**
 * An interface for the sole purpose of representing a logical (e.g.: TypeBinary and TypeBool).
 *
 * @author Francisco Muñoz Guajardo
 */
public interface SLogical
    extends INeg, LogicalOperations, IAndWithBool, IOrWithBool, IAndWithBinary, IOrWithBinary {

}
