package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.types.TypeBool;

/**
 * An interface to represent a HiddenBool or a HiddenNull
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/23 19:35
 */
public interface HBool extends HType, HLogical {

    /**
     * Returns the value as a {@code TypeBool}
     *
     * @return the value as a {@code TypeBool}
     */
    TypeBool asTypeBool();

}
