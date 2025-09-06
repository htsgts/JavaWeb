import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnect {
	Connection conn = null;
	Statement stmt = null;  //  literal SQL
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DBConnect(){
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mariadb://localhost:9933/web",
					"root",
					"1234"
					);
			if(conn != null) {
				System.out.println(conn);
				System.out.println("Congratulations!! Connect OK");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnect dbConn = new DBConnect();
		dbConn.test();
		dbConn.select1("인천", "의원").forEach(System.out::println);
		dbConn.select2("대전", "보건소").forEach(System.out::println);
	}

	public void test() {
		String sql = "select 'hi' as ans from dual";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println("DB responded");
				System.out.println("Response : " + rs.getString("ans"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Statement
	public ArrayList<HospitalVO> select1(String region, String typ){
		ArrayList<HospitalVO> arr = new ArrayList();
		
		// select * from hptl_mast_bak 
		// where sido_cd_nm = '서울' and typ_cd_nm = '상급종합'
		String sql = "";
		sql += "select * from hptl_mast_bak ";
		sql += "where sido_cd_nm = '" + region + "' ";
		sql += "and typ_cd_nm = '" + typ + "' ";
		sql += "limit 10";
		System.out.println(sql);
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				HospitalVO vo = new HospitalVO();
				String name = rs.getString("hptl_nm");
				String addr = rs.getString("addr");
				int num = rs.getInt("doc_num");
				vo.setHospitalVO(name, addr, num);
				arr.add(vo);
			}
		} catch(Exception e) { }
		
		return arr;
	}
	
	// PreparedStatement
	public ArrayList<HospitalVO> select2(String region, String typ){
		ArrayList<HospitalVO> arr = new ArrayList();
		
		// select * from hptl_mast_bak 
		// where sido_cd_nm = '서울' and typ_cd_nm = '상급종합'
		// PreparedStatement는 변수 부분을 ?로 작성
		String sql = "";
		sql += "select * from hptl_mast_bak ";
		sql += "where sido_cd_nm = ? ";
		sql += "and typ_cd_nm = ? ";
		sql += "limit 10";
		System.out.println(sql);
		
		// preparedStatement의 유일한 단점 : (비정상적인) 수행 SQL의
		// 파라미터를 알아내기가 복잡 -> 수행회수가 매우 많은 경우 사용
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, region);
			pstmt.setString(2, typ);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				HospitalVO vo = new HospitalVO();
				String name = rs.getString("hptl_nm");
				String addr = rs.getString("addr");
				int num = rs.getInt("doc_num");
				vo.setHospitalVO(name, addr, num);
				arr.add(vo);
			}
		} catch(Exception e) { }
		
		return arr;
	}
}
