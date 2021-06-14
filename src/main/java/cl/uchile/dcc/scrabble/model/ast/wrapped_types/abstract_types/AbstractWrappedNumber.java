package cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_types;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedInt;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.interfaces_types.WNumber;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;

/**
 * An abstract class to wrap a generic {@code SNumber}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:05
 * @see SNumber
 */
public abstract class AbstractWrappedNumber extends AbstractWrappedType implements WNumber {

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WNumber divWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WNumber divWithFloat(WrappedFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WNumber divWithInt(WrappedInt wInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WNumber multWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WNumber multWithFloat(WrappedFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WNumber multWithInt(WrappedInt wInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WNumber subWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WNumber subWithFloat(WrappedFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WNumber subWithInt(WrappedInt wInt) {
        return null;
    }
}
