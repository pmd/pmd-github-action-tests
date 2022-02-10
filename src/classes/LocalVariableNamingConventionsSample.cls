public class LocalVariableNamingConventionsSample {
    public void bar() {
        Integer LOCAL_VARIABLE; // should be reported as "localVariableNamingConventions" (prio 5, notice)
    }
}
