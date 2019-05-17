package hotel;

public class BeanHotel {

	String ville,nom;
	int nbre_etoiles;
	double prix_single,prix_double;
	
	public BeanHotel(String ville,String nom,int nbre_etoiles,double prix_single,double prix_double)
	{
		this.ville=ville;
		this.nom=nom;
		this.nbre_etoiles=nbre_etoiles;
		this.prix_single = prix_single;
		this.prix_double = prix_double;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbre_etoiles() {
		return nbre_etoiles;
	}

	public void setNbre_etoiles(int nbre_etoiles) {
		this.nbre_etoiles = nbre_etoiles;
	}

	public double getPrix_single() {
		return prix_single;
	}

	public void setPrix_single(double prix_single) {
		this.prix_single = prix_single;
	}

	public double getPrix_double() {
		return prix_double;
	}

	public void setPrix_double(double prix_double) {
		this.prix_double = prix_double;
	}
}
