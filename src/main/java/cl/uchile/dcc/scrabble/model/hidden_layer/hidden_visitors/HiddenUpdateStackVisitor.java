package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenBinaryOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.HiddenUnaryOperator;
import java.util.Stack;

/**
 * A visitor to update the stack
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/31 14:01
 */
public class HiddenUpdateStackVisitor implements HiddenVisitor {

    private final Stack<HiddenASTComponent> stack;

    public HiddenUpdateStackVisitor(
        Stack<HiddenASTComponent> stack) {
        this.stack = stack;
    }

    /**
     * Visit a {@code hiddenBinaryOperator}.
     *
     * @param hiddenBinaryOperator an generic {@code hiddenBinaryOperator}
     */
    @Override
    public void visitHiddenBinaryOperator(HiddenBinaryOperator hiddenBinaryOperator) {
        stack.push(hiddenBinaryOperator.getSecondChildren());
        stack.push(hiddenBinaryOperator.getFirstChildren());
    }

    /**
     * Visit a {@code HiddenUnaryOperator}.
     *
     * @param hiddenUnaryOperator an generic {@code HiddenUnaryOperator}
     */
    @Override
    public void visitHiddenUnaryOperator(HiddenUnaryOperator hiddenUnaryOperator) {
        stack.push(hiddenUnaryOperator.getFirstChildren());
    }
}
