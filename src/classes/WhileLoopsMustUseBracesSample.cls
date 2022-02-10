public class WhileLoopsMustUseBracesSample {
    public void run(int x) {
        while (x < 10)    // should be reported as "WhileLoopsMustUseBraces" (prio 3, warning)
            x++;
    }
}
