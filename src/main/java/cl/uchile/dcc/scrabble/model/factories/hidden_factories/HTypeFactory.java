package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.HiddenNull;
import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * An Utility Class to creates instances of {@code HType}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 22:29
 */
public final class HTypeFactory {

    private static final HiddenBinaryFactory binaryFactory = HiddenBinaryFactory.getInstance();
    private static final HiddenBoolFactory boolFactory = HiddenBoolFactory.getInstance();
    private static final HiddenFloatFactory floatFactory = HiddenFloatFactory.getInstance();
    private static final HiddenIntFactory intFactory = HiddenIntFactory.getInstance();
    private static final HiddenStringFactory stringFactory = HiddenStringFactory.getInstance();

    /**
     * Private constructor to avoid instance this class
     */
    private HTypeFactory() {}

    /**
     * Create a {@code HiddenBinary} from another instance.
     *
     * @param instance a {@code HiddenBinary} instance.
     * @return a {@code HiddenBinary} from the cache.
     */
    public static HiddenBinary createHiddenBinary(HiddenBinary instance) {
        return binaryFactory.create(instance);
    }

    /**
     * Create a {@code HiddenBool} from another instance.
     *
     * @param instance a {@code HiddenBool} instance.
     * @return a {@code HiddenBool} from the cache.
     */
    public static HiddenBool createHiddenBool(HiddenBool instance) {
        return boolFactory.create(instance);
    }

    /**
     * Create a {@code HiddenFloat} from another instance.
     *
     * @param instance a {@code HiddenFloat} instance.
     * @return a {@code HiddenFloat} from the cache.
     */
    public static HiddenFloat createHiddenFloat(HiddenFloat instance) {
        return floatFactory.create(instance);
    }

    /**
     * Create a {@code HiddenInt} from another instance.
     *
     * @param instance a {@code HiddenInt} instance.
     * @return a {@code HiddenInt} from the cache.
     */
    public static HiddenInt createHiddenInt(HiddenInt instance) {
        return intFactory.create(instance);
    }

    /**
     * Create a {@code HiddenString} from another instance.
     *
     * @param instance a {@code HiddenString} instance.
     * @return a {@code HiddenString} from the cache.
     */
    public static HiddenString createHiddenString(HiddenString instance) {
        return stringFactory.create(instance);
    }

    /**
     * Create a {@code HiddenNull}.
     *
     * @return a {@code HiddenNull} from the cache.
     */
    public static HiddenNull createHiddenNull() {
        return HiddenNull.getInstance();
    }

    /**
     * Create a {@code HiddenBinary} from another instance.
     *
     * @param instance a {@code TypeBinary} instance.
     * @return a {@code HiddenBinary} from the cache.
     */
    public static HiddenBinary createHiddenBinary(TypeBinary instance) {
        return binaryFactory.create(instance);
    }

    /**
     * Create a {@code HiddenBool} from another instance.
     *
     * @param instance a {@code TypeBool} instance.
     * @return a {@code HiddenBool} from the cache.
     */
    public static HiddenBool createHiddenBool(TypeBool instance) {
        return boolFactory.create(instance);
    }

    /**
     * Create a {@code HiddenFloat} from another instance.
     *
     * @param instance a {@code TypeFloat} instance.
     * @return a {@code HiddenFloat} from the cache.
     */
    public static HiddenFloat createHiddenFloat(TypeFloat instance) {
        return floatFactory.create(instance);
    }

    /**
     * Create a {@code HiddenInt} from another instance.
     *
     * @param instance a {@code TypeInt} instance.
     * @return a {@code HiddenInt} from the cache.
     */
    public static HiddenInt createHiddenInt(TypeInt instance) {
        return intFactory.create(instance);
    }

    /**
     * Create a {@code HiddenString} from another instance.
     *
     * @param instance a {@code TypeString} instance.
     * @return a {@code HiddenString} from the cache.
     */
    public static HiddenString createHiddenString(TypeString instance) {
        return stringFactory.create(instance);
    }

    /**
     * Create a {@code HiddenBinary} from the value given.
     *
     * @param value a value.
     * @return a {@code HiddenBinary} from the cache.
     */
    public static HiddenBinary createHiddenBinary(String value) {
        return binaryFactory.create(value);
    }

    /**
     * Create a {@code HiddenBool} from the value given.
     *
     * @param value a value.
     * @return a {@code HiddenBool} from the cache.
     */
    public static HiddenBool createHiddenBool(boolean value) {
        return boolFactory.create(value);
    }

    /**
     * Create a {@code HiddenFloat} from the value given.
     *
     * @param value a value.
     * @return a {@code HiddenFloat} from the cache.
     */
    public static HiddenFloat createHiddenFloat(double value) {
        return floatFactory.create(value);
    }

    /**
     * Create a {@code HiddenInt} from the value given.
     *
     * @param value a value.
     * @return a {@code HiddenInt} from the cache.
     */
    public static HiddenInt createHiddenInt(int value) {
        return intFactory.create(value);
    }

    /**
     * Create a {@code HiddenString} from the value given.
     *
     * @param value a value.
     * @return a {@code HiddenString} from the cache.
     */
    public static HiddenString createHiddenString(String value) {
        return stringFactory.create(value);
    }

}
