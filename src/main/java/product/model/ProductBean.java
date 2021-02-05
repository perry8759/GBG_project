package product.model;

import java.io.Serializable;
import java.sql.Clob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="product")
public class ProductBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_id;
	
	@NotNull
	private String product_title;
	
	@NotNull
	private Double product_price;
	
	@NotNull
	private String productno;
	private Clob product_textdetails;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_category_id")
	private CustomerCategoryBean customer_category_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="category_id")
	private ProductCategoryBean category_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_st")
	private ProductStausBean product_st;
	
	@NotNull
	private Integer product_purchases;
	@NotNull
	private Double average_score;
	
	
	//Constructor
	public ProductBean() {

	}
	
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_title() {
		return product_title;
	}
	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}
	public Double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(Double product_price) {
		this.product_price = product_price;
	}
	public String getProductno() {
		return productno;
	}
	public void setProductno(String productno) {
		this.productno = productno;
	}
	public Clob getProduct_textdetails() {
		return product_textdetails;
	}
	public void setProduct_textdetails(Clob product_textdetails) {
		this.product_textdetails = product_textdetails;
	}
	public CustomerCategoryBean getCustomer_category_id() {
		return customer_category_id;
	}
	public void setCustomer_category_id(CustomerCategoryBean customer_category_id) {
		this.customer_category_id = customer_category_id;
	}
	public ProductCategoryBean getCategory_id() {
		return category_id;
	}
	public void setCategory_id(ProductCategoryBean category_id) {
		this.category_id = category_id;
	}
	public ProductStausBean getProduct_st() {
		return product_st;
	}
	public void setProduct_st(ProductStausBean product_st) {
		this.product_st = product_st;
	}
	public Integer getProduct_purchases() {
		return product_purchases;
	}
	public void setProduct_purchases(Integer product_purchases) {
		this.product_purchases = product_purchases;
	}
	public Double getAverage_score() {
		return average_score;
	}
	public void setAverage_score(Double average_score) {
		this.average_score = average_score;
	}
	
	
}
