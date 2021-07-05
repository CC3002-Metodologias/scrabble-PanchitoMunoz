package cl.uchile.dcc.scrabble.model.factories.types_factories;

import cl.uchile.dcc.scrabble.model.factories.AbstractGeneralTypeFactory;
import java.util.HashMap;

/**
 * An abstract class for the {@code SType} factories.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/05 0:44
 */
public abstract class AbstractSTypeFactory extends AbstractGeneralTypeFactory {

    /**
     * General constructor
     *
     * @param hashMapCache a {@code HashMap}
     */
    protected AbstractSTypeFactory(
        HashMap<Object, Object> hashMapCache) {
        super(hashMapCache);
    }
}
