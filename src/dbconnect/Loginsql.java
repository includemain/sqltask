package dbconnect;

import java.sql.*;
import java.util.ArrayList;

import vo.Auser;

public class Loginsql {
	public static ArrayList<Auser> query(String Ano,String Acode){
		ArrayList<Auser> records = new ArrayList<Auser>();
		Connection conn = DatabaseConnect.getConnection();
		String sql = "select Aname from Auser where Ano = ? and Acode = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Ano);
			pstmt.setString(2, Acode);
	        ResultSet rs = pstmt.executeQuery();
	        while(rs.next()){
	        	Auser record2 = new Auser(
	        			rs.getString(1)
	        		);
				records.add(record2);

	        }
	        DbClose.close(rs, pstmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return records;
	}

}
