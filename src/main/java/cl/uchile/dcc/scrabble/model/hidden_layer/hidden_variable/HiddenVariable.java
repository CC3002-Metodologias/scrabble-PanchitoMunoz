package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTLeaf;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
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
    private HiddenASTComponent value = HTypeFactory.createHiddenNull();

    /**
     * Constructor without saying the value.
     *
     * @param name a variable name.
     */
    public HiddenVariable(@NotNull String name) {
        this.name = name;
        HiddenGlobalVariables.getInstance().updateVariablesInfo(
            this.name, this.value
        );
    }

    /**
     * Method that accepts a {@code HiddenSetterVisitor}.
     *
     * @param visitor a {@code HiddenSetterVisitor}.
     */
    @Override
    public void accept(HiddenSetterVisitor visitor) {
        visitor.visitVariable(this);
    }

    /**
     * Calculate the {@code HType} result of performing all operations
     *
     * @return HType result of operations.
     */
    @Override
    public HType calculate() {
        return value.calculate();
    }

    /**
     * Returns the {@code String} representation of the current {@code HiddenASTComponent}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenASTComponent} as {@code String}
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
     * The hidden representation.
     *
     * @return the representation as string
     */
    @Override
    public String toString() {
        return "HiddenVariable{" +
            "name='" + name + '\'' +
            ", value=" + value +
            '}';
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
     * @return the same variable with the value assigned
     */
    public HiddenVariable setValue(@NotNull HiddenASTComponent value) {
        return this.setValue(value, true);
    }

    /**
     * Sets the value of the variable, and updates the global variables if it is needed.
     *
     * @param value                 the value to set.
     * @param updateGlobalVariables a boolean, that decides if the global variables it will be
     *                              updated or not.
     * @return the same instance.
     */
    protected HiddenVariable setValue(@NotNull HiddenASTComponent value,
        boolean updateGlobalVariables) {
        if (updateGlobalVariables) {
            HiddenGlobalVariables.getInstance().updateVariablesInfo(this.name, value);
        }
        this.value = value;
        return this;
    }
}
