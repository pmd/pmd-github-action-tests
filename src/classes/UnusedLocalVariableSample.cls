public class UnusedLocalVariableSample {
    public Boolean bar(String z) {
        String x = 'some string'; // should be reported as "UnusedLocalVariable" (prior 2, error)

        String y = 'some other string'; // used in the next line
        return z.equals(y);
    }

    public Boolean foo(String z) {
        String x = 'some string'; // should be reported as "UnusedLocalVariable" (prior 2, error)

        String y = 'some other string'; // used in the next line
        return z.equals(y);
    }
}

