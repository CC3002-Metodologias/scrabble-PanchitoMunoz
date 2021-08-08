package cl.uchile.dcc.scrabble.model.ast.relational_operators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class LowerEqualsTest extends BaseTypeTest {

    private RelationalOperator equals;
    private RelationalOperator greater;
    private RelationalOperator lower;

    @BeforeEach
    public void setUp() {
        super.setUp();
        equals = new LowerEquals(typeBinary1, typeBinary1.toTypeFloat());
        if (typeFloat1.compareTo(typeFloat2) >= 0) {
            greater = new LowerEquals(typeFloat1, typeFloat2);
            lower = new LowerEquals(typeFloat2, typeFloat1);
        } else {
            greater = new LowerEquals(typeFloat2, typeFloat1);
            lower = new LowerEquals(typeFloat1, typeFloat2);
        }
    }

    @RepeatedTest(20)
    void testCalculate() {
        assertEquals(falseTypeBool, greater.calculate(),
            "Class LowerEquals does not works." + messageSeed);
        assertEquals(trueTypeBool, equals.calculate(),
            "Class LowerEquals does not works." + messageSeed);
        assertEquals(trueTypeBool, lower.calculate(),
            "Class LowerEquals does not works." + messageSeed);
    }

}