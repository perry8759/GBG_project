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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import member.model.MemberBean;

@Entity
@Table(name="order_satus")
public class OrderSatusBean implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer order_st_id;
	@NotNull
	private String order_stname;
	
	@OneToMany(mappedBy="order_satus", cascade={CascadeType.ALL}) 
	@JoinColumn(name="order_st_id", nullable=false)
	private Set<OrdersBean> ordersBean = new LinkedHashSet<>();
	
	//要有預設建構子
	public OrderSatusBean() {
	}


	public OrderSatusBean(Integer order_st_id, String order_stname, Set<OrdersBean> ordersBean) {
		super();
		this.order_st_id = order_st_id;
		this.order_stname = order_stname;
		this.ordersBean = ordersBean;
	}


	public Integer getOrder_st_id() {
		return order_st_id;
	}


	public void setOrder_st_id(Integer order_st_id) {
		this.order_st_id = order_st_id;
	}


	public String getOrder_stname() {
		return order_stname;
	}


	public void setOrder_stname(String order_stname) {
		this.order_stname = order_stname;
	}


	public Set<OrdersBean> getOrdersAnno() {
		return ordersBean;
	}


	public void setOrdersAnno(Set<OrdersBean> ordersBean) {
		this.ordersBean = ordersBean;
	}


}
