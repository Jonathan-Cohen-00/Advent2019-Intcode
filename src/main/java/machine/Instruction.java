package machine;

import java.util.List;

public class Instruction {
    private final List<Long> programme;
    private final int compteur;
    private final int relativeBase;
    private final OpCode opCode;
    private final ModeParametre modeParametre1;
    private final ModeParametre modeParametre2;
    private final ModeParametre modeParametre3;


    public Instruction(Integer integer, List<Long> programme, Integer compteur, Integer relativeBase) throws CodeInconnuException, ModeInconnuException {
        this.programme = programme;
        this.compteur = compteur;
        this.relativeBase = relativeBase;
        this.opCode = OpCode.opCodeFromInt(integer % 100);
        this.modeParametre1 = ModeParametre.modeParametreFromInt(integer % 1000 / 100);
        this.modeParametre2 = ModeParametre.modeParametreFromInt(integer % 10000 / 1000);
        this.modeParametre3 = ModeParametre.modeParametreFromInt(integer / 10000);
    }

    private int getIndiceReelParametre(ModeParametre modeParametre, int indiceParametre) throws ModeInconnuException {
        if (modeParametre.equals(ModeParametre.IMMEDIATE_MODE)) {
            return indiceParametre;
        } else if (modeParametre.equals(ModeParametre.POSITION_MODE)) {
            return Math.toIntExact(programme.get(indiceParametre));
        } else if (modeParametre.equals(ModeParametre.RELATIVE_MODE)) {
            return Math.toIntExact(programme.get(indiceParametre)) + relativeBase;
        }
        throw new ModeInconnuException(100);
    }

    public OpCode getOpCode() {
        return this.opCode;
    }

    public int getIndiceReelPremierParametre() throws ModeInconnuException {
        return getIndiceReelParametre(modeParametre1, compteur + 1);
    }

    public int getIndiceReelDeuxiemeParametre() throws ModeInconnuException {
        return getIndiceReelParametre(modeParametre2, compteur + 2);
    }

    public int getIndiceReelTroisiemeParametre() throws ModeInconnuException {
        return getIndiceReelParametre(modeParametre3, compteur + 3);
    }
}


