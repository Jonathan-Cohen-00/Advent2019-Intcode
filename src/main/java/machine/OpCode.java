package machine;

public enum OpCode {
    ADD, MULTIPLY, INPUT, OUTPUT, END, JUMPifTRUE, JUMPifFalse, LESSTHAN, EQUALS;

    public static OpCode opCodeFromInt(int entier) throws CodeInconnuException {
        return switch (entier) {
            case 1 -> ADD;
            case 2 -> MULTIPLY;
            case 3 -> INPUT;
            case 4 -> OUTPUT;
            case 5 -> JUMPifTRUE;
            case 6 -> JUMPifFalse;
            case 7 -> LESSTHAN;
            case 8 -> EQUALS;
            case 99 -> END;
            default -> throw new CodeInconnuException(entier);
        };
    }
}