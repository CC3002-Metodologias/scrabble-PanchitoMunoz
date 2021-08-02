package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.BaseHiddenOperationTest;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HNumber;

/**
 * Base class for Hidden Relational Operators' tests
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/29 20:58
 */
public abstract class BaseHiddenRelationalOperatorTest extends BaseHiddenOperationTest {

    protected HNumber greaterNumber;
    protected HNumber lowerNumber;
    protected HiddenRelationalOperator greaterCase;
    protected HiddenRelationalOperator equalsCase;
    protected HiddenRelationalOperator lowerCase;


    public HNumber greaterHNumber(HNumber number1, HNumber number2) {
        return number1.getValueAsDouble() >= number2.getValueAsDouble() ? number1 : number2;
    }

    public HNumber lowerHNumber(HNumber number1, HNumber number2) {
        return number1.getValueAsDouble() <= number2.getValueAsDouble() ? number1 : number2;
    }
}


