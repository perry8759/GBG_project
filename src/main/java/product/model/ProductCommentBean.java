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
@Table(name = "product_comment")
public class ProductCommentBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer comment_id;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private MemberBean memberBean;

//	@NotNull
	private Date comment_date;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private ProductBean productBean;

	@NotNull
	private Integer comment_value;
	private Clob comment_comment;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manage_status_id")
	private ManageStatusBean manageStatusBean;

	// 要有預設建構子
	public ProductCommentBean() {
	}

	public ProductCommentBean(Integer comment_id, MemberBean memberBean, Date comment_date, ProductBean productBean,
			Integer comment_value, Clob comment_comment, ManageStatusBean manageStatusBean) {
		super();
		this.comment_id = comment_id;
		this.memberBean = memberBean;
		this.comment_date = comment_date;
		this.productBean = productBean;
		this.comment_value = comment_value;
		this.comment_comment = comment_comment;
		this.manageStatusBean = manageStatusBean;
	}

	public Integer getComment_id() {
		return comment_id;
	}

	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}

	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
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

	public ManageStatusBean getManageStatusBean() {
		return manageStatusBean;
	}

	public void setManageStatusBean(ManageStatusBean manageStatusBean) {
		this.manageStatusBean = manageStatusBean;
	}

}
