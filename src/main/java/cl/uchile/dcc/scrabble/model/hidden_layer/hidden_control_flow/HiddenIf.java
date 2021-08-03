package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenVisitor;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/03 8:55
 */
public class HiddenIf extends AbstractHiddenControlFlow {

    /**
     * Default constructor.
     *
     * @param condition    the condition.
     * @param ifBody       the first body to execute.
     * @param operatorName the operator's name.
     */
    protected HiddenIf(
        HiddenASTComponent condition,
        HiddenAST ifBody, String operatorName) {
        super(condition, ifBody, operatorName);
    }

    /**
     * Default constructor.
     *
     * @param condition the condition.
     * @param ifBody    the first body to execute.
     */
    public HiddenIf(
        HiddenASTComponent condition,
        HiddenAST ifBody) {
        this(condition, ifBody, "If");
    }

    /**
     * Returns the {@code String} representation of the current {@code HiddenASTComponent}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenASTComponent} as {@code String}
     */
    @Override
    public String asString(int space) {
        String tab = " ".repeat(space);
        return tab + "If (\n"
            + getCondition().asString(space + 2) + '\n'
            + tab + ") {\n"
            + getFirstBody().asString(space + 2) + '\n'
            + tab + "}";
    }

    /**
     * Method that accepts a {@code HiddenVisitor}.
     *
     * @param visitor a {@code HiddenVisitor}.
     */
    @Override
    public void accept(HiddenVisitor visitor) {
        visitor.visitHiddenIf(this);
    }

    /**
     * Returns the code representation.
     *
     * @param space the number of space of indentation.
     * @return a code representation
     */
    @Override
    public String asCode(int space) {
        String tab = " ".repeat(space);
        return tab + "If ( " + getCondition().asCode() + " ) {\n"
            + getFirstBody().asCode(space + 2) + '\n'
            + tab + '}';
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     */
    @Override
    public HiddenAST copy() {
        return new HiddenIf(getCondition().copy(), getFirstBody().copy());
    }
}
