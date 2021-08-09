package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenFor;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenIf;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenIfElse;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenWhile;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_executables.HiddenListOfInstructions;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
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
        if (!globalVariables.containsKey(varName)) {  // Case the variable didn't add
            globalVariables.put(varName, value);
        } else if (value
            .equals(HTypeFactory.createHiddenNull())) {  // Case variable add, but it is null
            hiddenVariable.assign(globalVariables.get(varName));
        } else {  // Other cases
            HiddenASTComponent valueCopy = value.copy();
            valueCopy.accept(this);
            globalVariables.put(varName, valueCopy.calculate());
        }
    }

    /**
     * Visit a {@code HiddenOperator}.
     *
     * @param hiddenOperator an generic {@code HiddenOperator}
     */
    @Override
    public void visitHiddenOperator(HiddenOperator hiddenOperator) {
        for (String varName : globalVariables.keySet()) {
            hiddenOperator.setVariable(varName, globalVariables.get(varName));
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
     * Gets and updates the condition as boolean.
     *
     * @param condition a condition in AST format
     * @return the condition as boolean.
     */
    private boolean getConditionAsBoolean(HiddenASTComponent condition) {
        condition.accept(this);
        HType conditionCalculated = condition.calculate();
        return conditionCalculated.getValueAsBool();
    }

    /**
     * Visit a {@code HiddenWhile}.
     *
     * @param hiddenWhile an generic {@code HiddenWhile}
     */
    @Override
    public void visitHiddenWhile(HiddenWhile hiddenWhile) {
        HiddenASTComponent condition = hiddenWhile.getCondition().copy();
        while (getConditionAsBoolean(condition)) {
            hiddenWhile.getFirstBody().accept(this);
        }
    }

    /**
     * Visit a {@code HiddenIf}.
     *
     * @param hiddenIf an generic {@code HiddenIf}
     */
    @Override
    public void visitHiddenIf(HiddenIf hiddenIf) {
        HiddenASTComponent condition = hiddenIf.getCondition().copy();
        if (getConditionAsBoolean(condition)) {
            hiddenIf.getFirstBody().accept(this);
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
        if (getConditionAsBoolean(condition)) {
            hiddenIfElse.getFirstBody().accept(this);
        } else {
            hiddenIfElse.getSecondBody().accept(this);
        }
    }

    /**
     * Visit a {@code HiddenFor}.
     *
     * @param hiddenFor an generic {@code HiddenFor}
     */
    @Override
    public void visitHiddenFor(HiddenFor hiddenFor) {
        // Initialize variable
        hiddenFor.getInitializer().copy().accept(this);
        // Get the condition
        HiddenASTComponent condition = hiddenFor.getCondition().copy();
        while (getConditionAsBoolean(condition)) {
            // execute the body
            hiddenFor.getFirstBody().accept(this);
            // updates the variable
            hiddenFor.getIncrease().accept(this);
        }
    }
}
