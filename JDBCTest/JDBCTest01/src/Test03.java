import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        //初始化一个界面
        Map<String,String> UserLoginInfo = initUI();

        //验证用户名和密码
        boolean loginSuccsee = login(UserLoginInfo);

        //输出登陆结果
        System.out.println(loginSuccsee ? "登陆成功！" : "登陆失败!");
    }

    /*
    * 用户登陆
    * userLoginInfo 用户登陆信息
    * return 登陆结果 true表示成功 false表示失败
    * */

    private static boolean login(Map<String, String> userLoginInfo) {
        //打标记
        boolean loginSuccess = false;
        //JDBC代码
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //1.创建驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cjc","root","123");
            //3.获取数据库操作对象
            stat = conn.createStatement();
            //4.执行SQL语句
            String strSQL = "select * from t_user where uName = '"+userLoginInfo.get("uName")+"' and uPwd ='"+userLoginInfo.get("uPwd")+"' ";
            rs = stat.executeQuery(strSQL);
            //5.处理查询结果集
            if (rs.next()){
                loginSuccess = true;

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //6.关闭资源
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

        return loginSuccess;
    }

    /*
    *初始化用户界面
    *@return 用户输入的用户名的密码等登陆信息
    *
    * */
    private static Map<String, String> initUI() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String uName = s.nextLine();
        System.out.println("请输入密码:");
        String uPwd = s.nextLine();

        Map<String,String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("uName",uName);
        userLoginInfo.put("uPwd",uPwd);

        return userLoginInfo;
    }
}
