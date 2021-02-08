package shoppingCart.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
		@NotNull
		private Integer product_amount;
		
		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="member_id")
		private MemberBean memberBean;
		
		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="product_detail_id")
		private ProductDetailBean productDetailBean;
		
		
		//要有預設建構子
		public ShoppingCartBean() {
		}

		public ShoppingCartBean(Integer cart_id, Integer product_amount, MemberBean memberBean,
				ProductDetailBean productDetailBean) {
			super();
			this.cart_id = cart_id;
			this.product_amount = product_amount;
			this.memberBean = memberBean;
			this.productDetailBean = productDetailBean;
		}

		public Integer getCart_id() {
			return cart_id;
		}

		public void setCart_id(Integer cart_id) {
			this.cart_id = cart_id;
		}

		public Integer getProduct_amount() {
			return product_amount;
		}

		public void setProduct_amount(Integer product_amount) {
			this.product_amount = product_amount;
		}

		public MemberBean getMemberBean() {
			return memberBean;
		}

		public void setMemberBean(MemberBean memberBean) {
			this.memberBean = memberBean;
		}

		public ProductDetailBean getProductDetailBean() {
			return productDetailBean;
		}

		public void setProductDetailBean(ProductDetailBean productDetailBean) {
			this.productDetailBean = productDetailBean;
		}

}