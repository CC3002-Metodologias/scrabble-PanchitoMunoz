package cl.uchile.dcc.scrabble.model.types;

/**
 * An abstract class for numbers that are like integers (e.g.: TypeInt and TypeBinary).
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractInteger extends AbstractNumber {
    /**
     * Transforms the current type to a TypeBinary.
     *
     * @return TypeBinary with a value equivalent to the current type.
     */
    abstract public TypeBinary toTypeBinary();

    /**
     * Transforms the current type to a TypeInt.
     *
     * @return TypeInt with a value equivalent to the current type.
     */
    abstract public TypeInt toTypeInt();
}
