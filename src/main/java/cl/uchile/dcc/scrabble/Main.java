package cl.uchile.dcc.scrabble;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedString;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;

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
    }

}
