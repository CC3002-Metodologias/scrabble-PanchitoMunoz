package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.AbstractRandomValues;
import cl.uchile.dcc.scrabble.model.factories.types_factories.TypeBinaryFactory;
import cl.uchile.dcc.scrabble.model.factories.types_factories.TypeBoolFactory;
import cl.uchile.dcc.scrabble.model.factories.types_factories.TypeFloatFactory;
import cl.uchile.dcc.scrabble.model.factories.types_factories.TypeIntFactory;
import cl.uchile.dcc.scrabble.model.factories.types_factories.TypeStringFactory;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import java.util.ArrayList;
import java.util.List;

/**
 * A base class that contains the standard settings for each test class in types.
 *
 * @author Francisco Muñoz Guajardo
 */
public abstract class BaseTypeTest extends AbstractRandomValues {

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
    // List random SType
    protected List<SType> listRandSType = new ArrayList<>();

    protected void setUp() {
        // Setting random values
        setRandomValues();
        // Generate 2 binaries random
        typeBinary1 = new TypeBinary(aBinary1);
        typeBinary2 = new TypeBinary(aBinary2);
        listRandSType.add(typeBinary1);
        listRandSType.add(trueTypeBool);
        listRandSType.add(falseTypeBool);
        // Generate 2 floats random
        typeFloat1 = new TypeFloat(aFloat1);
        typeFloat2 = new TypeFloat(aFloat2);
        listRandSType.add(typeFloat1);
        // Generate 2 ints random
        typeInt1 = new TypeInt(anInt1);
        typeInt2 = new TypeInt(anInt2);
        listRandSType.add(typeInt1);
        // Generate 2 strings random
        typeString1 = new TypeString(aString1);
        typeString2 = new TypeString(aString2);
        listRandSType.add(typeString1);
    }

    protected void tearDown() {
        // Clears the cache
        TypeBinaryFactory.getInstance().clear();
        TypeBoolFactory.getInstance().clear();
        TypeFloatFactory.getInstance().clear();
        TypeIntFactory.getInstance().clear();
        TypeStringFactory.getInstance().clear();
    }
}
