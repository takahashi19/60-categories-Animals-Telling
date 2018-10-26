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
					request.setAttribute("message", "ŠY“–‚Í‚ ‚è‚Ü‚¹‚ñ");
				}
			}
				else{
					request.setAttribute("message", "id‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢");
				}
			}
				catch(NumberFormatException e){
				request.setAttribute("message", "”’l‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢");

			}catch(SQLException e){
				request.setAttribute("message","JDBC‚ÌƒGƒ‰[‚Å‚·");
			}finally{
				if(daoTest !=null){
					daoTest.close();
				}
			}
	}
}