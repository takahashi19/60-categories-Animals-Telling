package modelPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoTest{
	private Connection connection;

	public DaoTest() throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
		"jbdc:mysql://localhost:3306/sweets"
		+"?user=Mulder&passWord=TrusNo1"
		+"&useUnicode=true&characterEncode=MS932");
		}
	private void colse() {
		try{
		if(connection !=null){
			connection.close();
		}
		}catch(SQLException e){
		e.printStackTrace();
		// TODO 自動生成されたメソッド・スタブ

	}

}

	public ProductEntity getSweetsDataById(int id）throws SQLException{


	}