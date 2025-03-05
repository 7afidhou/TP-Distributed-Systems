//package Exo4;

public class Joueur {
    private int numero;
    private String nom;
    private int age;
    private String poste;

    public Joueur(int numero, String nom, int age, String poste) {
        this.numero = numero;
        this.nom = nom;
        this.age = age;
        this.poste = poste;
    }

    public int getNumero() {
        return numero;
    }

    public int getAge() {
        return age;
    }

    public String getPoste() {
        return poste;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "numero=" + numero +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                ", poste='" + poste + '\'' +
                '}';
    }
}