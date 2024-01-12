package Entity;

public class Categorie {

	  private int idCat;
	    private String nameCat;
	    
	    
		public int getIdCat() {
			return idCat;
		}
		public void setIdCat(int idCat) {
			this.idCat = idCat;
		}
		public String getNameCat() {
			return nameCat;
		}
		public void setNameCat(String nameCat) {
			this.nameCat = nameCat;
		}
		
		
		@Override
		public String toString() {
			return "Categorie [idCat=" + idCat + ", nameCat=" + nameCat + "]";
		}
		
		
		public Categorie(int idCat, String nameCat) {
			super();
			this.idCat = idCat;
			this.nameCat = nameCat;
		}
	    
	    public Categorie() {
	    	
	    }
	    
	}
