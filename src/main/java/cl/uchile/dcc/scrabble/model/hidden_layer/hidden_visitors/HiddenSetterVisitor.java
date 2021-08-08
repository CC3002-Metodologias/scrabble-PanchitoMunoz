package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import org.jetbrains.annotations.NotNull;

/**
 * A visitor that visits a {@code HiddenASTLeaf} and sets the value in the {@code HiddenVariable}
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/04 0:17
 */
public class HiddenSetterVisitor implements HiddenVisitor {

    private final String name;
    private final HiddenASTComponent value;

    /**
     * Constructor.
     *
     * @param name  name of the variable to set
     * @param value value to set
     */
    public HiddenSetterVisitor(@NotNull String name, @NotNull HiddenASTComponent value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Visits a {@code HiddenVariable}. It sets the variable if the name match.
     *
     * @param hiddenVariable a {@code HiddenVariable}.
     */
    @Override
    public void visitHiddenVariable(HiddenVariable hiddenVariable) {
        if (hiddenVariable.getName().equals(name)) {
            hiddenVariable.assign(value);
        }
    }

}
