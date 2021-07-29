package cl.uchile.dcc.scrabble.model.hidden_layer;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/25 18:30
 */
public abstract class AbstractHiddenASTComposite {

//    private final HiddenAST firstChildren;
//    private final HiddenAST secondChildren;
//    private final HiddenAST thirdChildren;
//    private final String operatorName;
//
//    /**
//     * Default constructor.
//     *
//     * @param firstChildren  the first children.
//     * @param secondChildren the second children.
//     * @param thirdChildren  the third children.
//     * @param operatorName   the operator name.
//     */
//    protected AbstractHiddenASTComposite(
//        HiddenAST firstChildren,
//        HiddenAST secondChildren,
//        HiddenAST thirdChildren,
//        String operatorName) {
//        this.firstChildren = firstChildren;
//        this.secondChildren = secondChildren;
//        this.thirdChildren = thirdChildren;
//        this.operatorName = operatorName;
//    }
//
//    /**
//     * Indicates whether some other object is "equal to" this one.
//     *
//     * @param o the reference object with which to compare.
//     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
//     * @see #hashCode()
//     * @see HashMap
//     */
//    @Override
//    public final boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (!(o instanceof HiddenASTComposite)) {
//            return false;
//        }
//
//        HiddenASTComposite that = (HiddenASTComposite) o;
//
//        if (!getFirstChildren().equals(that.getFirstChildren())) {
//            return false;
//        }
//        if (!getSecondChildren().equals(that.getSecondChildren())) {
//            return false;
//        }
//        if (!getThirdChildren().equals(that.getThirdChildren())) {
//            return false;
//        }
//        return getOperatorName().equals(that.getOperatorName());
//    }
//
//    /**
//     * Returns a hash code value for the object.
//     *
//     * @return a hash code value for this object.
//     * @see Object#equals(Object)
//     * @see System#identityHashCode
//     */
//    @Override
//    public final int hashCode() {
//        int result = getFirstChildren().hashCode();
//        result = 31 * result + getSecondChildren().hashCode();
//        result = 31 * result + getThirdChildren().hashCode();
//        result = 31 * result + getOperatorName().hashCode();
//        return result;
//    }
//
//    /**
//     * A String representation of the current instance.
//     *
//     * @return a string representation
//     */
//    @Override
//    public final String toString() {
//        return asString(0);
//    }
//
//    /**
//     * Get the first children
//     *
//     * @return the first children
//     */
//    @Override
//    public final HiddenAST getFirstChildren() {
//        return firstChildren;
//    }
//
//    /**
//     * Get the second children
//     *
//     * @return the second children
//     */
//    @Override
//    public final HiddenAST getSecondChildren() {
//        return secondChildren;
//    }
//
//    /**
//     * Get the third children
//     *
//     * @return the third children
//     */
//    @Override
//    public final HiddenAST getThirdChildren() {
//        return thirdChildren;
//    }
//
//    /**
//     * Get the operator name
//     *
//     * @return the operator name
//     */
//    @Override
//    public final String getOperatorName() {
//        return operatorName;
//    }
}
