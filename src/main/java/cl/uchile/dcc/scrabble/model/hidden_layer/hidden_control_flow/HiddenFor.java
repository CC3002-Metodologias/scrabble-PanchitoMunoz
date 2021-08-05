package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import cl.uchile.dcc.scrabble.model.ast.control_flow.For;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenVisitor;
import org.jetbrains.annotations.NotNull;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/03 11:11
 */
public class HiddenFor extends AbstractHiddenControlFlow {

    private final HiddenVariable initializer;
    private final HiddenVariable increase;

    /**
     * Default constructor.
     *
     * @param initializer the initializer of the loop
     * @param condition   the condition.
     * @param increase    the condition to increase/decrease
     * @param firstBody   the first body to execute.
     */
    public HiddenFor(
        HiddenVariable initializer,
        HiddenASTComponent condition,
        HiddenVariable increase,
        HiddenAST firstBody) {
        super(condition, firstBody, "For");
        this.initializer = initializer;
        this.increase = increase;
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
        return tab + "For (\n"
            + getInitializer().asString(space + 2) + ";\n"
            + getCondition().asString(space + 2) + ";\n"
            + getIncrease().asString(space + 2) + '\n'
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
        visitor.visitHiddenFor(this);
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
        return tab + "For ( "
            + getInitializer().asCode() + "; "
            + getCondition().asCode() + "; "
            + getIncrease().asCode() + " ) {\n"
            + getFirstBody().asCode(space + 2) + '\n'
            + tab + "}";
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     */
    @Override
    public HiddenAST copy() {
        return new HiddenFor(
            getInitializer().copy(),
            getCondition().copy(),
            getIncrease().copy(),
            getFirstBody().copy());
    }

    /**
     * Gets the initializer
     *
     * @return the initializer
     */
    public HiddenVariable getInitializer() {
        return initializer;
    }

    /**
     * Gets the condition to increase/decrease
     *
     * @return the condition to increase/decrease
     */
    public HiddenVariable getIncrease() {
        return increase;
    }

    /**
     * Returns the AST equivalent.
     *
     * @return an AST equivalent.
     */
    @Override
    public @NotNull For asAST() {
        return new For(getInitializer().asAST(), getCondition().asAST(), getIncrease().asAST(),
            getFirstBody().asAST());
    }
}
