package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenVisitor;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/26 0:23
 */
public class HiddenWhile extends AbstractHiddenControlFlow {

    /**
     * Default constructor.
     *
     * @param condition A condition. It can be a {@code HiddenASTComponent}.
     * @param whileBody The body that it could be executed iff the condition holds.
     */
    public HiddenWhile(
        HiddenASTComponent condition,
        HiddenAST whileBody) {
        super(condition, whileBody, "While");
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
        return tab + "While (\n"
            + getCondition().asString(space + 2) + '\n'
            + tab + ") {\n"
            + getFirstBody().asString(space + 2) + '\n'
            + tab + '}';
    }

    /**
     * Method that accepts a {@code HiddenVisitor}.
     *
     * @param visitor a {@code HiddenVisitor}.
     */
    @Override
    public void accept(HiddenVisitor visitor) {
        visitor.visitHiddenWhile(this);
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
        return tab + "While ( " + getCondition().asCode() + " ) {\n"
            + getFirstBody().asCode(space + 2) + '\n'
            + tab + '}';
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     */
    @Override
    public HiddenWhile copy() {
        return new HiddenWhile(getCondition().copy(), getFirstBody().copy());
    }
}
