package cl.uchile.dcc.scrabble.model.ast.builders;

import cl.uchile.dcc.scrabble.model.ast.builders.interfaces.BinaryASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.builders.interfaces.BoolASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.builders.interfaces.FloatASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.builders.interfaces.IntASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.builders.interfaces.IntegerASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.builders.interfaces.LogicalASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.builders.interfaces.NumberASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.builders.interfaces.StringASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.builders.interfaces.TypeASTBuilder;
import cl.uchile.dcc.scrabble.model.ast.operations.Add;
import cl.uchile.dcc.scrabble.model.ast.operations.And;
import cl.uchile.dcc.scrabble.model.ast.operations.Div;
import cl.uchile.dcc.scrabble.model.ast.operations.Mult;
import cl.uchile.dcc.scrabble.model.ast.operations.Neg;
import cl.uchile.dcc.scrabble.model.ast.operations.Or;
import cl.uchile.dcc.scrabble.model.ast.operations.Sub;

/**
 * An utility class to build an {@code AST}
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/02 21:34
 */
public final class ASTBuilder {

    /**
     * Private constructor to avoid instance this class.
     */
    private ASTBuilder() {}

    /**
     * Auxiliary method.
     *
     * @param leftValue a {@code TypeASTBuilder}
     * @param rightValue a {@code TypeASTBuilder}
     * @return an {@code Add} instance
     */
    private static Add createAdd(TypeASTBuilder leftValue, TypeASTBuilder rightValue) {
        return new Add(leftValue.build(), rightValue.build());
    }

    /**
     * Auxiliary method.
     *
     * @param leftValue a {@code TypeASTBuilder}
     * @param rightValue a {@code TypeASTBuilder}
     * @return a {@code Sub} instance
     */
    private static Sub createSub(TypeASTBuilder leftValue, TypeASTBuilder rightValue) {
        return new Sub(leftValue.build(), rightValue.build());
    }

    /**
     * Auxiliary method.
     *
     * @param leftValue a {@code TypeASTBuilder}
     * @param rightValue a {@code TypeASTBuilder}
     * @return a {@code Mult} instance
     */
    private static Mult createMult(TypeASTBuilder leftValue, TypeASTBuilder rightValue) {
        return new Mult(leftValue.build(), rightValue.build());
    }

    /**
     * Auxiliary method.
     *
     * @param leftValue a {@code TypeASTBuilder}
     * @param rightValue a {@code TypeASTBuilder}
     * @return a {@code Div} instance
     */
    private static Div createDiv(TypeASTBuilder leftValue, TypeASTBuilder rightValue) {
        return new Div(leftValue.build(), rightValue.build());
    }

    /**
     * Auxiliary method.
     *
     * @param leftValue a {@code TypeASTBuilder}
     * @param rightValue a {@code TypeASTBuilder}
     * @return an {@code And} instance
     */
    private static And createAnd(TypeASTBuilder leftValue, TypeASTBuilder rightValue) {
        return new And(leftValue.build(), rightValue.build());
    }

    /**
     * Auxiliary method.
     *
     * @param leftValue a {@code TypeASTBuilder}
     * @param rightValue a {@code TypeASTBuilder}
     * @return a {@code Or} instance
     */
    private static Or createOr(TypeASTBuilder leftValue, TypeASTBuilder rightValue) {
        return new Or(leftValue.build(), rightValue.build());
    }

    /**
     * Auxiliary method.
     *
     * @param value a {@code TypeASTBuilder}
     * @return a {@code Or} instance
     */
    private static Neg createNeg(TypeASTBuilder value) {
        return new Neg(value.build());
    }

    /**
     * Computes the addition between two values.
     *
     * @param leftValue a {@code StringASTBuilder}
     * @param rightValue a {@code TypeASTBuilder}
     * @return a {@code TypeStringASTBuilder}
     */
    public static TypeStringASTBuilder add(StringASTBuilder leftValue, TypeASTBuilder rightValue) {
        return new TypeStringASTBuilder(createAdd(leftValue, rightValue));
    }

    /**
     * Computes the addition between two values.
     *
     * @param leftValue a {@code FloatASTBuilder}
     * @param rightValue a {@code NumberASTBuilder}
     * @return a {@code TypeFloatASTBuilder}
     */
    public static TypeFloatASTBuilder add(FloatASTBuilder leftValue, NumberASTBuilder rightValue) {
        return new TypeFloatASTBuilder(createAdd(leftValue, rightValue));
    }

    /**
     * Computes the addition between two values.
     *
     * @param leftValue a {@code IntASTBuilder}
     * @param rightValue a {@code FloatASTBuilder}
     * @return a {@code TypeFloatASTBuilder}
     */
    public static TypeFloatASTBuilder add(IntASTBuilder leftValue, FloatASTBuilder rightValue) {
        return new TypeFloatASTBuilder(createAdd(leftValue, rightValue));
    }

    /**
     * Computes the addition between two values.
     *
     * @param leftValue a {@code IntASTBuilder}
     * @param rightValue a {@code IntegerASTBuilder}
     * @return a {@code TypeIntASTBuilder}
     */
    public static TypeIntASTBuilder add(IntASTBuilder leftValue, IntegerASTBuilder rightValue) {
        return new TypeIntASTBuilder(createAdd(leftValue, rightValue));
    }

    /**
     * Computes the addition between two values.
     *
     * @param leftValue a {@code BinaryASTBuilder}
     * @param rightValue a {@code IntegerASTBuilder}
     * @return a {@code TypeBinaryASTBuilder}
     */
    public static TypeBinaryASTBuilder add(BinaryASTBuilder leftValue, IntegerASTBuilder rightValue) {
        return new TypeBinaryASTBuilder(createAdd(leftValue, rightValue));
    }

    /**
     * Computes the subtraction between two values.
     *
     * @param leftValue a {@code FloatASTBuilder}
     * @param rightValue a {@code NumberASTBuilder}
     * @return a {@code TypeFloatASTBuilder}
     */
    public static TypeFloatASTBuilder sub(FloatASTBuilder leftValue, NumberASTBuilder rightValue) {
        return new TypeFloatASTBuilder(createSub(leftValue, rightValue));
    }

    /**
     * Computes the subtraction between two values.
     *
     * @param leftValue a {@code IntASTBuilder}
     * @param rightValue a {@code FloatASTBuilder}
     * @return a {@code TypeFloatASTBuilder}
     */
    public static TypeFloatASTBuilder sub(IntASTBuilder leftValue, FloatASTBuilder rightValue) {
        return new TypeFloatASTBuilder(createSub(leftValue, rightValue));
    }

    /**
     * Computes the subtraction between two values.
     *
     * @param leftValue a {@code IntASTBuilder}
     * @param rightValue a {@code IntegerASTBuilder}
     * @return a {@code TypeIntASTBuilder}
     */
    public static TypeIntASTBuilder sub(IntASTBuilder leftValue, IntegerASTBuilder rightValue) {
        return new TypeIntASTBuilder(createSub(leftValue, rightValue));
    }

    /**
     * Computes the subtraction between two values.
     *
     * @param leftValue a {@code BinaryASTBuilder}
     * @param rightValue a {@code IntegerASTBuilder}
     * @return a {@code TypeBinaryASTBuilder}
     */
    public static TypeBinaryASTBuilder sub(BinaryASTBuilder leftValue, IntegerASTBuilder rightValue) {
        return new TypeBinaryASTBuilder(createSub(leftValue, rightValue));
    }

    /**
     * Computes the multiplication between two values.
     *
     * @param leftValue a {@code FloatASTBuilder}
     * @param rightValue a {@code NumberASTBuilder}
     * @return a {@code TypeFloatASTBuilder}
     */
    public static TypeFloatASTBuilder mult(FloatASTBuilder leftValue, NumberASTBuilder rightValue) {
        return new TypeFloatASTBuilder(createMult(leftValue, rightValue));
    }

    /**
     * Computes the multiplication between two values.
     *
     * @param leftValue a {@code IntASTBuilder}
     * @param rightValue a {@code FloatASTBuilder}
     * @return a {@code TypeFloatASTBuilder}
     */
    public static TypeFloatASTBuilder mult(IntASTBuilder leftValue, FloatASTBuilder rightValue) {
        return new TypeFloatASTBuilder(createMult(leftValue, rightValue));
    }

    /**
     * Computes the multiplication between two values.
     *
     * @param leftValue a {@code IntASTBuilder}
     * @param rightValue a {@code IntegerASTBuilder}
     * @return a {@code TypeIntASTBuilder}
     */
    public static TypeIntASTBuilder mult(IntASTBuilder leftValue, IntegerASTBuilder rightValue) {
        return new TypeIntASTBuilder(createMult(leftValue, rightValue));
    }

    /**
     * Computes the multiplication between two values.
     *
     * @param leftValue a {@code BinaryASTBuilder}
     * @param rightValue a {@code IntegerASTBuilder}
     * @return a {@code TypeBinaryASTBuilder}
     */
    public static TypeBinaryASTBuilder mult(BinaryASTBuilder leftValue, IntegerASTBuilder rightValue) {
        return new TypeBinaryASTBuilder(createMult(leftValue, rightValue));
    }

    /**
     * Computes the division between two values.
     *
     * @param leftValue a {@code FloatASTBuilder}
     * @param rightValue a {@code NumberASTBuilder}
     * @return a {@code TypeFloatASTBuilder}
     */
    public static TypeFloatASTBuilder div(FloatASTBuilder leftValue, NumberASTBuilder rightValue) {
        return new TypeFloatASTBuilder(createDiv(leftValue, rightValue));
    }

    /**
     * Computes the division between two values.
     *
     * @param leftValue a {@code IntASTBuilder}
     * @param rightValue a {@code FloatASTBuilder}
     * @return a {@code TypeFloatASTBuilder}
     */
    public static TypeFloatASTBuilder div(IntASTBuilder leftValue, FloatASTBuilder rightValue) {
        return new TypeFloatASTBuilder(createDiv(leftValue, rightValue));
    }

    /**
     * Computes the division between two values.
     *
     * @param leftValue a {@code IntASTBuilder}
     * @param rightValue a {@code IntegerASTBuilder}
     * @return a {@code TypeIntASTBuilder}
     */
    public static TypeIntASTBuilder div(IntASTBuilder leftValue, IntegerASTBuilder rightValue) {
        return new TypeIntASTBuilder(createDiv(leftValue, rightValue));
    }

    /**
     * Computes the division between two values.
     *
     * @param leftValue a {@code BinaryASTBuilder}
     * @param rightValue a {@code IntegerASTBuilder}
     * @return a {@code TypeBinaryASTBuilder}
     */
    public static TypeBinaryASTBuilder div(BinaryASTBuilder leftValue, IntegerASTBuilder rightValue) {
        return new TypeBinaryASTBuilder(createDiv(leftValue, rightValue));
    }

    /**
     * Computes the disjunction between two values.
     *
     * @param leftValue a {@code BinaryASTBuilder}
     * @param rightValue a {@code LogicalASTBuilder}
     * @return a {@code TypeBinaryASTBuilder}
     */
    public static TypeBinaryASTBuilder and(BinaryASTBuilder leftValue, LogicalASTBuilder rightValue) {
        return new TypeBinaryASTBuilder(createAnd(leftValue, rightValue));
    }

    /**
     * Computes the disjunction between two values.
     *
     * @param leftValue a {@code BoolASTBuilder}
     * @param rightValue a {@code BoolASTBuilder}
     * @return a {@code TypeBoolASTBuilder}
     */
    public static TypeBoolASTBuilder and(BoolASTBuilder leftValue, BoolASTBuilder rightValue) {
        return new TypeBoolASTBuilder(createAnd(leftValue, rightValue));
    }

    /**
     * Computes the conjunction between two values.
     *
     * @param leftValue a {@code BinaryASTBuilder}
     * @param rightValue a {@code LogicalASTBuilder}
     * @return a {@code TypeBinaryASTBuilder}
     */
    public static TypeBinaryASTBuilder or(BinaryASTBuilder leftValue, LogicalASTBuilder rightValue) {
        return new TypeBinaryASTBuilder(createOr(leftValue, rightValue));
    }

    /**
     * Computes the conjunction between two values.
     *
     * @param leftValue a {@code BoolASTBuilder}
     * @param rightValue a {@code BoolASTBuilder}
     * @return a {@code TypeBoolASTBuilder}
     */
    public static TypeBoolASTBuilder or(BoolASTBuilder leftValue, BoolASTBuilder rightValue) {
        return new TypeBoolASTBuilder(createOr(leftValue, rightValue));
    }

    /**
     * Computes the negation.
     *
     * @param value a {@code BinaryASTBuilder}
     * @return a {@code TypeBinaryASTBuilder}
     */
    public static TypeBinaryASTBuilder neg(BinaryASTBuilder value) {
        return new TypeBinaryASTBuilder(createNeg(value));
    }

    /**
     * Computes the negation.
     *
     * @param value a {@code BoolASTBuilder}
     * @return a {@code TypeBoolASTBuilder}
     */
    public static TypeBoolASTBuilder neg(BoolASTBuilder value) {
        return new TypeBoolASTBuilder(createNeg(value));
    }
}
