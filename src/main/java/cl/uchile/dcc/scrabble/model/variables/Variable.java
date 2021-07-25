package cl.uchile.dcc.scrabble.model.variables;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import org.jetbrains.annotations.NotNull;

/**
 * A class to represent a generic variable.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/04 2:08
 */
public class Variable implements AST {

    /**
     * To use Adapter pattern
     */
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
     * Transform an {@code AST} into its equivalent {@code HiddenAST}.
     *
     * @return a transformation
     */
    @Override
    public HiddenVariable asHiddenAST() {
        return this.adaptee;
    }

    public Variable setValue(@NotNull SType value) {
        this.adaptee.setValue(value.asHType());
        return this;
    }
}
