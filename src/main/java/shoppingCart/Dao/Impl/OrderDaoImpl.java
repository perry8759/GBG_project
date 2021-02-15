package shoppingCart.Dao.Impl;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import shoppingCart.Dao.OrderDao;
import shoppingCart.Model.OrdersBean;

public class OrderDaoImpl implements Serializable, OrderDao {

	@Override
	public void insertOrder(OrdersBean ob) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setConnection(Connection con) {
		// TODO Auto-generated method stub

	}

	@Override
	public OrdersBean getOrder(String order_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersBean> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersBean> getMemberOrders(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateOrderStatus(OrdersBean ordersBean, long sizeInBytes) {
		// TODO Auto-generated method stub
		return 0;
	}

}
