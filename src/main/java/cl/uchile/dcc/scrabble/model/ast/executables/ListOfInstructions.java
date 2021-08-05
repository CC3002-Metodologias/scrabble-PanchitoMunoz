package cl.uchile.dcc.scrabble.model.ast.executables;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_executables.HiddenListOfInstructions;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * A class that represents a list of instructions
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 10:41
 */
public class ListOfInstructions implements AST {

    /**
     * To use adapter pattern
     */
    private final HiddenListOfInstructions adaptee;

    public ListOfInstructions(AST... instructions) {
        List<HiddenAST> hiddenASTList = new ArrayList<>();
        for (AST instruction : instructions) {
            hiddenASTList.add(instruction.asHiddenAST());
        }
        this.adaptee = new HiddenListOfInstructions(hiddenASTList.toArray(new HiddenAST[0]));
    }

    /**
     * Transform an {@code AST} into its equivalent {@code HiddenASTComponent}.
     *
     * @return a transformation
     */
    @Override
    public @NotNull HiddenListOfInstructions asHiddenAST() {
        return adaptee;
    }
}
