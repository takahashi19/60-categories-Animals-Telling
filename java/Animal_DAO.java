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


//���f�[�^�x�[�X�ڑ��؂�-------------------------------------
  public void close() {
    try{conn.close();}catch(SQLException e){e.printStackTrace();}
  }

//���肢���\�b�h--------------------------------------------
	public Animal_DTO fortune_ft(int int60id, String strSex){
			Animal_DTO aniDTO  = null;
			Statement stmt =null;
			ResultSet rs = null;

			try {
				stmt = conn.createStatement();
	//�@�����Ă���f�[�^���w��u�U�O���ނ̓����̏��v
				String strSql = "select A.name AS 60name ,B.name AS 12name,detail,lover_12id,lover_detail," 
											+ "friend_12id,friend_detail,work_12id,work_detail,A.12id AS 60ani12id "
											+ "from 60animals AS A JOIN 12animals AS B ON A.12id=B.12id "
											+ "JOIN details AS C ON A.60id =C.60id "
											+ "where A.60id =" + int60id + " and C.sex ='"+strSex+"'";
//��SQL�̊m�F System.out.println(strSql);


					rs=stmt.executeQuery(strSql);
	//----------------------�{�ԗp�R���X�g���N�^(�����U��)---------------------------
	//60���ނ̓������A�ڍׁA12���ނ�id�A���l�ڍׁA�F�B�ڍׁA�d�����ԏڍ�
			if(rs.next()){
				aniDTO = new Animal_DTO(
									rs.getString("60name"), rs.getInt("60ani12id"), rs.getString("detail"),
									rs.getString("lover_detail"), rs.getString("friend_detail"),rs.getString("work_detail")
									);
			}

	//���l�A�F�l�A�d�����Ԃ̂P�Qid���󂯎��
			int intLover_12id = rs.getInt("lover_12id") ;
			int intFriend_12id = rs.getInt("friend_12id") ;
			int intWork_12id = rs.getInt("work_12id") ;

	/*���l�A�F�l�A�d���l�̓������Ɖ摜�A�h���X��id�����Ƃɑウ��*/
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
			System.out.println("�G���[");
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


//60id�v�Z���\�b�h--------------------------------------------
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
//-----------���C�����\�b�h---------------------------------------------
	public static void main(String args[]) {
		int int60id = cal60_ft(1990,10,14);
			System.out.print(int60id);



	}
}

/*-----------------------���g�m�F------------------------------------
	       System.out.println("���Ȃ��� " + aniDTO.getStr60Name());
	       System.out.println("�����ԍ� " + aniDTO.getInt12Id());

	       System.out.println("���l�@�@ " + aniDTO.getStrLover_name());
	       System.out.println("�F�l�@�@ " + aniDTO.getStrFriend_name());
	       System.out.println("�d������ " + aniDTO.getStrWork_name());

	       System.out.println("���摜�A�h���X��");
	       System.out.println("���l�@�@ " + aniDTO.getStrLover_ad());
	       System.out.println("�F�l�@�@ " + aniDTO.getStrFriend_ad());
	       System.out.println("�d������ " + aniDTO.getStrWork_ad());

-----------------------------------------------------------*/