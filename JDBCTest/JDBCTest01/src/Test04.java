import java.sql.*;
import java.util.Scanner;

public class Test04 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int dno;
        Scanner s = new Scanner(System.in);
        System.out.println("请输入您要查询的部门编号(10/20/30/40):");
        dno = s.nextInt();
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cjc","root","123");
            //获取预编译数据库操作对象
            String strSQL = "select * from emp where deptno = ?";
            ps = conn.prepareStatement(strSQL);
            //执行SQL语句
            ps.setInt(1,dno);
            System.out.println("员工编号" + "\t" + "员工姓名" + "\t" + "部门编号" + "\t" + "薪资" + "\t\t" + "职业");
            //处理查询结果集
            rs = ps.executeQuery();
            while (rs.next()){
                String empno = rs.getString("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                String sal = rs.getString("sal");
                String deptno = rs.getString("deptno");
                System.out.println(empno + "\t" + ename + "\t" + deptno + "\t\t" + sal + "\t" + job);


            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
