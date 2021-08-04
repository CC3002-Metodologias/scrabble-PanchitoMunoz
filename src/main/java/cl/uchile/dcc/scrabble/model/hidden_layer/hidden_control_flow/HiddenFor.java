package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenVisitor;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/03 11:11
 */
public class HiddenFor extends AbstractHiddenControlFlow {

    private final HiddenVariable initializer;
    private final HiddenASTComponent increase;

    /**
     * Default constructor.
     *
     * @param condition   the condition.
     * @param firstBody   the first body to execute.
     * @param initializer the initializer of the loop
     * @param increase    the condition to increase/decrease
     */
    public HiddenFor(
        HiddenVariable initializer,
        HiddenASTComponent condition,
        HiddenASTComponent increase,
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

    public HiddenVariable getInitializer() {
        return initializer;
    }

    public HiddenASTComponent getIncrease() {
        return increase;
    }
}
