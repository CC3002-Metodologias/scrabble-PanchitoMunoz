package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_executables.HiddenProgram;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HiddenIfTest extends BaseHTypeTest {

    private HiddenIf hiddenIf1;
    private HiddenIf hiddenIf2;
    private HiddenProgram program;

    @BeforeEach
    public void setUp() {
        super.setUp();
        hiddenIf1 = new HiddenIf(trueHiddenBool,
            new HiddenVariable("x").assign(new HiddenInt(1))
        );
        hiddenIf2 = new HiddenIf(falseHiddenBool,
            new HiddenVariable("1").assign(new HiddenInt(1))
        );
        program = new HiddenProgram(
            new HiddenVariable("x").assign(new HiddenInt(0)),
            new HiddenVariable("y").assign(new HiddenInt(0)),
            hiddenIf1,
            hiddenIf2
        );
    }

    @Test
    void testGetCondition() {
        assertEquals(trueHiddenBool, hiddenIf1.getCondition(),
            "Method getCondition does not works." + messageSeed);
    }

    @Test
    void testGetFirstBody() {
        assertEquals(new HiddenVariable("x").assign(new HiddenInt(1)),
            hiddenIf1.getFirstBody(),
            "Method getFirstBody does not works." + messageSeed);
    }

    @Test
    void testToString() {
        String expected = "If (\n"
            + "%s\n"
            + ") {\n"
            + "%s\n"
            + "}";
        assertEquals(
            String.format(expected, trueHiddenBool.asString(2),
                new HiddenVariable("x").assign(new HiddenInt(1)).asString(2)),
            hiddenIf1.toString(),
            "Method toString does not works." + messageSeed
        );
    }

    @Test
    void testAsCode() {
        String expected = "If ( true ) {\n"
            + "  x = 1\n"
            + "}";
        assertEquals(expected, hiddenIf1.asCode(),
            "Method asCode does not works." + messageSeed);
    }

    @Test
    void testAccept() {
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
        assertNotSame(hiddenIf1, hiddenIf1.copy(),
            "Method copy does not works." + messageSeed);
    }
}