package cl.uchile.dcc.scrabble.model.variables;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.model.ast.operations.Add;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.ast.operations.Sub;
import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

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
}