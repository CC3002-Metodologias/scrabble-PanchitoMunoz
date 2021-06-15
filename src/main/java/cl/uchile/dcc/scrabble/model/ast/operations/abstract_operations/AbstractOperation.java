package cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Abstract class for a general {@code Operation}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/14 9:52 TODO: agregar el resto de hijos que podrían verse afectadas por esta
 * clase
 */
public abstract class AbstractOperation implements Operation {

    protected final List<AST> children = new ArrayList<>();

    /**
     * Constructs a new object.
     */
    public AbstractOperation(AST... components) {
        this.add(components);
    }

    /**
     * Transform a {@code SType} into its equivalent {@code WType}. If the argument is a {@code
     * WType} or an {@code AST}, it does nothing.
     *
     * @return a transformation
     */
    @Override
    public AST toWrapType() {
        return this;
    }

    /**
     * Add a component to the list of components.
     *
     * @param component a component
     */
    @Override
    public void add(AST component) {
        // Convert to wrap type
        AST componentToAdd = component.toWrapType();
        // Add the wrapped component
        children.add(componentToAdd);
    }

    /**
     * Add multiples components to the list of components.
     *
     * @param components multiples components
     */
    @Override
    public void add(AST... components) {
        List<AST> componentsAsList = Arrays.asList(components);
        for (int i = 0; i < components.length; i++) {
            this.add(componentsAsList.get(i));
        }
    }

    /**
     * Clears the list of components
     */
    @Override
    public void clear() {
        children.clear();
    }

    /**
     * Calculate the {@code SType} result of performing all operations
     *
     * @return SType result of operations.
     */
    @Override
    public SType calculate() {
        WType unwrappedResult = unwrapOperations(children);
        return unwrappedResult.calculate();
    }

    /**
     * Unwrap the components in the list with the current operation. Use the template pattern over
     * {@code mainOperation}.
     *
     * @param listToUnwrap list to unwrap
     * @return every component calculated and unwrapped
     */
    protected WType unwrapOperations(List<AST> listToUnwrap) {
        // Gets the size
        int sizeList = listToUnwrap.size();
        // To ensure that we can get an element
        assert sizeList > 0;
        // Gets the last element
        AST currentElem = listToUnwrap.get(sizeList - 1);
        // If the list only have an element, returns that element
        if (sizeList == 1) {
            return (WType) currentElem.calculate().toWrapType();
        }
        // Otherwise, apply a recurrence
        AST computedUnwrap = unwrapOperations(listToUnwrap.subList(0, sizeList - 1));
        // Calculate the components and transform
        WType WValue1 = (WType) computedUnwrap.calculate().toWrapType();
        WType WValue2 = (WType) currentElem.calculate().toWrapType();
        // Gets the a result
        return mainOperation(WValue1, WValue2);
    }

    /**
     * Compute the operation between 2 {@code WType} and returns its operation.
     *
     * @param value1 the value at the left
     * @param value2 the value at the right
     * @return the value computed
     */
    protected abstract WType mainOperation(WType value1, WType value2);

    /**
     * Generalize the {@code asString} method, in order to only modify the operator symbol and the
     * class name.
     *
     * @param space          number of spaces to ident
     * @param operatorSymbol an operator symbol. E.g.: "+", "-"...
     * @param name           the name of the class. E.g.: "Add", "Sub"
     * @return the string representation.
     */
    protected String asString(int space, String operatorSymbol, String name) {
        String tab = " ".repeat(space);
        StringBuilder childrenAsString = new StringBuilder();
        for (int i = 0; i < children.size(); i++) {
            AST leaf = children.get(i);
            if (i == children.size() - 1) {
                childrenAsString.append(leaf.asString(space + 2)).append("\n").append(tab);
            } else {
                childrenAsString.append(leaf.asString(space + 2)).append(" ").append(
                    operatorSymbol).append("\n");
            }
        }
        return tab + name + "(\n" + childrenAsString + ")";
    }

    /**
     * A String representation of the current instance.
     *
     * @return a string representation
     */
    @Override
    public String toString() {
        return asString(0);
    }
}
