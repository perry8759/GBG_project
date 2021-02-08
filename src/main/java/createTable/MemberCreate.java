package createTable;

import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import member.model.ManageStatusBean;
import member.model.MemberBean;
import member.model.MemberPermBean;
import member.model.MemberSexBean;
import member.model.NewsBean;
import product.model.CustomerCategoryBean;
import product.model.ProductBean;
import product.model.ProductCategoryBean;
import product.model.ProductCommentBean;
import product.model.ProductDetailBean;
import product.model.ProductPicBean;
import product.model.ProductStausBean;
import shoppingCart.Model.FavoriteListBean;
import shoppingCart.Model.OrderDetailsBean;
import shoppingCart.Model.OrderSatusBean;
import shoppingCart.Model.OrdersBean;
import shoppingCart.Model.ShoppingCartBean;
import util.HibernateUtils;

public class MemberCreate {
	//fff
	public static void main(String[] args) {
		MemberBean member = new MemberBean();
		
		MemberPermBean memberPerm1 = new MemberPermBean("normal_member");
		MemberPermBean memberPerm2 = new MemberPermBean("company_member");
		MemberPermBean memberPerm3 = new MemberPermBean("manager");
		
		MemberSexBean memberSex1 = new MemberSexBean("male");
		MemberSexBean memberSex2 = new MemberSexBean("female");
		
		NewsBean news = new NewsBean();
		ManageStatusBean manageStatus1 = new ManageStatusBean("unlock");
		ManageStatusBean manageStatus2 = new ManageStatusBean("locking");
		
		ProductBean product1=new ProductBean();
		ProductBean product2 =new ProductBean(null, "籃球", 300.0, "111.111", null, null, null, null, null, null, null, null, null);
		
		
		Set<ProductBean> products1 = new LinkedHashSet<>();
		products1.add(product1);
		products1.add(product2);
		ProductStausBean producsStaus1=new ProductStausBean(null, "onSale",products1);
		ProductStausBean producsStaus2=new ProductStausBean(null, "offSale",null);
		
		CustomerCategoryBean customerCategory1=new CustomerCategoryBean(null, "male", products1);
		
		ProductCategoryBean productCategory=new ProductCategoryBean(null, "用具", products1);
		
		ProductDetailBean basketball1=new ProductDetailBean(null, product2, "red", "6號球", 50, null, null, null);
		ProductDetailBean basketball2=new ProductDetailBean(null, product2, "red", "5號球", 50, null, null, null);
		
		ProductPicBean proPic1=new ProductPicBean(null, basketball1, null, 0);
		ProductPicBean proPic2=new ProductPicBean(null, basketball1, null, 1);
		ProductPicBean proPic3=new ProductPicBean(null, basketball2, null, 0);
		
		ProductCommentBean produccComment1=new ProductCommentBean(null, member, null, product2, 5, null, manageStatus1);
		
		OrdersBean order1=new OrdersBean(null, "a00001", null, member, "Sam", "台北市內湖區", null, null, null, "外送", null);
		
		OrderDetailsBean od1=new OrderDetailsBean(null, 2, order1, basketball1);
		OrderDetailsBean od2=new OrderDetailsBean(null, 5, order1, basketball2);
		
		Set<OrdersBean> orders1 = new LinkedHashSet<>();
		orders1.add(order1);
		
		OrderSatusBean ordesSatus1=new OrderSatusBean(null, "未處理", orders1);
		
		ShoppingCartBean cart1=new ShoppingCartBean(null, 2, member, basketball1);
		
		FavoriteListBean favoriteList1=new FavoriteListBean(null, member, product2);
		
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(memberPerm1);
			session.persist(memberPerm2);
			session.persist(memberPerm3);
			session.persist(memberSex1);
			session.persist(memberSex2);
			session.persist(member);
			session.persist(news);
			session.persist(manageStatus1);
			session.persist(manageStatus2);
			
			session.persist(basketball1);
			session.persist(basketball2);
			session.persist(producsStaus1);
			session.persist(producsStaus2);
			session.persist(customerCategory1);
			session.persist(productCategory);
			session.persist(proPic1);
			session.persist(proPic2);
			session.persist(proPic3);
			session.persist(produccComment1);
			session.persist(order1);
			session.persist(od1);
			session.persist(od2);
			session.persist(ordesSatus1);
			session.persist(cart1);
			session.persist(favoriteList1);
			
			tx.commit();
			System.out.println("資料新增完畢");
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// 需要印出錯誤訊息
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			// 關閉Session物件
			if (session != null)
				session.close();
		}
		factory.close();
	}
}
