package cl.uchile.dcc.scrabble.model.variables;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_variable.HiddenVariable;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import org.jetbrains.annotations.NotNull;

/**
 * A class to represent a generic variable.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/04 2:08
 */
public class Variable implements AST {

    private final HiddenVariable adaptee;

    /**
     * Constructor without saying the value.
     *
     * @param name a variable name.
     */
    public Variable(@NotNull String name) {
        this.adaptee = new HiddenVariable(name);
    }

    /**
     * Constructor saying the value.
     *
     * @param name a variable name.
     * @param value a {@code HType}.
     */
    public Variable(@NotNull String name, @NotNull SType value) {
        this.adaptee = new HiddenVariable(name, value.toHiddenAST());
    }

    /**
     * Transform an {@code AST} into its equivalent {@code HiddenAST}.
     *
     * @return a transformation
     */
    @Override
    public HiddenVariable toHiddenAST() {
        return this.adaptee;
    }

    /**
     * Gets the name of the variable.
     *
     * @return the name of the variable.
     */
    public String getName() {
        return this.adaptee.getName();
    }

    /**
     * Sets the value of the variable.
     *
     * @param value a {@code HType} value to set.
     */
    public void setValue(@NotNull SType value) {
        this.adaptee.setValue(value.toHiddenAST());
    }

}
