package cl.uchile.dcc.scrabble.model.ast.executables;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_executables.HiddenProgram;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import cl.uchile.dcc.scrabble.model.variables.Variable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A class that represents a program
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 10:53
 */
public class Program {

    /**
     * To use adapter pattern
     */
    private final HiddenProgram adaptee;

    /**
     * Constructor.
     *
     * @param instructions a list of instructions.
     */
    public Program(AST... instructions) {
        List<HiddenAST> hiddenASTList = new ArrayList<>();
        for (AST instruction : instructions) {
            hiddenASTList.add(instruction.asHiddenAST());
        }
        this.adaptee = new HiddenProgram(hiddenASTList.toArray(new HiddenAST[0]));
    }

    /**
     * Executes the program.
     *
     * @return itself
     */
    public Program execute() {
        adaptee.execute();
        return this;
    }

    /**
     * Get a list of the current variables.
     *
     * @return a list of the current variables.
     */
    public List<Variable> getGlobalVariables() {
        List<HiddenVariable> hiddenVariableList = adaptee.getGlobalVariables();
        return hiddenVariableList.stream().map(HiddenVariable::asAST)
            .collect(Collectors.toList());
    }

    /**
     * Gets the variable of the global variables given a name.
     *
     * @param name the name of the variable.
     * @return the variable.
     */
    public Variable getGlobalVariables(String name) {
        return adaptee.getGlobalVariables(name).asAST();
    }

    @Override
    public String toString() {
        return adaptee.toString();
    }
}
