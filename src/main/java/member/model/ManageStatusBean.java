package member.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import product.model.ProductBean;
import product.model.ProductCommentBean;

@Entity
@Table(name="manage_status")
public class ManageStatusBean implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer manage_status_id;
	private String manage_status_name;
	
	//雙向一對多，可以藉由管理狀態找到商品評論
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "manage_status_id")
	private Set<ProductCommentBean> productCommentBean = new LinkedHashSet<>();
	
	public ManageStatusBean() {
		super();
	}

	public ManageStatusBean(String manage_status_name) {
		super();
		this.manage_status_name = manage_status_name;
	}
	
	public Integer getManage_status_id() {
		return manage_status_id;
	}
	public void setManage_status_id(Integer manage_status_id) {
		this.manage_status_id = manage_status_id;
	}
	public String getManage_status_name() {
		return manage_status_name;
	}
	public void setManage_status_name(String manage_status_name) {
		this.manage_status_name = manage_status_name;
	}

	public Set<ProductCommentBean> getProductCommentBean() {
		return productCommentBean;
	}

	public void setProductCommentBean(Set<ProductCommentBean> productCommentBean) {
		this.productCommentBean = productCommentBean;
	}
	
}
