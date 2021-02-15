package product.dao;

import java.util.List;
import java.util.Map;

import product.model.ProductBean;
import product.model.ProductDetailBean;


public interface ProductDao {
	

		// 依product_id來查詢單筆記錄
		ProductBean getProduct(int product_id);
		
		// 依productNo來查詢單筆記錄
		ProductBean getProduct(String productNo);

		// 依product_detail_id來查詢單筆記錄
		ProductBean getProductDetails(int product_detail_id);
		
		//依照庫存量來找商品
		List<ProductBean> getProductDetailsByStock(int product_stock);
		
		//依照商品名稱來找商品
		List<ProductBean> getProductByProductTitle(String product_title);
		
		//依照商品名稱來找商品並依價位排序(降冪)
		List<ProductBean> getProductOrderByPriceDesc(String product_title);
		
		//依照商品名稱來找商品並依價位排序(昇冪)
		List<ProductBean> getProductOrderByPriceAsc(String product_title);
		
		//依照商品名稱來找商品並依熱度排序
		List<ProductBean> getProductOrderByHit(String product_title);
		
		//依照商品分類來找商品並依熱度排序
		List<ProductBean> getProductOrderByCat(String category_name);
		
		List<String> getProductCategory();
		
		List<String> getCustomerProductCategory();
		
//		String getCategoryTag();
		
		Map<Integer, ProductBean> getPageProduct(int pageNo);

//		int getPageNo();
		
		long getRecordCounts();

		int getRecordsPerPage();

		int getTotalPages();
		
		// 新增一筆記錄
		int saveProduct(ProductBean productBean);
		
		int saveProductDetail(ProductDetailBean productDetailBean);

//	    void setPageNo(int pageNo);
		
	    void setRecordsPerPage(int recordsPerPage);
		
	    void setSelected(String selected);
		// 計算紀錄總筆數

		int updateProduct(ProductBean productBean, long sizeInBytes);
		
		int updateProduct(ProductDetailBean productDetailBean, long sizeInBytes);
		
		int updateProductStatus(ProductBean productBean, long sizeInBytes);
		
}
