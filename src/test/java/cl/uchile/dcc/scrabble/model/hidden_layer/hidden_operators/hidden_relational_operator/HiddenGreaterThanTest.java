package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.hidden_relational_operator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.HiddenAdd;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenGreaterThanTest extends BaseHiddenRelationalOperatorTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
        greaterNumber = greaterHNumber(hiddenBinary1, hiddenBinary2);
        lowerNumber = lowerHNumber(hiddenBinary1, hiddenBinary2);
        greaterCase = new HiddenGreaterThan(greaterNumber, lowerNumber);
        equalsCase = new HiddenGreaterThan(hiddenBinary1, hiddenBinary1.toHiddenFloat());
        lowerCase = new HiddenGreaterThan(lowerNumber, greaterNumber);
    }

    @RepeatedTest(20)
    void testEquals() {
        HiddenRelationalOperator other = new HiddenGreaterThan(greaterNumber, lowerNumber);
        assertEquals(greaterCase, other,
            "Method equals does not works with equals case." + messageSeed);
        assertNotEquals(lowerCase, other,
            "Method equals does not works with different case." + messageSeed);
        assertNotEquals(new HiddenAdd(greaterNumber, lowerNumber), greaterCase,
            " Method equals does not works with different type." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        HiddenRelationalOperator other = new HiddenGreaterThan(greaterNumber, lowerNumber);
        assertEquals(greaterCase.hashCode(), other.hashCode(),
            "Method equals does not works with equals case." + messageSeed);
        assertNotEquals(lowerCase.hashCode(), other.hashCode(),
            "Method equals does not works with different case." + messageSeed);
        assertNotEquals(
            new HiddenAdd(greaterNumber, lowerNumber).hashCode(), greaterCase.hashCode(),
            " Method equals does not works with different type." + messageSeed);
    }

    @RepeatedTest(20)
    void testAsString() {
        String templateString = (
            "GreaterThan(\n"
                + "  %s >\n"
                + "  %s\n"
                + ")"
        );
        for (HType hType1 : hTypeList2) {
            for (HType hType2 : hTypeList2) {
                String expected = String.format(templateString,
                    hType1.asString(0), hType2.asString(0));
                assertEquals(expected, new HiddenGreaterThan(hType1, hType2).asString(0),
                    "Method asString does not works." + messageSeed);
            }
        }
    }

    @RepeatedTest(20)
    void testSize() {
        assertEquals(3, greaterCase.size(),
            "Method size does not works." + messageSeed);
        HiddenRelationalOperator operator = new HiddenGreaterThan(hiddenFloat1, greaterCase);
        assertEquals(5, operator.size(),
            "Method size does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testCalculate() {
        assertEquals(trueHiddenBool, greaterCase.calculate(),
            "Method calculate does not works with greater case." + messageSeed);
        assertEquals(falseHiddenBool, equalsCase.calculate(),
            "Method calculate does not works with equals case." + messageSeed);
        assertEquals(falseHiddenBool, lowerCase.calculate(),
            "Method calculate does not works with lower case." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        assertEquals(greaterCase.asString(0), greaterCase.toString(),
            "Method toString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testSetVariable() {
        HiddenRelationalOperator operator = new HiddenGreaterThan(
            new HiddenVariable("x"), new HiddenVariable("y")
        );
        operator.setVariable("x", greaterNumber);
        operator.setVariable("y", lowerNumber);
        assertEquals(trueHiddenBool, operator.calculate(),
            "Method setVariable does not works." + messageSeed);
        operator.setVariable("x", lowerNumber);
        operator.setVariable("y", greaterNumber);
        assertEquals(falseHiddenBool, operator.calculate(),
            "Method setVariable does not works." + messageSeed);
    }

}