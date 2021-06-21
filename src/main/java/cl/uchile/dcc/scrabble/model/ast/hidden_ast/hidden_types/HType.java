package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations.HAdd;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations.HAnd;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations.HDiv;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations.HMult;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations.HNeg;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations.HOr;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations.HSub;
import cl.uchile.dcc.scrabble.model.ast.interfaces.Operation;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * An interface that defines a wrap of {@code SType}. This is a leaf of {@code HiddenAST}, using the
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
 * @see HiddenAST
 * @see Operation
 */
public interface HType extends HiddenAST, HAdd, HSub, HMult, HDiv, HAnd, HOr, HNeg {


    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    SType getAdaptee();

    /**
     * Transform the current instance to a {@code HiddenBinary}.
     *
     * @return a {@code HiddenBinary} equivalent
     */
    HiddenBinary toWrappedBinary();

    /**
     * Transform the current instance to a {@code HiddenBool}.
     *
     * @return a {@code HiddenBool} equivalent
     */
    HiddenBool toWrappedBool();

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    HiddenFloat toWrappedFloat();

    /**
     * Transform the current instance to a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt} equivalent
     */
    HiddenInt toWrappedInt();

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    HiddenString toWrappedString();
}
