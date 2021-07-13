package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTLeaf;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.variables.Variable;
import org.jetbrains.annotations.NotNull;

/**
 * Hidden Variable to use un the hidden layer.
 *
 * @see Variable
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/04 0:04
 */
public class HiddenVariable implements HiddenASTLeaf {

    private final String name;
    private HType value = HTypeFactory.createHiddenNull();

    /**
     * Constructor without saying the value.
     *
     * @param name a variable name.
     */
    public HiddenVariable(@NotNull String name) {
        this.name = name;
    }

    /**
     * Constructor saying the value.
     *
     * @param name a variable name.
     * @param value a {@code HType}.
     */
    public HiddenVariable(@NotNull String name, @NotNull HType value) {
        this(name);
        this.value = value;
    }

    /**
     * Method that accepts a {@code HiddenASTVisitor}.
     *
     * @param visitor a {@code HiddenASTVisitor}.
     */
    @Override
    public void accept(HiddenASTVisitor visitor) {
        visitor.visitVariable(this);
    }

    /**
     * Calculate the {@code HType} result of performing all operations
     *
     * @return HType result of operations.
     */
    @Override
    public HType calculate() {
        return value;
    }

    /**
     * Returns the {@code String} representation of the current {@code HiddenAST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenAST} as {@code String}
     */
    @Override
    public String asString(int space) {
        String tab = " ".repeat(space);
        return tab + "Variable{"
            + "name=" + name + ", "
            + "value=" + value.asString(0)
            + '}';
    }

    /**
     * Gets the name of the variable.
     *
     * @return the name of the variable.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the variable.
     *
     * @param value a {@code HType} value to set.
     */
    public void setValue(@NotNull HType value) {
        this.value = value;
    }
}
