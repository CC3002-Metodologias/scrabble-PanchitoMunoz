package cl.uchile.dcc.scrabble.model.builders;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.model.ast.operations.Add;
import cl.uchile.dcc.scrabble.model.ast.operations.And;
import cl.uchile.dcc.scrabble.model.ast.operations.Div;
import cl.uchile.dcc.scrabble.model.ast.operations.Mult;
import cl.uchile.dcc.scrabble.model.ast.operations.Neg;
import cl.uchile.dcc.scrabble.model.ast.operations.Or;
import cl.uchile.dcc.scrabble.model.ast.operations.Sub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class ASTBuilderTest extends BaseBuilderTest {

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
        expected = new Add(stringAST, trueTypeBool);
        assertEquals(expected, ASTBuilder.add(stringASTBuilder, trueTypeBool).build(),
            "Method add does not works with strings AST and SType." + messageSeed);
        // Case float-number
        expected = new Add(typeFloat1, typeBinary1);
        assertEquals(expected, ASTBuilder.add(typeFloat1, typeBinary1).build(),
            "Method add does not works with floats and SNumber." + messageSeed);
        expected = new Add(floatAST, typeBinary1);
        assertEquals(expected, ASTBuilder.add(floatASTBuilder, typeBinary1).build(),
            "Method add does not works with floats AST and SNumber." + messageSeed);
        // Case int-float
        expected = new Add(typeInt1, typeFloat1);
        assertEquals(expected, ASTBuilder.add(typeInt1, typeFloat1).build(),
            "Method add does not works with ints and floats." + messageSeed);
        expected = new Add(intAST, typeFloat1);
        assertEquals(expected, ASTBuilder.add(intASTBuilder, typeFloat1).build(),
            "Method add does not works with ints AST and floats." + messageSeed);
        // Case int-integer
        expected = new Add(typeInt1, typeInt2);
        assertEquals(expected, ASTBuilder.add(typeInt1, typeInt2).build(),
            "Method add does not works with int and integers." + messageSeed);
        expected = new Add(intAST, typeInt2);
        assertEquals(expected, ASTBuilder.add(intASTBuilder, typeInt2).build(),
            "Method add does not works with int AST and integers." + messageSeed);
        // Case binary-integer
        expected = new Add(typeBinary1, typeInt1);
        assertEquals(expected, ASTBuilder.add(typeBinary1, typeInt1).build(),
            "Method add does not works with binaries and integers." + messageSeed);
        expected = new Add(binaryAST, typeInt1);
        assertEquals(expected, ASTBuilder.add(binaryASTBuilder, typeInt1).build(),
            "Method add does not works with binaries AST and integers." + messageSeed);
    }

    @RepeatedTest(20)
    void testSub() {
        // Case float-number
        var expected = new Sub(typeFloat1, typeInt1);
        assertEquals(expected, ASTBuilder.sub(typeFloat1, typeInt1).build(),
            "Method sub does not works with floats and SNumber." + messageSeed);
        expected = new Sub(floatAST, typeInt1);
        assertEquals(expected, ASTBuilder.sub(floatASTBuilder, typeInt1).build(),
            "Method sub does not works with floats AST and SNumber." + messageSeed);
        // Case int-float
        expected = new Sub(typeInt1, typeFloat1);
        assertEquals(expected, ASTBuilder.sub(typeInt1, typeFloat1).build(),
            "Method sub does not works with ints and floats." + messageSeed);
        expected = new Sub(intAST, typeFloat1);
        assertEquals(expected, ASTBuilder.sub(intASTBuilder, typeFloat1).build(),
            "Method sub does not works with ints AST and floats." + messageSeed);
        // Case int-integer
        expected = new Sub(typeInt1, typeInt2);
        assertEquals(expected, ASTBuilder.sub(typeInt1, typeInt2).build(),
            "Method sub does not works with int and integers." + messageSeed);
        expected = new Sub(intAST, typeInt2);
        assertEquals(expected, ASTBuilder.sub(intASTBuilder, typeInt2).build(),
            "Method sub does not works with int AST and integers." + messageSeed);
        // Case binary-integer
        expected = new Sub(typeBinary1, typeBinary2);
        assertEquals(expected, ASTBuilder.sub(typeBinary1, typeBinary2).build(),
            "Method sub does not works with binaries and integers." + messageSeed);
        expected = new Sub(binaryAST, typeBinary2);
        assertEquals(expected, ASTBuilder.sub(binaryASTBuilder, typeBinary2).build(),
            "Method sub does not works with binaries AST and integers." + messageSeed);
    }

    @RepeatedTest(20)
    void testMult() {
        // Case float-number
        var expected = new Mult(typeFloat1, typeFloat2);
        assertEquals(expected, ASTBuilder.mult(typeFloat1, typeFloat2).build(),
            "Method mult does not works with floats and SNumber." + messageSeed);
        expected = new Mult(floatAST, typeFloat2);
        assertEquals(expected, ASTBuilder.mult(floatASTBuilder, typeFloat2).build(),
            "Method mult does not works with floats AST and SNumber." + messageSeed);
        // Case int-float
        expected = new Mult(typeInt1, typeFloat1);
        assertEquals(expected, ASTBuilder.mult(typeInt1, typeFloat1).build(),
            "Method mult does not works with ints and floats." + messageSeed);
        expected = new Mult(intAST, typeFloat1);
        assertEquals(expected, ASTBuilder.mult(intASTBuilder, typeFloat1).build(),
            "Method mult does not works with ints AST and floats." + messageSeed);
        // Case int-integer
        expected = new Mult(typeInt1, typeInt2);
        assertEquals(expected, ASTBuilder.mult(typeInt1, typeInt2).build(),
            "Method mult does not works with int and integers." + messageSeed);
        expected = new Mult(intAST, typeInt2);
        assertEquals(expected, ASTBuilder.mult(intASTBuilder, typeInt2).build(),
            "Method mult does not works with int AST and integers." + messageSeed);
        // Case binary-integer
        expected = new Mult(typeBinary1, typeBinary2);
        assertEquals(expected, ASTBuilder.mult(typeBinary1, typeBinary2).build(),
            "Method mult does not works with binaries and integers." + messageSeed);
        expected = new Mult(binaryAST, typeBinary2);
        assertEquals(expected, ASTBuilder.mult(binaryASTBuilder, typeBinary2).build(),
            "Method mult does not works with binaries AST and integers." + messageSeed);
    }

    @RepeatedTest(20)
    void testDiv() {
        // Case float-number
        var expected = new Div(typeFloat1, typeFloat2);
        assertEquals(expected, ASTBuilder.div(typeFloat1, typeFloat2).build(),
            "Method div does not works with floats and SNumber." + messageSeed);
        expected = new Div(floatAST, typeFloat2);
        assertEquals(expected, ASTBuilder.div(floatASTBuilder, typeFloat2).build(),
            "Method div does not works with floats AST and SNumber." + messageSeed);
        // Case int-float
        expected = new Div(typeInt1, typeFloat1);
        assertEquals(expected, ASTBuilder.div(typeInt1, typeFloat1).build(),
            "Method div does not works with ints and floats." + messageSeed);
        expected = new Div(intAST, typeFloat1);
        assertEquals(expected, ASTBuilder.div(intASTBuilder, typeFloat1).build(),
            "Method div does not works with ints AST and floats." + messageSeed);
        // Case int-integer
        expected = new Div(typeInt1, typeInt2);
        assertEquals(expected, ASTBuilder.div(typeInt1, typeInt2).build(),
            "Method div does not works with int and integers." + messageSeed);
        expected = new Div(intAST, typeInt2);
        assertEquals(expected, ASTBuilder.div(intASTBuilder, typeInt2).build(),
            "Method div does not works with int AST and integers." + messageSeed);
        // Case binary-integer
        expected = new Div(typeBinary1, typeBinary2);
        assertEquals(expected, ASTBuilder.div(typeBinary1, typeBinary2).build(),
            "Method div does not works with binaries and integers." + messageSeed);
        expected = new Div(binaryAST, typeBinary2);
        assertEquals(expected, ASTBuilder.div(binaryASTBuilder, typeBinary2).build(),
            "Method div does not works with binaries AST and integers." + messageSeed);
    }

    @RepeatedTest(20)
    void testAnd() {
        // case binary-logical
        var expected = new And(typeBinary1, typeBinary2);
        assertEquals(expected, ASTBuilder.and(typeBinary1, typeBinary2).build(),
            "Method and does not works with binaries and logicals." + messageSeed);
        expected = new And(binaryAST, typeBinary2);
        assertEquals(expected, ASTBuilder.and(binaryASTBuilder, typeBinary2).build(),
            "Method and does not works with binaries AST and logicals." + messageSeed);
        // case bool-bool
        expected = new And(trueTypeBool, falseTypeBool);
        assertEquals(expected, ASTBuilder.and(trueTypeBool, falseTypeBool).build(),
            "Method and does not works with booleans and booleans." + messageSeed);
        expected = new And(boolAST, falseTypeBool);
        assertEquals(expected, ASTBuilder.and(boolASTBuilder, falseTypeBool).build(),
            "Method and does not works with booleans AST and booleans." + messageSeed);
    }

    @RepeatedTest(20)
    void testOr() {
        // case binary-logical
        var expected = new Or(typeBinary1, trueTypeBool);
        assertEquals(expected, ASTBuilder.or(typeBinary1, trueTypeBool).build(),
            "Method or does not works with binaries or logicals." + messageSeed);
        expected = new Or(binaryAST, trueTypeBool);
        assertEquals(expected, ASTBuilder.or(binaryASTBuilder, trueTypeBool).build(),
            "Method or does not works with binaries AST or logicals." + messageSeed);
        // case bool-bool
        expected = new Or(trueTypeBool, falseTypeBool);
        assertEquals(expected, ASTBuilder.or(trueTypeBool, falseTypeBool).build(),
            "Method or does not works with booleans or booleans." + messageSeed);
        expected = new Or(boolAST, falseTypeBool);
        assertEquals(expected, ASTBuilder.or(boolASTBuilder, falseTypeBool).build(),
            "Method or does not works with booleans AST or booleans." + messageSeed);
    }

    @RepeatedTest(20)
    void testNeg() {
        // Case binary
        var expected = new Neg(typeBinary1);
        assertEquals(expected, ASTBuilder.neg(typeBinary1).build(),
            "Method neg does not works with binaries." + messageSeed);
        expected = new Neg(binaryAST);
        assertEquals(expected, ASTBuilder.neg(binaryASTBuilder).build(),
            "Method neg does not works with binaries AST." + messageSeed);
        // Case bool
        expected = new Neg(trueTypeBool);
        assertEquals(expected, ASTBuilder.neg(trueTypeBool).build(),
            "Method neg does not works with booleans." + messageSeed);
        expected = new Neg(boolAST);
        assertEquals(expected, ASTBuilder.neg(boolASTBuilder).build(),
            "Method neg does not works with booleans AST." + messageSeed);
    }
}