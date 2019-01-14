public class FindbugsCode {

    public void someMethod() {
        //boxed primitive allocated only for String value
        String text = new Integer(1).toString(); //should use just Integer(1).toString()
        equalityMethod(text, "b");
    }

    private boolean equalityMethod(String a, String b) {
        boolean equality = (a == b); //== instead of equals
        return equality;
    }

    private void unusedPrivateMethod() {
    }
}