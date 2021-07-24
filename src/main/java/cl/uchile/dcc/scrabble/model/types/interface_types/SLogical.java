package cl.uchile.dcc.scrabble.model.types.interface_types;

import cl.uchile.dcc.scrabble.model.builders.interfaces.LogicalASTBuilder;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HLogical;
import cl.uchile.dcc.scrabble.model.types.operations.LogicalOperations;

/**
 * An interface for the sole purpose of representing a logical (e.g.: TypeBinary and TypeBool).
 *
 * @author Francisco Muñoz Guajardo
 */
public interface SLogical extends SType, LogicalOperations, LogicalASTBuilder {

    /**
     * Transform the current {@code SType} as a {@code HType}.
     *
     * @return a transformation
     */
    @Override
    HLogical asHType();

}
