package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import java.util.ArrayList;
import java.util.List;

/**
 * Base class to wrapped types.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 16:01
 */
public abstract class BaseHTypeTest extends BaseTypeTest {

    protected final HiddenNull hiddenNull = HTypeFactory.createHiddenNull();
    protected final HiddenBinary hiddenBinaryZero = new HiddenBinary(typeBinaryZero);
    // Booleans
    protected final HiddenBool trueHiddenBool = new HiddenBool(trueTypeBool);
    protected final HiddenBool falseHiddenBool = new HiddenBool(falseTypeBool);
    protected final HiddenFloat hiddenFloatZero = new HiddenFloat(typeFloatZero);
    protected final HiddenInt hiddenIntZero = new HiddenInt(typeIntZero);
    // Binaries
    protected HiddenBinary hiddenBinary1;
    protected HiddenBinary hiddenBinary2;
    // Floats
    protected HiddenFloat hiddenFloat1;
    protected HiddenFloat hiddenFloat2;
    // Ints
    protected HiddenInt hiddenInt1;
    protected HiddenInt hiddenInt2;
    // Strings
    protected HiddenString hiddenString1;
    protected HiddenString hiddenString2;
    protected List<HType> hTypeList2 = new ArrayList<>();

    @Override
    protected void setUp() {
        // Setting random values
        super.setUp();
        hTypeList2.add(trueHiddenBool);
        hTypeList2.add(falseHiddenBool);
        // Generate 2 binaries random
        hiddenBinary1 = new HiddenBinary(typeBinary1);
        hiddenBinary2 = new HiddenBinary(typeBinary2);
        hTypeList2.add(hiddenBinary2);
        // Generate 2 floats random
        hiddenFloat1 = new HiddenFloat(typeFloat1);
        hiddenFloat2 = new HiddenFloat(typeFloat2);
        hTypeList2.add(hiddenFloat2);
        // Generate 2 ints random
        hiddenInt1 = new HiddenInt(typeInt1);
        hiddenInt2 = new HiddenInt(typeInt2);
        hTypeList2.add(hiddenInt2);
        // Generate 2 strings random
        hiddenString1 = new HiddenString(typeString1);
        hiddenString2 = new HiddenString(typeString2);
        hTypeList2.add(hiddenString2);
    }
}
