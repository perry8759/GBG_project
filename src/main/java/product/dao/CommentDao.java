package product.dao;

import java.util.List;
import java.util.Map;

import product.model.ProductCommentBean;

public interface CommentDao {

	// 依會員編號來查詢評論
	List<ProductCommentBean> getCommentByMemberId(int member_id);

	// 依評論狀態來查詢評論
	List<ProductCommentBean> getCommentByCommentSt(String manage_status_name);
	
	// 依商品id來查詢評論
	List<ProductCommentBean> getCommentByProductId(int product_id);

	Map<Integer, ProductCommentBean> getProductComments(int pageNo);

//		int getPageNo();

	long getRecordCounts();

	int getRecordsPerPage();

	int getTotalPages();

	// 新增一筆記錄
	int saveProductComment(ProductCommentBean productCommentBean);

//	    void setPageNo(int pageNo);

	void setRecordsPerPage(int recordsPerPage);

	void setSelected(String selected);
	// 計算紀錄總筆數

	int updateComment(ProductCommentBean productCommentBean, long sizeInBytes);
}
