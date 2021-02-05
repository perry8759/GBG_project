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

//	private Integer member_id;
	
	@OneToMany(mappedBy="favorite_list", cascade={CascadeType.ALL}) 
	@JoinColumn(name="member_id", nullable=false)
	private Set<MemberBean> memberBean = new LinkedHashSet<>();

	Integer product_id;
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="product_id")
	private Set<ProductBean> productBean = new LinkedHashSet<>();

	// 要有預設建構子
	public FavoriteListBean() {
	}


	public FavoriteListBean(Integer favorite_id, Set<MemberBean> memberBean, Integer product_id,
			Set<ProductBean> productBean) {
		super();
		this.favorite_id = favorite_id;
		this.memberBean = memberBean;
		this.product_id = product_id;
		this.productBean = productBean;
	}


	public Integer getFavorite_id() {
		return favorite_id;
	}

	public void setFavorite_id(Integer favorite_id) {
		this.favorite_id = favorite_id;
	}


	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}


	public Set<MemberBean> getMemberAnno() {
		return memberBean;
	}


	public void setMemberAnno(Set<MemberBean> memberBean) {
		this.memberBean = memberBean;
	}


	public Set<ProductBean> getProductAnno() {
		return productBean;
	}


	public void setProductAnno(Set<ProductBean> productBean) {
		this.productBean = productBean;
	}

}
