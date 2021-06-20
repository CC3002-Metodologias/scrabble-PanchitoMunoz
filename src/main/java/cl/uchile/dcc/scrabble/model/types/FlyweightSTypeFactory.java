package cl.uchile.dcc.scrabble.model.types;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryToInt;
import static java.util.Objects.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 17:33
 */
public class FlyweightSTypeFactory {

    // Specifics dictionaries for every type
    private final Map<Integer, TypeBinary> createdBinaries = new HashMap<>();
    private final Map<Integer, TypeBool> createdBooleans = new HashMap<>();
    private final Map<Integer, TypeFloat> createdFloats = new HashMap<>();
    private final Map<Integer, TypeInt> createdInts = new HashMap<>();
    private final Map<Integer, TypeString> createdStrings = new HashMap<>();

    public TypeBinary getBinary(String value) {
        int hashValue = hash(binaryToInt(value));
        if (!createdBinaries.containsKey(hashValue)) {
            createdBinaries.put(hashValue, new TypeBinary(value));
        }
        return createdBinaries.get(hashValue);
    }

    public TypeBool getBool(boolean value) {
        int hashValue = hash(value);
        if (!createdBooleans.containsKey(hashValue)) {
            createdBooleans.put(hashValue, new TypeBool(value));
        }
        return createdBooleans.get(hashValue);
    }

    public TypeFloat getFloat(double value) {
        int hashValue = hash(value);
        if (!createdFloats.containsKey(hashValue)) {
            createdFloats.put(hashValue, new TypeFloat(value));
        }
        return createdFloats.get(hashValue);
    }

    public TypeInt getInt(int value) {
        int hashValue = hash(value);
        if (!createdInts.containsKey(hashValue)) {
            createdInts.put(hashValue, new TypeInt(value));
        }
        return createdInts.get(hashValue);
    }

    public TypeString getString(String value) {
        int hashValue = hash(value);
        if (!createdStrings.containsKey(hashValue)) {
            createdStrings.put(hashValue, new TypeString(value));
        }
        return createdStrings.get(hashValue);
    }
}
