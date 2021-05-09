package cl.uchile.dcc.scrabble.model.types;

/**
 * A class for the boolean type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeBool extends AbstractType {
    private Boolean value;

    /**
     * Constructor for the BoolType.
     * @param value A boolean as a value.
     */
    public TypeBool(Boolean value) {
        this.value = value;
    }
}
