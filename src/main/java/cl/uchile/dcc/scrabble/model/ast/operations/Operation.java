package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.TypeString;

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

    /**
     * Transform the current instance into a {@code TypeBinary}.
     *
     * @return a {@code TypeBinary}
     */
    TypeBinary toTypeBinary();

    /**
     * Transform the current instance into a {@code TypeBool}.
     *
     * @return a {@code TypeBool}
     */
    TypeBool toTypeBool();

    /**
     * Transform the current instance into a {@code TypeFloat}.
     *
     * @return a {@code TypeFloat}
     */
    TypeFloat toTypeFloat();

    /**
     * Transform the current instance into a {@code TypeInt}.
     *
     * @return a {@code TypeInt}
     */
    TypeInt toTypeInt();

    /**
     * Transform the current instance into a {@code TypeString}.
     *
     * @return a {@code TypeString}
     */
    TypeString toTypeString();
}
