package cl.uchile.dcc.scrabble.model.builders;

import cl.uchile.dcc.scrabble.model.ast.operations.Add;
import cl.uchile.dcc.scrabble.model.ast.operations.And;
import cl.uchile.dcc.scrabble.model.ast.operations.BaseOperationTest;
import cl.uchile.dcc.scrabble.model.ast.operations.Div;
import cl.uchile.dcc.scrabble.model.ast.operations.Mult;
import cl.uchile.dcc.scrabble.model.ast.operations.Sub;

/**
 * Base class for builder's tests
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/25 13:30
 */
public class BaseBuilderTest extends BaseOperationTest {

    protected Div binaryAST;
    protected TypeBinaryASTBuilder binaryASTBuilder;
    protected And boolAST;
    protected TypeBoolASTBuilder boolASTBuilder;
    protected Sub floatAST;
    protected TypeFloatASTBuilder floatASTBuilder;
    protected Mult intAST;
    protected TypeIntASTBuilder intASTBuilder;
    protected Add stringAST;
    protected TypeStringASTBuilder stringASTBuilder;

    @Override
    protected void setUp() {
        super.setUp();
        binaryAST = new Div(typeBinary1, typeBinary2);
        binaryASTBuilder = ASTBuilder.div(typeBinary1, typeBinary2);
        boolAST = new And(trueTypeBool, falseTypeBool);
        boolASTBuilder = ASTBuilder.and(trueTypeBool, falseTypeBool);
        floatAST = new Sub(typeFloat1, typeInt1);
        floatASTBuilder = ASTBuilder.sub(typeFloat1, typeInt1);
        intAST = new Mult(typeInt1, typeInt2);
        intASTBuilder = ASTBuilder.mult(typeInt1, typeInt2);
        stringAST = new Add(typeString1, typeFloat1);
        stringASTBuilder = ASTBuilder.add(typeString1, typeFloat1);
    }
}
