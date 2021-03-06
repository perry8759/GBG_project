package product.model;

import java.io.Serializable;
import java.sql.Blob;

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
@Table(name = "product_pic")
public class ProductPicBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_pic_id;

	//雙向一對多，可以藉由商品ID找到商品照片
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private ProductBean productBean;

	@NotNull
	private Blob product_pic_img;
	private Integer product_pic_seq;

	// 要有預設建構子
	public ProductPicBean() {
	}

	public ProductPicBean(Integer product_pic_id, ProductBean productBean, Blob product_pic_img,
			Integer product_pic_seq) {
		super();
		this.product_pic_id = product_pic_id;
		this.productBean = productBean;
		this.product_pic_img = product_pic_img;
		this.product_pic_seq = product_pic_seq;
	}

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}

	public Integer getProduct_pic_id() {
		return product_pic_id;
	}

	public void setProduct_pic_id(Integer product_pic_id) {
		this.product_pic_id = product_pic_id;
	}

//	public ProductDetailBean getProductDetailBean() {
//		return productDetailBean;
//	}
//
//	public void setProductDetailBean(ProductDetailBean productDetailBean) {
//		this.productDetailBean = productDetailBean;
//	}

	public Blob getProduct_pic_img() {
		return product_pic_img;
	}

	public void setProduct_pic_img(Blob product_pic_img) {
		this.product_pic_img = product_pic_img;
	}

	public Integer getProduct_pic_seq() {
		return product_pic_seq;
	}

	public void setProduct_pic_seq(Integer product_pic_seq) {
		this.product_pic_seq = product_pic_seq;
	}

}