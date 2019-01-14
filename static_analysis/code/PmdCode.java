public class PmdCode {

    public void someMethod() {
        int variable = 1; //unused variable

        if(true) {
            //always true
        }

        for(int i=0; i<=1; i++)
            emptyMethod(); //no braces in loop
    }

    public void emptyMethod() {
    }
}