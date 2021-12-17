public class AvoidCatchingThrowableSample {

    public void bar() {
        try {
            // do something
        } catch (Throwable th) {  // should not catch Throwable
            th.printStackTrace();
        }
    }
}
