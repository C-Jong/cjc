import java.sql.*;

public class Test02 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //创建驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cjc","root","123");
            //获取数据库操作对象
            statement = connection.createStatement();
            //执行SQL语句
            String strSQL = "select * from dept";
            resultSet = statement.executeQuery(strSQL);
            //处理查询结果集
            while (resultSet.next()){
                String deptno = resultSet.getString("deptno");
                String dname = resultSet.getString("dname");
                String loc = resultSet.getString("loc");
                System.out.println(deptno +"," +dname + "," + loc);
            }
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //关闭资源
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if (statement != null){
                try {
                   statement.close();
                 } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}












