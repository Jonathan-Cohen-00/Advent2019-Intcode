package machine;

public enum ModeParametre {
    POSITION_MODE, IMMEDIATE_MODE;

    public static ModeParametre modeParametreFromInt(int entier) throws ModeInconnuException {
        return switch (entier) {
            case 0 -> POSITION_MODE;
            case 1 -> IMMEDIATE_MODE;
            default -> throw new ModeInconnuException(entier);
        };
    }

}
