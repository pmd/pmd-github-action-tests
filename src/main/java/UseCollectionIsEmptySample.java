import java.util.List;

public class UseCollectionIsEmptySample {
    void bad() {
        List<String> foo = getList();
        if (foo.size() == 0) {
            // blah
        }
    }

    private List<String> getList() {
        return null;
    }
}
