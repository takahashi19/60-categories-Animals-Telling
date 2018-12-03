<%@ page contentType="text/html; charset=Windows-31J"%>
<!DOCTYPE HTML>
<HTML><HEAD><TITLE>60分類動物占い</TITLE>
<LINK REL="stylesheet" TYPE="text/css" HREF="style.css">
   
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <!-- 自サイトのJavaScript -->
    <script src="js/main.js"></script>

</HEAD>
<body>
<div class="warpper">
<div class="warpper2">
<DIV CLASS="section">
<%-- <DIV CLASS="page"> --%>
<H1>60分類動物占い</H1>
<p>あなたを12種類の動物と60通りのパターンで占います！</p>



<div class="er">

<%
//セッション変数の取得
 if((String)session.getAttribute("error") != null){ %>
<%=(String)session.getAttribute("error")%>
<%}%>
</div>


<form action="Animal_ftResult.jsp" method="post">
<p class="p4">
<span>お名前</span>
<INPUT TYPE="text" NAME="name" size="20"></p>
<%-- </DIV> --%>
<p class="p2">
<%-- <a href="#" class="btn btn-primary">生年月日</a> --%>
<span>生年月日</span>
<INPUT  type="text" NAME="birth_year" size="4">

<B>年</B>
<input type="text" NAME="birth_month" size="1">
<B>月</B>
<input type="text" NAME="birth_day" size="1">
<b>日</b>
<p>
<div class="alert alert-warning" role="alert">西暦で入力してください</div>
<p class="p3">
<span>性別</span>
<INPUT TYPE="radio" NAME="sex" VALUE="m"><span class="span1">男性</span>
<INPUT TYPE="radio" NAME="sex" VALUE="f"><span class="span2">女性</span>
</p>
<div class="wrapper3">
<input type="submit" class="btn btn-default" value="占う">
</div>

</div>
</div>
</DIV>
</form>
 <script src="bootstrap/js/bootstrap.min.js"></script>
</BODY></HTML>
