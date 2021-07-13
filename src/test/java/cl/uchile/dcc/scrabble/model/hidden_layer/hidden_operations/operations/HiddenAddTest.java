package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operations.operations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenAddTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testToString() {
        String templateString = (
            "Add(\n"
            + "  %s +\n"
            + "  %s\n"
            + ")"
        );
        for (HType hType1 : hTypeList2) {
            for (HType hType2 : hTypeList2) {
                String expected = String.format(templateString,
                    hType1.asString(0), hType2.asString(0));
                assertEquals(expected, new HiddenAdd(hType1, hType2).toString(),
                    "Method toString does not works." + messageSeed);
            }
        }
    }

    @RepeatedTest(20)
    void testCalculate() {
        // Add with String
        for (HType hType : hTypeList2) {
            HType expected1 = hiddenString1.add(hType);
            assertEquals(expected1, new HiddenAdd(hiddenString1, hType).calculate(),
                "Method add does not works with string type." + messageSeed);
        }
        // Add with bool
        for (HType hType : hTypeList2) {
            assertEquals(hiddenNull, new HiddenAdd(trueHiddenBool, hType).calculate(),
                "Method add does not works with bool type." + messageSeed);
            assertEquals(hiddenNull, new HiddenAdd(falseHiddenBool, hType).calculate(),
                "Method add does not works with bool type." + messageSeed);
        }
        // Add with float
        for (HType hType : hNumberList) {
            HType expected1 = hiddenFloat1.add(hType);
            assertEquals(expected1, new HiddenAdd(hiddenFloat1, hType).calculate(),
                "Method add does not works with float type." + messageSeed);
        }
        for (HType hType : hNumberCList) {
            assertEquals(hiddenNull, new HiddenAdd(hiddenFloat1, hType).calculate(),
                "Method add does not works with float type." + messageSeed);
        }
        // Add with int
        for (HType hType : hNumberList) {
            HType expected1 = hiddenInt1.add(hType);
            assertEquals(expected1, new HiddenAdd(hiddenInt1, hType).calculate(),
                "Method add does not works with int type." + messageSeed);
        }
        for (HType hType : hNumberCList) {
            assertEquals(hiddenNull, new HiddenAdd(hiddenInt1, hType).calculate(),
                "Method add does not works with int type." + messageSeed);
        }
        // Add with binary
        for (HType hType : hIntegerList) {
            HType expected1 = hiddenBinary1.add(hType);
            assertEquals(expected1, new HiddenAdd(hiddenBinary1, hType).calculate(),
                "Method add does not works with binary type." + messageSeed);
        }
        for (HType hType : hIntegerCList) {
            assertEquals(hiddenNull, new HiddenAdd(hiddenBinary1, hType).calculate(),
                "Method add does not works with binary type." + messageSeed);
        }
    }

    @RepeatedTest(20)
    void testEquals() {
        HiddenAdd hiddenAdd = new HiddenAdd(hiddenString1, hiddenString2);
        HiddenAdd equalsHiddenAdd = new HiddenAdd(hiddenString1, hiddenString2);
        HiddenAdd differentHiddenAdd = new HiddenAdd(hiddenString2, trueHiddenBool);
        HiddenSub otherNode = new HiddenSub(hiddenFloat1, hiddenFloat2);
        assertEquals(hiddenAdd, hiddenAdd,
            "Method equals does not works." + messageSeed);
        assertEquals(equalsHiddenAdd, hiddenAdd,
            "Method equals does not works." + messageSeed);
        assertNotEquals(differentHiddenAdd, hiddenAdd,
            "Method equals does not works." + messageSeed);
        assertNotEquals(otherNode, hiddenAdd,
            "Method equals does not works." + messageSeed);
        assertNotEquals(hiddenAdd, typeString1,
            "Method equals does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testTestHashCode() {
        HiddenAdd hiddenAdd = new HiddenAdd(hiddenString1, hiddenString2);
        HiddenAdd equalsHiddenAdd = new HiddenAdd(hiddenString1, hiddenString2);
        HiddenAdd differentHiddenAdd = new HiddenAdd(hiddenString2, trueHiddenBool);
        HiddenSub otherNode = new HiddenSub(hiddenFloat1, hiddenFloat2);
        assertEquals(equalsHiddenAdd.hashCode(), hiddenAdd.hashCode(),
            "Method hashCode does not works." + messageSeed);
        assertNotEquals(differentHiddenAdd.hashCode(), hiddenAdd.hashCode(),
            "Method hashCode does not works." + messageSeed);
        assertNotEquals(otherNode.hashCode(), hiddenAdd.hashCode(),
            "Method hashCode does not works." + messageSeed);
        assertNotEquals(hiddenString1.hashCode(), hiddenAdd.hashCode(),
            "Method hashCode does not works." + messageSeed);
    }
}