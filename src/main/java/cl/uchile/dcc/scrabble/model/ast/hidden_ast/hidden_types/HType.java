package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations.HArithmeticOperations;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations.HLogicalOperations;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * An interface that defines a wrap of {@code SType}. This is a leaf of {@code HiddenAST}, using the
 * composite pattern. Also, it is used the Adapter pattern.
 *
 * <p>
 * The purpose of this adapter is to allow the operations that in other way can not be computed, and
 * replace with {@code null} if the operation is not defined. E.g.: operations between {@code SNumber},
 * {@code binary.add(float)} can not be computed, but with this adapter, it can, and the result is
 * {@code null}. (note that the user is not expected to do these kinds of operations, but if it
 * does, then the program will not crash abruptly at this point).
 * </p>
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 23:42
 * @see SType
 * @see HiddenAST
 * @see Operation
 */
public interface HType extends HiddenAST, HArithmeticOperations, HLogicalOperations {

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    SType toSType();

    /**
     * Transform the current instance to a {@code HiddenBinary}.
     *
     * @return a {@code HiddenBinary} equivalent
     */
    default HiddenBinary toHiddenBinary() {
        return null;
    }

    /**
     * Transform the current instance to a {@code HiddenBool}.
     *
     * @return a {@code HiddenBool} equivalent
     */
    default HiddenBool toHiddenBool() {
        return null;
    }

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    default HiddenFloat toHiddenFloat() {
        return null;
    }

    /**
     * Transform the current instance to a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt} equivalent
     */
    default HiddenInt toHiddenInt() {
        return null;
    }

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    default HiddenString toHiddenString() {
        return null;
    }
}
