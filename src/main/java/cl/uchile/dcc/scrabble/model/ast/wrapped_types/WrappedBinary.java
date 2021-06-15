package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_types.AbstractWrappedType;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * A class to wrap a {@code TypeBinary}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:01
 * @see TypeBinary
 */
public class WrappedBinary extends AbstractWrappedType {

    private final TypeBinary typeBinary;

    /**
     * Constructor.
     *
     * @param typeBinary a Type Binary
     */
    public WrappedBinary(TypeBinary typeBinary) {
        this.typeBinary = typeBinary;
    }

    /**
     * Constructor
     *
     * @param value a string binary
     */
    public WrappedBinary(String value) {
        this.typeBinary = new TypeBinary(value);
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public SType getAdaptee() {
        return this.typeBinary;
    }

    @Override
    public String toString() {
        return "WrappedBinary{" +
            "value=" + typeBinary.getValue() +
            '}';
    }

    /**
     * Returns the sum
     *
     * @param wType other type to sum
     * @return the sum
     */
    @Override
    public WType add(WType wType) {
        return wType.addWithBinary(this);
    }

    /**
     * Returns the disjunction between logicals
     *
     * @param wType another logical
     * @return the disjunction
     */
    @Override
    public WType and(WType wType) {
        return wType.andWithBinary(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param wType another number
     * @return the division
     */
    @Override
    public WType div(WType wType) {
        return wType.divWithBinary(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param wType another number
     * @return the multiplication
     */
    @Override
    public WType mult(WType wType) {
        return wType.multWithBinary(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param wType another logical
     * @return the conjunction
     */
    @Override
    public WType or(WType wType) {
        return wType.orWithBinary(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param wType another number
     * @return the subtraction
     */
    @Override
    public WType sub(WType wType) {
        return wType.subWithBinary(this);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary
            .addWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeBinary
            .addWithFloat((TypeFloat) wFloat.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithInt(WrappedInt wInt) {
        TypeInt computed = (TypeInt) this.typeBinary
            .addWithInt((TypeInt) wInt.getAdaptee());
        return new WrappedInt(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary
            .subWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeBinary
            .subWithFloat((TypeFloat) wFloat.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithInt(WrappedInt wInt) {
        TypeInt computed = (TypeInt) this.typeBinary
            .subWithInt((TypeInt) wInt.getAdaptee());
        return new WrappedInt(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WType multWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary
            .multWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WType multWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeBinary
            .multWithFloat((TypeFloat) wFloat.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WType multWithInt(WrappedInt wInt) {
        TypeInt computed = (TypeInt) this.typeBinary
            .multWithInt((TypeInt) wInt.getAdaptee());
        return new WrappedInt(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WType divWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary
            .divWithBinary((TypeBinary) wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WType divWithFloat(WrappedFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeBinary
            .divWithFloat((TypeFloat) wFloat.getAdaptee());
        return new WrappedFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WType divWithInt(WrappedInt wInt) {
        TypeInt computed = (TypeInt) this.typeBinary.divWithInt(
            (TypeInt) wInt.getAdaptee());
        return new WrappedInt(computed);
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WType andWithBool(WrappedBool wBool) {
        TypeBinary computed = (TypeBinary) this.typeBinary.andWithBool(
            (TypeBool) wBool.getAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WType andWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.andWithBinary(
            (TypeBinary) wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WType orWithBool(WrappedBool wBool) {
        TypeBinary computed = (TypeBinary) this.typeBinary.orWithBool(
            (TypeBool) wBool.getAdaptee());
        return new WrappedBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WType orWithBinary(WrappedBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.orWithBinary(
            (TypeBinary) wBinary.getAdaptee());
        return new WrappedBinary(computed);
    }
}
