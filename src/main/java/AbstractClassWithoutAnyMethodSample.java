public abstract class AbstractClassWithoutAnyMethodSample { // should be reported as "AbstractClassWithoutAbstractMethod" (prio 1, failure)
    String field;
    int otherField;
}
