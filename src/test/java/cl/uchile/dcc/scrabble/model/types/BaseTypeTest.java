package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.AbstractRandomValues;

/**
 * A base class that contains the standard settings for each test class in types.
 *
 * @author Francisco Muñoz Guajardo
 */
public class BaseTypeTest extends AbstractRandomValues {

    // Binaries
    protected TypeBinary typeBinary1;
    protected TypeBinary typeBinary2;
    protected final TypeBinary typeBinaryZero = new TypeBinary(aBinaryZero);
    // Booleans
    protected final TypeBool trueTypeBool = new TypeBool(trueBoolean);
    protected final TypeBool falseTypeBool = new TypeBool(falseBoolean);
    // Floats
    protected TypeFloat typeFloat1;
    protected TypeFloat typeFloat2;
    protected final TypeFloat typeFloatZero = new TypeFloat(aFloatZero);
    // Ints
    protected TypeInt typeInt1;
    protected TypeInt typeInt2;
    protected final TypeInt typeIntZero = new TypeInt(anIntZero);
    // Strings
    protected TypeString typeString1;
    protected TypeString typeString2;

    protected void setUp() {
        // Setting random values
        setRandomValues();
        // Generate 2 binaries random
        typeBinary1 = new TypeBinary(aBinary1);
        typeBinary2 = new TypeBinary(aBinary2);
        // Generate 2 floats random
        typeFloat1 = new TypeFloat(aFloat1);
        typeFloat2 = new TypeFloat(aFloat2);
        // Generate 2 ints random
        typeInt1 = new TypeInt(anInt1);
        typeInt2 = new TypeInt(anInt2);
        // Generate 2 strings random
        typeString1 = new TypeString(aString1);
        typeString2 = new TypeString(aString2);
    }
}
