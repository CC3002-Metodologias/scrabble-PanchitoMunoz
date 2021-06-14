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

    public List<AST> getChildren() {
        return children;
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

    public WType unwrapOperations(List<AST> listToUnwrap) {
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
        // Gets the a result
        return mainOperation(computedUnwrap, currentElem);
    }

    /**
     * Compute the operation between 2 {@code AST} and returns its operation. Note that internally
     * it must occupy the method {@code calculate}.
     *
     * @param value1 the value at the left
     * @param value2 the value at the right
     * @return the value computed
     */
    protected abstract WType mainOperation(AST value1, AST value2);
}
