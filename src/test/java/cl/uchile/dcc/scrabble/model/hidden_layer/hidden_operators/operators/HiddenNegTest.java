package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenSub;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.HiddenNeg;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class HiddenNegTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testToString() {
        String templateString = (
            "Neg(\n"
            + "  %s\n"
            + ")"
        );
        for (HType hType1 : hTypeList2) {
            String expected = String.format(templateString, hType1.asString(0));
            assertEquals(expected, new HiddenNeg(hType1).toString(),
                "Method toString does not works." + messageSeed);
        }
    }

    @RepeatedTest(20)
    void testCalculate() {
        for (HType hType :
            hLogicalList) {
            assertEquals(hType.neg(), new HiddenNeg(hType).calculate(),
                "Method neg does not works." + messageSeed);
        }
        for (HType hType :
            hLogicalCList) {
            assertEquals(hiddenNull, new HiddenNeg(hType).calculate(),
                "Method neg does not works." + messageSeed);
        }
    }

    @RepeatedTest(20)
    void testTestEquals() {
        HiddenNeg hiddenNeg = new HiddenNeg(hiddenBinary1);
        HiddenNeg equalsHiddenNeg = new HiddenNeg(hiddenBinary1);
        HiddenNeg differentHiddenNeg = new HiddenNeg(trueHiddenBool);
        HiddenSub otherNode = new HiddenSub(hiddenFloat1, hiddenFloat2);
        assertEquals(hiddenNeg, hiddenNeg,
            "Method equals does not works." + messageSeed);
        assertEquals(equalsHiddenNeg, hiddenNeg,
            "Method equals does not works." + messageSeed);
        assertNotEquals(differentHiddenNeg, hiddenNeg,
            "Method equals does not works." + messageSeed);
        assertNotEquals(otherNode, hiddenNeg,
            "Method equals does not works." + messageSeed);
        assertNotEquals(hiddenNeg, hiddenString1,
            "Method equals does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testTestHashCode() {
        HiddenNeg hiddenNeg = new HiddenNeg(hiddenBinary1);
        HiddenNeg equalsHiddenNeg = new HiddenNeg(hiddenBinary1);
        HiddenNeg differentHiddenNeg = new HiddenNeg(hiddenBinary2);
        HiddenSub otherNode = new HiddenSub(hiddenFloat1, hiddenFloat2);
        assertEquals(equalsHiddenNeg.hashCode(), hiddenNeg.hashCode(),
            "Method hashCode does not works with equals content." + messageSeed);
        assertNotEquals(differentHiddenNeg.hashCode(), hiddenNeg.hashCode(),
            "Method hashCode does not works with different content." + messageSeed);
        assertNotEquals(otherNode.hashCode(), hiddenNeg.hashCode(),
            "Method hashCode does not works with a different node." + messageSeed);
        assertNotEquals(hiddenString1.hashCode(), hiddenNeg.hashCode(),
            "Method hashCode does not works with other value." + messageSeed);
    }

    @RepeatedTest(20)
    void testCopy() {
        HiddenNeg operation = new HiddenNeg(hiddenFloat1);
        HiddenOperator other = operation.copy();
        assertNotSame(other, operation);
        assertSame(other.getFirstChildren(), operation.getFirstChildren());
    }

    @Test
    void testAccept() {
        HiddenOperator operator = new HiddenNeg(new HiddenVariable("x"));
        operator.setVariable("x", trueHiddenBool);
        assertEquals(falseHiddenBool, operator.calculate(),
            "Method accept does not works." + messageSeed);
    }

    @Test
    void testAsCode() {
        String expected = "~(true)";
        assertEquals(expected, new HiddenNeg(trueHiddenBool).asCode(),
            "Method asCode does not works." + messageSeed);
    }
}