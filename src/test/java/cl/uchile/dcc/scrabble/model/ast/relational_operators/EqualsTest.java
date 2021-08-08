package cl.uchile.dcc.scrabble.model.ast.relational_operators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class EqualsTest extends BaseTypeTest {

    private RelationalOperator equals;
    private RelationalOperator greater;
    private RelationalOperator lower;

    @BeforeEach
    public void setUp() {
        super.setUp();
        equals = new Equals(typeBinary1, typeBinary1.toTypeFloat());
        if (typeFloat1.compareTo(typeFloat2) >= 0) {
            greater = new Equals(typeFloat1, typeFloat2);
            lower = new Equals(typeFloat2, typeFloat1);
        } else {
            greater = new Equals(typeFloat2, typeFloat1);
            lower = new Equals(typeFloat1, typeFloat2);
        }
    }

    @RepeatedTest(20)
    void testCalculate() {
        assertEquals(falseTypeBool, greater.calculate(),
            "Class Equals does not works." + messageSeed);
        assertEquals(trueTypeBool, equals.calculate(),
            "Class Equals does not works." + messageSeed);
        assertEquals(falseTypeBool, lower.calculate(),
            "Class Equals does not works." + messageSeed);
    }
}