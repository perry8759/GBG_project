package shoppingCart.Model;

import java.io.Serializable;
import java.util.Date;
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

import com.sun.istack.NotNull;

import member.model.MemberBean;

@Entity
@Table(name = "orders")
public class OrdersBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer oseq_id;
//	@Column(columnDefinition = "Not Null")
	private String order_id;

	private Integer order_st_id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_st_id", nullable = false)
	private OrderSatusBean orderSatusBean;

	private Integer member_id;
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="Fk_OrdersBean_to_member_id")
//	private MemberBean memberBean;

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

	@OneToMany(mappedBy = "orders")
	@JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
	private Set<OrderDetailsBean> orderDetailsBean = new LinkedHashSet<>();

	public Integer getOseq_id() {
		return oseq_id;
	}

	// 要有預設建構子
	public OrdersBean() {
	}



}
