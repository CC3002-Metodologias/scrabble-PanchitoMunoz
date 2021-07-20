package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/20 1:51
 */
public interface HNumber extends HType {

    /**
     * Get value as double
     *
     * @return Get value as double
     */
    double getValueAsDouble();
}
