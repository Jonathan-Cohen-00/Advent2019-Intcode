package machine;

import java.util.List;
import java.util.Scanner;
import static file.FileUtils.separerEntierEnChiffres;

public class Machine {
    private final List<Integer> programme;
    private int compteur = 0;

    public Machine(List<Integer> programme) {
        this.programme = programme;
    }
//public void opcode1AdditionRemastered (){
//        List<Integer> liste = separerEntierEnChiffres(programme.get(compteur));
//        if (liste.size() == 2 ){
//            opcode1Addition();
//        }
//        if (liste.size()== 3){
//
//        }qzdqzd
//}
    public void opcode1Addition() {
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

    private void opcode3Input() {
        Scanner saisie = new Scanner(System.in);
        int entierSaisi = saisie.nextInt();
        programme.set(programme.get(compteur + 1), entierSaisi);
    }

    private void opcode4Output() {
        System.out.println(programme.get(programme.get(compteur + 1)));
    }

    public void execute() throws PointeurException, CodeInconnuException, ModeInconnuException {
        generalLoop:
        while (true) {
            if (compteur < programme.size() && compteur >= 0) {
                OpCode code = OpCode.opCodeFromInt(programme.get(compteur));
//                ModeParametre modeParametre = ModeParametre.modeParametreFromInt(programme.get(compteur));
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
                    case INPUT -> {

                    }
                }
            } else {
                throw new PointeurException();
            }
        }
    }
}
