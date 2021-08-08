package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_executables.HiddenProgram;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator.HiddenLowerThan;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HiddenForTest extends BaseHTypeTest {

    private HiddenVariable initializer;
    private HiddenASTComponent condition;
    private HiddenVariable increase;
    private HiddenAST firstBody;
    private HiddenFor hiddenFor;
    private HiddenProgram program;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        initializer = new HiddenVariable("i").assign(new HiddenInt(0));
        condition = new HiddenLowerThan(new HiddenVariable("i"), new HiddenInt(10));
        increase = new HiddenVariable("i").increase();
        firstBody = new HiddenVariable("j").assign(new HiddenVariable("i"));
        hiddenFor = new HiddenFor(initializer, condition, increase,
            firstBody);
        program = new HiddenProgram(
            new HiddenVariable("j").assign(new HiddenInt(0)),
            hiddenFor
        );
    }

    @Test
    void testGetCondition() {
        assertSame(condition, hiddenFor.getCondition(),
            "Method getCondition does not works." + messageSeed);
    }

    @Test
    void testGetFirstBody() {
        assertSame(firstBody, hiddenFor.getFirstBody(),
            "Method getFirstBody does not works." + messageSeed);
    }

    @Test
    void testToString() {
        String expected = "For (\n"
            + "%s;\n"
            + "%s;\n"
            + "%s\n"
            + ") {\n"
            + "%s\n"
            + "}";
        assertEquals(
            String.format(expected,
                initializer.asString(2),
                condition.asString(2),
                increase.asString(2),
                firstBody.asString(2)),
            hiddenFor.toString(),
            "Method toString does not works." + messageSeed
        );
    }

    @Test
    void testAccept() {
        program.execute();
        assertEquals(
            program.getGlobalVariables("j"),
            new HiddenVariable("j").assign(new HiddenInt(9))
        );
    }

    @Test
    void testAsCode() {
        String expected = "For ( i = 0; i < 10; i = i + 1 ) {\n"
            + "  j = i\n"
            + "}";
        assertEquals(expected, hiddenFor.asCode(),
            "Method asCode does not works." + messageSeed);
    }

    @Test
    void testCopy() {
        assertNotSame(hiddenFor, hiddenFor.copy(),
            "Method copy does not works." + messageSeed);
    }

    @Test
    void testGetInitializer() {
        assertSame(initializer, hiddenFor.getInitializer(),
            "Method getInitializer does not works." + messageSeed);
    }

    @Test
    void testGetIncrease() {
        assertSame(increase, hiddenFor.getIncrease(),
            "Method getIncrease does not works." + messageSeed);
    }
}