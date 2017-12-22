package dao;

import bean.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyushuai@fang.com on 2017/12/21.
 */
public class HeroDAO {
    public HeroDAO() {
       try {
           Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/_local_test?characterEncoding=UTF-8","root","root");
    }

    /**
     * 获取总数
     * @return
     */
    public int getTotal() {
        int total = 0;
        try(Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select count(*) from hero";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    /**
    * 获取列表
    * @param start : 开始行
     *@param count: 行
    */
    public List<Hero> list(int start, int count) {
        List<Hero> heros = new ArrayList<Hero>();
        String sql = "select * from hero order by id desc limit ?,?";
        try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hero hero = new Hero();
                hero.setId(rs.getInt(1));
                hero.setName(rs.getString("name"));
                hero.setHp(rs.getFloat("hp"));
                hero.setDamage(rs.getInt("damage"));
                heros.add(hero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heros;
    }

    /**
     * 添加
     * @param hero 实体
     */
    public void add(Hero hero) {
        String sql = "insert into hero values(null,?,?,?)";
        try(Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,hero.getName());
            ps.setFloat(2,hero.getHp());
            ps.setInt(3,hero.getDamage());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                hero.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
