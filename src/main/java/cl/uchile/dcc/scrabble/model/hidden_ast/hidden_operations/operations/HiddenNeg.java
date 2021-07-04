package cl.uchile.dcc.scrabble.model.hidden_ast.hidden_operations.operations;

import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_operations.abstract_classes.AbstractHiddenUnaryOperation;
import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_ast.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.operations.Neg;

/**
 * A class to add a node in the {@code HiddenAST}. It is equivalent to compute the {@code neg} method. This class will be adapted by the {@code Neg} class.
 *
 * @see Neg
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/21 17:33
 */
public class HiddenNeg extends AbstractHiddenUnaryOperation {

    /**
     * Default constructor. It can receive an {@code HiddenOperation} or a {@code HType}.
     *
     * @param value left value, it can be an {@code HiddenOperation} or a {@code HType}.
     */
    public HiddenNeg(HiddenAST value) {
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
