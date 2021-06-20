package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations.WAdd;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations.WAnd;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations.WDiv;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations.WMult;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations.WNeg;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations.WOr;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations.WSub;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * An interface that defines a wrap of {@code SType}. This is a leaf of {@code AST}, using the
 * composite pattern. Also, it is used the Adapter pattern.
 *
 * <p>
 * The purpose of this adapter is to allow the operations that in other way can not be computed, and
 * thereby make it compatible with {@code Operation}. E.g.: operations between {@code SNumber},
 * {@code binary.add(float)} can not be computed, but with this adapter, it can, and the result is
 * {@code null}. (note that the user is not expected to do these kinds of operations, but if it
 * does, then the program will not crash abruptly at this point).
 * </p>
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 23:42
 * @see SType
 * @see AST
 * @see Operation
 */
public interface WType extends AST, WAdd, WSub, WMult, WDiv, WAnd, WOr, WNeg {


    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    SType getAdaptee();

    /**
     * Transform the current instance to a {@code WrappedBinary}.
     *
     * @return a {@code WrappedBinary} equivalent
     */
    WrappedBinary toWrappedBinary();

    /**
     * Transform the current instance to a {@code WrappedBool}.
     *
     * @return a {@code WrappedBool} equivalent
     */
    WrappedBool toWrappedBool();

    /**
     * Transform the current instance to a {@code WrappedFloat}.
     *
     * @return a {@code WrappedFloat} equivalent
     */
    WrappedFloat toWrappedFloat();

    /**
     * Transform the current instance to a {@code WrappedInt}.
     *
     * @return a {@code WrappedInt} equivalent
     */
    WrappedInt toWrappedInt();

    /**
     * Transform the current instance to a {@code WrappedString}.
     *
     * @return a {@code WrappedString} equivalent
     */
    WrappedString toWrappedString();
}
