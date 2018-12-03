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


//null����----------------------------------
		if (strName == null || strYear==null || strMonth == null || strDay == null){
//�Z�b�V�����ϐ���o�^
			String strError = "���@�L���R�ꂪ����܂��@��";
			session.setAttribute("error",strError);
			response.sendRedirect("Animal_ftForm.jsp");
			return;
		}
		boolean checker = false;
//�uint�^�v�ɕϊ��ł��邩�Ŕ���-------------

		try{
			intYear  = Integer.parseInt(strYear);
			intMonth = Integer.parseInt(strMonth);
			intDay   = Integer.parseInt(strDay);
		}catch(NumberFormatException e){
//�Z�b�V�����ϐ���o�^
			String strError = "���@���N�����͐�������͂��Ă��������@��";
			session.setAttribute("error",strError);
			response.sendRedirect("Animal_ftForm.jsp");
			return;
		}
//�J�����_�[�̔N�����ƍ���������-------------
		boolean a = calendar_check.checker(intYear, intMonth, intDay);
		if (a){
			String strError = "���@���N����������������܂���@��";
			session.setAttribute("error",strError);
			response.sendRedirect("Animal_ftForm.jsp");
			return;
		}

//Animal_DAO�̃��\�b�h�����s���邽�߃C���X�^���X������
		animal_ft.Animal_DAO  aniDAO = new animal_ft.Animal_DAO();


//60���ނ��v�Z
		int id = aniDAO.cal60_ft(intYear, intMonth, intDay);

//�肢���ʂ��󂯎��C���X�^���X������
		animal_ft.Animal_DTO  aniDTO = new animal_ft.Animal_DTO();


//����Ă݂�---------------------------------
   try{
		aniDTO = aniDAO.fortune_ft(id, strSex);
   }catch(NullPointerException e){
			String strError = "���@�肢���ʂ��o���܂���@��";
			session.setAttribute("error",strError);
			response.sendRedirect("Animal_ftForm.jsp");
			return;
   }catch(Exception e){
			String strError = "���@�s���̃G���[�ł��@��";
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
<TITLE>JSP�T���v��</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=Windows-31J">
<LINK REL="stylesheet" TYPE="text/css" HREF="result.css">
</head>
	<body>
		<div id="<%=aniDAO.changeCLASS(int12id)%>"><!-- �������ɕύX -->
			<div class="frame">
				<!-- 12���ޓ����� -->
				<div class="box1">
				<p class="title"><b><%=strName%></b>����𓮕��ł��Ƃ���ƁE�E�E</p>
				<p class="name"><%=aniDTO.getStr60Name()%> </p>
				<p class="desu">�ł��I</p>
				<div class="animal"><img src="img/<%=aniDAO.changePictName(int12id)%>"></div>

				</div><!--box1"-->

				<!-- �肢�ڍ� -->
				<div class="box2">
				<p class="detail">
<%=aniDTO.getStrDetail()%>
				</p>

				</div><!--box2"-->

				<div class="box3">
				<p class="compatible">���Ȃ��Ƒ����̂��������́H</p>

				<!-- ���l�Ȃ� -->
				<p class="lover">*���l�Ȃ�*</p><p class="lovername">
<%=aniDTO.getStrLover_name()%></p>
				<div class="miniImg"><img src="img/<%=aniDTO.getStrLover_ad()%>"></div>
				<p class="ex">
<%=aniDTO.getStrLover_detail()%>
				</p>

				<!-- �F�l�Ȃ� -->
				<p class="friend">*�F�l�Ȃ�*</p><p class="friendname"><%=aniDTO.getStrFriend_name()%></p>
				<div class="miniImg"><img src="img/<%=aniDTO.getStrFriend_ad()%>"></div>
				<p class="ex">
				<%=aniDTO.getStrFriend_detail()%>
				</p>

				<!-- �d�����Ԃɂ���Ȃ� -->
				<p class="work">*�d�����Ԃɂ���Ȃ�*</p><p class="workname"><%=aniDTO.getStrWork_name()%></p>
				<div class="miniImg"><img src="img/<%=aniDTO.getStrWork_ad()%>"></div>
				<p class="ex_last">
				<%=aniDTO.getStrWork_detail()%>
				</p>
				</div><!--box3"-->

			</div><!--frame"-->

				<div class="button_box">
				 <a href="Animal_ftForm.jsp" class="linkButton">���̐l��肤</a>
				</div>
		</div><!--monkey"-->
	</body>
</html>