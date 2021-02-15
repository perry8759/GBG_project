package product.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import product.dao.ProductDao;
import product.model.ProductBean;
import product.model.ProductDetailBean;
import util.HibernateUtils;

public class ProductDaoImpl implements Serializable, ProductDao {

	public static final int RECORDS_PER_PAGE = 10;
	private int recordsPerPage =RECORDS_PER_PAGE;
	private int totalPages = -1;
	
	String selected = "";
	SessionFactory factory = null;

	public ProductDaoImpl() {
		factory = HibernateUtils.getSessionFactory();
	}
	
	
	@Override
	public ProductBean getProduct(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductBean getProduct(String productNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductBean getProductDetails(int product_detail_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductBean> getProductDetailsByStock(int product_stock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductBean> getProductByProductTitle(String product_title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductBean> getProductOrderByPriceDesc(String product_title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductBean> getProductOrderByPriceAsc(String product_title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductBean> getProductOrderByHit(String product_title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductBean> getProductOrderByCat(String category_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getProductCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCustomerProductCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, ProductBean> getPageProduct(int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getRecordCounts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRecordsPerPage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalPages() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveProduct(ProductBean productBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveProductDetail(ProductDetailBean productDetailBean) {
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
	public int updateProduct(ProductBean productBean, long sizeInBytes) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateProduct(ProductDetailBean productDetailBean, long sizeInBytes) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateProductStatus(ProductBean productBean, long sizeInBytes) {
		// TODO Auto-generated method stub
		return 0;
	}

}
