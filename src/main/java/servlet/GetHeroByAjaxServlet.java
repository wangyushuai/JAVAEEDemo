package servlet;

import bean.Hero;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangyushuai@fang.com on 2017/12/23.
 */
public class GetHeroByAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Hero hero = new Hero();
        hero.setName("后羿");
        hero.setHp(100);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("hero",JSONObject.fromObject(hero));
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
