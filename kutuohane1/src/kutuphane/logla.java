package kutuphane;

import java.sql.ResultSet;
import java.sql.SQLException;

public class logla {
	
	
	
	public static void aldi(String alankisi, String kitapismi) {
		String sql3 = "SELECT * FROM log";
		
		ResultSet myRs3;
		try {
			myRs3 = baglalog.bul(sql3);
				String loggonderici = "INSERT INTO log (ogrismi, kitap, islem)  VALUES (" +
						   			  "'" + alankisi + "'," + "'" + kitapismi + "'," +  "'ALDI')";
				System.out.println(loggonderici);
				baglalog.update(loggonderici);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public static void verdi(String alankisi, String kitapismi) {
			String sql3 = "SELECT * FROM log";
			
			ResultSet myRs3;
			try {
				myRs3 = baglalog.bul(sql3);
					String loggonderici = "INSERT INTO log (ogrismi, kitap, islem)  VALUES (" +
							   			  "'" + alankisi + "'," + "'" + kitapismi + "'," +  "'VERDI')";
					System.out.println(loggonderici);
					baglalog.update(loggonderici);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



		
		}
		
}
