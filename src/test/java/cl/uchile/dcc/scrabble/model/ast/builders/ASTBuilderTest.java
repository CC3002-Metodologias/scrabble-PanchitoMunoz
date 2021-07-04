package cl.uchile.dcc.scrabble.model.ast.builders;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.operations.Add;
import cl.uchile.dcc.scrabble.model.ast.operations.BaseOperationTest;
import cl.uchile.dcc.scrabble.model.ast.operations.Sub;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ASTBuilderTest extends BaseOperationTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    void testAdd() {
        // Case string-SType
        var expected = new Add(typeString1, trueTypeBool);
        assertEquals(expected, ASTBuilder.add(typeString1, trueTypeBool).build(),
            "Method add does not works with strings and SType." + messageSeed);
        // Case float-number
        expected = new Add(typeFloat1, typeBinary1);
        assertEquals(expected, ASTBuilder.add(typeFloat1, typeBinary1).build(),
            "Method add does not works with floats and SNumber." + messageSeed);
        // Case int-float
        expected = new Add(typeInt1, typeFloat1);
        assertEquals(expected, ASTBuilder.add(typeInt1, typeFloat1).build(),
            "Method add does not works with ints and floats." + messageSeed);
        // Case binary-integer
        expected = new Add(typeBinary1, typeInt1);
        assertEquals(expected, ASTBuilder.add(typeBinary1, typeInt1).build(),
            "Method add does not works with binaries and integers." + messageSeed);
    }

    @Test
    void testSub() {
        // Case float-number
        // var expected = new Sub(typeFloat1, typeInt1);
        // Case int-float
        // Case binary-integer
    }

    @Test
    void testMult() {
    }

    @Test
    void testDiv() {
    }

    @Test
    void testAnd() {
    }

    @Test
    void testOr() {
    }
}