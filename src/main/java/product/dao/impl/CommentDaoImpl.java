package product.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import product.dao.CommentDao;
import product.model.ProductCommentBean;
import util.HibernateUtils;

public class CommentDaoImpl implements Serializable, CommentDao {

	public static final int RECORDS_PER_PAGE = 10;
	private int recordsPerPage =RECORDS_PER_PAGE;
	private int totalPages = -1;
	
	String selected = "";
	SessionFactory factory = null;

	public CommentDaoImpl() {
		factory = HibernateUtils.getSessionFactory();
	}




	@Override
	public List<ProductCommentBean> getCommentByMemberId(int member_id) {
		return null;
	}

	@Override
	public List<ProductCommentBean> getCommentByCommentSt(String manage_status_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCommentBean> getCommentByProductId(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, ProductCommentBean> getProductComments(int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public long getRecordCounts() {
		long count = 0; // 必須使用 long 型態
		String hql = "SELECT count(*) FROM ProductCommentBean";
		Session session = factory.getCurrentSession();
		List<Long> list = session.createQuery(hql).getResultList();
		if (list.size() > 0) {
			count = list.get(0);
		}
		return count;
	}
	


	@Override
	public int getRecordsPerPage() {
		// TODO Auto-generated method stub
		return 0;
	}

	// 計算商品的評論總共有幾頁
	@Override
	public int getTotalPages() {
		totalPages = (int) (Math.ceil(getRecordCounts() / (double) recordsPerPage));
		return totalPages;
	}
	
	@Override
	public int saveProductComment(ProductCommentBean productCommentBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRecordsPerPage(int recordsPerPage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSelected(String selected) {
		// TODO Auto-generated method stub

	}

	@Override
	public int updateComment(ProductCommentBean productCommentBean, long sizeInBytes) {
		int n = 0;
		
		return n;
	}
}
