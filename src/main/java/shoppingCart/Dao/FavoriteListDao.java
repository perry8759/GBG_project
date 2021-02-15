package shoppingCart.Dao;

import java.sql.Connection;
import java.util.List;

import product.model.ProductBean;

public interface FavoriteListDao {

	void setConnection(Connection con);

	List<ProductBean> getMemberFavoriteList(String memberId);

	void insertFavoriteList(ProductBean pb);

	// 依product_id來刪除單筆記錄
	int deleteProduct(int product_id);
}
