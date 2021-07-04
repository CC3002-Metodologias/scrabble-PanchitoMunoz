package cl.uchile.dcc.scrabble.model.hidden_ast.hidden_variable;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_operations.operations.HiddenAdd;
import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.BaseHTypeTest;
import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.HiddenFloat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenASTVisitorTest extends BaseHTypeTest {

    private HiddenASTVisitor visitor1;
    private HiddenASTVisitor visitor2;
    private final String name = "x";
    private final String otherName = "y";

    @BeforeEach
    public void setUp() {
        super.setUp();
        visitor1 = new HiddenASTVisitor(name, hiddenFloat1);
        visitor2 = new HiddenASTVisitor(otherName, hiddenFloat2);
    }

    @RepeatedTest(20)
    void testCalculate() {
        // It does nothing
        hiddenFloat1.accept(visitor1);
        assertEquals(hiddenFloat1.toSType(), hiddenFloat1.toSType());
        // Set variable
        HiddenVariable variable = new HiddenVariable(name);
        assertEquals(hiddenNull, variable.calculate());
        variable.accept(visitor2);
        assertEquals(hiddenNull, variable.calculate(),
            "Method calculate does not works." + messageSeed);
        variable.accept(visitor1);
        assertEquals(hiddenFloat1, variable.calculate(),
            "Method calculate does not works." + messageSeed);
        // Set in an hidden operation
        HiddenAdd operation = new HiddenAdd(
            new HiddenVariable(name), new HiddenVariable(otherName)
        );
        assertEquals(hiddenNull, operation.calculate(),
            "HiddenOperation does not works with empty leaf." + messageSeed);
        operation.accept(visitor2);
        assertEquals(hiddenNull, operation.calculate(),
            "calculate does not works with other variable." + messageSeed);
        operation.accept(visitor1);
        assertEquals(new HiddenFloat(aFloat1 + aFloat2), operation.calculate(),
            "calculate does not works with correct variable." + messageSeed);
    }
}