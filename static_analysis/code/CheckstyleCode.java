import java.math.BigInteger; //unused import

public class CheckstyleCode {

    public final static int someConstant = 1; //should be SOME_CONSTANT instead

    public void some_method() { //should be someMethod instead
        //body
    }

    public void methodTooManyParameters(int a, int b, int c) { //too many parameters - max 2
        //body
    }
}