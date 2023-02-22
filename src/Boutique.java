import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Boutique {

    private static ArrayList<Produit> Produits;

    public int indiceDe(int code){
        int conteneur = 0;
        for (int i = 0; i < Produits.size(); i++) {
            if (Produits.get(i).getCode() == code) {
                conteneur = i;
            }else {
                conteneur = -1;
            }
        }
        return conteneur;
    }

    public void ajouter(Produit p) throws IllegalAccessException {
        for (int i = 0; i < Produits.size(); i++) {
            if (!Produits.get(i).equals(p)){
                Produits.add(p);
            }else {
                throw new IllegalAccessException("Produit existant !");
            }
        }
    }

    public boolean supprimer(int code){
        boolean conteneur = false;
        for (int i = 0; i < Produits.size(); i++) {
            if (Produits.get(i).getCode() == code) {
                Produits.remove(i);
                conteneur = true;
            }else{
                conteneur = false;
            }
        }
        return conteneur;
    }

    public boolean supprimer(Produit p){
        boolean conteneur = false;
        for (int i = 0; i < Produits.size(); i++) {
            if (Produits.get(i).equals(p)) {
                Produits.remove(p);
                conteneur = true;
            }else{
                conteneur = false;
            }
        }
        return conteneur;
    }

    public int nombreProduitsEnSolde(){
        int count = 0 ;
        for (int i = 0; i < Produits.size(); i++) {
            if (Produits.get(i).getPrix() == Produits.get(i).prixProduit()) {
                count++;
            }
        }
        return count;
    }

    public void enregistrer(String chemin) throws Exception {
        PrintWriter writer = new PrintWriter(new FileWriter(chemin));
        for (Produit produit : Produits) {
            if (produit instanceof ProduitEnSolde) {
                ProduitEnSolde produitSolde = (ProduitEnSolde) produit;
                writer.println(produit.getCode() + ";" + produit.getPrix() + ";" + produitSolde.getRemise());
            } else {
                writer.println(produit.getCode() + ";" + produit.getPrix());
            }
        }
        writer.close();
    }

}
