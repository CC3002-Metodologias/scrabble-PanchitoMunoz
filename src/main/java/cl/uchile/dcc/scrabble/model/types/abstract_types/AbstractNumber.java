package cl.uchile.dcc.scrabble.model.types.abstract_types;

import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;

/**
 * An abstract class for the general numbers used.
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractNumber extends AbstractType implements SNumber {

    /**
     * Method that determines if the object 'o' is equals to the current instance.
     *
     * @param o Another object that is compared to the current instance.
     * @return A boolean that determines whether the current instance are equals with 'o'.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SNumber)) {
            return false;
        }
        TypeFloat typeFloat = ((SNumber) o).toTypeFloat();
        TypeFloat thisTypeFloat = this.toTypeFloat();
        return Double.compare(typeFloat.getValue(), thisTypeFloat.getValue()) == 0;
    }
}
