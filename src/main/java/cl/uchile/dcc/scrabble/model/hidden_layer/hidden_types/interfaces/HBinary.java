package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;

/**
 * An interface to represent a HiddenBinary or a HiddenNull
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/23 19:34
 */
public interface HBinary extends HInteger, HLogical {

    /**
     * Returns the value as a {@code TypeBinary}
     *
     * @return the value as a {@code TypeBinary}
     */
    TypeBinary asTypeBinary();

}
