package product.model;

import java.io.Serializable;
import java.sql.Clob;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import member.model.ManageStatusBean;
import member.model.MemberBean;

@Entity
@Table(name="product_comment")
public class ProductCommentBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer comment_id;
	
	@ManyToOne
	@JoinColumn(name="member_id")
	private MemberBean member_id;
	
	@NotNull
	private Date comment_date;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
	private ProductBean product_id;
	
	@NotNull
	private Integer comment_value;
	private Clob comment_comment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="manage_status_id")
	private ManageStatusBean manage_status_id;
	
	
	public Integer getComment_id() {
		return comment_id;
	}

	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}

	public MemberBean getMember_id() {
		return member_id;
	}

	public void setMember_id(MemberBean member_id) {
		this.member_id = member_id;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}

	public ProductBean getProduct_id() {
		return product_id;
	}

	public void setProduct_id(ProductBean product_id) {
		this.product_id = product_id;
	}

	public Integer getComment_value() {
		return comment_value;
	}

	public void setComment_value(Integer comment_value) {
		this.comment_value = comment_value;
	}

	public Clob getComment_comment() {
		return comment_comment;
	}

	public void setComment_comment(Clob comment_comment) {
		this.comment_comment = comment_comment;
	}

	public ManageStatusBean getManage_status_id() {
		return manage_status_id;
	}

	public void setManage_status_id(ManageStatusBean manage_status_id) {
		this.manage_status_id = manage_status_id;
	}

	
	
}
