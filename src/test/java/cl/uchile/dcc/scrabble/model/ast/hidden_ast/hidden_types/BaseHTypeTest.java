package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;

/**
 * Base class to wrapped types.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 16:01
 */
public abstract class BaseHTypeTest extends BaseTypeTest {

    protected final HiddenBinary wBinaryZero = new HiddenBinary(typeBinaryZero);
    // Booleans
    protected final HiddenBool trueWBool = new HiddenBool(trueTypeBool);
    protected final HiddenBool falseWBool = new HiddenBool(falseTypeBool);
    protected final HiddenFloat wFloatZero = new HiddenFloat(typeFloatZero);
    protected final HiddenInt wIntZero = new HiddenInt(typeIntZero);
    // Binaries
    protected HiddenBinary wBinary1;
    protected HiddenBinary wBinary2;
    // Floats
    protected HiddenFloat wFloat1;
    protected HiddenFloat wFloat2;
    // Ints
    protected HiddenInt wInt1;
    protected HiddenInt wInt2;
    // Strings
    protected HiddenString wString1;
    protected HiddenString wString2;

    protected void setUp() {
        // Setting random values
        super.setUp();
        // Generate 2 binaries random
        wBinary1 = new HiddenBinary(typeBinary1);
        wBinary2 = new HiddenBinary(typeBinary2);
        // Generate 2 floats random
        wFloat1 = new HiddenFloat(typeFloat1);
        wFloat2 = new HiddenFloat(typeFloat2);
        // Generate 2 ints random
        wInt1 = new HiddenInt(typeInt1);
        wInt2 = new HiddenInt(typeInt2);
        // Generate 2 strings random
        wString1 = new HiddenString(typeString1);
        wString2 = new HiddenString(typeString2);
    }
}
