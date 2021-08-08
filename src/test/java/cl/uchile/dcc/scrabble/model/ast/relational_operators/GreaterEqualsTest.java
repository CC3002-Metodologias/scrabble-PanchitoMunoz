package cl.uchile.dcc.scrabble.model.ast.relational_operators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class GreaterEqualsTest extends BaseTypeTest {

    private RelationalOperator equals;
    private RelationalOperator greater;
    private RelationalOperator lower;

    @BeforeEach
    public void setUp() {
        super.setUp();
        equals = new GreaterEquals(typeBinary1, typeBinary1.toTypeFloat());
        if (typeFloat1.compareTo(typeFloat2) >= 0) {
            greater = new GreaterEquals(typeFloat1, typeFloat2);
            lower = new GreaterEquals(typeFloat2, typeFloat1);
        } else {
            greater = new GreaterEquals(typeFloat2, typeFloat1);
            lower = new GreaterEquals(typeFloat1, typeFloat2);
        }
    }

    @RepeatedTest(20)
    void testCalculate() {
        assertEquals(trueTypeBool, greater.calculate(),
            "Class GreaterEquals does not works." + messageSeed);
        assertEquals(trueTypeBool, equals.calculate(),
            "Class GreaterEquals does not works." + messageSeed);
        assertEquals(falseTypeBool, lower.calculate(),
            "Class GreaterEquals does not works." + messageSeed);
    }
}