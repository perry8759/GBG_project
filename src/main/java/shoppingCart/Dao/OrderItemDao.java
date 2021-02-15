package shoppingCart.Dao;

import java.sql.Connection;

import shoppingCart.Model.OrderDetailsBean;

public interface OrderItemDao {
	
	// 由OrderDetailsBean取得商品價格。
		
	double findProductPrice(OrderDetailsBean odb);

	int updateProductStock(OrderDetailsBean odb);
	
	void setConnection(Connection conn);
}
