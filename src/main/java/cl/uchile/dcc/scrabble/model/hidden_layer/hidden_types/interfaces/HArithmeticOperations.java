package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces;

import cl.uchile.dcc.scrabble.model.exceptions.ZeroDivisionException;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;

/**
 * Interface for arithmetical operations in {@code HType}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 22:26
 */
public interface HArithmeticOperations {

    /**
     * Returns the sum
     *
     * @param hType other type to sum
     * @return the sum
     */
    default HType add(HType hType) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Returns the division between numbers
     *
     * @param hType another number
     * @return the division
     */
    default HType div(HType hType) throws ZeroDivisionException {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param hType another number
     * @return the multiplication
     */
    default HType mult(HType hType) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param hType another number
     * @return the subtraction
     */
    default HType sub(HType hType) {
        return HTypeFactory.createHiddenNull();
    }

}
