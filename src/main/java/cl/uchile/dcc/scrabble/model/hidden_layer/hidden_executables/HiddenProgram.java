package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_executables;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenGlobalVariableVisitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A class that represents a program.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/02 16:56
 */
public class HiddenProgram {

    private final HiddenListOfInstructions instructionsList;
    private final HashMap<String, HiddenASTComponent> globalVariables = new HashMap<>();
    private final HiddenGlobalVariableVisitor visitor
        = new HiddenGlobalVariableVisitor(globalVariables);

    /**
     * Constructor.
     *
     * @param instructions The instructions to build the program.
     */
    public HiddenProgram(HiddenAST... instructions) {
        this.instructionsList = new HiddenListOfInstructions(instructions);
    }

    /**
     * Executes the current program and updates the global variables.
     */
    public HiddenProgram execute() {
        // First at all: clear the global variables.
        globalVariables.clear();
        HiddenListOfInstructions instructionsListCopy = instructionsList.copy();
        for (HiddenAST instruction : instructionsListCopy.getInstructionsList()) {
            // Executes each line updating the global variables.
            instruction.accept(visitor);
        }
        return this;
    }

    /**
     * Return a list with the current global variables in the program, as {@code HiddenVariable}.
     *
     * @return a list with {@code HiddenVariable}.
     */
    public List<HiddenVariable> getGlobalVariables() {
        List<HiddenVariable> listToReturn = new ArrayList<>();
        for (String varName : globalVariables.keySet()) {
            HiddenASTComponent varValue = globalVariables.get(varName).copy();
            listToReturn.add(new HiddenVariable(varName).setValue(varValue));
        }
        return listToReturn;
    }

    public HiddenVariable getGlobalVariable(String name) {
        HiddenASTComponent value = globalVariables.get(name);
        return new HiddenVariable(name).setValue(value);
    }

    /**
     * The representation.
     *
     * @return the representation as string.
     */
    @Override
    public String toString() {
        return instructionsList.asCode();
    }
}
