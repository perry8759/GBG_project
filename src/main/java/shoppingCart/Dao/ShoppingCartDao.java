package shoppingCart.Dao;

import java.sql.Connection;

import shoppingCart.Model.OrderDetailsBean;

public interface ShoppingCartDao {
	
	double findProductPrice(OrderDetailsBean odb);

	int updateProductStock(OrderDetailsBean odb);
	
	int deleteProduct(int product_id);
	
	void setConnection(Connection conn);
	
	//將商品移入收藏清單
}
