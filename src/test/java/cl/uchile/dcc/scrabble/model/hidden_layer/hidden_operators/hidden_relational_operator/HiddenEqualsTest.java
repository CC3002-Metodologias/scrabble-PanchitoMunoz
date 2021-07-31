package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.hidden_relational_operator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.HiddenAdd;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenEqualsTest extends BaseHiddenRelationalOperatorTest {

    private HiddenEquals greaterCase;
    private HiddenEquals equalsCase;
    private HiddenEquals lowerCase;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        greaterNumber = greaterHNumber(hiddenBinary1, hiddenBinary2);
        lowerNumber = lowerHNumber(hiddenBinary1, hiddenBinary2);
        greaterCase = new HiddenEquals(greaterNumber, lowerNumber);
        equalsCase = new HiddenEquals(hiddenBinary1, hiddenBinary1.toHiddenFloat());
        lowerCase = new HiddenEquals(lowerNumber, greaterNumber);
    }

    @RepeatedTest(20)
    void testEquals() {
        HiddenRelationalOperator other = new HiddenEquals(greaterNumber, lowerNumber);
        assertEquals(greaterCase, other,
            "Method equals does not works with equals case." + messageSeed);
        assertNotEquals(lowerCase, other,
            "Method equals does not works with different case." + messageSeed);
        assertNotEquals(new HiddenAdd(greaterNumber, lowerNumber), greaterCase,
            " Method equals does not works with different type." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        HiddenRelationalOperator other = new HiddenEquals(greaterNumber, lowerNumber);
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
            "Equals(\n"
                + "  %s ==\n"
                + "  %s\n"
                + ")"
        );
        for (HType hType1 : hTypeList2) {
            for (HType hType2 : hTypeList2) {
                String expected = String.format(templateString,
                    hType1.asString(0), hType2.asString(0));
                assertEquals(expected, new HiddenEquals(hType1, hType2).asString(0),
                    "Method asString does not works." + messageSeed);
            }
        }
    }

    @RepeatedTest(20)
    void testSize() {
        assertEquals(3, greaterCase.size(),
            "Method size does not works." + messageSeed);
        HiddenRelationalOperator operator = new HiddenEquals(hiddenFloat1, greaterCase);
        assertEquals(5, operator.size(),
            "Method size does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testCalculate() {
        assertEquals(falseHiddenBool, greaterCase.calculate(),
            "Method calculate does not works with greater case." + messageSeed);
        assertEquals(trueHiddenBool, equalsCase.calculate(),
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
        HiddenRelationalOperator operator = new HiddenEquals(
            new HiddenVariable("x"), new HiddenVariable("y")
        );
        operator.setVariable("x", hiddenBinary1);
        operator.setVariable("y", hiddenBinary2);
        assertEquals(falseHiddenBool, operator.calculate(),
            "Method setVariable does not works." + messageSeed);
        operator.setVariable("y", hiddenBinary1.toHiddenFloat());
        assertEquals(trueHiddenBool, operator.calculate(),
            "Method setVariable does not works." + messageSeed);
    }
}