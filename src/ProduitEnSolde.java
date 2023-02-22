public class ProduitEnSolde extends Produit{

    private double remise;

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        if (remise > 0 || remise < 90) {
            this.remise = remise;
        }else {
            throw new IllegalArgumentException("remise non accepté");
        }
    }

    public ProduitEnSolde(int code, double prix, double remise) {
        super(code, prix);
        if (remise > 0 || remise < 90) {
            this.remise = remise;
        }else {
            throw new IllegalArgumentException("remise non accepté");
        }
    }

    @Override
    public double prixProduit(){
        return getPrix() * (remise/100);
    }

    @Override
    public String toString() {
        return super.toString() + " ; Remise = " + remise;
    }
}
