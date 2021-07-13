package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types.AbstractHiddenType;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.operation_visitor.HiddenStringVisitor;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.operation_visitor.HiddenTypeVisitor;
import cl.uchile.dcc.scrabble.model.types.TypeString;

// TODO: trasladar la lógica de las operaciones aquí y dejar SType como un adaptador
/**
 * A class to wrap a {@code TypeString}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 23:57
 * @see TypeString
 */
public class HiddenString extends AbstractHiddenType {

    private final TypeString typeString;
    private final HiddenStringVisitor visitor;

    /**
     * Constructor.
     *
     * @param typeString a type string.
     */
    public HiddenString(TypeString typeString) {
        super(typeString);
        this.typeString = STypeFactory.createTypeString(typeString);
        this.visitor = new HiddenStringVisitor(this);
    }

    /**
     * Constructor.
     *
     * @param value a string
     */
    public HiddenString(String value) {
        this(STypeFactory.createTypeString(value));
    }

    /**
     * Returns the visitor
     *
     * @return a visitor
     */
    @Override
    public HiddenStringVisitor getVisitor() {
        return visitor;
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeString asSType() {
        return STypeFactory.createTypeString(typeString);
    }

    @Override
    public String toString() {
        return "HiddenString{" +
            "value='" + typeString.getValue() + '\'' +
            '}';
    }

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    @Override
    public HType toHiddenString() {
        TypeString computed = this.typeString.toTypeString();
        return HTypeFactory.createHiddenString(computed);
    }

    /**
     * Returns the sum
     *
     * @param hType other type to sum
     * @return the sum
     */
    @Override
    public HType add(HType hType) {
        return hType.getVisitor().addWithString(this);
    }
}
