package machine;

import java.util.List;

public class Machine {
    private final List<Integer> programme;
    private int compteur = 0;

    public Machine(List<Integer> programme) {
        this.programme = programme;
    }

    public  void opcode1Addition() {
        int indexDuPremierNombre = programme.get(compteur + 1);
        int indexDuDeuxiemeNombre = programme.get(compteur + 2);
        int indexDeLaSomme = programme.get(compteur + 3);
        int somme = programme.get(indexDuPremierNombre) + programme.get(indexDuDeuxiemeNombre);
        programme.set(indexDeLaSomme, somme);
    }

    private void opcode2Multiplication() {
        int indexDuPremierNombre = programme.get(compteur + 1);
        int indexDuDeuxiemeNombre = programme.get(compteur + 2);
        int indexDuProduit = programme.get(compteur + 3);
        int produit = programme.get(indexDuPremierNombre) * programme.get(indexDuDeuxiemeNombre);
        programme.set(indexDuProduit, produit);
    }

    public void execute() throws PointeurException, CodeInconnuException {

        generalLoop: while (true) {
            if (compteur < programme.size()&& compteur>=0) {
                OpCode code = OpCode.opCodeFromInt(programme.get(compteur));
                switch (code) {
                    case ADD -> {
                        opcode1Addition();
                        compteur += 4;
                    }
                    case MULTIPLY -> {
                        opcode2Multiplication();
                        compteur += 4;
                    }
                    case END -> {
                        break generalLoop;
                    }
                }
            } else {
                throw new PointeurException();
            }
        }
    }
}
