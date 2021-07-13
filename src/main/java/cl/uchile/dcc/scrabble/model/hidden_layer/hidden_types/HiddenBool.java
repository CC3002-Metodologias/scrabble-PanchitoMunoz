package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types.AbstractHiddenType;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeString;

// TODO: trasladar la lógica de las operaciones aquí y dejar SType como un adaptador
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
        this.typeBool = STypeFactory.createTypeBool(typeBool);
    }

    /**
     * Constructor.
     *
     * @param value a boolean
     */
    public HiddenBool(boolean value) {
        this(STypeFactory.createTypeBool(value));
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeBool toSType() {
        return STypeFactory.createTypeBool(typeBool);
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
    public HType toHiddenBool() {
        TypeBool computed = this.typeBool.toTypeBool();
        return HTypeFactory.createHiddenBool(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    @Override
    public HType toHiddenString() {
        TypeString computed = this.typeBool.toTypeString();
        return HTypeFactory.createHiddenString(computed);
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
     * Returns the negation of the current instance
     *
     * @return the negation.
     */
    @Override
    public HType neg() {
        return HTypeFactory.createHiddenBool(this.typeBool.neg());
    }

    /**
     * To use double dispatch in {@code and}
     * @param hiddenBool a {@code HiddenBool}
     */
    @Override
    public HType andWithBool(HiddenBool hiddenBool) {
        TypeBool computed = this.typeBool.andWithBool(hiddenBool.toSType());
        return HTypeFactory.createHiddenBool(computed);
    }

    /**
     * To use double dispatch in {@code and}
     *
     *
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HType andWithBinary(HiddenBinary hiddenBinary) {
        TypeBinary computed = this.typeBool.andWithBinary(hiddenBinary.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     *
     *
     * @param hiddenBool a {@code HiddenBool}
     */
    @Override
    public HType orWithBool(HiddenBool hiddenBool) {
        TypeBool computed = this.typeBool.orWithBool(hiddenBool.toSType());
        return HTypeFactory.createHiddenBool(computed);
    }

    /**
     * To use double dispatch in {@code or}
     *
     *
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HType orWithBinary(HiddenBinary hiddenBinary) {
        TypeBinary computed = this.typeBool.orWithBinary(hiddenBinary.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }
}
