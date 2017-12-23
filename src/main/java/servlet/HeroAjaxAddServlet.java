package servlet;

import bean.Hero;
import dao.HeroDAO;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangyushuai@fang.com on 2017/12/23.
 */
public class HeroAjaxAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String data = request.getParameter("data");
        System.out.println("服务端接收到的数据为："  + data);
        JSONObject json = JSONObject.fromObject(data);
        System.out.println("转换为JSON对象之后是:" + json);
        Hero hero = (Hero) json.toBean(json,Hero.class);

        //write db
        new HeroDAO().add(hero);
        System.out.println(hero.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
