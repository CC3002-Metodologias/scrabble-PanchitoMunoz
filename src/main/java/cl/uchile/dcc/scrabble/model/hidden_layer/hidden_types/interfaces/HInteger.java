package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/20 1:52
 */
public interface HInteger extends HNumber {

    /**
     * Gets the value as binary
     *
     * @return the value as binary
     */
    String getValueAsBinary();

    /**
     * Gets the value as int
     *
     * @return Gets the value as int
     */
    int getValueAsInt();
}
