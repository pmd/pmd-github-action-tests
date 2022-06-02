import java.util.List;

public class AllInOne {

    public abstract class AbstractClassWithoutAnyMethodSample { // should be reported as "AbstractClassWithoutAbstractMethod" (prio 1, failure)
        String field;
        int otherField;
    }

    public void avoidCatchingThrowable() {
        try {
            // do something
        } catch (Throwable th) {  // should be reported as "AvoidCatchingThrowable" (prio 2, failure)
            th.printStackTrace();
        }
    }

    public String returnFromFinallyBlock() {
        try {
            throw new Exception( "My Exception" );
        } catch (Exception e) {
            throw e;
        } finally {
            return "A. O. K."; // should be reported as "ReturnFromFinallyBlock" (prio 3, warning)
        }
    }

    public void unconditionalIfStatement() {
        if (true) {        // should be reported as "UnconditionalIfStatement" (prio 4, warning)
            // ...
        }
    }

    void useCollectionIsEmpty() {
        List<String> foo = getList();
        if (foo.size() == 0) { // should be reported as "UseCollectionIsEmpty" (prio 5, notice)
            // blah
        }
    }

    private List<String> getList() {
        return null;
    }
}
