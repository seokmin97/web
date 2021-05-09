package kr.mjc.hongseokmin.web.mvc;

import kr.mjc.hongseokmin.web.dao.Article;
import kr.mjc.hongseokmin.web.dao.ArticleDao;
import kr.mjc.hongseokmin.web.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ArticleController {

    private final ArticleDao articleDao;

    @Autowired
    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    /**
     * article list 화면
     */
    public void articleList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("articleList", articleDao.listArticles(0, 100));

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleList.jsp")
                .forward(request, response);
    }
    /**
     * article Deatil 화면 //오타주의오타주의오타주의오타주의오타주의오타주의오타주의오타주의오타주의오타주의
     */
    public void articleDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("articleDeatil",articleDao.getArticle(391));
        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleDeatil.jsp")
                .forward(request, response);
    }
    /**
     * article 글 추가
     */

    public  void articleAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("USER");
        Article article = new Article();
        article.setUserId(user.getUserId());
        article.setTitle(request.getParameter("title"));
        article.setName(request.getParameter("name"));
        article.setContent(request.getParameter("content"));
        articleDao.addArticle(article);
        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleAdd.jsp");
    }
}



