<%@ page import="kr.mjc.hongseokmin.web.dao.Article" %>
<!DOCTYPE html>
<html>
<body>
<h3>게시글</h3>
<form action="<%=action%>" method="post">
    <input type="hidden" name="articleId" value="<%=articleId%>" />
    <p><input type="text" name="title" placeholder="제목" value="<%=title%>" required autofocus/>
    </p>
    <p><input type="text" name="name" placeholder="이름" value="<%=name%>" required/></p>
    <p><textarea name="content" title="내용" cols="80" rows="20"><%=content%></textarea>
    <p>
        <button type="submit"><%=modify ? "수정" : "저장"%></button>
    </p>
</form>
<p style="color:red;"><%= Optional.ofNullable(request.getParameter("msg"))
        .orElse("")%>
</p>
</body>
</html>