package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;

/**
 * Interface for General Types that represents a number
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/20 1:51
 */
public interface HNumber extends HType {

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    SNumber asSType();

    /**
     * Get value as double
     *
     * @return Get value as double
     */
    double getValueAsDouble();
}
