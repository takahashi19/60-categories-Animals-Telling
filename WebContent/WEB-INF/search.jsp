
<%@ page contentType="text/html; charset=Windows-31J"%>
<%@ page import="modelPack.ProductEntity" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="Windows-31J">
<title>�X�E�B�[�c�����y�[�W</title>
</head>
<body>
    <h2>�X�E�B�[�c�����y�[�W</h2>

  <!-- form �^�O�̊��肪�����̂ŉ������{�^���ɂ���ēn�����p�����[�^���ς��
  �p�����[�^������paramid�Ȃ�h�c������ paramPrice�Ȃ���z�����Ȃǂ̓n�����p�����[�^�Ŕ��f -->
    <form action="control" method="post">
    <p>�����������X�E�B�[�cID����͂��Ă�������</p>
    <p>
    <input type="text" name="paramId" value="">
    <input type="submit" value="����">
    </p>
    </form>
    <%
    if (request.getAttribute("message")!=null){%>
    <p><%=(String)request.getAttribute("message") %></p>
    <%} %>
    <%if(request.getAttribute("sweets")!=null){%>
    <%
    ProductEntity ent=(ProductEntity)request.getAttribute("sweets");
    %>
    <h2>��������</h2>
    <table border="1">
    <tr><th>ID</th><th>���O</th><th>���z</th></tr>
    <tr><td><%=ent.getProduct_id() %></td><td><%=ent.getProduct_name() %></td><td><%=ent.getPrice() %></td></tr>
    </table>
    <%} %>

</body>
</html>