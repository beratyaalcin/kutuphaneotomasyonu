package kutuphane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class baglakitap {
	static Connection myConn;
	static Statement myState;
	static ResultSet myRs;
	static ResultSet yap() {
		try {
			myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ogrenciler","root","root");
			myState=myConn.createStatement();
			myRs = myState.executeQuery("SELECT * FROM kitaplar");
			return myRs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;
	}
	static void ekle(String sql_sorgu) throws SQLException {
		myState.executeUpdate(sql_sorgu);
	}
	static void update(String sql_sorgu) throws SQLException {
		myState.executeUpdate(sql_sorgu);
	}
	
	static void sil(String sql_sorgu) throws SQLException{
		myState.executeUpdate(sql_sorgu);
	}
	
	static ResultSet bul(String sql) throws SQLException {
		ResultSet myRs=null;
		myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ogrenciler","root","root");
		myState=myConn.createStatement();
		myRs = myState.executeQuery(sql);
		return myRs;
	}

}