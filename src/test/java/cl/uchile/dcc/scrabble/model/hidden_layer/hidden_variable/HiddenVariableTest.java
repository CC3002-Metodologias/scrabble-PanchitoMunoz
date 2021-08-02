package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenAdd;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenSetterVisitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class HiddenVariableTest extends BaseHTypeTest {

    private final String name = "x";
    private final String otherName = "y";
    private HiddenVariable variable;
    private HiddenVariable binaryVariable;
    private HiddenVariable boolVariable;
    private HiddenVariable floatVariable;
    private HiddenVariable intVariable;
    private HiddenVariable nullVariable;
    private HiddenVariable stringVariable;

    @BeforeEach
    public void setUp() {
        super.setUp();
        variable = new HiddenVariable(name);
        binaryVariable = new HiddenVariable(name).setValue(hiddenBinary1);
        boolVariable = new HiddenVariable(name).setValue(trueHiddenBool);
        floatVariable = new HiddenVariable(name).setValue(hiddenFloat1);
        intVariable = new HiddenVariable(name).setValue(hiddenInt1);
        nullVariable = new HiddenVariable(name).setValue(hiddenNull);
        stringVariable = new HiddenVariable(name).setValue(hiddenString1);
    }

    @Test
    void testAccept() {
        // Case visitor with name that don't match
        HiddenSetterVisitor visitor1 = new HiddenSetterVisitor(otherName, hiddenFloat2);
        assertEquals(hiddenFloat1, floatVariable.calculate());
        floatVariable.accept(visitor1);
        assertEquals(hiddenFloat1, floatVariable.calculate(),
            "Method accept does not works." + messageSeed);
        // Case visitor with name that match
        HiddenSetterVisitor visitor2 = new HiddenSetterVisitor(name, hiddenFloat2);
        assertEquals(hiddenFloat1, floatVariable.calculate());
        floatVariable.accept(visitor2);
        assertEquals(hiddenFloat2, floatVariable.calculate(),
            "Method accept does not works." + messageSeed);
        // Case that have a variable unsigned
        assertEquals(hiddenNull, variable.calculate());
        variable.accept(visitor2);
        assertEquals(hiddenFloat2, variable.calculate(),
            "Method accept does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testCalculate() {
        assertEquals(hiddenNull, variable.calculate(),
            "Method calculate does not works with standard variable." + messageSeed);
        assertEquals(hiddenBinary1, binaryVariable.calculate(),
            "Method calculate does not works with binary variable." + messageSeed);
        assertEquals(trueHiddenBool, boolVariable.calculate(),
            "Method calculate does not works with boolean variable." + messageSeed);
        assertEquals(hiddenFloat1, floatVariable.calculate(),
            "Method calculate does not works with float variable." + messageSeed);
        assertEquals(hiddenInt1, intVariable.calculate(),
            "Method calculate does not works with int variable." + messageSeed);
        assertEquals(hiddenNull, nullVariable.calculate(),
            "Method calculate does not works with null variable." + messageSeed);
        assertEquals(hiddenString1, stringVariable.calculate(),
            "Method calculate does not works with string variable." + messageSeed);
        HiddenVariable variable = new HiddenVariable(otherName).setValue(
            new HiddenAdd(hiddenString1, hiddenBinary1)
        );
        HiddenVariable variable1 = new HiddenVariable(name).setValue(variable);
    }

    @RepeatedTest(20)
    void testAsString() {
        String formatAsString = "Variable{name=x, value=%s}";
        assertEquals(String.format(formatAsString, "null"), variable.asString(0),
            "Method asString does not works." + messageSeed);
        assertEquals(String.format(formatAsString, hiddenFloat1.asString(0)),
            floatVariable.asString(0),
            "Method asString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testGetName() {
        assertEquals(name, variable.getName(),
            "Method getName does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testSetValue() {
        assertEquals(hiddenFloat1, floatVariable.calculate());
        floatVariable.setValue(hiddenFloat2);
        assertEquals(hiddenFloat2, floatVariable.calculate(),
            "Method setValue does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        String expected = "HiddenVariable{name='" + name + "', value=" + hiddenFloat1 + "}";
        assertEquals(expected, floatVariable.toString(),
            "Method toString does not works." + messageSeed);
    }
}