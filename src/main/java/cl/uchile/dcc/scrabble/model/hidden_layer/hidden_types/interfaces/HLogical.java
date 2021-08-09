package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;

/**
 * Interface for a general type that represents a logical
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/20 1:52
 */
public interface HLogical extends HType {

    /**
     * Gets the value as a {@code SLogical}
     *
     * @return the value as a {@code SLogical}
     */
    SLogical asSLogical();

}
