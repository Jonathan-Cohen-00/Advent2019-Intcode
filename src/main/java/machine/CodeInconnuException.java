package machine;

public class CodeInconnuException extends Exception {
    private final int codeInconnu;

    public CodeInconnuException(int codeInconnu) {
        super("Code inconnu : " + codeInconnu);
        this.codeInconnu = codeInconnu;
    }

    public int getCodeInconnu() {
        return codeInconnu;
    }
}