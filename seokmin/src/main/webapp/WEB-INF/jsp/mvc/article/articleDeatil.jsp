<%@ page import="kr.mjc.hongseokmin.web.dao.Article" %>
<!DOCTYPE html>
<% Article article = (Article) request.getAttribute("articleDeatil"); %>
<html>
<body>
<h3>아티클 상세보기</h3>

<p><%=article%></p>
</body>
</html>