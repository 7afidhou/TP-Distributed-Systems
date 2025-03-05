package EXO2;

import java.io.Serializable;

public class Compte implements Serializable {
    private int numero;   // Numéro de compte
    private double solde; // Solde du compte

    // Constructeur
    public Compte(int numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    // Getters et Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    // Déposer de l'argent sur le compte
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println(montant + "€ déposés. Nouveau solde : " + solde + "€.");
        } else {
            System.out.println("Montant invalide.");
        }
    }

    // Retirer de l'argent du compte
    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            System.out.println(montant + "€ retirés. Nouveau solde : " + solde + "€.");
        } else if (montant <= 0) {
            System.out.println("Montant invalide.");
        } else {
            System.out.println("Solde insuffisant.");
        }
    }

    // Consulter le solde
    public double consulter() {
        return solde;
    }
}