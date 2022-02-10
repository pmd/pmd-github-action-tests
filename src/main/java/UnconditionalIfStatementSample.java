public class UnconditionalIfStatementSample {
    public void close() {
        if (true) {        // should be reported as "UnconditionalIfStatement" (prio 4, warning)
            // ...
        }
    }
}
