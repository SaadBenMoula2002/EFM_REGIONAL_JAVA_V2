import java.util.Objects;

public class Produit {

    private int code;
    private double prix;

    public int getCode() {
        return code;
    }

    public double getPrix() {
        return prix;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Produit(int code, double prix) {
        this.code = code;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Code = " + code +
                " ; Prix = " + prix;
    }

    public boolean equals(Produit produit) {
        if (this.code == produit.code) {
            return true;
        }else {
            return false;
        }
    }

    public double prixProduit(){
        return prix;
    }

}
