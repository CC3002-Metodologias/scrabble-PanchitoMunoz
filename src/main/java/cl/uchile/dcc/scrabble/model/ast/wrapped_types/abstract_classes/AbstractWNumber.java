package cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_classes;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WInt;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.type_interfaces.WNumber;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;

/**
 * An abstract class to wrap a generic {@code SNumber}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:05
 * @see SNumber
 */
public abstract class AbstractWNumber extends AbstractWType implements WNumber {

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WNumber divWithBinary(WBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WNumber divWithFloat(WFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WNumber divWithInt(WInt wInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WNumber multWithBinary(WBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WNumber multWithFloat(WFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WNumber multWithInt(WInt wInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WNumber subWithBinary(WBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WNumber subWithFloat(WFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WNumber subWithInt(WInt wInt) {
        return null;
    }
}
