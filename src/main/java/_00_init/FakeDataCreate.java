package _00_init;

import _00_init.Act.ActFakeDataCreate;
import _00_init.Act.ActQesFakeDataCreate;
import _00_init.Act.ActRformFakeDataCreate;
import _00_init.dos.DosFakeDataCreate;
import _00_init.dos.DosPicFakeDataCreate;

public class FakeDataCreate {
	public static void main(String[] args) {
//		MemberFakeDataCreate.initVal();
//		System.out.println("Member資料新增完畢");
//		NewsFakeDataCreate.initVal();
//		System.out.println("News資料新增完畢");
		DosPicFakeDataCreate.initVal();
		System.out.println("Dos Pic資料新增完畢");
		DosFakeDataCreate.initVal();
		System.out.println("Dos資料新增完畢");
		ActRformFakeDataCreate.initVal();
		System.out.println("Act Rform資料新增完畢");
		ActQesFakeDataCreate.initVal();
		System.out.println("Act Qes資料新增完畢");
		ActFakeDataCreate.initVal();
		System.out.println("Act資料新增完畢");
	}
}
