package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_executables.HiddenProgram;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenAdd;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator.HiddenLowerThan;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HiddenWhileTest extends BaseHTypeTest {

    private HiddenWhile hiddenWhile;
    private HiddenASTComponent condition;
    private HiddenASTComponent firstBody;
    private HiddenProgram program;

    @BeforeEach
    public void setUp() {
        super.setUp();
        condition = new HiddenLowerThan(
            new HiddenVariable("i"),
            new HiddenInt(10)
        );
        firstBody = new HiddenVariable("i").setValue(
            new HiddenAdd(
                new HiddenVariable("i"),
                new HiddenInt(1)
            )
        );
        hiddenWhile = new HiddenWhile(condition, firstBody);
        program = new HiddenProgram(
            new HiddenVariable("i").setValue(new HiddenInt(0)),
            hiddenWhile
        );
    }

    @Test
    void testGetCondition() {
        assertEquals(condition, hiddenWhile.getCondition(),
            "Method getCondition does not works." + messageSeed);
    }

    @Test
    void testGetFirstBody() {
        assertEquals(firstBody, hiddenWhile.getFirstBody(),
            "Method getFirstBody does not works." + messageSeed);
    }

    @Test
    void testToString() {
        String expected = "While (\n"
            + "%s\n"
            + ") {\n"
            + "%s\n"
            + "}";
        assertEquals(
            String.format(expected,
                condition.asString(2),
                firstBody.asString(2)),
            hiddenWhile.toString(),
            "Method toString does not works." + messageSeed
        );
        System.out.println(hiddenWhile);
    }

    @Test
    void testAsCode() {
        String expected = "While ( i < 10 ) {\n"
            + "  i = i + 1\n"
            + "}";
        assertEquals(expected, hiddenWhile.asCode(),
            "Method asCode does not works." + messageSeed);
    }

    @Test
    void testAccept() {
        program.execute();
        assertEquals(new HiddenVariable("i").setValue(new HiddenInt(10)),
            program.getGlobalVariables("i"),
            "Method does not works." + messageSeed);
    }

    @Test
    void testCopy() {
        assertNotSame(hiddenWhile, hiddenWhile.copy(),
            "Method copy does not works." + messageSeed);
    }
}