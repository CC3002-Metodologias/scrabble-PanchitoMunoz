package cl.uchile.dcc.scrabble.model.ast.control_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.model.ast.executables.Program;
import cl.uchile.dcc.scrabble.model.exceptions.VariableNotFoundException;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.variables.Variable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IfTest {

    private If anIf;
    private Program program;

    @BeforeEach
    void setUp() {
        anIf = new If(
            new TypeBool(true),
            new Variable("j").assign(new TypeInt(1))
        );
        program = new Program(
            new Variable("j").assign(new TypeInt(0)),
            anIf
        );
    }

    @Test
    void testAsHiddenAST() throws VariableNotFoundException {
        program.execute();
        assertEquals(new Variable("j").assign(new TypeInt(1)),
            program.getGlobalVariables("j"),
            "Method asHiddenAST does not works.");
    }

    @Test
    void testToString() {
        String expected = "If (\n"
            + "  TypeBool{value=true}\n"
            + ") {\n"
            + "  Variable{name=j, value=\n"
            + "    TypeInt{value=1}}\n"
            + "}";
        assertEquals(expected, anIf.toString(),
            "Method toString does not works.");
    }
}