package shoppingCart.Dao.Impl;

import java.io.Serializable;
import java.sql.Connection;

import shoppingCart.Dao.ShoppingCartDao;
import shoppingCart.Model.OrderDetailsBean;

public class ShoppingCartDaoImpl implements Serializable, ShoppingCartDao {

	@Override
	public double findProductPrice(OrderDetailsBean odb) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateProductStock(OrderDetailsBean odb) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int product_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setConnection(Connection conn) {
		// TODO Auto-generated method stub

	}

}
