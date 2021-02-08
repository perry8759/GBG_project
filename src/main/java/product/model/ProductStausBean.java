package product.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "product_staus")
public class ProductStausBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_st;

	@NotNull
	private String product_st_name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_st")
	private Set<ProductBean> productBean = new LinkedHashSet<>();

	// 要有預設建構子
	public ProductStausBean() {
	}

	public ProductStausBean(Integer product_st, String product_st_name, Set<ProductBean> productBean) {
		super();
		this.product_st = product_st;
		this.product_st_name = product_st_name;
		this.productBean = productBean;
	}

	public Integer getProduct_st() {
		return product_st;
	}

	public void setProduct_st(Integer product_st) {
		this.product_st = product_st;
	}

	public String getProduct_name() {
		return product_st_name;
	}

	public void setProduct_name(String product_name) {
		this.product_st_name = product_name;
	}

	public Set<ProductBean> getProductBean() {
		return productBean;
	}

	public void setProductBean(Set<ProductBean> productBean) {
		this.productBean = productBean;
	}

}
