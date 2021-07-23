package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces;

import cl.uchile.dcc.scrabble.model.types.TypeInt;

/**
 * An interface to represent a HiddenInt or a HiddenNull
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/23 19:36
 */
public interface HInt extends HInteger {

    /**
     * Returns the value as a {@code TypeInt}
     *
     * @return the value as a {@code TypeInt}
     */
    TypeInt asTypeInt();

}
