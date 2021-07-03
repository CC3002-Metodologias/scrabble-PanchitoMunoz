package cl.uchile.dcc.scrabble.model.ast.builders;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.operations.And;
import cl.uchile.dcc.scrabble.model.ast.operations.BaseOperationTest;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeBool;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TypeBoolASTBuilderTest extends BaseOperationTest {

    private And operation;
    private TypeBoolASTBuilder boolASTBuilder;

    @BeforeEach
    public void setUp() {
        super.setUp();
        operation = new And(trueTypeBool, falseTypeBool);
        boolASTBuilder = new TypeBoolASTBuilder(operation);
    }

    @RepeatedTest(20)
    void testBuild() {
        assertEquals(operation, boolASTBuilder.build(),
            "Method build does not works with Operation values." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeString() {
        ToTypeString expected = new ToTypeString(operation);
        assertEquals(expected, boolASTBuilder.toTypeString().build(),
            "Method toTypeString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeBool() {
        ToTypeBool expected = new ToTypeBool(operation);
        assertEquals(expected, boolASTBuilder.toTypeBool().build(),
            "Method toTypeBool does not works." + messageSeed);
    }
}