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
@Table(name="customer_category")
public class CustomerCategoryBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customer_category_id;
	
	@NotNull
	private String customer_category_name;
	
	
	//Constructor
	public CustomerCategoryBean() {

	}
	
	public Integer getCustomer_category_id() {
		return customer_category_id;
	}
	public void setCustomer_category_id(Integer customer_category_id) {
		this.customer_category_id = customer_category_id;
	}
	public String getCustomer_category_name() {
		return customer_category_name;
	}
	public void setCustomer_category_name(String customer_category_name) {
		this.customer_category_name = customer_category_name;
	}
	
	
}
