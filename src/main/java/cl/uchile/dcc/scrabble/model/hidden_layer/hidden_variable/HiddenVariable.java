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
            + "name=" + name + ", "
            + "value=" + getValue().asString(0)
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
    protected HiddenASTComponent getValue() {
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
     * Creates and returns a copy of this object.  The precise meaning of "copy" may depend on the
     * class of the object. The general intent is that, for any object {@code x}, the expression:
     * <blockquote>
     * <pre>
     * x.clone() != x</pre></blockquote>
     * will be true, and that the expression:
     * <blockquote>
     * <pre>
     * x.clone().getClass() == x.getClass()</pre></blockquote>
     * will be {@code true}, but these are not absolute requirements. While it is typically the case
     * that:
     * <blockquote>
     * <pre>
     * x.clone().equals(x)</pre></blockquote>
     * will be {@code true}, this is not an absolute requirement.
     * <p>
     * By convention, the returned object should be obtained by calling {@code super.clone}.  If a
     * class and all of its superclasses (except {@code Object}) obey this convention, it will be
     * the case that {@code x.clone().getClass() == x.getClass()}.
     * <p>
     * By convention, the object returned by this method should be independent of this object (which
     * is being cloned).  To achieve this independence, it may be necessary to modify one or more
     * fields of the object returned by {@code super.clone} before returning it.  Typically, this
     * means copying any mutable objects that comprise the internal "deep structure" of the object
     * being cloned and replacing the references to these objects with references to the copies.  If
     * a class contains only primitive fields or references to immutable objects, then it is usually
     * the case that no fields in the object returned by {@code super.clone} need to be modified.
     * <p>
     * The method {@code clone} for class {@code Object} performs a specific cloning operation.
     * First, if the class of this object does not implement the interface {@code Cloneable}, then a
     * {@code CloneNotSupportedException} is thrown. Note that all arrays are considered to
     * implement the interface {@code Cloneable} and that the return type of the {@code clone}
     * method of an array type {@code T[]} is {@code T[]} where T is any reference or primitive
     * type. Otherwise, this method creates a new instance of the class of this object and
     * initializes all its fields with exactly the contents of the corresponding fields of this
     * object, as if by assignment; the contents of the fields are not themselves cloned. Thus, this
     * method performs a "shallow copy" of this object, not a "deep copy" operation.
     * <p>
     * The class {@code Object} does not itself implement the interface {@code Cloneable}, so
     * calling the {@code clone} method on an object whose class is {@code Object} will result in
     * throwing an exception at run time.
     *
     * @return a clone of this instance.
     * @see Cloneable
     */
    @Override
    public HiddenVariable clone() {
        return new HiddenVariable(getName()).setValue(getValue());
    }
}
