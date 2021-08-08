package cl.uchile.dcc.scrabble.model.ast.control_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.model.ast.executables.ListOfInstructions;
import cl.uchile.dcc.scrabble.model.ast.executables.Program;
import cl.uchile.dcc.scrabble.model.ast.relational_operators.LowerThan;
import cl.uchile.dcc.scrabble.model.exceptions.VariableNotFoundException;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.variables.Variable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WhileTest {

    private While aWhile;
    private Program program;

    @BeforeEach
    void setUp() {
        aWhile = new While(
            new LowerThan(new Variable("i"), new TypeInt(10)),
            new ListOfInstructions(
                new Variable("j").assign(new Variable("i")),
                new Variable("i").increase()
            )
        );
        program = new Program(
            new Variable("i").assign(new TypeInt(0)),
            new Variable("j").assign(new TypeInt(0)),
            aWhile
        );
    }

    @Test
    void testAsHiddenAST() throws VariableNotFoundException {
        program.execute();
        assertEquals(new Variable("j").assign(new TypeInt(9)),
            program.getGlobalVariables("j"),
            "Method asHiddenAST does not works.");
    }

    @Test
    void testToString() {
        String expected = "While (\n"
            + "  LowerThan(\n"
            + "    Variable{name=i} <\n"
            + "    TypeInt{value=10}\n"
            + "  )\n"
            + ") {\n"
            + "  Variable{name=j, value=\n"
            + "    Variable{name=i}}\n"
            + "  Variable{name=i, value=\n"
            + "    Add(\n"
            + "      Variable{name=i} +\n"
            + "      TypeInt{value=1}\n"
            + "    )}\n"
            + "}";
        assertEquals(expected, aWhile.toString(),
            "Method toString does not works.");
    }
}