package machine;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Instruction {
    private final List<Integer> programme;
    private final int compteur;
    private final OpCode opCode;
    private ModeParametre modeParametre1 = ModeParametre.POSITION_MODE;
    private ModeParametre modeParametre2 = ModeParametre.POSITION_MODE;
    private ModeParametre modeParametre3 = ModeParametre.POSITION_MODE;


    public Instruction(Integer integer, List<Integer> programme, Integer compteur) throws CodeInconnuException, ModeInconnuException {
        this.programme = programme;
        this.compteur = compteur;
        this.opCode = OpCode.opCodeFromInt(integer % 100);
        this.modeParametre1 = ModeParametre.modeParametreFromInt(integer % 1000 / 100);
        this.modeParametre2 = ModeParametre.modeParametreFromInt(integer % 10000 / 1000);
        this.modeParametre3 = ModeParametre.modeParametreFromInt(integer / 10000);
    }

    private int getValeurParametre(ModeParametre modeParametre, int indiceParametre) throws ModeInconnuException {
        if (modeParametre.equals(ModeParametre.IMMEDIATE_MODE)) {
            return programme.get(indiceParametre);
        } else if (modeParametre.equals(ModeParametre.POSITION_MODE)) {
            int pointeur = programme.get(indiceParametre);
            return programme.get(pointeur);
        }
        throw new ModeInconnuException(100);
    }

    public OpCode getOpCode() {
        return opCode;
    }

    public int getValeurPremierParametre() throws ModeInconnuException {
        return getValeurParametre(modeParametre1, compteur + 1);
    }

    public int getValeurDeuxiemeParametre() throws ModeInconnuException {
        return getValeurParametre(modeParametre2, compteur + 2);
    }

    public int getValeurTroisiemeParametre() throws ModeInconnuException {
        return getValeurParametre(modeParametre3, compteur + 3);
    }
    public int getIndiceEcriture() {
        switch (opCode) {
            case INPUT -> {
                return programme.get(compteur + 1);
            }
            default -> {
                return programme.get(compteur + 3);
            }
        }
    }
}

