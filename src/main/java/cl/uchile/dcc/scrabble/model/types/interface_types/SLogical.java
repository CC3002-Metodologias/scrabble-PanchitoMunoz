package cl.uchile.dcc.scrabble.model.types.interface_types;

import cl.uchile.dcc.scrabble.model.ast.interfaces.LogicalAST;
import cl.uchile.dcc.scrabble.model.types.operations.INeg;
import cl.uchile.dcc.scrabble.model.types.operations.LogicalOperations;
import cl.uchile.dcc.scrabble.model.types.operations.and.IAndWithBinary;
import cl.uchile.dcc.scrabble.model.types.operations.and.IAndWithBool;
import cl.uchile.dcc.scrabble.model.types.operations.or.IOrWithBinary;
import cl.uchile.dcc.scrabble.model.types.operations.or.IOrWithBool;

/**
 * An interface for the sole purpose of representing a logical (e.g.: TypeBinary and TypeBool).
 *
 * @author Francisco Muñoz Guajardo
 */
public interface SLogical
    extends LogicalAST, INeg, LogicalOperations, IAndWithBool, IOrWithBool, IAndWithBinary,
    IOrWithBinary {

}
