package cl.uchile.dcc.scrabble.model.ast.control_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.model.ast.executables.Program;
import cl.uchile.dcc.scrabble.model.ast.relational_operators.GreaterThan;
import cl.uchile.dcc.scrabble.model.ast.relational_operators.LowerThan;
import cl.uchile.dcc.scrabble.model.exceptions.VariableNotFoundException;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.variables.Variable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ForTest {

    private For aFor;
    private Program program;
    private For aFor1;
    private Program program1;
    private For aFor2;
    private Program program2;
    private For aFor3;
    private Program program3;

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
        aFor1 = new For(
            new Variable("i").assign(new TypeInt(0)),
            new LowerThan(new Variable("i"), new TypeInt(10)),
            new Variable("i").increase(new TypeInt(2)),
            new Variable("j").assign(new Variable("i"))
        );
        program1 = new Program(
            new Variable("j").assign(new TypeInt(0)),
            aFor1
        );
        aFor2 = new For(
            new Variable("i").assign(new TypeInt(10)),
            new GreaterThan(new Variable("i"), new TypeInt(0)),
            new Variable("i").decreased(),
            new Variable("j").assign(new Variable("i"))
        );
        program2 = new Program(
            new Variable("j").assign(new TypeInt(10)),
            aFor2
        );
        aFor3 = new For(
            new Variable("i").assign(new TypeInt(10)),
            new GreaterThan(new Variable("i"), new TypeInt(0)),
            new Variable("i").decreased(new TypeInt(2)),
            new Variable("j").assign(new Variable("i"))
        );
        program3 = new Program(
            new Variable("j").assign(new TypeInt(10)),
            aFor3
        );
    }

    @Test
    void testExecute() throws VariableNotFoundException {
        program.execute();
        assertEquals(
            new Variable("j").assign(new TypeInt(9)),
            program.getGlobalVariables("j"),
            "Method execute does not works.");
        program1.execute();
        assertEquals(
            new Variable("j").assign(new TypeInt(8)),
            program1.getGlobalVariables("j"),
            "Method execute does not works.");
        program2.execute();
        assertEquals(
            new Variable("j").assign(new TypeInt(1)),
            program2.getGlobalVariables("j"),
            "Method execute does not works.");
        program3.execute();
        assertEquals(
            new Variable("j").assign(new TypeInt(2)),
            program3.getGlobalVariables("j"),
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