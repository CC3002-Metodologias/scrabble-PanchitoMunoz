package cl.uchile.dcc.scrabble;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.HiddenAdd;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.HiddenOr;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.HiddenSub;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.ast.operations.Add;
import cl.uchile.dcc.scrabble.model.ast.operations.Or;
import cl.uchile.dcc.scrabble.model.ast.operations.Sub;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.utils.BinaryUtilities;

/**
 * A main to experiment implementations
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/14 9:08
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(BinaryUtilities.intToBinary(-2));
        TypeBinary typeBinary = new TypeBinary("0110");
        HiddenBinary wBinary = new HiddenBinary(typeBinary);
        TypeFloat typeFloat = new TypeFloat(3.1415);
        HiddenFloat wFloat = new HiddenFloat(typeFloat);
        System.out.println(wFloat.add(wBinary));
        System.out.println(wFloat);
        HiddenString wString = new HiddenString("Hola!");
        System.out.println(wFloat.add(wString));
        System.out.println(typeBinary.toHiddenAST());
        System.out.println(wString.sub(wBinary));
        HiddenAdd addAST1 = new HiddenAdd(
            new HiddenFloat(6.9),
            new HiddenOr(
                new HiddenBinary("1000"),
                new HiddenSub(
                    new HiddenInt(25),
                    new HiddenBinary("0101")
                ).toHiddenBinary()
            ).toHiddenInt().toHiddenFloat()
        );
        System.out.println("Representación: " + addAST1);
        System.out.println("Resultado: " + addAST1.calculate());
        Add addAST = new Add(
            new TypeFloat(6.9),
            new Or(
                new TypeBinary("1000"),
                new Sub(
                    new TypeInt(25),
                    new TypeBinary("0101")
                ).toTypeBinary()
            ).toTypeInt().toTypeFloat()
        );
        System.out.println("Representación: " + addAST);
        System.out.println("Resultado: " + addAST.calculate());
        Add addAST2 = new Add(
            new TypeBool(true),
            new Or(
                new TypeString("Hola!"),
                new Sub(
                    new TypeInt(25),
                    new TypeBinary("0101")
                ).toTypeBinary()
            ).toTypeInt().toTypeFloat()
        );
        System.out.println("Representación: " + addAST2);
        System.out.println("Resultado: " + addAST2.calculate());
//        AST addAST3 = new Or(
//            new Add(
//                new TypeBinary("10101"),
//                new TypeInt(42)
//            ),
//            new TypeBool(true)
//        );
//        System.out.println(addAST3);
//        System.out.println(addAST3.calculate());
//        TypeBinaryFactory binaryFactory = TypeBinaryFactory.getInstance();
//        TypeBinary typeBinary1 = binaryFactory.create(typeBinary.getValue());
//        System.out.println(typeBinary);
//        TypeBinaryFactory binaryFactory1 = TypeBinaryFactory.getInstance();
    }

}
