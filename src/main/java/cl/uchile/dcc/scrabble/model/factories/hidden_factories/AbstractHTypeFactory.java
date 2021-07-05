package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import cl.uchile.dcc.scrabble.model.factories.AbstractGeneralTypeFactory;
import java.util.HashMap;

/**
 * An abstract class for the {@code HType} factories.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/05 0:56
 */
public abstract class AbstractHTypeFactory extends AbstractGeneralTypeFactory {

    /**
     * General constructor
     *
     * @param hashMapCache a {@code HashMap}
     */
    protected AbstractHTypeFactory(
        HashMap<Object, Object> hashMapCache) {
        super(hashMapCache);
    }
}
