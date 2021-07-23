package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * An interface to represent a HiddenString or a HiddenNull
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/23 19:36
 */
public interface HString extends HType {

    /**
     * Returns the value as a {@code TypeString}
     *
     * @return the value as a {@code TypeString}
     */
    TypeString asTypeString();

}
