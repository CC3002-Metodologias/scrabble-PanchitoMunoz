package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 17:46
 */
public class HiddenBinaryBridge extends AbstractHiddenTypeBridge {

    /**
     * Constructor.
     *
     * @param value an {@code HType}
     */
    public HiddenBinaryBridge(HiddenBinary value) {
        super(value);
    }

    @Override
    public HiddenBinary getValue() {
        return (HiddenBinary) super.getValue();
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HType addWithBinary(HiddenBinary hiddenBinary) {
        TypeBinary computed = this.getValue().asSType().addWithBinary(hiddenBinary.asSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public HType addWithFloat(HiddenFloat hiddenFloat) {
        TypeFloat computed = this.getValue().asSType().addWithFloat(hiddenFloat.asSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HType addWithInt(HiddenInt hiddenInt) {
        TypeInt computed = this.getValue().asSType().addWithInt(hiddenInt.asSType());
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HType subWithBinary(HiddenBinary hiddenBinary) {
        TypeBinary computed = this.getValue().asSType().subWithBinary(hiddenBinary.asSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public HType subWithFloat(HiddenFloat hiddenFloat) {
        TypeFloat computed = this.getValue().asSType().subWithFloat(hiddenFloat.asSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HType subWithInt(HiddenInt hiddenInt) {
        TypeInt computed = this.getValue().asSType().subWithInt(hiddenInt.asSType());
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HType multWithBinary(HiddenBinary hiddenBinary) {
        TypeBinary computed = this.getValue().asSType().multWithBinary(hiddenBinary.asSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public HType multWithFloat(HiddenFloat hiddenFloat) {
        TypeFloat computed = this.getValue().asSType().multWithFloat(hiddenFloat.asSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HType multWithInt(HiddenInt hiddenInt) {
        TypeInt computed = this.getValue().asSType().multWithInt(hiddenInt.asSType());
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code div}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HType divWithBinary(HiddenBinary hiddenBinary) {
        TypeBinary computed = this.getValue().asSType().divWithBinary(hiddenBinary.asSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code div}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public HType divWithFloat(HiddenFloat hiddenFloat) {
        TypeFloat computed = this.getValue().asSType().divWithFloat(hiddenFloat.asSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HType divWithInt(HiddenInt hiddenInt) {
        TypeInt computed = this.getValue().asSType().divWithInt(hiddenInt.asSType());
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code and}
     * @param hiddenBool a {@code HiddenBool}
     */
    @Override
    public HType andWithBool(HiddenBool hiddenBool) {
        TypeBinary computed = this.getValue().asSType().andWithBool(hiddenBool.asSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code and}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HType andWithBinary(HiddenBinary hiddenBinary) {
        TypeBinary computed = this.getValue().asSType().andWithBinary(hiddenBinary.asSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     * @param hiddenBool a {@code HiddenBool}
     */
    @Override
    public HType orWithBool(HiddenBool hiddenBool) {
        TypeBinary computed = this.getValue().asSType().orWithBool(hiddenBool.asSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HType orWithBinary(HiddenBinary hiddenBinary) {
        TypeBinary computed = this.getValue().asSType().orWithBinary(hiddenBinary.asSType());
        return HTypeFactory.createHiddenBinary(computed);
    }
}
