package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTLeaf;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HArithmeticOperations;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HComparable;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HLogicalOperations;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HString;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenVisitor;
import cl.uchile.dcc.scrabble.model.hidden_layer.types_bridge.HiddenTypeBridge;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * An interface that defines a general Hidden Type. This is a leaf of {@code HiddenASTComponent},
 * using the composite pattern.
 *
 * <p>
 * The purpose of this adapter is to allow the operations that in other way can not be computed, and
 * replace with {@code null} if the operation is not defined. E.g.: operations between {@code
 * SNumber}, {@code binary.add(float)} can not be computed, but with this adapter, it can, and the
 * result is {@code null}. (note that the user is not expected to do these kinds of operations, but
 * if it does, then the program will not crash abruptly at this point).
 * </p>
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 23:42
 * @see SType
 * @see HiddenASTComponent
 * @see Operation
 */
public interface HType
    extends HiddenASTLeaf, HArithmeticOperations, HLogicalOperations, HComparable {


    /**
     * Returns the visitor
     *
     * @return a visitor
     */
    HiddenTypeBridge getBridge();

    /**
     * Value as String
     *
     * @return Value as String
     */
    default String getValueAsString() {
        return null;
    }

    /**
     * Returns the value
     * @return the value in the object
     */
    Object getValue();

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    SType asSType();

    /**
     * Method that accepts a {@code HiddenVisitor}.
     *
     * @param visitor a {@code HiddenVisitor}.
     */
    @Override
    default void accept(HiddenVisitor visitor) {
        visitor.visitHType(this);
    }


    /**
     * Calculate the {@code HType} result of performing all operations.
     *
     * @return {@code HType} result of operations
     */
    @Override
    default HType calculate() {
        return this;
    }

    /**
     * Returns the {@code SType} as String
     *
     * @return the {@code SType} as String
     */
    String sTypeAsString();

    /**
     * Transform the current instance to a {@code HiddenBinary}.
     *
     * @return a {@code HiddenBinary} equivalent
     */
    @Override
    default HBinary toHiddenBinary() {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Transform the current instance to a {@code HiddenBool}.
     *
     * @return a {@code HiddenBool} equivalent
     */
    @Override
    default HBool toHiddenBool() {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    @Override
    default HFloat toHiddenFloat() {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Transform the current instance to a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt} equivalent
     */
    @Override
    default HInt toHiddenInt() {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    @Override
    default HString toHiddenString() {
        return HTypeFactory.createHiddenNull();
    }
}
