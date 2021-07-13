package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.operation_visitor;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 18:11
 */
public class HiddenBoolVisitor extends AbstractHiddenTypeVisitor {

    /**
     * Constructor.
     *
     * @param value an {@code HType}
     */
    public HiddenBoolVisitor(
        HiddenBool value) {
        super(value);
    }

    /**
     * Returns the value in the visitor
     *
     * @return the value in the visitor
     */
    @Override
    public HiddenBool getValue() {
        return (HiddenBool) super.getValue();
    }

    /**
     * To use double dispatch in {@code and}
     * @param hiddenBool a {@code HiddenBool}
     */
    @Override
    public HType andWithBool(HiddenBool hiddenBool) {
        TypeBool computed = this.getValue().asSType().andWithBool(hiddenBool.asSType());
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
        TypeBinary computed = this.getValue().asSType().andWithBinary(hiddenBinary.asSType());
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
        TypeBool computed = this.getValue().asSType().orWithBool(hiddenBool.asSType());
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
        TypeBinary computed = this.getValue().asSType().orWithBinary(hiddenBinary.asSType());
        return HTypeFactory.createHiddenBinary(computed);
    }
}
