package shoppingCart.Model;

import java.io.Serializable;
import java.util.LinkedHashSet;
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

import member.model.MemberBean;
import product.model.ProductDetailBean;

@Entity
@Table(name="shopping_cart")
public class ShoppingCartBean implements Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer cart_id;
		
		private Integer member_id;
		
		@OneToMany(mappedBy="shopping_cart", cascade={CascadeType.ALL}) 
		@JoinColumn(name="member_id", nullable=false) 
		private Set<MemberBean> memberBean = new LinkedHashSet<>();
		
//		private Integer product_detail_id;
		
		@OneToMany(cascade = CascadeType.PERSIST)
		@JoinColumn(name="product_detail_id")
		private Set<ProductDetailBean> productDetailBean = new LinkedHashSet<>();
		
		@NotNull
		private Integer product_amount;
		
		//要有預設建構子
		public ShoppingCartBean() {
		}
		
		
		public ShoppingCartBean(Integer cart_id, Integer member_id, Set<MemberBean> memberBean,
				Set<ProductDetailBean> productDetailBean, Integer product_amount) {
			super();
			this.cart_id = cart_id;
			this.member_id = member_id;
			this.memberBean = memberBean;
			this.productDetailBean = productDetailBean;
			this.product_amount = product_amount;
		}


		public Integer getCart_id() {
			return cart_id;
		}
		public void setCart_id(Integer cart_id) {
			this.cart_id = cart_id;
		}
		public Integer getMember_id() {
			return member_id;
		}
		public void setMember_id(Integer member_id) {
			this.member_id = member_id;
		}

		public Integer getProduct_amount() {
			return product_amount;
		}
		public void setProduct_amount(Integer product_amount) {
			this.product_amount = product_amount;
		}


		public Set<MemberBean> getMemberAnno() {
			return memberBean;
		}


		public void setMemberAnno(Set<MemberBean> memberBean) {
			this.memberBean = memberBean;
		}


		public Set<ProductDetailBean> getProductDetailAnno() {
			return productDetailBean;
		}


		public void setProductDetailAnno(Set<ProductDetailBean> productDetailBean) {
			this.productDetailBean = productDetailBean;
		}

}
