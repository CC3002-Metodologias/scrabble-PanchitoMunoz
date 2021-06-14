package cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations;

import cl.uchile.dcc.scrabble.model.WrapTransformation;
import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.operations_types.TypeOperation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO: documentar
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/14 9:50
 */
public abstract class AbstractTypeOperation extends AbstractOperation implements TypeOperation {

    private final List<AST> children = new ArrayList<>();

    public AbstractTypeOperation(WrapTransformation... components) {
        add(components);
    }

    protected static AST mainOperation(AST anElement, AST otherElement) {
        return null;
    }

    protected List<AST> getChildren() {
        return children;
    }

    public void add(WrapTransformation component) {
        AST componentToAdd = component.toWrapType();
        children.add(componentToAdd);
    }

    public void add(WrapTransformation... components) {
        List<WrapTransformation> componentsAsList = Arrays.asList(components);
        List<AST> listToAdd = new ArrayList<>();
        for (int i = 0; i < componentsAsList.size(); i++) {
            listToAdd.set(i, componentsAsList.get(i).toWrapType());
        }
        children.addAll(listToAdd);
    }

    /**
     * Clears the children in the current instance.
     */
    @Override
    public void clear() {
        children.clear();
    }

    public AST unwrapOperations(List<AST> elements) {
        int sizeElem = elements.size();
        assert (sizeElem > 0);
        AST currentElement = elements.get(sizeElem - 1);
        if (sizeElem == 1) {
            return currentElement;
        }
        AST expectedResultUnwrap = unwrapOperations(elements.subList(0, sizeElem - 2));
        return mainOperation(expectedResultUnwrap, currentElement);
    }
}
