package cl.uchile.dcc.scrabble.model.factories.types_factories;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 21:18
 */
public final class STypeFactory {

    private static final TypeBinaryFactory binaryFactory = TypeBinaryFactory.getInstance();
    private static final TypeBoolFactory boolFactory = TypeBoolFactory.getInstance();
    private static final TypeFloatFactory floatFactory = TypeFloatFactory.getInstance();
    private static final TypeIntFactory intFactory = TypeIntFactory.getInstance();
    private static final TypeStringFactory stringFactory = TypeStringFactory.getInstance();

    /**
     * Private constructor to avoid instance this class
     */
    private STypeFactory() {}

    /**
     * Create a {@code TypeBinary} from another instance.
     *
     * @param instance a {@code TypeBinary} instance.
     * @return a {@code TypeBinary} from the cache.
     */
    public static TypeBinary createTypeBinary(TypeBinary instance) {
        return binaryFactory.create(instance);
    }

    /**
     * Create a {@code TypeBinary} from the value given.
     *
     * @param value a value.
     * @return a {@code TypeBinary} from the cache.
     */
    public static TypeBinary createTypeBinary(String value) {
        return binaryFactory.create(value);
    }

    /**
     * Create a {@code TypeBool} from another instance.
     *
     * @param instance a {@code TypeBool} instance.
     * @return a {@code TypeBool} from the cache.
     */
    public static TypeBool createTypeBool(TypeBool instance) {
        return boolFactory.create(instance);
    }

    /**
     * Create a {@code TypeBool} from the value given.
     *
     * @param value a value.
     * @return a {@code TypeBool} from the cache.
     */
    public static TypeBool createTypeBool(boolean value) {
        return boolFactory.create(value);
    }

    /**
     * Create a {@code TypeFloat} from another instance.
     *
     * @param instance a {@code TypeFloat} instance.
     * @return a {@code TypeFloat} from the cache.
     */
    public static TypeFloat createTypeFloat(TypeFloat instance) {
        return floatFactory.create(instance);
    }

    /**
     * Create a {@code TypeFloat} from the value given.
     *
     * @param value a value.
     * @return a {@code TypeFloat} from the cache.
     */
    public static TypeFloat createTypeFloat(double value) {
        return floatFactory.create(value);
    }

    /**
     * Create a {@code TypeInt} from another instance.
     *
     * @param instance a {@code TypeInt} instance.
     * @return a {@code TypeInt} from the cache.
     */
    public static TypeInt createTypeInt(TypeInt instance) {
        return intFactory.create(instance);
    }

    /**
     * Create a {@code TypeInt} from the value given.
     *
     * @param value a value.
     * @return a {@code TypeInt} from the cache.
     */
    public static TypeInt createTypeInt(int value) {
        return intFactory.create(value);
    }

    /**
     * Create a {@code TypeString} from another instance.
     *
     * @param instance a {@code TypeString} instance.
     * @return a {@code TypeString} from the cache.
     */
    public static TypeString createTypeString(TypeString instance) {
        return stringFactory.create(instance);
    }

    /**
     * Create a {@code TypeString} from the value given.
     *
     * @param value a value.
     * @return a {@code TypeString} from the cache.
     */
    public static TypeString createTypeString(String value) {
        return stringFactory.create(value);
    }

}
