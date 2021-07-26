package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators;

import cl.uchile.dcc.scrabble.model.ast.operations.Neg;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.abstract_classes.AbstractHiddenUnaryOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;

/**
 * A class to add a node in the {@code HiddenASTComponent}. It is equivalent to compute the {@code
 * neg} method. This class will be adapted by the {@code Neg} class.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/21 17:33
 * @see Neg
 */
public class HiddenNeg extends AbstractHiddenUnaryOperator {

    /**
     * Default constructor. It can receive an {@code HiddenOperator} or a {@code HType}.
     *
     * @param value left value, it can be an {@code HiddenOperator} or a {@code HType}.
     */
    public HiddenNeg(HiddenASTComponent value) {
        super(value, "Neg");
    }

    /**
     * Compute the unary operation. To use template pattern in {@code mainOperation}.
     *
     * @param value a value
     * @return the value computed
     */
    @Override
    protected HType mainUnaryOperation(HType value) {
        return value.neg();
    }
}
