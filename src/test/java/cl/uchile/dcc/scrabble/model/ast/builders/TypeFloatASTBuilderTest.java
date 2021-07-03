package cl.uchile.dcc.scrabble.model.ast.builders;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.operations.BaseOperationTest;
import cl.uchile.dcc.scrabble.model.ast.operations.Sub;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeFloat;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TypeFloatASTBuilderTest extends BaseOperationTest {

    private Sub operation;
    private TypeFloatASTBuilder floatASTBuilder;

    @BeforeEach
    public void setUp() {
        super.setUp();
        operation = new Sub(typeFloat1, typeFloat2);
        floatASTBuilder = new TypeFloatASTBuilder(operation);
    }

    @RepeatedTest(20)
    void testBuild() {
        assertEquals(operation, floatASTBuilder.build(),
            "Method build does not works with Operation values." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeFloat() {
        ToTypeFloat expected = new ToTypeFloat(operation);
        assertEquals(expected, floatASTBuilder.toTypeFloat().build(),
            "Method toTypeFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeString() {
        ToTypeString expected = new ToTypeString(operation);
        assertEquals(expected, floatASTBuilder.toTypeString().build(),
            "Method toTypeString does not works." + messageSeed);
    }
}