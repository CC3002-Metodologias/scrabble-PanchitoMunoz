package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.abstract_types.AbstractHiddenType;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * A class to wrap a {@code TypeBool}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:00
 * @see TypeBool
 */
public class HiddenBool extends AbstractHiddenType {

    private final TypeBool typeBool;

    /**
     * Constructor.
     *
     * @param typeBool a type bool
     */
    public HiddenBool(TypeBool typeBool) {
        this.typeBool = typeBool;
    }

    /**
     * Constructor.
     *
     * @param value a boolean
     */
    public HiddenBool(boolean value) {
        this(new TypeBool(value));
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeBool getAdaptee() {
        return new TypeBool(this.typeBool.getValue());
    }

    @Override
    public String toString() {
        return "HiddenBool{" +
            "value=" + typeBool.getValue() +
            '}';
    }

    /**
     * Transform the current instance to a {@code HiddenBool}.
     *
     * @return a {@code HiddenBool} equivalent
     */
    @Override
    public HiddenBool toHiddenBool() {
        TypeBool computed = this.typeBool.toTypeBool();
        return new HiddenBool(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    @Override
    public HiddenString toHiddenString() {
        TypeString computed = this.typeBool.toTypeString();
        return new HiddenString(computed);
    }

    /**
     * Returns the sum
     *
     * @param hType other type to sum
     * @return the sum
     */
    @Override
    public HType add(HType hType) {
        return hType.addWithBool(this);
    }

    /**
     * Returns the disjunction between logicals
     *
     * @param hType another logical
     * @return the disjunction
     */
    @Override
    public HType and(HType hType) {
        return hType.andWithBool(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param hType another logical
     * @return the conjunction
     */
    @Override
    public HType or(HType hType) {
        return hType.orWithBool(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param hType another number
     * @return the division
     */
    @Override
    public HType div(HType hType) {
        return hType.divWithBool(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param hType another number
     * @return the multiplication
     */
    @Override
    public HType mult(HType hType) {
        return hType.multWithBool(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param hType another number
     * @return the subtraction
     */
    @Override
    public HType sub(HType hType) {
        return hType.subWithBool(this);
    }

    /**
     * Returns the negation of the current instance
     *
     * @return the negation.
     */
    @Override
    public HType neg() {
        return new HiddenBool((TypeBool) this.typeBool.neg());
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public HType andWithBool(HiddenBool wBool) {
        TypeBool computed = (TypeBool) this.typeBool.andWithBool(wBool.getAdaptee());
        return new HiddenBool(computed);
    }

    /**
     * To use double dispatch in {@code and}
     *
     *
     */
    @Override
    public HType andWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBool.andWithBinary(wBinary.getAdaptee());
        return new HiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     *
     *
     */
    @Override
    public HType orWithBool(HiddenBool wBool) {
        TypeBool computed = (TypeBool) this.typeBool.orWithBool(wBool.getAdaptee());
        return new HiddenBool(computed);
    }

    /**
     * To use double dispatch in {@code or}
     *
     *
     */
    @Override
    public HType orWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBool.orWithBinary(wBinary.getAdaptee());
        return new HiddenBinary(computed);
    }
}
