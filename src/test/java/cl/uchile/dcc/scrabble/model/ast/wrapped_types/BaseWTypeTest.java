package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;

/**
 * Base class to wrapped types.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 16:01
 */
public abstract class BaseWTypeTest extends BaseTypeTest {

    protected final WrappedBinary wBinaryZero = new WrappedBinary(typeBinaryZero);
    // Booleans
    protected final WrappedBool trueWBool = new WrappedBool(trueTypeBool);
    protected final WrappedBool falseWBool = new WrappedBool(falseTypeBool);
    protected final WrappedFloat wFloatZero = new WrappedFloat(typeFloatZero);
    protected final WrappedInt wIntZero = new WrappedInt(typeIntZero);
    // Binaries
    protected WrappedBinary wBinary1;
    protected WrappedBinary wBinary2;
    // Floats
    protected WrappedFloat wFloat1;
    protected WrappedFloat wFloat2;
    // Ints
    protected WrappedInt wInt1;
    protected WrappedInt wInt2;
    // Strings
    protected WrappedString wString1;
    protected WrappedString wString2;

    protected void setUp() {
        // Setting random values
        super.setUp();
        // Generate 2 binaries random
        wBinary1 = new WrappedBinary(typeBinary1);
        wBinary2 = new WrappedBinary(typeBinary2);
        // Generate 2 floats random
        wFloat1 = new WrappedFloat(typeFloat1);
        wFloat2 = new WrappedFloat(typeFloat2);
        // Generate 2 ints random
        wInt1 = new WrappedInt(typeInt1);
        wInt2 = new WrappedInt(typeInt2);
        // Generate 2 strings random
        wString1 = new WrappedString(typeString1);
        wString2 = new WrappedString(typeString2);
    }
}
