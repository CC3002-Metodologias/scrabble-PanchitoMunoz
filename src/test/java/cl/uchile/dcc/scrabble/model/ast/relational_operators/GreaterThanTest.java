package cl.uchile.dcc.scrabble.model.ast.relational_operators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class GreaterThanTest extends BaseTypeTest {

    private RelationalOperator equals;
    private RelationalOperator greater;
    private RelationalOperator lower;

    @BeforeEach
    public void setUp() {
        super.setUp();
        equals = new GreaterThan(typeBinary1, typeBinary1.toTypeFloat());
        if (typeFloat1.compareTo(typeFloat2) >= 0) {
            greater = new GreaterThan(typeFloat1, typeFloat2);
            lower = new GreaterThan(typeFloat2, typeFloat1);
        } else {
            greater = new GreaterThan(typeFloat2, typeFloat1);
            lower = new GreaterThan(typeFloat1, typeFloat2);
        }
    }

    @RepeatedTest(20)
    void testCalculate() {
        assertEquals(trueTypeBool, greater.calculate(),
            "Class GreaterThan does not works." + messageSeed);
        assertEquals(falseTypeBool, equals.calculate(),
            "Class GreaterThan does not works." + messageSeed);
        assertEquals(falseTypeBool, lower.calculate(),
            "Class GreaterThan does not works." + messageSeed);
    }

}