package cl.uchile.dcc.scrabble.model.hidden_ast.hidden_operations.operations;

import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.BaseHTypeTest;
import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.HiddenNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Base class for hidden operations
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 23:00
 */
public abstract class BaseHiddenOperationTest extends BaseHTypeTest {

    protected List<HType> hNumberList = new ArrayList<>();
    protected List<HType> hNumberCList = new ArrayList<>();
    protected List<HType> hIntegerList = new ArrayList<>();
    protected List<HType> hIntegerCList = new ArrayList<>();
    protected List<HType> hLogicalList = new ArrayList<>();
    protected List<HType> hLogicalCList = new ArrayList<>();

    @Override
    protected void setUp() {
        super.setUp();
        // Add elements in number type's list
        hNumberList.add(hiddenBinary2);
        hNumberCList.add(falseHiddenBool);
        hNumberCList.add(trueHiddenBool);
        hNumberList.add(hiddenFloat2);
        hNumberList.add(hiddenInt2);
        hNumberCList.add(HiddenNull.getInstance());
        hNumberCList.add(hiddenString2);
        // Add elements in integer type's list
        hIntegerList.add(hiddenBinary2);
        hIntegerCList.add(falseHiddenBool);
        hIntegerCList.add(trueHiddenBool);
        hIntegerCList.add(hiddenFloat2);
        hIntegerList.add(hiddenInt2);
        hIntegerCList.add(HiddenNull.getInstance());
        hIntegerCList.add(hiddenString2);
        // Add elements in logical type's list
        hLogicalList.add(hiddenBinary2);
        hLogicalList.add(falseHiddenBool);
        hLogicalList.add(trueHiddenBool);
        hLogicalCList.add(hiddenFloat2);
        hLogicalCList.add(hiddenInt2);
        hLogicalCList.add(HiddenNull.getInstance());
        hLogicalCList.add(hiddenString2);
    }
}
