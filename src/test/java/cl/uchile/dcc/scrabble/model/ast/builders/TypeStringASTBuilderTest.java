package cl.uchile.dcc.scrabble.model.ast.builders;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.operations.Add;
import cl.uchile.dcc.scrabble.model.ast.operations.BaseOperationTest;
import cl.uchile.dcc.scrabble.model.ast.operations.Div;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TypeStringASTBuilderTest extends BaseOperationTest {

    private Add operation;
    private TypeStringASTBuilder stringASTBuilder;

    @BeforeEach
    public void setUp() {
        super.setUp();
        operation = new Add(typeString1, typeString2);
        stringASTBuilder = new TypeStringASTBuilder(operation);
    }

    @RepeatedTest(20)
    void testBuild() {
        assertEquals(operation, stringASTBuilder.build(),
            "Method build does not works with Operation values." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeString() {
        ToTypeString expected = new ToTypeString(operation);
        assertEquals(expected, stringASTBuilder.toTypeString().build(),
            "Method toTypeString does not works." + messageSeed);
    }
}