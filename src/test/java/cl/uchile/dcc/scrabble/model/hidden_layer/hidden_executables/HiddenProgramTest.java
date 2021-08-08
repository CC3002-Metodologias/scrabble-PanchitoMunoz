package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_executables;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenIfElse;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenWhile;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenSub;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator.HiddenGreaterThan;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator.HiddenNotEquals;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class HiddenProgramTest extends BaseHTypeTest {

    private HiddenProgram program1;

    @BeforeEach
    public void setUp() {
        super.setUp();
        program1 = new HiddenProgram(
            new HiddenVariable("a").assign(new HiddenInt(30)),
            new HiddenVariable("b").assign(new HiddenInt(15)),
            new HiddenWhile(
                new HiddenNotEquals(
                    new HiddenVariable("b"), new HiddenInt(0)
                ),
                new HiddenIfElse(
                    new HiddenGreaterThan(new HiddenVariable("a"), new HiddenVariable("b")),
                    new HiddenVariable("a").assign(
                        new HiddenSub(
                            new HiddenVariable("a"), new HiddenVariable("b")
                        )
                    ),
                    new HiddenVariable("b").assign(
                        new HiddenSub(
                            new HiddenVariable("b"), new HiddenVariable("a")
                        )
                    )
                )
            )
        );
    }

    @Test
    void testExecute() {
        program1.execute();
        List<HiddenVariable> globalVariables = program1.getGlobalVariables();
        List<HiddenVariable> expectedList = new ArrayList<>();
        expectedList.add(new HiddenVariable("a").assign(new HiddenInt(15)));
        expectedList.add(new HiddenVariable("b").assign(new HiddenInt(0)));
        for (HiddenVariable expectedVar : expectedList) {
            assertTrue(globalVariables.contains(expectedVar),
                "Method execute does not works." + messageSeed);
        }
    }

    @RepeatedTest(20)
    void testGetGlobalVariables() {
        HiddenProgram program = new HiddenProgram(
            new HiddenVariable("x").assign(hiddenInt1)
        ).execute();
        assertEquals(
            new HiddenVariable("x").assign(hiddenInt1),
            program.getGlobalVariables().get(0),
            "Method getGlobalVariables does not works." + messageSeed);
    }

    @Test
    void testToString() {
        String expected = "a = 30\n"
            + "b = 15\n"
            + "While ( b != 0 ) {\n"
            + "  If ( a > b ) {\n"
            + "    a = a - b\n"
            + "  } Else {\n"
            + "    b = b - a\n"
            + "  }\n"
            + "}";
        assertEquals(expected, program1.toString(),
            "Method toString does not works." + messageSeed);
    }
}