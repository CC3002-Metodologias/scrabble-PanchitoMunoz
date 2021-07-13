package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.operation_visitor;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 18:19
 */
public class HiddenStringVisitor extends AbstractHiddenTypeVisitor {

    /**
     * Constructor.
     *
     * @param value an {@code HType}
     */
    public HiddenStringVisitor(
        HiddenString value) {
        super(value);
    }

    /**
     * Returns the value in the visitor
     *
     * @return the value in the visitor
     */
    @Override
    public HiddenString getValue() {
        return (HiddenString) super.getValue();
    }
}
