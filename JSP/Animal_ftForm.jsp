<%@ page contentType="text/html; charset=Windows-31J"%>
<!DOCTYPE HTML>
<HTML><HEAD><TITLE>60���ޓ����肢</TITLE>
<LINK REL="stylesheet" TYPE="text/css" HREF="style.css">
   
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <!-- ���T�C�g��JavaScript -->
    <script src="js/main.js"></script>

</HEAD>
<body>
<div class="warpper">
<div class="warpper2">
<DIV CLASS="section">
<%-- <DIV CLASS="page"> --%>
<H1>60���ޓ����肢</H1>
<p>���Ȃ���12��ނ̓�����60�ʂ�̃p�^�[���Ő肢�܂��I</p>



<div class="er">

<%
//�Z�b�V�����ϐ��̎擾
 if((String)session.getAttribute("error") != null){ %>
<%=(String)session.getAttribute("error")%>
<%}%>
</div>


<form action="Animal_ftResult.jsp" method="post">
<p class="p4">
<span>�����O</span>
<INPUT TYPE="text" NAME="name" size="20"></p>
<%-- </DIV> --%>
<p class="p2">
<%-- <a href="#" class="btn btn-primary">���N����</a> --%>
<span>���N����</span>
<INPUT  type="text" NAME="birth_year" size="4">

<B>�N</B>
<input type="text" NAME="birth_month" size="1">
<B>��</B>
<input type="text" NAME="birth_day" size="1">
<b>��</b>
<p>
<div class="alert alert-warning" role="alert">����œ��͂��Ă�������</div>
<p class="p3">
<span>����</span>
<INPUT TYPE="radio" NAME="sex" VALUE="m"><span class="span1">�j��</span>
<INPUT TYPE="radio" NAME="sex" VALUE="f"><span class="span2">����</span>
</p>
<div class="wrapper3">
<input type="submit" class="btn btn-default" value="�肤">
</div>

</div>
</div>
</DIV>
</form>
 <script src="bootstrap/js/bootstrap.min.js"></script>
</BODY></HTML>
