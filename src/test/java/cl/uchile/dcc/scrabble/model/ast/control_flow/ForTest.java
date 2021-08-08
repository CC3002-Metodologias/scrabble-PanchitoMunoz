package cl.uchile.dcc.scrabble.model.ast.control_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.model.ast.executables.Program;
import cl.uchile.dcc.scrabble.model.ast.relational_operators.LowerThan;
import cl.uchile.dcc.scrabble.model.exceptions.VariableNotFoundException;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.variables.Variable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ForTest {

    private For aFor;
    private Program program;

    @BeforeEach
    void setUp() {
        aFor = new For(
            new Variable("i").assign(new TypeInt(0)),
            new LowerThan(new Variable("i"), new TypeInt(10)),
            new Variable("i").increase(),
            new Variable("j").assign(new Variable("i"))
        );
        program = new Program(
            new Variable("j").assign(new TypeInt(0)),
            aFor
        );
    }

    @Test
    void testExecute() throws VariableNotFoundException {
        program.execute();
        assertEquals(
            new Variable("j").assign(new TypeInt(9)),
            program.getGlobalVariables("j"),
            "Method execute does not works.");
    }

    @Test
    void testToString() {
        String expected = "For (\n"
            + "  Variable{name=i, value=\n"
            + "    TypeInt{value=0}};\n"
            + "  LowerThan(\n"
            + "    Variable{name=i} <\n"
            + "    TypeInt{value=10}\n"
            + "  );\n"
            + "  Variable{name=i, value=\n"
            + "    Add(\n"
            + "      Variable{name=i} +\n"
            + "      TypeInt{value=1}\n"
            + "    )}\n"
            + ") {\n"
            + "  Variable{name=j, value=\n"
            + "    Variable{name=i}}\n"
            + "}";
        assertEquals(expected, aFor.toString(),
            "Method toString does not works.");
    }
}