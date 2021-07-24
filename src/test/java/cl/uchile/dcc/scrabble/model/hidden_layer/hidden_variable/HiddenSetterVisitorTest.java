package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenSetterVisitorTest extends BaseHTypeTest {

    private HiddenSetterVisitor visitor1;
    private HiddenSetterVisitor visitor2;
    private final String name = "x";
    private final String otherName = "y";

    @BeforeEach
    public void setUp() {
        super.setUp();
        visitor1 = new HiddenSetterVisitor(name, hiddenFloat1);
        visitor2 = new HiddenSetterVisitor(otherName, hiddenFloat2);
    }

    @RepeatedTest(20)
    void testCalculate() {
        // It does nothing
        hiddenFloat1.accept(visitor1);
        assertEquals(hiddenFloat1.asSType(), hiddenFloat1.asSType());
        // Set variable
        HiddenVariable variable = new HiddenVariable(name);
        assertEquals(hiddenNull, variable.calculate());
        variable.accept(visitor2);
        assertEquals(hiddenNull, variable.calculate(),
            "Method calculate does not works." + messageSeed);
        variable.accept(visitor1);
        assertEquals(hiddenFloat1, variable.calculate(),
            "Method calculate does not works." + messageSeed);
    }
}