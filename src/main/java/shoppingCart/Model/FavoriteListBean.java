package shoppingCart.Model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import member.model.MemberBean;
import product.model.ProductBean;
import product.model.ProductDetailBean;

@Entity
@Table(name = "favorite_list")
public class FavoriteListBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer favorite_id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="member_id")
	private MemberBean memberBean;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
	private ProductBean productBean;

	// 要有預設建構子
	public FavoriteListBean() {
	}

	public FavoriteListBean(Integer favorite_id, MemberBean memberBean, ProductBean productBean) {
		super();
		this.favorite_id = favorite_id;
		this.memberBean = memberBean;
		this.productBean = productBean;
	}

	public Integer getFavorite_id() {
		return favorite_id;
	}

	public void setFavorite_id(Integer favorite_id) {
		this.favorite_id = favorite_id;
	}

	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}

}
