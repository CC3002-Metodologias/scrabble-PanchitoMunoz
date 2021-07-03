package cl.uchile.dcc.scrabble.model.ast.builders;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.operations.And;
import cl.uchile.dcc.scrabble.model.ast.operations.BaseOperationTest;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeBinary;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeFloat;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeInt;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TypeBinaryASTBuilderTest extends BaseOperationTest {

    private And operation;
    private TypeBinaryASTBuilder binaryASTBuilder;

    @BeforeEach
    public void setUp() {
        super.setUp();
        operation = new And(typeBinary1, typeBinary2);
        binaryASTBuilder = new TypeBinaryASTBuilder(operation);
    }

    @RepeatedTest(20)
    void testBuild() {
        assertEquals(operation, binaryASTBuilder.build(),
            "Method build does not works with Operation values." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeInt() {
        ToTypeInt expected = new ToTypeInt(operation);
        assertEquals(expected, binaryASTBuilder.toTypeInt().build(),
            "Method toTypeInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeBinary() {
        ToTypeBinary expected = new ToTypeBinary(operation);
        assertEquals(expected, binaryASTBuilder.toTypeBinary().build(),
            "Method toTypeBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeFloat() {
        ToTypeFloat expected = new ToTypeFloat(operation);
        assertEquals(expected, binaryASTBuilder.toTypeFloat().build(),
            "Method toTypeFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeString() {
        ToTypeString expected = new ToTypeString(operation);
        assertEquals(expected, binaryASTBuilder.toTypeString().build(),
            "Method toTypeString does not works." + messageSeed);
    }
}