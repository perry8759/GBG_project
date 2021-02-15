package shoppingCart.Dao;

import java.sql.Connection;
import java.util.List;

import product.model.ProductBean;
import shoppingCart.Model.OrdersBean;

public interface OrderDao {

	void insertOrder(OrdersBean ob);

	void setConnection(Connection con);

	//使用訂單編號查詢訂單
	OrdersBean getOrder(String order_id);

	List<OrdersBean> getAllOrders();

	List<OrdersBean> getMemberOrders(String memberId);
	
	//修改訂單狀態
	int updateOrderStatus(OrdersBean ordersBean, long sizeInBytes);

}