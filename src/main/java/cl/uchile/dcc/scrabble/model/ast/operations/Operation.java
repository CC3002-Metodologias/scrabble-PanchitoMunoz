package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeBinary;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeBool;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeFloat;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeInt;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeString;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * This interface is to define the different types of operations that exists. This is the composite
 * part of {@code HiddenASTComponent}, using the composite pattern
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 23:47
 * @see HiddenASTComponent
 */
public interface Operation extends AST {

    /**
     * Sets the variable in an {@code Operation}.
     *
     * @param name  the name of the variable
     * @param value the current value to set
     */
    void setVariable(String name, SType value);

    /**
     * Calculate the {@code SType} result of performing all operations
     *
     * @return SType result of operations.
     */
    SType calculate();

    /**
     * Transform an {@code AST} into its equivalent {@code HiddenASTComponent}.
     *
     * @return a transformation
     */
    @Override
    HiddenOperator asHiddenAST();

    /**
     * Transform the current instance into a {@code TypeBinary}.
     *
     * @return a {@code TypeBinary}
     */
    default Operation toTypeBinary() {
        return new ToTypeBinary(this);
    }

    /**
     * Transform the current instance into a {@code TypeBool}.
     *
     * @return a {@code TypeBool}
     */
    default Operation toTypeBool() {
        return new ToTypeBool(this);
    }

    /**
     * Transform the current instance into a {@code TypeFloat}.
     *
     * @return a {@code TypeFloat}
     */
    default Operation toTypeFloat() {
        return new ToTypeFloat(this);
    }

    /**
     * Transform the current instance into a {@code TypeInt}.
     *
     * @return a {@code TypeInt}
     */
    default Operation toTypeInt() {
        return new ToTypeInt(this);
    }

    /**
     * Transform the current instance into a {@code TypeString}.
     *
     * @return a {@code TypeString}
     */
    default Operation toTypeString() {
        return new ToTypeString(this);
    }
}
