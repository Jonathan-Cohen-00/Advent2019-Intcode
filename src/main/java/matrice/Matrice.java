package matrice;

import java.util.HashMap;


public class Matrice<T> {

    private final HashMap<Coordonnees, CaseMatrice<T>> casesMatrice = new HashMap<>();

    public HashMap<Coordonnees, CaseMatrice<T>> getCasesMatrice() {
        return casesMatrice;
    }
    
    public CaseMatrice<T> getCaseADroite(Coordonnees coordonnees) {
        return casesMatrice.get(new Coordonnees(coordonnees.i(), coordonnees.j() + 1));
    }

    public CaseMatrice<T> getCaseAGauche(Coordonnees coordonnees) {
        return casesMatrice.get(new Coordonnees(coordonnees.i(), coordonnees.j() - 1));
    }

    public CaseMatrice<T> getCaseEnHaut(Coordonnees coordonnees) {
        return casesMatrice.get(new Coordonnees(coordonnees.i() - 1, coordonnees.j()));
    }

    public CaseMatrice<T> getCaseEnBas(Coordonnees coordonnees) {
        return casesMatrice.get(new Coordonnees(coordonnees.i() + 1, coordonnees.j()));
    }

}