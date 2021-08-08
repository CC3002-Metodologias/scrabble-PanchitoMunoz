package cl.uchile.dcc.scrabble;

import cl.uchile.dcc.scrabble.model.ast.control_flow.IfElse;
import cl.uchile.dcc.scrabble.model.ast.control_flow.While;
import cl.uchile.dcc.scrabble.model.ast.executables.Program;
import cl.uchile.dcc.scrabble.model.ast.operations.Sub;
import cl.uchile.dcc.scrabble.model.ast.relational_operators.GreaterThan;
import cl.uchile.dcc.scrabble.model.ast.relational_operators.NotEquals;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.variables.Variable;

/**
 * A main to experiment implementations
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/14 9:08
 */
public class Main {

    public static void main(String[] args) {
//        Operation ast = ASTBuilder.add(
//            new TypeFloat(6.9),
//            ASTBuilder.or(
//                new TypeBinary("1000"),
//                ASTBuilder.sub(
//                    new TypeInt(25),
//                    new TypeBinary("0101")
//                ).toTypeBinary()
//            )
//        ).build();
//        System.out.println("Representación : " + ast);
//        System.out.println("Resultado : " + ast.calculate());

//        System.out.println(BinaryUtilities.intToBinary(-2));
//        TypeBinary typeBinary = new TypeBinary("0110");
//        TypeFloat typeFloat = new TypeFloat(3.1415);
//
//        Add addAST = new Add(
//            new Variable("x"),
//            new Or(
//                new TypeBinary("1000"),
//                new Sub(
//                    new TypeInt(25),
//                    new TypeBinary("0101")
//                ).toTypeBinary()
//            )
//        );
//        addAST.setVariable("x", new TypeFloat(6.9));
//        System.out.println("Representación: " + addAST);
//        System.out.println("Resultado: " + addAST.calculate());
//
//        System.out.println(new TypeFloat(3).compareTo(new TypeBinary("011")));

//        HiddenASTComponent hiddenASTComponent = new HiddenAdd(
//            new HiddenVariable("x"),
//            new HiddenOr(
//                new HiddenBinary("1000"),
//                new HiddenSub(
//                    new HiddenInt(25),
//                    new HiddenBinary("0101")
//                ).toHiddenBinary()
//            )
//        );
//
//        System.out.println(hiddenASTComponent);
//
//        LeafIterator iterator = new LeafIterator(hiddenASTComponent);
//
//        while (iterator.hasNext()) {
//            HiddenASTComponent next = iterator.next();
//            System.out.println("\nPróximo elemento:");
//            System.out.println(next);
//            System.out.println("Tamaño:");
//            System.out.println(next.size());
//        }

//        Add addAST2 = new Add(
//            new TypeBool(true),
//            new Or(
//                new TypeString("Hola!"),
//                new Sub(
//                    new TypeString("Mundo!"),
//                    new TypeBinary("0101")
//                ).toTypeBinary()
//            ).toTypeInt().toTypeFloat()
//        );
//        System.out.println("Representación: " + addAST2);
//        System.out.println("Resultado: " + addAST2.calculate());




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

//        HiddenProgram program = new HiddenProgram(
//            new HiddenVariable("i").setValue(new HiddenInt(1)),
//            new HiddenWhile(new HiddenLowerThan(new HiddenVariable("i"), new HiddenInt(10)),
//                new HiddenVariable("i").setValue(new HiddenAdd(
//                    new HiddenVariable("i"), new HiddenInt(1)
//                ))
//            )
//        ).execute();
//        List<HiddenVariable> varList = program.getGlobalVariables();
//        String vars = String.valueOf(program.getGlobalVariables());
//        System.out.println(vars);
//        System.out.println(varList.get(0).calculate());
//        System.out.println(new HiddenWhile(new HiddenLowerThan(new HiddenVariable("i"), new HiddenInt(10)),
//            new HiddenVariable("i").setValue(new HiddenAdd(
//                new HiddenVariable("i"), new HiddenInt(1)
//            ))
//        ));
//        System.out.println(program);

//        HiddenProgram program = new HiddenProgram(
////            new HiddenVariable("a").setValue(new HiddenInt(100000001)),
////            new HiddenVariable("b").setValue(new HiddenInt(17)),
//            new HiddenVariable("a").setValue(new HiddenInt(30)),
//            new HiddenVariable("b").setValue(new HiddenInt(15)),
//            new HiddenWhile(
//                new HiddenNotEquals(new HiddenVariable("b"), new HiddenInt(0).toHiddenBinary()),
//                new HiddenIfElse(
//                    new HiddenGreaterThan(new HiddenVariable("a"), new HiddenVariable("b")),
//                    new HiddenVariable("a").setValue(
//                        new HiddenSub(
//                            new HiddenVariable("a"), new HiddenVariable("b")
//                        )
//                    ),
//                    new HiddenVariable("b").setValue(
//                        new HiddenSub(
//                            new HiddenVariable("b"), new HiddenVariable("a")
//                        )
//                    )
//                )
//            )
//        );
//        System.out.println(program);
////        String listVar = String.valueOf(program.getGlobalVariables());
////        System.out.println(listVar);
////        program.execute();
////        listVar = String.valueOf(program.getGlobalVariables());
////        System.out.println(listVar);
//
//        program = new HiddenProgram(
//            new HiddenFor(
//                new HiddenVariable("i").setValue(new HiddenInt(8)),
//                new HiddenGreaterThan(new HiddenVariable("i"), new HiddenInt(5)),
//                new HiddenVariable("i").decreased(),
//                HTypeFactory.createHiddenNull()
//            )
//        );
//        System.out.println(program);
//        String listVar = String.valueOf(program.getGlobalVariables());
//        System.out.println(listVar);
//        program.execute();
//        listVar = String.valueOf(program.getGlobalVariables());
//        System.out.println(listVar);

        Program program1 = new Program(
            new Variable("a").assign(new TypeInt(12)),
            new Variable("b").assign(new TypeInt(8)),
            new While(
                new NotEquals(new Variable("b"), new TypeInt(0)),
                new IfElse(
                    new GreaterThan(new Variable("a"), new Variable("b")),
                    new Variable("a").assign(
                        new Sub(new Variable("a"), new Variable("b"))
                    ),
                    new Variable("b").assign(
                        new Sub(new Variable("b"), new Variable("a"))
                    )
                )
            )
        );
        System.out.println(program1);
        program1.execute();
        System.out.println(program1.getGlobalVariables("a"));
        System.out.println(program1.getGlobalVariables("b"));

    }

}
