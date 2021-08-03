package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenIfElse;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenWhile;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_executables.HiddenListOfInstructions;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenBinaryOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.HiddenUnaryOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import java.util.HashMap;

/**
 * A visitor that sets the current variables in the program
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/02 17:01
 */
public class HiddenGlobalVariableVisitor implements HiddenVisitor {

    private final HashMap<String, HiddenASTComponent> globalVariables;

    /**
     * Constructor.
     *
     * @param globalVariables a hash map that represents the global variables
     */
    public HiddenGlobalVariableVisitor(HashMap<String, HiddenASTComponent> globalVariables) {
        this.globalVariables = globalVariables;
    }

    /**
     * Visit a {@code HiddenVariable}.
     *
     * @param hiddenVariable an generic {@code HiddenVariable}
     */
    @Override
    public void visitHiddenVariable(HiddenVariable hiddenVariable) {
        String varName = hiddenVariable.getName();
        HiddenASTComponent value = hiddenVariable.getValue().copy();
        if (!globalVariables.containsKey(varName)) {
            globalVariables.put(varName, value);
        } else {
            HiddenASTComponent valueCopy = value.copy();
            valueCopy.accept(this);
            globalVariables.put(varName, valueCopy.calculate());
        }
    }

    /**
     * Visit a {@code HiddenUnaryOperator}.
     *
     * @param hiddenUnaryOperator an generic {@code HiddenUnaryOperator}
     */
    @Override
    public void visitHiddenUnaryOperator(HiddenUnaryOperator hiddenUnaryOperator) {
        for (String varName : globalVariables.keySet()) {
            HiddenSetterVisitor setterVisitor = new HiddenSetterVisitor(
                varName, globalVariables.get(varName)
            );
            hiddenUnaryOperator.getFirstChildren().accept(setterVisitor);
        }
    }

    /**
     * Visit a {@code HiddenBinaryOperator}.
     *
     * @param hiddenBinaryOperator an generic {@code HiddenBinaryOperator}
     */
    @Override
    public void visitHiddenBinaryOperator(HiddenBinaryOperator hiddenBinaryOperator) {
        for (String varName : globalVariables.keySet()) {
            HiddenSetterVisitor setterVisitor = new HiddenSetterVisitor(
                varName, globalVariables.get(varName)
            );
            hiddenBinaryOperator.getFirstChildren().accept(setterVisitor);
            hiddenBinaryOperator.getSecondChildren().accept(setterVisitor);
        }
    }

    /**
     * Visit a {@code HiddenListOfInstructions}.
     *
     * @param hiddenListOfInstructions an generic {@code HiddenListOfInstructions}
     */
    @Override
    public void visitHiddenListOfInstructions(HiddenListOfInstructions hiddenListOfInstructions) {
        for (HiddenAST instruction :
            hiddenListOfInstructions.getInstructionsList()) {
            instruction.accept(this);
        }
    }

    /**
     * Visit a {@code HiddenWhile}.
     *
     * @param hiddenWhile an generic {@code HiddenWhile}
     */
    @Override
    public void visitHiddenWhile(HiddenWhile hiddenWhile) {
        HiddenASTComponent condition = hiddenWhile.getCondition().copy();
        condition.accept(this);
        HiddenBool conditionCalculated = (HiddenBool) condition.calculate();
        boolean conditionBoolean = conditionCalculated.getValueAsBool();
        while (conditionBoolean) {
            hiddenWhile.getFirstBody().accept(this);
            condition.accept(this);
            conditionCalculated = (HiddenBool) condition.calculate();
            conditionBoolean = conditionCalculated.getValueAsBool();
        }
    }

    /**
     * Visit a {@code HiddenIfElse}.
     *
     * @param hiddenIfElse an generic {@code HiddenIfElse}
     */
    @Override
    public void visitHiddenIfElse(HiddenIfElse hiddenIfElse) {
        HiddenASTComponent condition = hiddenIfElse.getCondition().copy();
        condition.accept(this);
        if (((HiddenBool) condition.calculate()).getValueAsBool()) {
            hiddenIfElse.getFirstBody().accept(this);
        } else {
            hiddenIfElse.getSecondBody().accept(this);
        }
    }
}
