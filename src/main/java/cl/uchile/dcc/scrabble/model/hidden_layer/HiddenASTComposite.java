package cl.uchile.dcc.scrabble.model.hidden_layer;

/**
 * An interface to represent an AST composite in the hidden layer.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/25 18:17
 */
public interface HiddenASTComposite extends HiddenASTComponent {

    /**
     * Get the first children
     *
     * @return the first children
     */
    HiddenASTComponent getFirstChildren();

    /**
     * Get the operator name
     *
     * @return the operator name
     */
    String getOperatorName();
}
