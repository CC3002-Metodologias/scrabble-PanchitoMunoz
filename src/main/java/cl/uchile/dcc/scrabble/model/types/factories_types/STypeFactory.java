package cl.uchile.dcc.scrabble.model.types.factories_types;

/**
 * Interface to describe any factory of SType.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 20:47
 */
public interface STypeFactory {

    /**
     * Clear the current caché.
     */
    void clear();

    /**
     * Returns {@code true} if the caché is empty, {@code false} otherwise.
     *
     * @return a boolean
     */
    boolean isEmpty();
}
