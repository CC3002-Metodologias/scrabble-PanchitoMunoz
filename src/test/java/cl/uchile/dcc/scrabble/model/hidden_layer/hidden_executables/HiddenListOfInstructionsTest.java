package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_executables;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenListOfInstructionsTest extends BaseHTypeTest {

    private final List<HiddenVariable> hiddenVariableList = new ArrayList<>();
    private HiddenListOfInstructions listOfInstructions;
    private HiddenProgram program;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        listOfInstructions = new HiddenListOfInstructions(
            new HiddenVariable("x").setValue(hiddenInt1),
            new HiddenVariable("y").setValue(hiddenInt2)
        );
        program = new HiddenProgram(listOfInstructions);
        hiddenVariableList.add(new HiddenVariable("x").setValue(hiddenInt1));
        hiddenVariableList.add(new HiddenVariable("y").setValue(hiddenInt2));
    }

    @RepeatedTest(20)
    void testAsCode() {
        String expected = "x = %s\n"
            + "y = %s";
        assertEquals(String.format(expected, hiddenInt1.asCode(), hiddenInt2.asCode()),
            listOfInstructions.asCode(),
            "Method asCode does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAsString() {
        String expected = "Variable{name=x, value=\n"
            + "  %s}\n"
            + "Variable{name=y, value=\n"
            + "  %s}";
        assertEquals(String.format(expected, hiddenInt1.asString(), hiddenInt2.asString()),
            listOfInstructions.asString(),
            "Method asCode does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testCopy() {
        HiddenListOfInstructions other = listOfInstructions.copy();
        assertNotSame(other, listOfInstructions,
            "Method copy does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testGetInstructionsList() {
        assertEquals(hiddenVariableList, listOfInstructions.getInstructionsList());
    }

    @RepeatedTest(20)
    void testAccept() {
        program.execute();
        var globalVariables = program.getGlobalVariables();
        for (HiddenVariable variable :
            hiddenVariableList) {
            assertTrue(globalVariables.contains(variable),
                "Method accept does not works." + messageSeed);
        }
    }
}