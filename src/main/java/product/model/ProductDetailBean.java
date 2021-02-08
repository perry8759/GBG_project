package product.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import shoppingCart.Model.FavoriteListBean;
import shoppingCart.Model.OrderDetailsBean;
import shoppingCart.Model.ShoppingCartBean;

@Entity
@Table(name = "product_detail")
public class ProductDetailBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_detail_id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private ProductBean productBean;

	@NotNull
	private String product_color;
	@NotNull
	private String product_size;
	@NotNull
	private Integer product_stock;

//	================新增部分=================

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_detail_id")
//	List<ShoppingCartBean> shoppingCartBean = new ArrayList<>();
	private Set<ShoppingCartBean> shoppingCartBean = new LinkedHashSet<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_detail_id")
//	List<OrderDetailsBean> orderDetailsBean = new ArrayList<>();
	private Set<OrderDetailsBean> orderDetailsBean = new LinkedHashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_detail_id")
//	List<ProductPicBean> productPicBean = new ArrayList<>();
	private Set<ProductPicBean> productPicBean = new LinkedHashSet<>();

//	================新增部分=================

	// 要有預設建構子
	public ProductDetailBean() {
	}

	public ProductDetailBean(Integer product_detail_id, ProductBean productBean, String product_color,
			String product_size, Integer product_stock, Set<ShoppingCartBean> shoppingCartBean,
			Set<OrderDetailsBean> orderDetailsBean, Set<ProductPicBean> productPicBean) {
		super();
		this.product_detail_id = product_detail_id;
		this.productBean = productBean;
		this.product_color = product_color;
		this.product_size = product_size;
		this.product_stock = product_stock;
		this.shoppingCartBean = shoppingCartBean;
		this.orderDetailsBean = orderDetailsBean;
		this.productPicBean = productPicBean;
	}

	public Integer getProduct_detail_id() {
		return product_detail_id;
	}

	public void setProduct_detail_id(Integer product_detail_id) {
		this.product_detail_id = product_detail_id;
	}

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
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

	public Set<ShoppingCartBean> getShoppingCartBean() {
		return shoppingCartBean;
	}

	public void setShoppingCartBean(Set<ShoppingCartBean> shoppingCartBean) {
		this.shoppingCartBean = shoppingCartBean;
	}

	public Set<OrderDetailsBean> getOrderDetailsBean() {
		return orderDetailsBean;
	}

	public void setOrderDetailsBean(Set<OrderDetailsBean> orderDetailsBean) {
		this.orderDetailsBean = orderDetailsBean;
	}

	public Set<ProductPicBean> getProductPicBean() {
		return productPicBean;
	}

	public void setProductPicBean(Set<ProductPicBean> productPicBean) {
		this.productPicBean = productPicBean;
	}

}