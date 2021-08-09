package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces;

import cl.uchile.dcc.scrabble.model.types.TypeFloat;

/**
 * An interface to represent a HiddenFloat or a HiddenNull
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/23 19:35
 */
public interface HFloat extends HNumber {

    /**
     * Returns the value as a {@code TypeFloat}
     *
     * @return the value as a {@code TypeFloat}
     */
    TypeFloat asTypeFloat();

}
