package _00_init;

/*  
    程式說明：建立表格與設定初始測試資料。
    表格包括：Book, BookCompany, Member, Orders, OrderItems
 
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import product.model.CustomerCategoryBean;
import product.model.ProductBean;
import product.model.ProductCategoryBean;
import product.model.ProductDetailBean;
import product.model.ProductPicBean;
import product.model.ProductStausBean;
import shoppingCart.Model.OrderSatusBean;
import util.HibernateUtils;

public class EDMTableResetHibernateGBG {
	public static final String UTF8_BOM = "\uFEFF"; // 定義 UTF-8的BOM字元

	public static void main(String args[]) {

		String line = "";
		List<OrderSatusBean> orderStList = new ArrayList<>();
		List<CustomerCategoryBean> customerCategoryList = new ArrayList<>();
		List<ProductCategoryBean> productCategoryList = new ArrayList<>();
		List<ProductStausBean> productStausList = new ArrayList<>();
		List<ProductBean> productList = new ArrayList<>();

		int count = 0;
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		// spring
//		Session session = HibernateUtils.getSessionFactory().openSession();
//		Transaction tx = null;
//		int count = 0;

		// -------------讀取order_satus資料，寫入資料庫----------------
		// 定義儲存order_satus的List物件，當讀入每筆order_satus資料後，不立即
		// 寫入資料庫而是等到讀入Member時，將對應的Hobby存入Member，
		// 再寫入Member(當然同時寫入Hobby)

		try (
				// data2/order_satus.dat存放要新增的n筆資料
				InputStreamReader isr0 = new InputStreamReader(new FileInputStream("data2/order_satus.dat"), "UTF-8");
				BufferedReader br = new BufferedReader(isr0);) {
//				String line = "";
			tx = session.beginTransaction();
			while ((line = br.readLine()) != null) {
				String[] sa = line.split("\\|");
				OrderSatusBean orderStatus = new OrderSatusBean();
				orderStatus.setOrder_st_id(null);
				orderStatus.setOrder_stname(sa[0]);
				session.save(orderStatus);

				orderStList.add(orderStatus);

				count++;
				System.out.println("新增" + count + "筆記錄:" + sa[0]);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		System.out.println("orderStList==>" + orderStList);

		// -------------讀取customer_Category資料，寫入資料庫----------------
		// 定義儲存customer_Category的List物件，當讀入每筆customer_Category資料後，不立即
		// 寫入資料庫而是等到讀入Member時，將對應的Hobby存入Member，
		// 再寫入Member(當然同時寫入Hobby)

		try (
				// data2/order_satus.dat存放要新增的n筆資料
				InputStreamReader isr0 = new InputStreamReader(new FileInputStream("data2/customer_Category.dat"),
						"UTF-8");
				BufferedReader br = new BufferedReader(isr0);) {
//							String line = "";
			tx = session.beginTransaction();
			while ((line = br.readLine()) != null) {
				String[] sa = line.split("\\|");
				CustomerCategoryBean customerCategory = new CustomerCategoryBean();
				customerCategory.setCustomer_category_id(null);
				customerCategory.setCustomer_category_name(sa[0]);
				session.save(customerCategory);
				customerCategoryList.add(customerCategory);
				count++;
				System.out.println("新增" + count + "筆記錄:" + sa[0]);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		System.out.println("customerCategoryList==>" + customerCategoryList);
		// -------------讀取product_Category資料，寫入資料庫----------------
		// 定義儲存product_Category的List物件，當讀入每筆product_Category資料後，不立即

		// 寫入資料庫而是等到讀入Member時，將對應的Hobby存入Member，
		// 再寫入Member(當然同時寫入Hobby)

		try (
				// data2/order_satus.dat存放要新增的n筆資料
				InputStreamReader isr0 = new InputStreamReader(new FileInputStream("data2/product_Category.dat"),
						"UTF-8");
				BufferedReader br = new BufferedReader(isr0);) {
//				String line = "";
			tx = session.beginTransaction();
			while ((line = br.readLine()) != null) {
				String[] sa = line.split("\\|");
				ProductCategoryBean productCategory = new ProductCategoryBean();
				productCategory.setCategory_id(null);
				productCategory.setCategory_name(sa[0]);
				session.save(productCategory);
				productCategoryList.add(productCategory);
				count++;
				System.out.println("新增" + count + "筆記錄:" + sa[0]);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		System.out.println("customerCategoryList==>" + customerCategoryList);

		// -------------讀取customer_Category資料，寫入資料庫----------------
		// 定義儲存customer_Category的List物件，當讀入每筆customer_Category資料後，不立即

		// 寫入資料庫而是等到讀入Member時，將對應的Hobby存入Member，
		// 再寫入Member(當然同時寫入Hobby)

		try (
				// data2/order_satus.dat存放要新增的n筆資料
				InputStreamReader isr0 = new InputStreamReader(new FileInputStream("data2/product_status.dat"),
						"UTF-8");
				BufferedReader br = new BufferedReader(isr0);) {
//									String line = "";
			tx = session.beginTransaction();
			while ((line = br.readLine()) != null) {
				String[] sa = line.split("\\|");
				ProductStausBean productStaus = new ProductStausBean();
				productStaus.setProduct_stid(null);
				productStaus.setProduct_st_name(sa[0]);
				session.save(productStaus);
				productStausList.add(productStaus);
				count++;
				System.out.println("新增" + count + "筆記錄:" + sa[0]);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		System.out.println("productStausList==>" + productStausList);

		// -------------讀取Product資料，寫入資料庫----------------
		File file = new File("data2/product.dat");
		// 2-1 由"data/product.dat"逐筆讀入product表格內的初始資料，然後依序新增
		// 到product表格中
		try (FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
				BufferedReader br = new BufferedReader(isr);) {
			while ((line = br.readLine()) != null) {
				System.out.println("line=" + line);
				// 去除 UTF8_BOM: \uFEFF
				if (line.startsWith(UTF8_BOM)) {
					line = line.substring(1);
				}
				String[] token = line.split("\\|");
				ProductBean product = new ProductBean();
				product.setProduct_id(null);
				product.setProduct_title(token[0]);
				product.setProduct_price(Double.parseDouble(token[1].trim()));
				product.setProductno(token[2]);

				// 取得商品描述.txt檔
//						product.setProduct_textdetails(token[3]);
				
//				product.setCustomerCategoryBean(customerCategoryList.get(Integer.parseInt(token[4])));
//				product.setProductCategoryBean(productCategoryList.get(Integer.parseInt(token[5])));
//				product.setProductStausBean(productStausList.get(Integer.parseInt(token[6])));
				// 暫時不會用到
//						product.setCustomerCategoryId((token[4].trim());
//						product.setProductCategoryId((token[5].trim());
//						product.setProductStausId(token[6]);
				product.setProduct_purchases(Integer.parseInt(token[7].trim()));
				product.setAverage_score(Double.parseDouble(token[8].trim()));
				Timestamp onSaleTime = new Timestamp(System.currentTimeMillis());
				product.setOnSaleTime(onSaleTime);

				try {
					tx = session.beginTransaction();

					CustomerCategoryBean customerCategoryBean = session.get(CustomerCategoryBean.class,
							Integer.parseInt(token[4].trim()));
					product.setCustomerCategoryBean(customerCategoryBean);

					ProductCategoryBean productCategoryBean = session.get(ProductCategoryBean.class,
							Integer.parseInt(token[5].trim()));
					product.setProductCategoryBean(productCategoryBean);

					ProductStausBean productStausBean = session.get(ProductStausBean.class,
							Integer.parseInt(token[6].trim()));
					product.setProductStausBean(productStausBean);

					session.save(product);
					productList.add(product);

					tx.commit();
				} catch (Exception ex) {
					if (tx != null)
						tx.rollback();
				}
				System.out.println("新增一筆Product紀錄");
			}
			// 印出資料新增成功的訊息
			System.out.println("Product資料新增成功");
		} catch (Exception e) {
			System.err.println("新建Product表格時發生IO例外: " + e.getMessage());
		}
		
		// -------------讀取Product_detail資料，寫入資料庫----------------
		try (
				InputStreamReader isr0 = new InputStreamReader(
						new FileInputStream("data2/product_detail.dat"), "UTF-8");

				BufferedReader br = new BufferedReader(isr0);)
		// 由檔案("data2/product_detail.dat")讀入product_detail的資料，然後寫入資料庫
		{
			while ((line = br.readLine()) != null) {
				// 未處理BOM字元，若有需要，請自行加入
				String[] sa = line.split("\\|");
				try {
					tx = session.beginTransaction();
					ProductDetailBean productDetail=new ProductDetailBean();
					productDetail.setProduct_detail_id(null);
					
					ProductBean productBean = session.get(ProductBean.class, Integer.parseInt(sa[0].trim()));
					productDetail.setProductBean(productBean);
					
					productDetail.setProduct_color(sa[1]);
					productDetail.setProduct_size(sa[2]);
					productDetail.setProduct_stock(Integer.parseInt(sa[3]));
					
					session.save(productDetail);
					session.flush();
					tx.commit();
					count++;
					System.out.println("新增" + count + "筆記錄:" + sa[1]);
					//break;
				} catch (Exception e) {
					e.printStackTrace();
					if (tx != null) {
						tx.rollback();
					}
				} finally {

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// -------------讀取product_pic資料，寫入資料庫----------------
				try (
						InputStreamReader isr0 = new InputStreamReader(
								new FileInputStream("data2/product_pic.dat"), "UTF-8");

						BufferedReader br = new BufferedReader(isr0);)
				// 由檔案("data2/product_pic.dat")讀入product_pic的資料，然後寫入資料庫
				{
					while ((line = br.readLine()) != null) {
						// 未處理BOM字元，若有需要，請自行加入
						String[] sa = line.split("\\|");
						try {
							tx = session.beginTransaction();
							ProductPicBean productPic=new ProductPicBean();
							
							productPic.setProduct_pic_id(null);
							ProductBean productBean = 
									session.get(ProductBean.class, Integer.parseInt(sa[0].trim()));
							productPic.setProductBean(productBean);
//							productPic.setProductBean(productList.get(Integer.parseInt(sa[0])));
							productPic.setProduct_pic_seq(Integer.parseInt(sa[2]));
	
							// --------------處理Blob(圖片)欄位----------------
							File picf = new File(sa[1]);
							System.out.println(picf.getAbsolutePath());
							long size = picf.length();
							InputStream is = new FileInputStream(picf);
							Blob picb = Hibernate.getLobCreator(session).createBlob(is, size);
							productPic.setProduct_pic_img(picb);
							
							session.save(productPic);
							session.flush();
							tx.commit();
							count++;
							System.out.println("新增" + count + "筆記錄:" + sa[1]);
							//break;
						} catch (Exception e) {
							e.printStackTrace();
							if (tx != null) {
								tx.rollback();
							}
						} finally {

						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
//========================================================
		HibernateUtils.close();
	}
}