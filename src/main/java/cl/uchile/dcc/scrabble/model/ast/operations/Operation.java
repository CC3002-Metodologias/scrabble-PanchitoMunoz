package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.ast.AST;

/**
 * This interface is to define the different types of operations that exists. This is the composite
 * part of {@code AST}, using the composite pattern
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 23:47
 * @see AST
 */
public interface Operation extends AST {

    /**
     * Add a component to the list of components.
     *
     * @param component a component
     */
    void add(AST component);

    /**
     * Add multiples components to the list of components.
     *
     * @param components multiples components
     */
    void add(AST... components);

    /**
     * Clears the list of components
     */
    void clear();
}
