package machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Machine {
    private final List<Long> programme;
    private final boolean modeInteractif;
    private final List<Long> listeOutput = new ArrayList<>();
    private int compteur = 0;
    private List<Long> nextInputList;
    private int relativeBase = 0;
    private int inputIterator = 0;

    public Machine(List<Long> programme) {
        this.programme = programme;
        modeInteractif = false;
    }

    public Machine(List<Long> programme, boolean modeInteractif) {
        this.programme = programme;
        this.modeInteractif = modeInteractif;
    }

    public void setNextInputList(List<Long> inputList) {
        this.nextInputList = inputList ; }


    public void execute() throws PointeurException, CodeInconnuException, ModeInconnuException {
        generalLoop:
        while (true) {
            if (compteur < programme.size() && compteur >= 0) {
                Instruction instruction = new Instruction(Math.toIntExact(programme.get(compteur)), programme, compteur, relativeBase);
                switch (instruction.getOpCode()) {
                    case ADD -> {
                        long terme1 = programme.get(instruction.getIndiceReelPremierParametre());
                        long terme2 = programme.get(instruction.getIndiceReelDeuxiemeParametre());
                        int indiceEcritureSomme = instruction.getIndiceReelTroisiemeParametre();
                        this.programme.set(indiceEcritureSomme, terme1 + terme2);
                        compteur += 4;
                    }
                    case MULTIPLY -> {
                        long facteur1 = programme.get(instruction.getIndiceReelPremierParametre());
                        long facteur2 = programme.get(instruction.getIndiceReelDeuxiemeParametre());
                        int indiceEcritureProduit = instruction.getIndiceReelTroisiemeParametre();
                        this.programme.set(indiceEcritureProduit, facteur2 * facteur1);
                        compteur += 4;
                    }
                    case INPUT -> {
                        Long nextInt;
                        if (modeInteractif) {
                            System.out.println("Input ?");
                            Scanner saisie = new Scanner(System.in);
                            nextInt = saisie.nextLong();
                        } else {
                            nextInt = (nextInputList.get(inputIterator));
                            inputIterator +=1 ;
                        }
                        int positionNextInt = instruction.getIndiceReelPremierParametre();
                        programme.set(positionNextInt, nextInt);
                        compteur += 2;
                    }
                    case OUTPUT -> {
                        long output = programme.get(instruction.getIndiceReelPremierParametre());
                        compteur += 2;
                        listeOutput.add(output);
                    }
                    case JUMP_IF_TRUE -> {
                        if (programme.get(instruction.getIndiceReelPremierParametre()) != 0) {
                            compteur = Math.toIntExact(programme.get(instruction.getIndiceReelDeuxiemeParametre()));
                        } else compteur += 3;
                    }
                    case JUMP_IF_FALSE -> {
                        if (programme.get(instruction.getIndiceReelPremierParametre()) == 0) {
                            compteur = Math.toIntExact(programme.get(instruction.getIndiceReelDeuxiemeParametre()));
                        } else compteur += 3;
                    }
                    case LESSTHAN -> {
                        if (programme.get(instruction.getIndiceReelPremierParametre()) < programme.get(instruction.getIndiceReelDeuxiemeParametre())) {
                            programme.set(instruction.getIndiceReelTroisiemeParametre(), 1L);
                        } else {
                            programme.set(instruction.getIndiceReelTroisiemeParametre(), 0L);
                        }
                        compteur += 4;
                    }
                    case EQUALS -> {
                        long terme1 = programme.get(instruction.getIndiceReelPremierParametre());
                        long terme2 = programme.get(instruction.getIndiceReelDeuxiemeParametre());
                        if (terme1 == terme2) {
                            programme.set(instruction.getIndiceReelTroisiemeParametre(), 1L);
                        } else {
                            programme.set(instruction.getIndiceReelTroisiemeParametre(), 0L);
                        }
                        compteur += 4;
                    }
                    case ADJUSTS_RELATIVE_BASE -> {
                        relativeBase += programme.get(instruction.getIndiceReelPremierParametre());
                        compteur += 2;
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

    public List<Long> getListeOutput() {
        return listeOutput;
    }
}
