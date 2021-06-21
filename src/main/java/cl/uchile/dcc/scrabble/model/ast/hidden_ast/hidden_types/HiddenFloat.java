package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.abstract_types.AbstractHiddenType;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * A class to wrap a {@code TypeFloat}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:02
 * @see TypeFloat
 */
public class HiddenFloat extends AbstractHiddenType {

    private final TypeFloat typeFloat;

    /**
     * Constructor.
     *
     * @param typeFloat a type float
     */
    public HiddenFloat(TypeFloat typeFloat) {
        this.typeFloat = typeFloat;
    }

    /**
     * Constructor.
     *
     * @param value a double
     */
    public HiddenFloat(double value) {
        this(new TypeFloat(value));
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeFloat getAdaptee() {
        return new TypeFloat(this.typeFloat.getValue());
    }

    @Override
    public String toString() {
        return "HiddenFloat{" +
            "value=" + typeFloat.getValue() +
            '}';
    }

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    @Override
    public HiddenFloat toWrappedFloat() {
        TypeFloat computed = this.typeFloat.toTypeFloat();
        return new HiddenFloat(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    @Override
    public HiddenString toWrappedString() {
        TypeString computed = this.typeFloat.toTypeString();
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
        return hType.addWithFloat(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param hType another number
     * @return the division
     */
    @Override
    public HType div(HType hType) {
        return hType.divWithFloat(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param hType another number
     * @return the multiplication
     */
    @Override
    public HType mult(HType hType) {
        return hType.multWithFloat(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param hType another number
     * @return the subtraction
     */
    @Override
    public HType sub(HType hType) {
        return hType.subWithFloat(this);
    }

    /**
     * Returns the disjunction between logicals
     *
     * @param hType another logical
     * @return the disjunction
     */
    @Override
    public HType and(HType hType) {
        return hType.andWithFloat(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param hType another logical
     * @return the conjunction
     */
    @Override
    public HType or(HType hType) {
        return hType.orWithFloat(this);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public HType addWithFloat(HiddenFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeFloat.addWithFloat(wFloat.getAdaptee());
        return new HiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public HType addWithInt(HiddenInt wInt) {
        TypeFloat computed = (TypeFloat) this.typeFloat.addWithInt(wInt.getAdaptee());
        return new HiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public HType subWithFloat(HiddenFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeFloat.subWithFloat(wFloat.getAdaptee());
        return new HiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     *
     *
     */
    @Override
    public HType subWithInt(HiddenInt wInt) {
        TypeFloat computed = (TypeFloat) this.typeFloat.subWithInt(wInt.getAdaptee());
        return new HiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     */
    @Override
    public HType multWithFloat(HiddenFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeFloat.multWithFloat(wFloat.getAdaptee());
        return new HiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     */
    @Override
    public HType multWithInt(HiddenInt wInt) {
        TypeFloat computed = (TypeFloat) this.typeFloat.multWithInt(wInt.getAdaptee());
        return new HiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     */
    @Override
    public HType divWithFloat(HiddenFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeFloat.divWithFloat(wFloat.getAdaptee());
        return new HiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     */
    @Override
    public HType divWithInt(HiddenInt wInt) {
        TypeFloat computed = (TypeFloat) this.typeFloat.divWithInt(wInt.getAdaptee());
        return new HiddenFloat(computed);
    }
}
