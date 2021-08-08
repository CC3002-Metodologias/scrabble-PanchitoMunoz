package cl.uchile.dcc.scrabble.model.variables;

import cl.uchile.dcc.scrabble.model.ast.ASTComponent;
import cl.uchile.dcc.scrabble.model.ast.ASTLeaf;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/**
 * A class to represent a generic variable.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/04 2:08
 */
public class Variable implements ASTLeaf {

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
     * Transform an {@code AST} into its equivalent {@code HiddenASTComponent}.
     *
     * @return a transformation
     */
    @Override
    public @NotNull HiddenVariable asHiddenAST() {
        return this.adaptee;
    }

    /**
     * Set the value.
     *
     * @param value a value.
     * @return itself.
     */
    public Variable assign(@NotNull ASTComponent value) {
        this.adaptee.assign(value.asHiddenAST());
        return this;
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
        if (!(o instanceof Variable)) {
            return false;
        }

        Variable variable = (Variable) o;

        return adaptee.equals(variable.adaptee);
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
        return adaptee.hashCode();
    }

    /**
     * The string representation.
     *
     * @return a string representation.
     */
    @Override
    public String toString() {
        return adaptee.asString();
    }

    /**
     * Increase the variable by 1.
     *
     * @return the variable increased by 1
     */
    public Variable increase() {
        adaptee.increase();
        return this;
    }

    /**
     * Increase the variable.
     *
     * @param valueToIncrease the value to increase.
     * @return the variable increased.
     */
    public Variable increase(TypeInt valueToIncrease) {
        adaptee.increase(valueToIncrease.asHType());
        return this;
    }

    /**
     * Decrease the variable by 1.
     *
     * @return the variable decreased by 1
     */
    public Variable decreased() {
        adaptee.decreased();
        return this;
    }

    /**
     * Decrease the variable.
     *
     * @param valueToDecreased the value to decreased.
     * @return the variable decreased.
     */
    public Variable decreased(TypeInt valueToDecreased) {
        adaptee.decreased(valueToDecreased.asHType());
        return this;
    }

    /**
     * Transform the value in the variable into a binary.
     *
     * @return another {@code Variable} instance.
     */
    public Variable toTypeBinary() {
        return this.adaptee.toHiddenBinary().asAST();
    }

    /**
     * Transform the value in the variable into a boolean.
     *
     * @return another {@code Variable} instance.
     */
    public Variable toTypeBool() {
        return this.adaptee.toHiddenBool().asAST();
    }

    /**
     * Transform the value in the variable into a float.
     *
     * @return another {@code Variable} instance.
     */
    public Variable toTypeFloat() {
        return this.adaptee.toHiddenFloat().asAST();
    }

    /**
     * Transform the value in the variable into an int.
     *
     * @return another {@code Variable} instance.
     */
    public Variable toTypeInt() {
        return this.adaptee.toHiddenInt().asAST();
    }

    /**
     * Transform the value in the variable into a string.
     *
     * @return another {@code Variable} instance.
     */
    public Variable toTypeString() {
        return this.adaptee.toHiddenString().asAST();
    }
}
