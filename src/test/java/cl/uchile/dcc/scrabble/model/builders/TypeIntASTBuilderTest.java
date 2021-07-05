package cl.uchile.dcc.scrabble.model.builders;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.operations.BaseOperationTest;
import cl.uchile.dcc.scrabble.model.ast.operations.Mult;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeBinary;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeFloat;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeInt;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TypeIntASTBuilderTest extends BaseOperationTest {

    private Mult operation;
    private TypeIntASTBuilder intASTBuilder;

    @BeforeEach
    public void setUp() {
        super.setUp();
        operation = new Mult(typeInt1, typeInt2);
        intASTBuilder = new TypeIntASTBuilder(operation);
    }

    @RepeatedTest(20)
    void testBuild() {
        assertEquals(operation, intASTBuilder.build(),
            "Method build does not works with Operation values." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeInt() {
        ToTypeInt expected = new ToTypeInt(operation);
        assertEquals(expected, intASTBuilder.toTypeInt().build(),
            "Method toTypeInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeBinary() {
        ToTypeBinary expected = new ToTypeBinary(operation);
        assertEquals(expected, intASTBuilder.toTypeBinary().build(),
            "Method toTypeBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeFloat() {
        ToTypeFloat expected = new ToTypeFloat(operation);
        assertEquals(expected, intASTBuilder.toTypeFloat().build(),
            "Method toTypeFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeString() {
        ToTypeString expected = new ToTypeString(operation);
        assertEquals(expected, intASTBuilder.toTypeString().build(),
            "Method toTypeString does not works." + messageSeed);
    }
}