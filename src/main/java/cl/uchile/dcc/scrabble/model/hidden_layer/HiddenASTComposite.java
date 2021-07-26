package cl.uchile.dcc.scrabble.model.hidden_layer;

/**
 * todo:doc
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
    HiddenAST getFirstChildren();

    /**
     * Get the second children
     *
     * @return the second children
     */
    HiddenAST getSecondChildren();

    /**
     * Get the third children
     *
     * @return the third children
     */
    HiddenAST getThirdChildren();

    /**
     * Get the operator name
     *
     * @return the operator name
     */
    String getOperatorName();

}
