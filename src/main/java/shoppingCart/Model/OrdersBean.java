package shoppingCart.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
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

import com.sun.istack.NotNull;

import member.model.MemberBean;

@Entity
@Table(name = "orders")
public class OrdersBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer oseq_id;
	private String order_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="order_st_id")
	private OrderSatusBean orderSatusBean;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="member_id")
	private MemberBean memberBean;

	@NotNull
	private String receive_men;
	@NotNull
	private String shipping_address;
	@NotNull
	private Date order_date;
	private Date shipping_date;
	private Date order_done_date;
	@NotNull
	private String shipping_style;

//	================新增部分=================
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Set<OrderDetailsBean> orderDetailsBean = new LinkedHashSet<>();
	
//	================新增部分=================


	// 要有預設建構子
	public OrdersBean() {
	}

	public OrdersBean(Integer oseq_id, String order_id, OrderSatusBean orderSatusBean, MemberBean memberBean,
			String receive_men, String shipping_address, Date order_date, Date shipping_date, Date order_done_date,
			String shipping_style, Set<OrderDetailsBean> orderDetailsBean) {
		super();
		this.oseq_id = oseq_id;
		this.order_id = order_id;
		this.orderSatusBean = orderSatusBean;
		this.memberBean = memberBean;
		this.receive_men = receive_men;
		this.shipping_address = shipping_address;
		this.order_date = order_date;
		this.shipping_date = shipping_date;
		this.order_done_date = order_done_date;
		this.shipping_style = shipping_style;
		this.orderDetailsBean = orderDetailsBean;
	}

	public Integer getOseq_id() {
		return oseq_id;
	}

	public void setOseq_id(Integer oseq_id) {
		this.oseq_id = oseq_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public OrderSatusBean getOrderSatusBean() {
		return orderSatusBean;
	}

	public void setOrderSatusBean(OrderSatusBean orderSatusBean) {
		this.orderSatusBean = orderSatusBean;
	}

	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	public String getReceive_men() {
		return receive_men;
	}

	public void setReceive_men(String receive_men) {
		this.receive_men = receive_men;
	}

	public String getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Date getShipping_date() {
		return shipping_date;
	}

	public void setShipping_date(Date shipping_date) {
		this.shipping_date = shipping_date;
	}

	public Date getOrder_done_date() {
		return order_done_date;
	}

	public void setOrder_done_date(Date order_done_date) {
		this.order_done_date = order_done_date;
	}

	public String getShipping_style() {
		return shipping_style;
	}

	public void setShipping_style(String shipping_style) {
		this.shipping_style = shipping_style;
	}

	public Set<OrderDetailsBean> getOrderDetailsBean() {
		return orderDetailsBean;
	}

	public void setOrderDetailsBean(Set<OrderDetailsBean> orderDetailsBean) {
		this.orderDetailsBean = orderDetailsBean;
	}

}
