package cl.uchile.dcc.scrabble;

import cl.uchile.dcc.scrabble.model.ast.operations.Add;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedString;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;

/**
 * A main to experiment implementations
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/14 9:08
 */
public class Main {

    public static void main(String[] args) {
        TypeBinary typeBinary = new TypeBinary("0110");
        WrappedBinary wBinary = new WrappedBinary(typeBinary);
        TypeFloat typeFloat = new TypeFloat(3.1415);
        WrappedFloat wFloat = new WrappedFloat(typeFloat);
        System.out.println(wFloat.add(wBinary));
        System.out.println(wFloat);
        WrappedString wString = new WrappedString("Hola!");
        System.out.println(wFloat.add(wString));
        System.out.println(typeBinary.toWrapType());
        System.out.println(wString.sub(wBinary));
//        Add addAST = new Add(new TypeInt(43), new TypeBinary("1001"));
//        Add addAST2 = new Add(new TypeInt(43), new TypeBinary("1001"), addAST);
//        Add addAST1 = new Add(new TypeString("42"), addAST2);
        Add addAST = new Add(
            new TypeInt(6),
            new Add(
                new TypeBinary("0110"),
                new TypeInt(42)
            ),
            new TypeInt(42),
            new TypeFloat(3.14)
        );
        System.out.println("Representación: " + addAST);
        System.out.println("Resultado: " + addAST.calculate());
    }

}
