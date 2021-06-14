package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractOperation;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WType;

/**
 * TODO: Documentar
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/14 9:54
 */
public class Add extends AbstractOperation {

    public Add(AST... components) {
        super(components);
    }

    /**
     * Returns the {@code String} representation of the current {@code AST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code AST} as {@code String}
     */
    @Override
    public String asString(int space) {
        String tab = " ".repeat(space);
        StringBuilder childrenAsString = new StringBuilder();
        for (int i = 0; i < children.size(); i++) {
            AST leaf = children.get(i);
            if (i == children.size() - 1) {
                childrenAsString.append(leaf.asString(space + 2)).append("\n").append(tab);
            } else {
                childrenAsString.append(leaf.asString(space + 2)).append(" +\n");
            }
        }
        return tab + "Add(\n" + childrenAsString + ")";
    }

    @Override
    public String toString() {
        return asString(0);
    }

    /**
     * Compute the operation between 2 {@code AST} and returns its operation. Note that internally
     * it must occupy the method {@code calculate}.
     *
     * @param value1 the value at the left
     * @param value2 the value at the right
     * @return the value computed
     */
    @Override
    protected WType mainOperation(AST value1, AST value2) {
        // Calculate with recursion
        WType WValue1 = (WType) value1.calculate().toWrapType();
        WType WValue2 = (WType) value2.calculate().toWrapType();
        return WValue1.add(WValue2);
    }
}
