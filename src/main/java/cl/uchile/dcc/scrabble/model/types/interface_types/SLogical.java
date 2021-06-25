package cl.uchile.dcc.scrabble.model.types.interface_types;

import cl.uchile.dcc.scrabble.model.types.operations.LogicalOperations;
import cl.uchile.dcc.scrabble.model.types.operations.operations_type.LogicalOperationsWithBinary;
import cl.uchile.dcc.scrabble.model.types.operations.operations_type.LogicalOperationsWithBool;

/**
 * An interface for the sole purpose of representing a logical (e.g.: TypeBinary and TypeBool).
 *
 * @author Francisco Muñoz Guajardo
 */
public interface SLogical
    extends LogicalOperations, LogicalOperationsWithBinary, LogicalOperationsWithBool {

}
