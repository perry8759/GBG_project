package shoppingCart.Dao.Impl;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import product.model.ProductBean;
import shoppingCart.Dao.FavoriteListDao;

public class FavoriteListDaoImpl implements Serializable, FavoriteListDao {

	@Override
	public void setConnection(Connection con) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProductBean> getMemberFavoriteList(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertFavoriteList(ProductBean pb) {
		// TODO Auto-generated method stub

	}

	@Override
	public int deleteProduct(int product_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
