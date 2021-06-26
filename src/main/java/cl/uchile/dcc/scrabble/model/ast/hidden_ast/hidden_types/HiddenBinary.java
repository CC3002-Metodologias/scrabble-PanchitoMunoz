package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.abstract_types.AbstractHiddenType;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * A class to wrap a {@code TypeBinary}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:01
 * @see TypeBinary
 */
public class HiddenBinary extends AbstractHiddenType {

    private final TypeBinary typeBinary;

    /**
     * Constructor.
     *
     * @param typeBinary a Type Binary
     */
    public HiddenBinary(TypeBinary typeBinary) {
        this.typeBinary = STypeFactory.createTypeBinary(typeBinary);
    }

    /**
     * Constructor
     *
     * @param value a string binary
     */
    public HiddenBinary(String value) {
        this(STypeFactory.createTypeBinary(value));
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeBinary toSType() {
        return STypeFactory.createTypeBinary(typeBinary);
    }

    @Override
    public String toString() {
        return "HiddenBinary{" +
            "value=" + typeBinary.getValue() +
            '}';
    }

    /**
     * Transform the current instance to a {@code HiddenBinary}.
     *
     * @return a {@code HiddenBinary} equivalent
     */
    @Override
    public HiddenBinary toHiddenBinary() {
        TypeBinary computed = this.typeBinary.toTypeBinary();
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    @Override
    public HiddenFloat toHiddenFloat() {
        TypeFloat computed = this.typeBinary.toTypeFloat();
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt} equivalent
     */
    @Override
    public HiddenInt toHiddenInt() {
        TypeInt computed = this.typeBinary.toTypeInt();
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    @Override
    public HiddenString toHiddenString() {
        TypeString computed = this.typeBinary.toTypeString();
        return HTypeFactory.createHiddenString(computed);
    }

    /**
     * Returns the sum
     *
     * @param hType other type to sum
     * @return the sum
     */
    @Override
    public HType add(HType hType) {
        return hType.addWithBinary(this);
    }

    /**
     * Returns the disjunction between logicals
     *
     * @param hType another logical
     * @return the disjunction
     */
    @Override
    public HType and(HType hType) {
        return hType.andWithBinary(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param hType another number
     * @return the division
     */
    @Override
    public HType div(HType hType) {
        return hType.divWithBinary(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param hType another number
     * @return the multiplication
     */
    @Override
    public HType mult(HType hType) {
        return hType.multWithBinary(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param hType another logical
     * @return the conjunction
     */
    @Override
    public HType or(HType hType) {
        return hType.orWithBinary(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param hType another number
     * @return the subtraction
     */
    @Override
    public HType sub(HType hType) {
        return hType.subWithBinary(this);
    }

    /**
     * Returns the negation of the current instance
     *
     * @return the negation.
     */
    @Override
    public HType neg() {
        return HTypeFactory.createHiddenBinary(this.typeBinary.neg());
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public HType addWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.addWithBinary(wBinary.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public HType addWithFloat(HiddenFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeBinary.addWithFloat(wFloat.toSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public HType addWithInt(HiddenInt wInt) {
        TypeInt computed = (TypeInt) this.typeBinary.addWithInt(wInt.toSType());
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public HType subWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.subWithBinary(wBinary.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public HType subWithFloat(HiddenFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeBinary.subWithFloat(wFloat.toSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public HType subWithInt(HiddenInt wInt) {
        TypeInt computed = (TypeInt) this.typeBinary.subWithInt(wInt.toSType());
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public HType multWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.multWithBinary(wBinary.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public HType multWithFloat(HiddenFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeBinary.multWithFloat(wFloat.toSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public HType multWithInt(HiddenInt wInt) {
        TypeInt computed = (TypeInt) this.typeBinary.multWithInt(wInt.toSType());
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public HType divWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.divWithBinary(wBinary.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public HType divWithFloat(HiddenFloat wFloat) {
        TypeFloat computed = (TypeFloat) this.typeBinary.divWithFloat(wFloat.toSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public HType divWithInt(HiddenInt wInt) {
        TypeInt computed = (TypeInt) this.typeBinary.divWithInt(wInt.toSType());
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public HType andWithBool(HiddenBool wBool) {
        TypeBinary computed = (TypeBinary) this.typeBinary.andWithBool(wBool.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public HType andWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.andWithBinary(wBinary.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public HType orWithBool(HiddenBool wBool) {
        TypeBinary computed = (TypeBinary) this.typeBinary.orWithBool(wBool.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public HType orWithBinary(HiddenBinary wBinary) {
        TypeBinary computed = (TypeBinary) this.typeBinary.orWithBinary(wBinary.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }
}
