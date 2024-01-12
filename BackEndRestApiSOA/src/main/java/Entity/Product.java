package Entity;



public class Product {

    private int idProduct;
    private String nameProduct;
    private int priceProduct;
    private int idCat;
	public int getIdCat() {
		return idCat;
	}


	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}


	public int getId() {
		return idProduct;
	}
	
	
	public void setId(int id) {
		this.idProduct = id;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public double getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(int priceProduct) {
		this.priceProduct = priceProduct;
	}
	
	
	@Override
	public String toString() {
		return "Product [id=" + idProduct + ", nameProduct=" + nameProduct + ", priceProduct=" + priceProduct + " + idCat]";
	}
	
	
	public Product(int id, String nameProduct, int priceProduct,int idCat) {
		super();
		this.idProduct = id;
		this.nameProduct = nameProduct;
		this.priceProduct = priceProduct;
		this.idCat=idCat;
	}
	
	public Product() {
		
	}
    
    
}
