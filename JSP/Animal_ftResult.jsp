<%@ page contentType="text/html; charset=Windows-31J"%>
<%@ page import="java.util.*"%>
<%@ page import="animal_ft.*"%>

<jsp:useBean class="animal_ft.Calendar_check" id="calendar_check" scope="session"/>

<%
request.setCharacterEncoding("Windows-31J");
String strName=request.getParameter("name");
String strYear=request.getParameter("birth_year");
String strMonth=request.getParameter("birth_month");
String strDay=request.getParameter("birth_day");
String strSex=request.getParameter("sex");
int intYear  = 0;
int intMonth = 0;
int intDay   = 0;
int int12id = 0;


//null判定----------------------------------
		if (strName == null || strYear==null || strMonth == null || strDay == null){
//セッション変数を登録
			String strError = "※　記入漏れがあります　※";
			session.setAttribute("error",strError);
			response.sendRedirect("Animal_ftForm.jsp");
			return;
		}
		boolean checker = false;
//「int型」に変換できるかで判定-------------

		try{
			intYear  = Integer.parseInt(strYear);
			intMonth = Integer.parseInt(strMonth);
			intDay   = Integer.parseInt(strDay);
		}catch(NumberFormatException e){
//セッション変数を登録
			String strError = "※　生年月日は数字を入力してください　※";
			session.setAttribute("error",strError);
			response.sendRedirect("Animal_ftForm.jsp");
			return;
		}
//カレンダーの年月日と合うか判定-------------
		boolean a = calendar_check.checker(intYear, intMonth, intDay);
		if (a){
			String strError = "※　生年月日が正しくありません　※";
			session.setAttribute("error",strError);
			response.sendRedirect("Animal_ftForm.jsp");
			return;
		}

//Animal_DAOのメソッドを実行するためインスタンスをつくる
		animal_ft.Animal_DAO  aniDAO = new animal_ft.Animal_DAO();


//60分類を計算
		int id = aniDAO.cal60_ft(intYear, intMonth, intDay);

//占い結果を受け取るインスタンスをつくる
		animal_ft.Animal_DTO  aniDTO = new animal_ft.Animal_DTO();


//占ってみる---------------------------------
   try{
		aniDTO = aniDAO.fortune_ft(id, strSex);
   }catch(NullPointerException e){
			String strError = "※　占い結果が出せません　※";
			session.setAttribute("error",strError);
			response.sendRedirect("Animal_ftForm.jsp");
			return;
   }catch(Exception e){
			String strError = "※　不明のエラーです　※";
			session.setAttribute("error",strError);
			response.sendRedirect("Animal_ftForm.jsp");
			return;
   }finally{
     aniDAO.close();
   }
	int12id = aniDTO.getInt12Id();
%>

<!DOCTYPE HTML>
<html>
<head>
<TITLE>JSPサンプル</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=Windows-31J">
<LINK REL="stylesheet" TYPE="text/css" HREF="result.css">
</head>
	<body>
		<div id="<%=aniDAO.changeCLASS(int12id)%>"><!-- 動物毎に変更 -->
			<div class="frame">
				<!-- 12分類動物名 -->
				<div class="box1">
				<p class="title"><b><%=strName%></b>さんを動物でたとえると・・・</p>
				<p class="name"><%=aniDTO.getStr60Name()%> </p>
				<p class="desu">です！</p>
				<div class="animal"><img src="img/<%=aniDAO.changePictName(int12id)%>"></div>

				</div><!--box1"-->

				<!-- 占い詳細 -->
				<div class="box2">
				<p class="detail">
<%=aniDTO.getStrDetail()%>
				</p>

				</div><!--box2"-->

				<div class="box3">
				<p class="compatible">あなたと相性のいい動物は？</p>

				<!-- 恋人なら -->
				<p class="lover">*恋人なら*</p><p class="lovername">
<%=aniDTO.getStrLover_name()%></p>
				<div class="miniImg"><img src="img/<%=aniDTO.getStrLover_ad()%>"></div>
				<p class="ex">
<%=aniDTO.getStrLover_detail()%>
				</p>

				<!-- 友人なら -->
				<p class="friend">*友人なら*</p><p class="friendname"><%=aniDTO.getStrFriend_name()%></p>
				<div class="miniImg"><img src="img/<%=aniDTO.getStrFriend_ad()%>"></div>
				<p class="ex">
				<%=aniDTO.getStrFriend_detail()%>
				</p>

				<!-- 仕事仲間にするなら -->
				<p class="work">*仕事仲間にするなら*</p><p class="workname"><%=aniDTO.getStrWork_name()%></p>
				<div class="miniImg"><img src="img/<%=aniDTO.getStrWork_ad()%>"></div>
				<p class="ex_last">
				<%=aniDTO.getStrWork_detail()%>
				</p>
				</div><!--box3"-->

			</div><!--frame"-->

				<div class="button_box">
				 <a href="Animal_ftForm.jsp" class="linkButton">他の人を占う</a>
				</div>
		</div><!--monkey"-->
	</body>
</html>