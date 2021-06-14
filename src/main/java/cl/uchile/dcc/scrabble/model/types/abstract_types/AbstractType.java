package cl.uchile.dcc.scrabble.model.types.abstract_types;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * An abstract class for the general types used.
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractType implements SType {
    /**
     * Method that determines if the object 'o' is equals to the current instance.
     * @param o Another object that is compared to the current instance.
     * @return A boolean that determines whether the current instance are equals with 'o'.
     */
    abstract public boolean equals(Object o);

    /**
     * Method that returns the hash code of the current instance.
     * @return The hash code of the current instance.
     */
    abstract public int hashCode();

    /**
     * Method that provides a representation of the current instance as a String.
     *
     * @return The representation as a String.
     */
    abstract public String toString();

    /**
     * Calculate the {@code SType} result of performing all operations
     *
     * @return SType result of operations.
     */
    @Override
    public SType calculate() {
        return this;
    }

    /**
     * Returns the {@code String} representation of the current {@code AST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code AST} as {@code String}
     */
    @Override
    public String asString(int space) {
        // TODO: Quizas para desacoplar este metodo de WType se podria implementar asString aqui y
        //  dejar que el Adapter lo adapte en su respectiva clase
        WType thisAsWType = (WType) this.toWrapType();
        return thisAsWType.asString(space);
    }
}
