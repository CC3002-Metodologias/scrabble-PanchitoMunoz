package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.abstract_types.AbstractHiddenType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * todo: documentar
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 14:20
 */
public class HiddenNull extends AbstractHiddenType {

    /**
     * To use Singleton pattern
     */
    private static HiddenNull uniqueInstance;

    /**
     * Private constructor to avoid multiples instances
     */
    private HiddenNull() {}

    /**
     * Returns the unique {@code HiddenNull} instance.
     *
     * @return the {@code HiddenNull} instance
     */
    public static HiddenNull getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new HiddenNull();
            return uniqueInstance;
        }
        return uniqueInstance;
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public SType toSType() {
        return null;
    }
}
