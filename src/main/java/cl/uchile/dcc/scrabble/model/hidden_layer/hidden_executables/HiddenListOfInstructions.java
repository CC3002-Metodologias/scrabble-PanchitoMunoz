package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_executables;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenVisitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class for generics list of instructions
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/02 18:00
 */
public class HiddenListOfInstructions implements HiddenAST {

    private final List<HiddenAST> instructionsList = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param instructions a list of instructions
     */
    public HiddenListOfInstructions(HiddenAST... instructions) {
        instructionsList.addAll(Arrays.asList(instructions));
    }

    /**
     * Returns the {@code String} representation of the current {@code HiddenASTComponent}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenASTComponent} as {@code String}
     */
    @Override
    public String asString(int space) {
        StringBuilder stringToReturn = new StringBuilder();
        for (HiddenAST instruction : instructionsList) {
            stringToReturn.append(instruction.asString(space)).append('\n');
        }
        return stringToReturn.toString();
    }

    /**
     * Method that accepts a {@code HiddenVisitor}.
     *
     * @param visitor a {@code HiddenVisitor}.
     */
    @Override
    public void accept(HiddenVisitor visitor) {
        visitor.visitHiddenListOfInstructions(this);
    }

    /**
     * Returns the code representation.
     *
     * @param space the number of space of indentation.
     * @return a code representation
     */
    @Override
    public String asCode(int space) {
        StringBuilder stringToReturn = new StringBuilder();
        for (HiddenAST instruction : getInstructionsList()) {
            stringToReturn.append(instruction.asCode(space)).append('\n');
        }
        return stringToReturn.toString();
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     */
    @Override
    public HiddenListOfInstructions copy() {
        List<HiddenAST> newInstructionList = new ArrayList<>();
        for (HiddenAST instruction : getInstructionsList()) {
            newInstructionList.add(instruction.copy());
        }
        return new HiddenListOfInstructions(newInstructionList.toArray(new HiddenAST[0]));
    }

    /**
     * Gets the instructions list.
     *
     * @return the instructions list.
     */
    public List<HiddenAST> getInstructionsList() {
        return instructionsList;
    }

}
