public class LocalVariableNamingConventionsSample {
    public Integer bar() {
        Integer LOCAL_VARIABLE = 1; // should be reported as "localVariableNamingConventions" (prio 5, notice)
        return LOCAL_VARIABLE;
    }
    public Integer foo() {
        Integer LOCAL_VARIABLE = 1; // should be reported as "localVariableNamingConventions" (prio 5, notice)
        return LOCAL_VARIABLE;
    }
}
