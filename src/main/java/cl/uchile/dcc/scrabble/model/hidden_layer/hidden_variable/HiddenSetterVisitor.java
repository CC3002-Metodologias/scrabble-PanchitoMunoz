package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import org.jetbrains.annotations.NotNull;

/**
 * A visitor that visits a {@code HiddenASTLeaf} and sets the value in the {@code HiddenVariable}
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/04 0:17
 */
public class HiddenSetterVisitor {

    private final String name;
    private final HiddenAST value;

    /**
     * Constructor.
     *
     * @param name  name of the variable to set
     * @param value value to set
     */
    public HiddenSetterVisitor(@NotNull String name, @NotNull HiddenAST value) {
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
}
