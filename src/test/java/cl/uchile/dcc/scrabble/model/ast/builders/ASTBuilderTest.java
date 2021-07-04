package cl.uchile.dcc.scrabble.model.ast.builders;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.operations.Add;
import cl.uchile.dcc.scrabble.model.ast.operations.And;
import cl.uchile.dcc.scrabble.model.ast.operations.BaseOperationTest;
import cl.uchile.dcc.scrabble.model.ast.operations.Div;
import cl.uchile.dcc.scrabble.model.ast.operations.Mult;
import cl.uchile.dcc.scrabble.model.ast.operations.Neg;
import cl.uchile.dcc.scrabble.model.ast.operations.Or;
import cl.uchile.dcc.scrabble.model.ast.operations.Sub;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class ASTBuilderTest extends BaseOperationTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
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
        // Case int-integer
        expected = new Add(typeInt1, typeInt2);
        assertEquals(expected, ASTBuilder.add(typeInt1, typeInt2).build(),
            "Method add does not works with int and integers." + messageSeed);
        // Case binary-integer
        expected = new Add(typeBinary1, typeInt1);
        assertEquals(expected, ASTBuilder.add(typeBinary1, typeInt1).build(),
            "Method add does not works with binaries and integers." + messageSeed);
    }

    @RepeatedTest(20)
    void testSub() {
        // Case float-number
        var expected = new Sub(typeFloat1, typeInt1);
        assertEquals(expected, ASTBuilder.sub(typeFloat1, typeInt1).build(),
            "Method sub does not works with floats and SNumber." + messageSeed);
        // Case int-float
        expected = new Sub(typeInt1, typeFloat1);
        assertEquals(expected, ASTBuilder.sub(typeInt1, typeFloat1).build(),
            "Method sub does not works with ints and floats." + messageSeed);
        // Case int-integer
        expected = new Sub(typeInt1, typeInt2);
        assertEquals(expected, ASTBuilder.sub(typeInt1, typeInt2).build(),
            "Method sub does not works with int and integers." + messageSeed);
        // Case binary-integer
        expected = new Sub(typeBinary1, typeBinary2);
        assertEquals(expected, ASTBuilder.sub(typeBinary1, typeBinary2).build(),
            "Method sub does not works with binaries and integers." + messageSeed);
    }

    @RepeatedTest(20)
    void testMult() {
        // Case float-number
        var expected = new Mult(typeFloat1, typeFloat2);
        assertEquals(expected, ASTBuilder.mult(typeFloat1, typeFloat2).build(),
            "Method mult does not works with floats and SNumber." + messageSeed);
        // Case int-float
        expected = new Mult(typeInt1, typeFloat1);
        assertEquals(expected, ASTBuilder.mult(typeInt1, typeFloat1).build(),
            "Method mult does not works with ints and floats." + messageSeed);
        // Case int-integer
        expected = new Mult(typeInt1, typeInt2);
        assertEquals(expected, ASTBuilder.mult(typeInt1, typeInt2).build(),
            "Method mult does not works with int and integers." + messageSeed);
        // Case binary-integer
        expected = new Mult(typeBinary1, typeBinary2);
        assertEquals(expected, ASTBuilder.mult(typeBinary1, typeBinary2).build(),
            "Method mult does not works with binaries and integers." + messageSeed);
    }

    @RepeatedTest(20)
    void testDiv() {
        // Case float-number
        var expected = new Div(typeFloat1, typeFloat2);
        assertEquals(expected, ASTBuilder.div(typeFloat1, typeFloat2).build(),
            "Method div does not works with floats and SNumber." + messageSeed);
        // Case int-float
        expected = new Div(typeInt1, typeFloat1);
        assertEquals(expected, ASTBuilder.div(typeInt1, typeFloat1).build(),
            "Method div does not works with ints and floats." + messageSeed);
        // Case int-integer
        expected = new Div(typeInt1, typeInt2);
        assertEquals(expected, ASTBuilder.div(typeInt1, typeInt2).build(),
            "Method div does not works with int and integers." + messageSeed);
        // Case binary-integer
        expected = new Div(typeBinary1, typeBinary2);
        assertEquals(expected, ASTBuilder.div(typeBinary1, typeBinary2).build(),
            "Method div does not works with binaries and integers." + messageSeed);
    }

    @RepeatedTest(20)
    void testAnd() {
        // case binary-logical
        var expected = new And(typeBinary1, typeBinary2);
        assertEquals(expected, ASTBuilder.and(typeBinary1, typeBinary2).build(),
            "Method and does not works with binaries and logicals." + messageSeed);
        // case bool-bool
        expected = new And(trueTypeBool, falseTypeBool);
        assertEquals(expected, ASTBuilder.and(trueTypeBool, falseTypeBool).build(),
            "Method and does not works with booleans and booleans." + messageSeed);
    }

    @RepeatedTest(20)
    void testOr() {
        // case binary-logical
        var expected = new Or(typeBinary1, trueTypeBool);
        assertEquals(expected, ASTBuilder.or(typeBinary1, trueTypeBool).build(),
            "Method or does not works with binaries or logicals." + messageSeed);
        // case bool-bool
        expected = new Or(trueTypeBool, falseTypeBool);
        assertEquals(expected, ASTBuilder.or(trueTypeBool, falseTypeBool).build(),
            "Method or does not works with booleans or booleans." + messageSeed);
    }

    @RepeatedTest(20)
    void testNeg() {
        // Case binary
        var expected = new Neg(typeBinary1);
        assertEquals(expected, ASTBuilder.neg(typeBinary1).build(),
            "Method neg does not works with binaries." + messageSeed);
        // Case bool
        expected = new Neg(trueTypeBool);
        assertEquals(expected, ASTBuilder.neg(trueTypeBool).build(),
            "Method neg does not works with booleans." + messageSeed);
    }
}