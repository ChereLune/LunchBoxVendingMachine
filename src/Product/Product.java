package Product;

public class Product {

	String productName;
	int productNum;
	int productPrice;
	
	public Product(String productName, int productNum, int productPrice) {
		super();
		this.productName = productName;
		this.productNum = productNum;
		this.productPrice = productPrice;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public int getProductNum() {
		return productNum;
	}
	
	public int getProductPrice() {
		return productPrice;
	}
}