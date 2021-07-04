package cl.uchile.dcc.scrabble.model.hidden_ast.hidden_variable;

import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_operations.HiddenOperation;
import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.HType;
import org.jetbrains.annotations.NotNull;

/**
 * A visitor that visits a {@code HiddenAST} and sets the value in the {@code HiddenVariable}
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/04 0:17
 */
public class HiddenASTVisitor {

    private final String name;
    private final HType value;

    /**
     * Constructor.
     *
     * @param name name of the variable to set
     * @param value value to set
     */
    public HiddenASTVisitor(@NotNull String name, @NotNull HType value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Visit a {@code HType}. It does nothing.
     *
     * @param hType an generic {@code HType}
     */
    public void visitHType(HType hType) { }

    /**
     * Visits a {@code HiddenVariable}. It sets the variable if the name match.
     *
     * @param hiddenVariable a {@code HiddenVariable}.
     */
    public void visitVariable(HiddenVariable hiddenVariable) {
        if (hiddenVariable.getName().equals(name)) {
            hiddenVariable.setValue(value);
        }
    }

    /**
     * Visits a {@code HiddenOperation}. It does that its children accepts the visitor.
     *
     * @param hiddenOperation a {@code HiddenOperation}.
     */
    public void visitHiddenOperation(HiddenOperation hiddenOperation) {
        hiddenOperation.getLeftChildren().accept(this);
        hiddenOperation.getRightChildren().accept(this);
    }
}
