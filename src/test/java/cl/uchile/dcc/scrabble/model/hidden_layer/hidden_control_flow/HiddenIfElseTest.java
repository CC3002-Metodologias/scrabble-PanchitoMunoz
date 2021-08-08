package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import cl.uchile.dcc.scrabble.model.exceptions.VariableNotFoundException;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_executables.HiddenProgram;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HiddenIfElseTest extends BaseHTypeTest {

    private HiddenIfElse hiddenIfElse;
    private HiddenProgram program;

    @BeforeEach
    public void setUp() {
        super.setUp();
        hiddenIfElse = new HiddenIfElse(
            trueHiddenBool,
            new HiddenVariable("x").assign(new HiddenInt(1)),
            new HiddenVariable("y").assign(new HiddenInt(1))
        );
        program = new HiddenProgram(
            new HiddenVariable("x").assign(new HiddenInt(0)),
            new HiddenVariable("y").assign(new HiddenInt(0)),
            hiddenIfElse
        );
    }

    @Test
    void testGetCondition() {
        assertEquals(trueHiddenBool, hiddenIfElse.getCondition(),
            "Method getCondition does not works." + messageSeed);
    }

    @Test
    void testGetFirstBody() {
        assertEquals(new HiddenVariable("x").assign(new HiddenInt(1)),
            hiddenIfElse.getFirstBody(),
            "Method getFirstBody does not works." + messageSeed);
    }

    @Test
    void testGetSecondBody() {
        assertEquals(new HiddenVariable("y").assign(new HiddenInt(1)),
            hiddenIfElse.getSecondBody(),
            "Method getSecondBody does not works." + messageSeed);
    }

    @Test
    void testToString() {
        String expected = "If (\n"
            + "%s\n"
            + ") {\n"
            + "%s\n"
            + "} Else {\n"
            + "%s\n"
            + "}";
        assertEquals(
            String.format(expected,
                trueHiddenBool.asString(2),
                new HiddenVariable("x").assign(new HiddenInt(1)).asString(2),
                new HiddenVariable("y").assign(new HiddenInt(1)).asString(2)
            ),
            hiddenIfElse.toString(),
            "Method toString does not works." + messageSeed
        );
    }

    @Test
    void testAsCode() {
        String expected = "If ( true ) {\n"
            + "  x = 1\n"
            + "} Else {\n"
            + "  y = 1\n"
            + "}";
        assertEquals(expected, hiddenIfElse.asCode(),
            "Method asCode does not works." + messageSeed);
    }

    @Test
    void testAccept() throws VariableNotFoundException {
        program.execute();
        assertEquals(new HiddenVariable("x").assign(new HiddenInt(1)),
            program.getGlobalVariables("x"),
            "Method execute does not works." + messageSeed);
        assertEquals(new HiddenVariable("y").assign(new HiddenInt(0)),
            program.getGlobalVariables("y"),
            "Method execute does not works." + messageSeed);
    }

    @Test
    void testCopy() {
        assertNotSame(hiddenIfElse, hiddenIfElse.copy(),
            "Method copy does not works." + messageSeed);
    }
}