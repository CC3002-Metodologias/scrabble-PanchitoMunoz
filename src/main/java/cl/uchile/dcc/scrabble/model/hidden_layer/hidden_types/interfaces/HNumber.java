package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;

/**
 * Interface for General Types that represents a number
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/20 1:51
 */
public interface HNumber extends HType, Comparable<HNumber> {

    /**
     * Gets the value as a {@code SNumber}
     *
     * @return the value as a {@code SNumber}
     */
    SNumber asSNumber();

    /**
     * Get value as double
     *
     * @return Get value as double
     */
    double getValueAsDouble();
}
