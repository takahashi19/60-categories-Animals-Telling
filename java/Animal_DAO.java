import java.sql.*;
import java.util.Calendar;
public class Animal_DAO {

  private Connection conn;

  public Animal_DAO() throws ClassNotFoundException, SQLException{
    Class.forName("com.mysql.jdbc.Driver");
			String strConn = "jdbc:mysql://localhost/animal_ft"
			+ "?user=Mulder&password=TrustNo1"
			+ "&useUicode=true&characterEncoding=MS932";
    conn = DriverManager.getConnection(strConn);
  }


//★データベース接続切り-------------------------------------
  public void close() {
    try{conn.close();}catch(SQLException e){e.printStackTrace();}
  }

//★占いメソッド--------------------------------------------
	public Animal_DTO fortune_ft(int int60id, String strSex){
			Animal_DTO aniDTO  = null;
			Statement stmt =null;
			ResultSet rs = null;

			try {
				stmt = conn.createStatement();
	//�@持ってくるデータを指定「６０分類の動物の情報」
				String strSql = "select A.name AS 60name ,B.name AS 12name,detail,lover_12id,lover_detail," 
											+ "friend_12id,friend_detail,work_12id,work_detail,A.12id AS 60ani12id "
											+ "from 60animals AS A JOIN 12animals AS B ON A.12id=B.12id "
											+ "JOIN details AS C ON A.60id =C.60id "
											+ "where A.60id =" + int60id + " and C.sex ='"+strSex+"'";
//★SQLの確認 System.out.println(strSql);


					rs=stmt.executeQuery(strSql);
	//----------------------本番用コンストラクタ(引数６つ)---------------------------
	//60分類の動物名、詳細、12分類のid、恋人詳細、友達詳細、仕事仲間詳細
			if(rs.next()){
				aniDTO = new Animal_DTO(
									rs.getString("60name"), rs.getInt("60ani12id"), rs.getString("detail"),
									rs.getString("lover_detail"), rs.getString("friend_detail"),rs.getString("work_detail")
									);
			}

	//恋人、友人、仕事仲間の１２idを受け取る
			int intLover_12id = rs.getInt("lover_12id") ;
			int intFriend_12id = rs.getInt("friend_12id") ;
			int intWork_12id = rs.getInt("work_12id") ;

	/*恋人、友人、仕事人の動物名と画像アドレスをidをもとに代える*/
			strSql = "select * from 12animals";
			rs=stmt.executeQuery(strSql);

			while(rs.next()){
				if (intLover_12id == rs.getInt("12id")){
				aniDTO.setStrLover_name( rs.getString("name"));
				aniDTO.setStrLover_ad( rs.getString("picture"));
				}
			}
			rs.beforeFirst();
			while(rs.next()){
				if ( intFriend_12id == rs.getInt("12id")){
				aniDTO.setStrFriend_name( rs.getString("name"));
				aniDTO.setStrFriend_ad( rs.getString("picture"));
				}
			}
			rs.beforeFirst();
			while(rs.next()){
				if ( intWork_12id ==rs.getInt("12id")){
				aniDTO.setStrWork_name( rs.getString("name"));
				aniDTO.setStrWork_ad( rs.getString("picture"));
				}
			}

	    }catch(Exception e){
			System.out.println("エラー");
			e.printStackTrace();
	    }finally{
	      try{
	        rs.close();
	      }catch(SQLException e){
	        e.printStackTrace();
	      }
	      try{stmt.close();}catch(SQLException e){e.printStackTrace();}
	      try{conn.close();}catch(SQLException e){e.printStackTrace();}
			}
		return aniDTO;
		}


//60id計算メソッド--------------------------------------------
	static int cal60_ft(int userYear,int userMonth,int userDay){
		int year= userYear;
		int month= userMonth;
		int day= userDay;
		Calendar cal1 = Calendar.getInstance();
		cal1.set(1910,0,1);
		long date1 = cal1.getTimeInMillis();
		Calendar cal2 = Calendar.getInstance();
		cal2.set(year,month-1,1);
		long date2 = cal2.getTimeInMillis();
		long distance = (date2 - date1) / (1000*60*60*24);
		int kansan = (int)(distance+2)%60;
		int int60id = (kansan + day);
		if(int60id > 60){
		  int60id = int60id-60;
		}
    return int60id;
	}
//-----------メインメソッド---------------------------------------------
	public static void main(String args[]) {
		int int60id = cal60_ft(1990,10,14);
			System.out.print(int60id);



	}
}

/*-----------------------中身確認------------------------------------
	       System.out.println("あなたは " + aniDTO.getStr60Name());
	       System.out.println("動物番号 " + aniDTO.getInt12Id());

	       System.out.println("恋人　　 " + aniDTO.getStrLover_name());
	       System.out.println("友人　　 " + aniDTO.getStrFriend_name());
	       System.out.println("仕事仲間 " + aniDTO.getStrWork_name());

	       System.out.println("＜画像アドレス＞");
	       System.out.println("恋人　　 " + aniDTO.getStrLover_ad());
	       System.out.println("友人　　 " + aniDTO.getStrFriend_ad());
	       System.out.println("仕事仲間 " + aniDTO.getStrWork_ad());

-----------------------------------------------------------*/
