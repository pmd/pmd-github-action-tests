public class ReturnFromFinallyBlockSample {
    public String bar() {
        try {
            throw new Exception( "My Exception" );
        } catch (Exception e) {
            throw e;
        } finally {
            return "A. O. K."; // should be reported as "ReturnFromFinallyBlock" (prio 3, warning)
        }
    }
}
