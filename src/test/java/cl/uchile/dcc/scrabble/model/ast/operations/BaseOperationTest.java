package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import java.util.ArrayList;
import java.util.List;

/**
 * A base class for Operation's tests
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/27 12:45
 */
public class BaseOperationTest extends BaseHTypeTest {

    protected List<SType> sTypeList = new ArrayList<>();
    protected List<SNumber> numberList = new ArrayList<>();
    protected List<SType> numberCList = new ArrayList<>();
    protected List<SInteger> integerList = new ArrayList<>();
    protected List<SType> integerCList = new ArrayList<>();
    protected List<SLogical> logicalList = new ArrayList<>();
    protected List<SType> logicalCList = new ArrayList<>();

    @Override
    protected void setUp() {
        super.setUp();
        // Add string
        sTypeList.add(typeString2);
        numberCList.add(typeString2);
        integerCList.add(typeString2);
        logicalCList.add(typeString2);
        // Add bool
        sTypeList.add(trueTypeBool);
        numberCList.add(trueTypeBool);
        integerCList.add(trueTypeBool);
        logicalList.add(trueTypeBool);
        sTypeList.add(falseTypeBool);
        numberCList.add(falseTypeBool);
        integerCList.add(falseTypeBool);
        logicalList.add(falseTypeBool);
        // Add float
        sTypeList.add(typeFloat2);
        numberList.add(typeFloat2);
        integerCList.add(typeFloat2);
        logicalCList.add(typeFloat2);
        // Add int
        sTypeList.add(typeInt2);
        numberList.add(typeInt2);
        integerList.add(typeInt2);
        logicalCList.add(typeInt2);
        // Add binaries
        sTypeList.add(typeBinary2);
        numberList.add(typeBinary2);
        integerList.add(typeBinary2);
        logicalList.add(typeBinary2);
    }
}
