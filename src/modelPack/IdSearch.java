package modelPack;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class IdSearch{
	public void execute(HttpServletRequest request)throws Exception{

		DaoTest daoTest = null;
		String id = request.getParameter("paramId");

		try{
			if (id !=null && !id.equals("")){

				daoTest = new DaoTest();
				ProductEntity ent = dao.Test.getSweetsDataById(Integer.parseInt(id));
				if(ent !=null){
					request.setAttribute("sweets",ent);

				}else{
					request.setAttribute("message", "該当はありません");
				}
			}
				else{
					request.setAttribute("message", "idを入力してください");
				}
			}
				catch(NumberFormatException e){
				request.setAttribute("message", "数値を入力してください");

			}catch(SQLException e){
				request.setAttribute("message","JDBCのエラーです");
			}finally{
				if(daoTest !=null){
					daoTest.close();
				}
			}
	}
}