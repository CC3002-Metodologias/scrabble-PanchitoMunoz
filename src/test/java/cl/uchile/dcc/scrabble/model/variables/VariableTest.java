package cl.uchile.dcc.scrabble.model.variables;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.model.ast.operations.Add;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.ast.operations.Sub;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class VariableTest extends BaseTypeTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testBuildingAST() {
        Operation ast = new Add(
            new Variable("x").assign(typeFloat1),
            new Sub(
                new Variable("z"),
                new Variable("y")
            )
        );
        assertNull(ast.calculate(),
            "Variables do not well assigned." + messageSeed);
        ast.setVariable("y", typeFloat2);
        ast.setVariable("z", typeFloat1);
        TypeFloat expected = typeFloat1.add(typeFloat1.sub(typeFloat2));
        assertEquals(expected, ast.calculate(),
            "Method setVariable does not works in AST." + messageSeed);
        ast.setVariable("x", typeString1);
        assertEquals(typeString1.add(new TypeFloat(aFloat1 - aFloat2)), ast.calculate(),
            "Method setVariable can not redefine a variable." + messageSeed);
    }

    @Test
    void testAsHiddenAST() {
        assertEquals(
            new HiddenVariable("x").assign(new HiddenInt(1)),
            new Variable("x").assign(new TypeInt(1)).asHiddenAST());
    }

    @Test
    void testEquals() {
        Variable same = new Variable("x").assign(new TypeInt(1));
        assertEquals(same, same);
        assertEquals(new Variable("x").assign(new TypeInt(1)),
            new Variable("x").assign(new TypeInt(1)));
        assertNotEquals(new Variable("x").assign(new TypeInt(1)),
            new Variable("x").assign(new TypeInt(2)));
        assertNotEquals(new Variable("x").assign(new TypeInt(1)),
            new HiddenVariable("x").assign(new HiddenInt(1)));
    }

    @Test
    void testHashCode() {
        assertEquals(new Variable("x").assign(new TypeInt(1)).hashCode(),
            new Variable("x").assign(new TypeInt(1)).hashCode());
        assertNotEquals(new Variable("x").assign(new TypeInt(1)).hashCode(),
            new Variable("x").assign(new TypeInt(2)).hashCode());
        assertNotEquals(new HiddenVariable("y").assign(new HiddenInt(1)).hashCode(),
            new Variable("x").assign(new TypeInt(1)).hashCode());
    }

    @Test
    void testToString() {
        Variable variable = new Variable("x");
        Variable variable1 = new Variable("x").assign(new TypeInt(1));
        assertEquals("Variable{name=x}", variable.toString());
        assertEquals("Variable{name=x, value=\n"
            + "  TypeInt{value=1}}", variable1.toString());
    }
}