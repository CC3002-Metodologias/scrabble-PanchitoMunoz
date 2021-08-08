package cl.uchile.dcc.scrabble.model.ast.control_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.model.ast.executables.Program;
import cl.uchile.dcc.scrabble.model.exceptions.VariableNotFoundException;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.variables.Variable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IfElseTest {

    private IfElse ifElse;
    private Program program;

    @BeforeEach
    void setUp() {
        ifElse = new IfElse(
            new TypeBool(true),
            new Variable("j").assign(new TypeInt(1)),
            new Variable("j").assign(new TypeInt(0))
        );
        program = new Program(ifElse);
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
            + "} Else {\n"
            + "  Variable{name=j, value=\n"
            + "    TypeInt{value=0}}\n"
            + "}";
        assertEquals(expected, ifElse.toString(),
            "Method toString does not works.");
    }
}