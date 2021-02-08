package product.model;

import java.io.Serializable;
import java.sql.Clob;
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

@Entity
@Table(name = "product")
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
	@JoinColumn(name = "customer_category_id")
	private CustomerCategoryBean customerCategoryBean;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private ProductCategoryBean productCategoryBean;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_st")
	private ProductStausBean productStausBean;

	@NotNull
	private Integer product_purchases;
	@NotNull
	private Double average_score;

//	================新增部分=================

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
//	List<ProductDetailBean> productDetailBean = new ArrayList<>();
	private Set<ProductDetailBean> productDetailBean = new LinkedHashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
//	List<FavoriteListBean> favoriteListBean = new ArrayList<>();
	private Set<FavoriteListBean> favoriteListBean = new LinkedHashSet<>();
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
//	List<ProductCommentBean> productCommentBean = new ArrayList<>();
	private Set<ProductCommentBean> productCommentBean = new LinkedHashSet<>();

//	================新增部分=================

	// 要有預設建構子
	public ProductBean() {
	}

	public ProductBean(Integer product_id, String product_title, Double product_price, String productno,
			Clob product_textdetails, CustomerCategoryBean customerCategoryBean,
			ProductCategoryBean productCategoryBean, ProductStausBean productStausBean, Integer product_purchases,
			Double average_score, Set<ProductDetailBean> productDetailBean, Set<FavoriteListBean> favoriteListBean,
			Set<ProductCommentBean> productCommentBean) {
		super();
		this.product_id = product_id;
		this.product_title = product_title;
		this.product_price = product_price;
		this.productno = productno;
		this.product_textdetails = product_textdetails;
		this.customerCategoryBean = customerCategoryBean;
		this.productCategoryBean = productCategoryBean;
		this.productStausBean = productStausBean;
		this.product_purchases = product_purchases;
		this.average_score = average_score;
		this.productDetailBean = productDetailBean;
		this.favoriteListBean = favoriteListBean;
		this.productCommentBean = productCommentBean;
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

	public CustomerCategoryBean getCustomerCategoryBean() {
		return customerCategoryBean;
	}

	public void setCustomerCategoryBean(CustomerCategoryBean customerCategoryBean) {
		this.customerCategoryBean = customerCategoryBean;
	}

	public ProductCategoryBean getProductCategoryBean() {
		return productCategoryBean;
	}

	public void setProductCategoryBean(ProductCategoryBean productCategoryBean) {
		this.productCategoryBean = productCategoryBean;
	}

	public ProductStausBean getProductStausBean() {
		return productStausBean;
	}

	public void setProductStausBean(ProductStausBean productStausBean) {
		this.productStausBean = productStausBean;
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

	public Set<ProductDetailBean> getProductDetailBean() {
		return productDetailBean;
	}

	public void setProductDetailBean(Set<ProductDetailBean> productDetailBean) {
		this.productDetailBean = productDetailBean;
	}

	public Set<FavoriteListBean> getFavoriteListBean() {
		return favoriteListBean;
	}

	public void setFavoriteListBean(Set<FavoriteListBean> favoriteListBean) {
		this.favoriteListBean = favoriteListBean;
	}

	public Set<ProductCommentBean> getProductCommentBean() {
		return productCommentBean;
	}

	public void setProductCommentBean(Set<ProductCommentBean> productCommentBean) {
		this.productCommentBean = productCommentBean;
	}

}
