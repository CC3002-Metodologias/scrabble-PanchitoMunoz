package cl.uchile.dcc.scrabble.model.ast.executables;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import cl.uchile.dcc.scrabble.model.ast.control_flow.IfElse;
import cl.uchile.dcc.scrabble.model.ast.control_flow.While;
import cl.uchile.dcc.scrabble.model.ast.operations.Sub;
import cl.uchile.dcc.scrabble.model.ast.relational_operators.GreaterThan;
import cl.uchile.dcc.scrabble.model.ast.relational_operators.NotEquals;
import cl.uchile.dcc.scrabble.model.exceptions.VariableNotFoundException;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.variables.Variable;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProgramTest {

    private Program program;

    @BeforeEach
    void setUp() {
        program = new Program(
            new Variable("a").assign(new TypeInt(30)),
            new Variable("b").assign(new TypeInt(20)),
            new While(
                new NotEquals(new Variable("b"), new TypeInt(0)),
                new IfElse(
                    new GreaterThan(new Variable("a"), new Variable("b")),
                    new Variable("a").assign(
                        new Sub(
                            new Variable("a"), new Variable("b")
                        )
                    ),
                    new Variable("b").assign(
                        new Sub(
                            new Variable("b"), new Variable("a")
                        )
                    )
                )
            )
        );
    }

    @Test
    void testExecute() throws VariableNotFoundException {
        program.execute();
        assertEquals(
            new Variable("a").assign(new TypeInt(10)),
            program.getGlobalVariables("a"),
            "Method execute does not works.");
        assertEquals(
            new Variable("b").assign(new TypeInt(0)),
            program.getGlobalVariables("b"),
            "Method execute does not works.");
    }

    @Test
    void testGetGlobalVariables() {
        assertThrows(VariableNotFoundException.class, () -> program.getGlobalVariables("a"),
            "Method getGlobalVariables does not throws the correct exception.");
        var expected = new ArrayList<Variable>();
        assertEquals(expected, program.getGlobalVariables(),
            "Method getGlobalVariables does not works when the program does not executes.");
        program.execute();
        try {
            assertEquals(new Variable("a").assign(new TypeInt(10)),
                program.getGlobalVariables("a"),
                "Method getGlobalVariables does not works.");
        } catch (VariableNotFoundException e) {
            fail("Exception does not works in getGlobalVariables.");
        }
        expected.add(new Variable("a").assign(new TypeInt(10)));
        expected.add(new Variable("b").assign(new TypeInt(0)));
        assertEquals(expected, program.getGlobalVariables(),
            "Method getGlobalVariables does not works.");
    }

    @Test
    void testToString() {
        String expected = "a = 30\n"
            + "b = 20\n"
            + "While ( b != 0 ) {\n"
            + "  If ( a > b ) {\n"
            + "    a = a - b\n"
            + "  } Else {\n"
            + "    b = b - a\n"
            + "  }\n"
            + "}";
        assertEquals(expected, program.toString(),
            "Method toString does not works.");
    }
}