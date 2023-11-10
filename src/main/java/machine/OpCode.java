package machine;

import java.util.function.BiFunction;

public enum OpCode {
    ADD, MULTIPLY, INPUT, OUTPUT, END;

    public static OpCode opCodeFromInt(int entier) throws CodeInconnuException {
        return switch (entier) {
            case 1 -> ADD;
            case 2 -> MULTIPLY;
            case 3 -> INPUT;
            case 4 -> OUTPUT;
            case 99 -> END;
            default -> throw new CodeInconnuException(entier);
        };
    }
}
