package matrice;
public class CaseMatrice<T> {
    private final Coordonnees coordonnees;
    private final T valeur;
    private final Matrice<T> matrice;

    public CaseMatrice(Coordonnees coordonnees, T valeur, Matrice<T> matrice) {
        this.coordonnees = coordonnees;
        this.valeur = valeur;
        this.matrice = matrice;
    }

    public CaseMatrice<T> getCaseAGauche() {
        return matrice.getCaseAGauche(coordonnees);
    }

    public CaseMatrice<T> getCaseADroite() {
        return matrice.getCaseADroite(coordonnees);
    }

    public CaseMatrice<T> getCaseEnHaut() {
        return matrice.getCaseEnHaut(coordonnees);
    }

    public CaseMatrice<T> getCaseEnBas() {
        return matrice.getCaseEnBas(coordonnees);
    }
    public T getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return "{" + "i=" + coordonnees.i() + ", j=" + coordonnees.j() + "} : " + valeur;
    }
}
