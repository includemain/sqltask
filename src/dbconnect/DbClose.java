package dbconnect;

import java.sql.*;

public class DbClose {
		public static void close(Connection conn){
			if(null != conn){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		public static void close(PreparedStatement pstmt) {
			if(null != pstmt){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		public static void close(ResultSet rs) {
			if(null != rs){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn){
			close(rs);
			close(pstmt, conn);
		} 
		public static void close(PreparedStatement pstmt,Connection conn) {
			close(pstmt);
			close(conn);
		}
}
