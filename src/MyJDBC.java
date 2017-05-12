import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyJDBC {

	public static List<String> ishavetype(String type) {
		List<String> list = new ArrayList<String>();
		String sql = "select time from allitems where type='" + type + "';";
		try {
			Statement st = getSt();
			ResultSet res = st.executeQuery(sql);
			while (res.next()) {
				list.add(res.getString(1));
			}
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public static boolean delitems(String type, String tablename) {
		String delinall = "DELETE FROM allitems WHERE time='" + tablename + "' and type='" + type + "';";
		String del = "delete from tumu" + tablename + " where type='" + type + "';";
		
		try {
			Statement st = getSt();
			st.execute(del);
			st.execute(delinall);
			ResultSet rs = st.executeQuery("SELECT * FROM tumu" + tablename);
			if(!rs.next())
				getSt().execute("drop table tumu" + tablename+";");
			st.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public static void inittable(String tablename) {
		try {
			// System.out.println(111);
			Statement st = getSt();
			st.execute("SELECT * FROM tumu" + tablename);
			st.close();
		} catch (SQLException e) {
			// System.out.println(e);
			
			if (e.toString().contains("Table 'tumu.tumu" + tablename + "' doesn't exist"))
				createtable(tablename);
		}
	}

	public static void createtable(String tablename) {
		// System.out.println("aaa");
		// insert into tumu2017_04_11
		// values('分布荷载#整跨#三级#8#HRB235#6#100#150#300#','0.0','0.0','0.0','0.0','0.0','-1','-1','0','1','-1','-2','1','0','-0.03036824','-0.03036824','0.0','0.03036824','-0.03036824','-0.06073648','0.03036824','0.0','0.0','0.0');

		String sql = "create table tumu" + tablename + "(type varchar(100),"
				+ "desgin double,myreal double,wanju double,baifenbiao double,kuazhongraodu double,"
				+ "yb1 int,yb2 int,yb3 int,yb4 int,yb5 int,yb6 int,yb7 int,yb8 int,"
				+ "yl1 double,yl2 double,yl3 double,yl4 double,yl5 double,yl6 double,yl7 double,yl8 double,"
				+ "jiemianqulv double,liefeng double,img varchar(255))";
		try {
			Statement st = getSt();
			st.execute(sql);
			st.close();
			// System.out.println("creat succ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(sql);
	}

	public static boolean additem(String tablename, List<MyItem> list) {
		for (MyItem myItem : list) {
			String sql = "insert into tumu" + tablename + " " + myItem.myToString();
			
			// System.out.println(sql);
			try {
				Statement st = getSt();
				st.execute(sql);
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public static void createallitems() {
		String sql = "create table allitems(time varchar(10),type varchar(100));";
		try {
			Statement st = getSt();
			st.execute(sql);
			st.close();
			// System.out.println("creat succ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean addAllitems(MyItem m) {
		initall();
		String sql = "insert into allitems values ('" + m.getTime() + "','" + m.getType() + "');";
		//System.out.println(sql);
		try {
			Statement st = getSt();
			st.execute(sql);
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static void initall() {
		try {
			Statement st = getSt();
			st.execute("SELECT * FROM allitems");
			st.close();
			// System.out.println(1111);
		} catch (SQLException e) {
			if (e.toString().contains("Table 'tumu.allitems' doesn't exist"))
				createallitems();
		}

	}

	public static void main(String[] args) {

		// MyItem m=new MyItem("2017_04_14",
		// "分布荷载#整跨#三级#8#HRB235#6#100#150#300#");
		// System.out.println(isexits(m));

		// try {
		// ResultSet re = getSt().executeQuery("select * from allitems");
		// while(re.next())
		// {
		// System.out.println(re.getString(1));
		// }
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	public static Statement getSt() {
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/tumu?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			String username = "root";
			String password = "tumu@2017";
			Connection con = DriverManager.getConnection(url, username, password);
			st = con.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

	public static boolean isexits(MyItem myItem) {
		// TODO Auto-generated method stub
		String sql = "select time from tumu.allitems where time='" + myItem.getTime() + "' and type='"
				+ myItem.getType() + "';";
		try {
			Statement st = getSt();
			ResultSet re = st.executeQuery(sql);
			if (re.next()) {
				st.close();
				return true;
			} else
			{
				st.close();
				return false;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	public static List<MyItem> getItemsBy(List<String> list, String type, int hezai) {
		// TODO Auto-generated method stub
		List<MyItem> li = new ArrayList<MyItem>();
		for (String time : list) {
			String sql = "select * from tumu" + time + " where type='" + type + "' and desgin between "
					+ (double) (hezai - 0.5) + " and " + (double) (hezai + 0.4) + ";";
			try {
				Statement st = getSt();
				ResultSet res = 
						st.executeQuery(sql);
				while (res.next()) {
					li.add(new MyItem(time, type, res.getDouble(2), res.getDouble(3), res.getDouble(4),
							res.getDouble(5), res.getDouble(6), res.getInt(7), res.getInt(8), res.getInt(9),
							res.getInt(10), res.getInt(11), res.getInt(12), res.getInt(13), res.getInt(14),
							res.getDouble(15), res.getDouble(16), res.getDouble(17), res.getDouble(18),
							res.getDouble(19), res.getDouble(20), res.getDouble(21), res.getDouble(22),
							res.getDouble(23), res.getDouble(24), res.getString(25)));
				}
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println(sql);
		}

		return li;
	}

}
