import java.util.List;

public class UseCollectionIsEmptySample {
    void bad() {
        List<String> foo = getList();
        if (foo.size() == 0) { // should be reported as "UseCollectionIsEmpty" (prio 5, notice)
            // blah
        }
    }

    private List<String> getList() {
        return null;
    }
}

