package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTLeaf;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenAdd;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenSub;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.ToHiddenBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.ToHiddenBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.ToHiddenFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.ToHiddenInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.ToHiddenString;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenVisitor;
import cl.uchile.dcc.scrabble.model.variables.Variable;
import java.util.HashMap;
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
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HiddenVariable)) {
            return false;
        }

        HiddenVariable variable = (HiddenVariable) o;

        if (!getName().equals(variable.getName())) {
            return false;
        }
        return getValue().equals(variable.getValue());
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getValue().hashCode();
        return result;
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

    /**
     * Gets the value as String.
     */
    private String getValueAsString(int space) {
        if (getValue().equals(HTypeFactory.createHiddenNull())) {
            return "";
        }
        return ", " + "value=\n"
            + getValue().asString(space);
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
    public HiddenVariable assign(@NotNull HiddenASTComponent value) {
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
        return new HiddenVariable(getName()).assign(getValue());
    }

    /**
     * Returns the AST equivalent.
     *
     * @return an AST equivalent.
     */
    @Override
    public @NotNull Variable asAST() {
        return new Variable(getName()).assign(getValue().calculate().asAST());
    }

    /**
     * Increase the variable by 1.
     *
     * @return the variable increased by 1
     */
    public HiddenVariable increase() {
        return increase(new HiddenInt(1));
    }

    /**
     * Increase the variable.
     *
     * @param valueToIncrease the value to increase.
     * @return the variable increased.
     */
    public HiddenVariable increase(HiddenInt valueToIncrease) {
        return this.assign(
            new HiddenAdd(new HiddenVariable(getName()), valueToIncrease)
        );
    }

    /**
     * Decrease the variable by 1.
     *
     * @return the variable decreased by 1
     */
    public HiddenVariable decreased() {
        return decreased(new HiddenInt(1));
    }

    /**
     * Decrease the variable.
     *
     * @param valueToDecreased the value to decreased.
     * @return the variable decreased.
     */
    public HiddenVariable decreased(HiddenInt valueToDecreased) {
        return this.assign(
            new HiddenSub(new HiddenVariable(getName()), valueToDecreased)
        );
    }

    /**
     * Transform the current instance to a {@code HiddenBinary}.
     *
     * @return a {@code HiddenBinary} equivalent
     */
    @Override
    public HiddenVariable toHiddenBinary() {
        this.assign(new ToHiddenBinary(this.getValue()));
        return this;
    }

    /**
     * Transform the current instance to a {@code HiddenBool}.
     *
     * @return a {@code HiddenBool} equivalent
     */
    @Override
    public HiddenVariable toHiddenBool() {
        this.assign(new ToHiddenBool(this.getValue()));
        return this;
    }

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    @Override
    public HiddenVariable toHiddenFloat() {
        this.assign(new ToHiddenFloat(this.getValue()));
        return this;
    }

    /**
     * Transform the current instance to a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt} equivalent
     */
    @Override
    public HiddenVariable toHiddenInt() {
        this.assign(new ToHiddenInt(this.getValue()));
        return this;
    }

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    @Override
    public HiddenVariable toHiddenString() {
        this.assign(new ToHiddenString(this.getValue()));
        return this;
    }
}
