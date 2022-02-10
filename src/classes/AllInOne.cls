public class AllInOne {
    Integer INSTANCE_FIELD; // should be reported as "FieldNamingConventions" (prio 1, error)

    public void unusedLocalVariableSample() {
        String x = 'some string'; // should be reported as "UnusedLocalVariable" (prior 2, error)
    }

    public void whileLoopsMustUseBraces(int x) {
        while (x < 10)    // should be reported as "WhileLoopsMustUseBraces" (prio 3, warning)
            x++;
    }

    Integer a, b;   // should be reported as "OneDeclarationPerLine" (prio 4, warning)

    public Integer localVariableNamingConventions() {
        Integer LOCAL_VARIABLE = 1; // should be reported as "localVariableNamingConventions" (prio 5, notice)
        return LOCAL_VARIABLE;
    }
}
