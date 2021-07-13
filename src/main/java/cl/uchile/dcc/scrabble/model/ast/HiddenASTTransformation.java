package cl.uchile.dcc.scrabble.model.ast;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operations.HiddenOperation;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * Interface that provides the transformation to a Hidden Type. This functionality allows mapping
 * {@code SType} and {@code Operation} to {@code HType} and {@code HiddenOperation} in the {@code HiddenAST}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/14 8:53
 * @see SType
 * @see HType
 * @see Operation
 * @see HiddenOperation
 * @see HiddenAST
 */
public interface HiddenASTTransformation {

    /**
     * Transform an {@code AST} into its equivalent {@code HiddenAST}.
     *
     * @return a transformation
     */
    HiddenAST asHiddenAST();
}
