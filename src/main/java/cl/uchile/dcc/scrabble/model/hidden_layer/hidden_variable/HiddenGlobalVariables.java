package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operations.HiddenOperation;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/**
 * A class that contains the information of every {@code HiddenVariable}
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/25 16:12
 */
public class HiddenGlobalVariables {

    /**
     * To use Singleton pattern
     */
    private static HiddenGlobalVariables instance;
    private final HashMap<String, HiddenASTComponent> variables = new HashMap<>();

    /**
     * Private constructor to avoid instance
     */
    private HiddenGlobalVariables() {
    }

    /**
     * Gets the current instance.
     *
     * @return the instance.
     */
    public static HiddenGlobalVariables getInstance() {
        if (instance == null) {
            instance = new HiddenGlobalVariables();
        }
        return instance;
    }

    public void updateVariablesInfo(@NotNull String name, @NotNull HiddenASTComponent value) {
        variables.put(name, value);
    }

    public void updateVariable(@NotNull HiddenVariable variable) {
        HiddenASTComponent globalValue = variables.get(variable.getName());
        variable.setValue(globalValue, false);
    }

    public void updateHiddenAST(@NotNull HiddenOperation hiddenOperation) {
        for (String key : variables.keySet()) {
            hiddenOperation.setVariable(key, variables.get(key));
        }
    }
}
