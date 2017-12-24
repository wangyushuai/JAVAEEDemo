package servlet;

import bean.Hero;
import dao.HeroDAO;
import net.sf.json.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by wangyushuai@fang.com on 2017/12/23.
 */
public class GetHeroesByAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Hero> heroes = new HeroDAO().list(0,Short.MAX_VALUE);
        String result = JSONSerializer.toJSON(heroes).toString();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
