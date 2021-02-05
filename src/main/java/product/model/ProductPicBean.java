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
@Table(name="product_pic")
public class ProductPicBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_pic_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_detail_id")
	private ProductDetailBean product_detail_id;
	
	@NotNull
	private Blob product_pic_img;
	private Integer product_pic_seq;
	
	public Integer getProduct_pic_id() {
		return product_pic_id;
	}
	public void setProduct_pic_id(Integer product_pic_id) {
		this.product_pic_id = product_pic_id;
	}
	public ProductDetailBean getProduct_detail_id() {
		return product_detail_id;
	}
	public void setProduct_detail_id(ProductDetailBean product_detail_id) {
		this.product_detail_id = product_detail_id;
	}
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