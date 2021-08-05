package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import cl.uchile.dcc.scrabble.model.ast.control_flow.IfElse;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenVisitor;
import org.jetbrains.annotations.NotNull;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/26 0:21
 */
public class HiddenIfElse extends HiddenIf {

    private final HiddenAST secondBody;

    /**
     * Constructor.
     *
     * @param condition A condition. It can be a {@code HiddenASTComponent}.
     * @param ifBody    the body if the condition is true.
     * @param elseBody  the body if the condition is false.
     */
    public HiddenIfElse(
        HiddenASTComponent condition,
        HiddenAST ifBody,
        HiddenAST elseBody) {
        super(condition, ifBody, "IfElse");
        this.secondBody = elseBody;
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
        return super.asString(space) + " Else {\n"
            + getSecondBody().asString(space + 2) + '\n'
            + tab + '}';
    }

    /**
     * Method that accepts a {@code HiddenVisitor}.
     *
     * @param visitor a {@code HiddenVisitor}.
     */
    @Override
    public void accept(HiddenVisitor visitor) {
        visitor.visitHiddenIfElse(this);
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
        return super.asCode(space) + " Else {\n"
            + getSecondBody().asCode(space + 2) + '\n'
            + tab + '}';
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     */
    @Override
    public HiddenIfElse copy() {
        return new HiddenIfElse(
            getCondition().copy(),
            getFirstBody().copy(),
            getSecondBody().copy());
    }

    /**
     * Gets the second body.
     *
     * @return the second body.
     */
    public HiddenAST getSecondBody() {
        return secondBody;
    }

    /**
     * Returns the AST equivalent.
     *
     * @return an AST equivalent.
     */
    @Override
    public @NotNull IfElse asAST() {
        return new IfElse(getCondition().asAST(), getFirstBody().asAST(), getSecondBody().asAST());
    }
}
