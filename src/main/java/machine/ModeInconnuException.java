package machine;

public class ModeInconnuException extends Exception {
    private final int modeInconnu;

    public ModeInconnuException(int modeInconnu) {
        super("Mode Inconnu : " + modeInconnu);
        this.modeInconnu = modeInconnu;
    }


    public int getModeInconnu() {
        return modeInconnu;
    }
}
