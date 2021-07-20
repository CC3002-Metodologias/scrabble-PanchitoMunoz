package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types.AbstractHiddenType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HLogical;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge.HiddenBoolBridge;
import cl.uchile.dcc.scrabble.model.types.TypeBool;

// TODO: trasladar la lógica de las operaciones aquí y dejar SType como un adaptador

/**
 * A class to wrap a {@code TypeBool}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:00
 * @see TypeBool
 */
public class HiddenBool extends AbstractHiddenType implements HLogical {

    private final TypeBool typeBool;
    private final HiddenBoolBridge bridge;

    /**
     * Constructor.
     *
     * @param typeBool a type bool
     */
    public HiddenBool(TypeBool typeBool) {
        super(typeBool);
        this.typeBool = STypeFactory.createTypeBool(typeBool);
        this.bridge = new HiddenBoolBridge(this);
    }

    /**
     * Value as Boolean
     *
     * @return Value as Boolean
     */
    public Boolean getValueAsBool() {
        return this.typeBool.getValue();
    }

    /**
     * Returns the value
     *
     * @return the value in the object
     */
    @Override
    public Boolean getValue() {
        return this.asSType().getValue();
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
     * Returns the visitor
     *
     * @return a visitor
     */
    @Override
    public HiddenBoolBridge getBridge() {
        return bridge;
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeBool asSType() {
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
//
//    /**
//     * Transform the current instance to a {@code HiddenString}.
//     *
//     * @return a {@code HiddenString} equivalent
//     */
//    @Override
//    public HType toHiddenString() {
//        TypeString computed = this.typeBool.toTypeString();
//        return HTypeFactory.createHiddenString(computed);
//    }

    /**
     * Returns the disjunction between logicals
     *
     * @param hType another logical
     * @return the disjunction
     */
    @Override
    public HType and(HType hType) {
        return hType.getBridge().andWithBool(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param hType another logical
     * @return the conjunction
     */
    @Override
    public HType or(HType hType) {
        return hType.getBridge().orWithBool(this);
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
}
