package cl.uchile.dcc.scrabble.model.types.abstract_types;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.factories_types.TypeBinaryFactory;
import cl.uchile.dcc.scrabble.model.types.factories_types.TypeBoolFactory;
import cl.uchile.dcc.scrabble.model.types.factories_types.TypeFloatFactory;
import cl.uchile.dcc.scrabble.model.types.factories_types.TypeIntFactory;
import cl.uchile.dcc.scrabble.model.types.factories_types.TypeStringFactory;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * An abstract class for the general types used.
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractType implements SType {

    /** Cache Factories */
    private final TypeBinaryFactory binaryFactory = TypeBinaryFactory.getInstance();
    private final TypeBoolFactory boolFactory = TypeBoolFactory.getInstance();
    private final TypeFloatFactory floatFactory = TypeFloatFactory.getInstance();
    private final TypeIntFactory intFactory = TypeIntFactory.getInstance();
    private final TypeStringFactory stringFactory = TypeStringFactory.getInstance();

    /**
     * Creates a binary using the factory
     *
     * @param value value to create
     * @return a {@code TypeBinary}
     */
    protected TypeBinary createBinary(String value) {
        return binaryFactory.create(value);
    }

    /**
     * Creates a bool using the factory
     *
     * @param value value to create
     * @return a {@code TypeBool}
     */
    protected TypeBool createBool(boolean value) {
        return boolFactory.create(value);
    }

    /**
     * Creates a float using the factory
     *
     * @param value value to create
     * @return a {@code TypeFloat}
     */
    protected TypeFloat createFloat(double value) {
        return floatFactory.create(value);
    }

    /**
     * Creates a int using the factory
     *
     * @param value value to create
     * @return a {@code TypeInt}
     */
    protected TypeInt createInt(int value) {
        return intFactory.create(value);
    }

    /**
     * Creates a string using the factory
     *
     * @param value value to create
     * @return a {@code TypeString}
     */
    protected TypeString createString(String value) {
        return stringFactory.create(value);
    }

    /**
     * Method that determines if the object 'o' is equals to the current instance.
     * @param o Another object that is compared to the current instance.
     * @return A boolean that determines whether the current instance are equals with 'o'.
     */
    abstract public boolean equals(Object o);

    /**
     * Method that returns the hash code of the current instance.
     * @return The hash code of the current instance.
     */
    abstract public int hashCode();

    /**
     * Method that provides a representation of the current instance as a String.
     *
     * @return The representation as a String.
     */
    abstract public String toString();

    /**
     * Calculate the {@code SType} result of performing all operations
     *
     * @return SType result of operations.
     */
    @Override
    public SType calculate() {
        return this;
    }
}
