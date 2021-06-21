package cl.uchile.dcc.scrabble;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedString;
import cl.uchile.dcc.scrabble.model.ast.interfaces.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.Add;
import cl.uchile.dcc.scrabble.model.ast.operations.Or;
import cl.uchile.dcc.scrabble.model.ast.operations.Sub;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.factories_types.TypeBinaryFactory;

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
        System.out.println(typeBinary.toHiddenAST());
        System.out.println(wString.sub(wBinary));
        AST addAST2 = new Add(new TypeInt(43), new TypeBinary("1001"));
        Add addAST1 = new Add(new TypeString("42"), addAST2);
        Add addAST = new Add(
            new TypeFloat(6.9),
            new Or(
                new TypeBinary("1000"),
                new Sub(
                    new TypeInt(25),
                    new TypeBinary("0101")
                ).toTypeBinary()
            )
        );
        System.out.println("Representación: " + addAST);
        System.out.println("Resultado: " + addAST.calculate());
        AST addAST3 = new Or(
            new Add(
                new TypeBinary("10101"),
                new TypeInt(42)
            ),
            new TypeBool(true)
        );
        System.out.println(addAST3);
        System.out.println(addAST3.calculate());
        TypeBinaryFactory binaryFactory = TypeBinaryFactory.getInstance();
        TypeBinary typeBinary1 = binaryFactory.create(typeBinary.getValue());
        System.out.println(typeBinary);
        TypeBinaryFactory binaryFactory1 = TypeBinaryFactory.getInstance();
    }

}
