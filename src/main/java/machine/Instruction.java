package machine;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Instruction {
    private final List<Integer> programme;
    private final int compteur;
    private ModeParametre modeParametre1 = ModeParametre.POSITION_MODE;
    private ModeParametre modeParametre2 = ModeParametre.POSITION_MODE;
    private ModeParametre modeParametre3 = ModeParametre.POSITION_MODE;
    private final OpCode opCode;
    private final List<Integer> nombresXXX;

    public ModeParametre getModeParametre2() {
        return modeParametre2;
    }

    public Instruction(Integer integer, List<Integer> programme, Integer compteurXXX) throws CodeInconnuException, ModeInconnuException {
        this.programme = programme;
        this.compteur = compteurXXX;
        List<Integer> nombres = separerEntierEnChiffres(integer);
        this.nombresXXX = nombres;
        if (nombres.size() == 1) {
            this.opCode = OpCode.opCodeFromInt(nombres.get(0));
        } else {
            this.opCode = OpCode.opCodeFromInt(nombres.get(nombres.size() - 1) + 10 * nombres.get(nombres.size() - 2));
            if (nombres.size() > 2) {
                this.modeParametre1 = ModeParametre.modeParametreFromInt(nombres.get(nombres.size() - 3));
            }
            if (nombres.size() > 3) {
                this.modeParametre2 = ModeParametre.modeParametreFromInt(nombres.get(nombres.size() - 4));
            }
            if (nombres.size() > 4) {
                this.modeParametre3 = ModeParametre.modeParametreFromInt(nombres.get(nombres.size() - 5));
            }
        }
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
        return  getValeurParametre(modeParametre3, compteur + 3);
    }


    private List<Integer> separerEntierEnChiffres(int nb) {
        String nbEnString = String.valueOf(nb);
        List<Integer> listeDesChiffres = new ArrayList<>();
        Pattern chiffreUniquePattern = Pattern.compile("([0-9])");
        Matcher chiffreUniqueMatcher = chiffreUniquePattern.matcher(nbEnString);
        while (chiffreUniqueMatcher.find()) {
            listeDesChiffres.add(Integer.valueOf(chiffreUniqueMatcher.group(1)));
        }
        return listeDesChiffres;
    }

    public int getIndiceEcriture() {
        switch (opCode) {
            case INPUT -> {
                return programme.get(compteur+1);
            }
            default -> {
                return programme.get(compteur + 3);
            }
        }
    }
}

