package machine;

public enum OpCode {
    ADD, MULTIPLY, INPUT, OUTPUT, END, JUMP_IF_TRUE, JUMP_IF_FALSE, LESSTHAN, EQUALS, ADJUSTS_RELATIVE_BASE;

    public static OpCode opCodeFromInt(int entier) throws CodeInconnuException {
        return switch (entier) {
            case 1 -> ADD;
            case 2 -> MULTIPLY;
            case 3 -> INPUT;
            case 4 -> OUTPUT;
            case 5 -> JUMP_IF_TRUE;
            case 6 -> JUMP_IF_FALSE;
            case 7 -> LESSTHAN;
            case 8 -> EQUALS;
            case 9 -> ADJUSTS_RELATIVE_BASE;
            case 99 -> END;
            default -> throw new CodeInconnuException(entier);
        };
    }
}