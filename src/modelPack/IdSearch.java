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
					request.setAttribute("message", "�Y���͂���܂���");
				}
			}
				else{
					request.setAttribute("message", "id����͂��Ă�������");
				}
			}
				catch(NumberFormatException e){
				request.setAttribute("message", "���l����͂��Ă�������");

			}catch(SQLException e){
				request.setAttribute("message","JDBC�̃G���[�ł�");
			}finally{
				if(daoTest !=null){
					daoTest.close();
				}
			}
	}
}