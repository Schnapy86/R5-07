import java.util.Scanner;

public class Morpion {
    static char[][] plateau = { {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} };
    static char joueurActuel = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jeuEnCours = true;

        System.out.println("Bienvenue dans le jeu du Morpion !");
        afficherPlateau();

        while (jeuEnCours) {
            System.out.println("Joueur " + joueurActuel + ", c'est votre tour.");
            int ligne, colonne;

            // Demander la position au joueur
            while (true) {
                System.out.print("Entrez la ligne (1-3) : ");
                ligne = scanner.nextInt() - 1;
                System.out.print("Entrez la colonne (1-3) : ");
                colonne = scanner.nextInt() - 1;

                if (ligne >= 0 && ligne < 3 && colonne >= 0 && colonne < 3 && plateau[ligne][colonne] == ' ') {
                    plateau[ligne][colonne] = joueurActuel;
                    break;
                } else {
                    System.out.println("Mouvement invalide, réessayez.");
                }
            }
afficherPlateau();

            // Vérifier si le joueur actuel a gagné
            if (verifierVictoire()) {
                System.out.println("Félicitations ! Le joueur " + joueurActuel + " a gagné !");
                jeuEnCours = false;
            } else if (plateauPlein()) {
                System.out.println("C'est un match nul !");
                jeuEnCours = false;
            } else {
                changerJoueur();
            }
        }

        scanner.close();
    }

    // Affiche le plateau de jeu
    public static void afficherPlateau() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(plateau[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    // Change le joueur actuel
    public static void changerJoueur() {
        joueurActuel = (joueurActuel == 'X') ? 'O' : 'X';
    }

    // Vérifie si le joueur actuel a gagné
    public static boolean verifierVictoire() {
        // Vérifier les lignes, colonnes et diagonales
        for (int i = 0; i < 3; i++) {
            if (plateau[i][0] == joueurActuel && plateau[i][1] == joueurActuel && plateau[i][2] == joueurActuel) {
                return true;
            }
            if (plateau[0][i] == joueurActuel && plateau[1][i] == joueurActuel && plateau[2][i] == joueurActuel) {
                return true;
            }
        }
        if (plateau[0][0] == joueurActuel && plateau[1][1] == joueurActuel && plateau[2][2] == joueurActuel) {
            return true;
        }
        if (plateau[0][2] == joueurActuel && plateau[1][1] == joueurActuel && plateau[2][0] == joueurActuel) {
            return true;
        }
        return false;
    }
// Vérifie si le plateau est plein (match nul)
    public static boolean plateauPlein() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (plateau[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
