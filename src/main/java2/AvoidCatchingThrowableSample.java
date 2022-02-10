public class AvoidCatchingThrowableSample {
    public void bar() {
        try {
            // do something
        } catch (Throwable th) {  // should be reported as "AvoidCatchingThrowable" (prio 2, failure)
            th.printStackTrace();
        }
    }
}

