package product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="product_staus")
public class ProductStausBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_st;
	
	@NotNull
	private String product_name;
	
	//Constructor
	public ProductStausBean() {

	}
	
	public Integer getProduct_st() {
		return product_st;
	}
	public void setProduct_st(Integer product_st) {
		this.product_st = product_st;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	
}
