package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTLeaf;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenVisitor;
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
    }

    /**
     * Method that accepts a {@code HiddenVisitor}.
     *
     * @param visitor a {@code HiddenVisitor}.
     */
    @Override
    public void accept(HiddenVisitor visitor) {
        visitor.visitHiddenVariable(this);
    }

    /**
     * Calculate the {@code HType} result of performing all operations
     *
     * @return HType result of operations.
     */
    @Override
    public HType calculate() {
        return getValue().calculate();
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
            + "name=" + name
            + getValueAsString(space + 2)
            + '}';
    }

    /**
     * Returns the code representation.
     *
     * @param space the number of space of indentation.
     * @return a code representation
     */
    @Override
    public String asCode(int space) {
        String tab = " ".repeat(space);
        if (getValue().equals(HTypeFactory.createHiddenNull())) {
            return tab + getName();
        }
        return tab + getName() + " = " + getValue().asCode();
    }

    private String getValueAsString(int space) {
        if (getValue().equals(HTypeFactory.createHiddenNull())) {
            return "";
        }
        return ", " + "value=\n"
            + getValue().asString(space + 2);
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
            ", value=" + getValue() +
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
     * Gets the value in the variable
     *
     * @return the value of the variable.
     */
    public HiddenASTComponent getValue() {
        return value;
    }

    /**
     * Sets the value of the variable.
     *
     * @param value a {@code HType} value to set.
     * @return the same variable with the value assigned
     */
    public HiddenVariable setValue(@NotNull HiddenASTComponent value) {
        this.value = value;
        return this;
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     */
    @Override
    public HiddenVariable copy() {
        return new HiddenVariable(getName()).setValue(getValue());
    }
}
