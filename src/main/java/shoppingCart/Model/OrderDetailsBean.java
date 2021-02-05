package shoppingCart.Model;

import java.io.Serializable;

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
@Table(name="order_details")
public class OrderDetailsBean implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer odseq_id;
	
	@ManyToOne
	@JoinColumn(name="order_id", nullable=false)
	private OrdersBean ordersBean;
	
	@ManyToOne(cascade = CascadeType.ALL)//==========待修改==============
	@JoinColumn(name="Fk_product_detail_id") //==========待修改==============
	private Integer product_detail_id;//==========待修改==============
	
	@NotNull
	private Integer order_amount;
	
	//要有預設建構子
	public OrderDetailsBean() {
	}
	



}
