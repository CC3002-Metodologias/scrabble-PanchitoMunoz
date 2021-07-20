package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types.AbstractHiddenInteger;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HLogical;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge.HiddenBinaryBridge;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;

// TODO: trasladar la lógica de las operaciones aquí y dejar SType como un adaptador

/**
 * A class to wrap a {@code TypeBinary}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:01
 * @see TypeBinary
 */
public class HiddenBinary extends AbstractHiddenInteger implements HLogical {

    private final TypeBinary typeBinary;
    private final HiddenBinaryBridge bridge;

    /**
     * Constructor.
     *
     * @param typeBinary a Type Binary
     */
    public HiddenBinary(TypeBinary typeBinary) {
        super(typeBinary);
        this.typeBinary = STypeFactory.createTypeBinary(typeBinary);
        this.bridge = new HiddenBinaryBridge(this);
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
     * Returns the visitor
     *
     * @return a visitor
     */
    @Override
    public HiddenBinaryBridge getBridge() {
        return bridge;
    }

    /**
     * Returns the value
     *
     * @return the value in the object
     */
    @Override
    public String getValue() {
        return this.asSType().getValue();
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeBinary asSType() {
        return STypeFactory.createTypeBinary(typeBinary);
    }

    @Override
    public String toString() {
        return "HiddenBinary{" +
            "value=" + typeBinary.getValue() +
            '}';
    }

    /**
     * Returns the sum
     *
     * @param hType other type to sum
     * @return the sum
     */
    @Override
    public HType add(HType hType) {
        return hType.getBridge().addWithBinary(this);
    }

    /**
     * Returns the disjunction between logicals
     *
     * @param hType another logical
     * @return the disjunction
     */
    @Override
    public HType and(HType hType) {
        return hType.getBridge().andWithBinary(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param hType another number
     * @return the division
     */
    @Override
    public HType div(HType hType) {
        return hType.getBridge().divWithBinary(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param hType another number
     * @return the multiplication
     */
    @Override
    public HType mult(HType hType) {
        return hType.getBridge().multWithBinary(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param hType another logical
     * @return the conjunction
     */
    @Override
    public HType or(HType hType) {
        return hType.getBridge().orWithBinary(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param hType another number
     * @return the subtraction
     */
    @Override
    public HType sub(HType hType) {
        return hType.getBridge().subWithBinary(this);
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
}
