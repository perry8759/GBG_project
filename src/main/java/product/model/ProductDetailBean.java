package product.model;

import java.io.Serializable;

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
@Table(name="product_detail")
public class ProductDetailBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_detail_id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
	private ProductBean product_id;
	
	@NotNull
	private String product_color;
	@NotNull
	private String product_size;
	@NotNull
	private Integer product_stock;
	
	//Constructor
	public ProductDetailBean() {

	}
	public Integer getProduct_detail_id() {
		return product_detail_id;
	}
	public void setProduct_detail_id(Integer product_detail_id) {
		this.product_detail_id = product_detail_id;
	}
	public ProductBean getProduct_id() {
		return product_id;
	}
	public void setProduct_id(ProductBean product_id) {
		this.product_id = product_id;
	}
	public String getProduct_color() {
		return product_color;
	}
	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}
	public String getProduct_size() {
		return product_size;
	}
	public void setProduct_size(String product_size) {
		this.product_size = product_size;
	}
	public Integer getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(Integer product_stock) {
		this.product_stock = product_stock;
	}
	
}
