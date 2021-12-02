public class UnusedLocalVariableSample {
    
    public Boolean bar(String z) {
        String x = 'some string'; // not used

        String y = 'some other string'; // used in the next line
        return z.equals(y);
    }
}

