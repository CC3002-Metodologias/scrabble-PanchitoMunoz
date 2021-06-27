package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class HiddenNegTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testToString() {
        String templateString = (
            "Neg(\n"
            + "  %s\n"
            + ")"
        );
        for (HType hType1 : hTypeList2) {
            String expected = String.format(templateString, hType1.asString(0));
            assertEquals(expected, new HiddenNeg(hType1).toString(),
                "Method toString does not works." + messageSeed);
        }
    }

    @RepeatedTest(20)
    void testCalculate() {
        for (HType hType :
            hLogicalList) {
            assertEquals(hType.neg(), new HiddenNeg(hType).calculate(),
                "Method neg does not works." + messageSeed);
        }
        for (HType hType :
            hLogicalCList) {
            assertNull(new HiddenNeg(hType).calculate(),
                "Method neg does not works." + messageSeed);
        }
    }
}