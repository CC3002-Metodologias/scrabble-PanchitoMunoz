package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;

/**
 * Base class to wrapped types.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 16:01
 */
public abstract class BaseWTypeTest extends BaseTypeTest {

    protected final WBinary wBinaryZero = new WBinary(typeBinaryZero);
    // Booleans
    protected final WBool trueWBool = new WBool(trueTypeBool);
    protected final WBool falseWBool = new WBool(falseTypeBool);
    protected final WFloat wFloatZero = new WFloat(typeFloatZero);
    protected final WInt wIntZero = new WInt(typeIntZero);
    // Binaries
    protected WBinary wBinary1;
    protected WBinary wBinary2;
    // Floats
    protected WFloat wFloat1;
    protected WFloat wFloat2;
    // Ints
    protected WInt wInt1;
    protected WInt wInt2;
    // Strings
    protected WString wString1;
    protected WString wString2;

    protected void setUp() {
        // Setting random values
        super.setUp();
        // Generate 2 binaries random
        wBinary1 = new WBinary(typeBinary1);
        wBinary2 = new WBinary(typeBinary2);
        // Generate 2 floats random
        wFloat1 = new WFloat(typeFloat1);
        wFloat2 = new WFloat(typeFloat2);
        // Generate 2 ints random
        wInt1 = new WInt(typeInt1);
        wInt2 = new WInt(typeInt2);
        // Generate 2 strings random
        wString1 = new WString(typeString1);
        wString2 = new WString(typeString2);
    }
}
