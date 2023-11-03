package machine;

public enum OpCode {
    ADD, MULTIPLY, END;

    public static OpCode opCodeFromInt(int entier) throws CodeInconnuException {
        return switch (entier) {
            case 1 -> ADD;
            case 2 -> MULTIPLY;
            case 99 -> END;
            default -> throw new CodeInconnuException(entier);
        };
    }
}
//commit du jour