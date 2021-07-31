package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.iterators;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTLeaf;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.HiddenAdd;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.HiddenMult;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.HiddenNeg;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.HiddenSub;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import java.util.ArrayList;
import java.util.List;

/**
 * A base class for AST's iterators
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/25 14:26
 */
public abstract class BaseIteratorTest extends BaseHTypeTest {

    protected HiddenASTComponent hiddenASTComponent;
    protected List<HiddenASTComponent> hiddenASTComponentList = new ArrayList<>();
    protected List<HiddenASTLeaf> hiddenASTLeaves = new ArrayList<>();

    @Override
    protected void setUp() {
        super.setUp();
        HiddenSub leftChildren = new HiddenSub(hiddenFloat1, hiddenBinary1);
        HiddenNeg binaryNeg = new HiddenNeg(hiddenBinary2);
        HiddenMult rightChildren = new HiddenMult(binaryNeg, hiddenInt1);
        hiddenASTComponent = new HiddenAdd(leftChildren, rightChildren);

        hiddenASTComponentList.add(hiddenASTComponent);
        hiddenASTComponentList.add(leftChildren);
        hiddenASTComponentList.add(hiddenFloat1);
        hiddenASTComponentList.add(hiddenBinary1);
        hiddenASTComponentList.add(rightChildren);
        hiddenASTComponentList.add(binaryNeg);
        hiddenASTComponentList.add(hiddenBinary2);
        hiddenASTComponentList.add(hiddenInt1);

        hiddenASTLeaves.add(hiddenFloat1);
        hiddenASTLeaves.add(hiddenBinary1);
        hiddenASTLeaves.add(hiddenBinary2);
        hiddenASTLeaves.add(hiddenInt1);
    }
}
