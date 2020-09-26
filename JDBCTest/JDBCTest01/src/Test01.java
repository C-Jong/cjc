import java.sql.*;

public class Test01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;

        try {
            //创建驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cjc","root","123");
            //获取数据库操作对象
            sta = conn.createStatement();
            //执行SQL语句
            String str = "select * from dept";
            rs = sta.executeQuery(str);
            //处理查询结果集
            while (rs.next()){
                int deptno = rs.getInt("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                System.out.println(deptno + "," + dname + "," + loc);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (sta != null){
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
