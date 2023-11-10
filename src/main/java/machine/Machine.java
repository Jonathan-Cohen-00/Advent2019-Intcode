package machine;

import java.util.List;
import java.util.Scanner;

public class Machine {
    private final List<Integer> programme;
    private int compteur = 0;
    private int nextInput = 21112001;

    public Machine(List<Integer> programme) {
        this.programme = programme;
    }

    public void setNextInput(int specialInput) {
        this.nextInput = specialInput;
    }

    public void execute() throws PointeurException, CodeInconnuException, ModeInconnuException {
        generalLoop:
        while (true) {
            if (compteur < programme.size() && compteur >= 0) {
                Instruction instruction = new Instruction(programme.get(compteur), programme, compteur);
                switch (instruction.getOpCode()) {
                    case ADD -> {
                        int terme1 = instruction.getValeurPremierParametre();
                        int terme2 = instruction.getValeurDeuxiemeParametre();
                        int indiceEcritureSomme = instruction.getIndiceEcriture();
                        this.programme.set(indiceEcritureSomme, terme1 + terme2);
                        compteur += 4;
                    }
                    case MULTIPLY -> {
                        int facteur1 = instruction.getValeurPremierParametre();
                        int facteur2 = instruction.getValeurDeuxiemeParametre();
                        int indiceEcritureProduit = instruction.getIndiceEcriture();
                        this.programme.set(indiceEcritureProduit, facteur1 * facteur2);
                        compteur += 4;
                    }
                    case INPUT -> {
                        int nextInt;
                        if (nextInput == 21112001) {
                            System.out.println("Input ?");
                            Scanner saisie = new Scanner(System.in);
                            nextInt = saisie.nextInt();
                        } else {
                            nextInt = nextInput;
                        }
                        int positionNextInt = instruction.getIndiceEcriture();
                        programme.set(positionNextInt, nextInt);
                        compteur += 2;
                    }
                    case OUTPUT -> {
                        int output = instruction.getValeurPremierParametre();
                        System.out.println(output);
                        compteur += 2;
                    }
                    case JUMPifTRUE -> {
                        if ( instruction.getValeurPremierParametre()!=0){
                            compteur = instruction.getValeurDeuxiemeParametre();
                        }
                        else compteur +=3;
                    }
                    case JUMPifFalse -> {
                        if ( instruction.getValeurPremierParametre()==0){
                            compteur = instruction.getValeurDeuxiemeParametre();
                        }
                        else compteur+=3;
                    }
                    case LESSTHAN -> {
                        if (instruction.getValeurPremierParametre() < instruction.getValeurDeuxiemeParametre()) {
                            programme.set(instruction.getIndiceEcriture(), 1);
                        } else {
                            programme.set(instruction.getIndiceEcriture(), 0);
                        }
                        compteur += 4;
                    }
                    case EQUALS -> {
                        if (instruction.getValeurPremierParametre() == instruction.getValeurDeuxiemeParametre()) {
                            programme.set(instruction.getIndiceEcriture(), 1);
                        } else {
                            programme.set(instruction.getIndiceEcriture(), 0);
                        }
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
