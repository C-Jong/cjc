import java.sql.*;
public class Test05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        String strSQL = "SELECT * FROM Categories";

        try {
            //注册驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:sqlserver://192.168.226.240:1433;DatabaseName=northwind",
                    "sa", "123456a@");
            //获取数据库操作对象
            stat = conn.createStatement();
            //执行SQL语句
            rs = stat.executeQuery(strSQL);
            //处理查询结果集
            while (rs.next()){
                int categoryID = rs.getInt("CategoryID");
                String categoryName = rs.getString("CategoryName");
                System.out.println(categoryID + "\t" + categoryName);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        //关闭资源
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stat != null){
            try {
                stat.close();
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
