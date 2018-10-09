package com.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MysqlConnect {
	PreparedStatement pstm=null;//这个是为了安全的技术
	Connection con =null;
	Statement sm=null;
	ResultSet rs=null;
	public Connection connect(){
		 //声明Connection对象
        System.out.print("进来了");
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/sf";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "root";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("数据库连接成功");
        } catch(ClassNotFoundException e) {   
            //数据库驱动类异常处理
            System.out.println("数据库驱动失败");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return con;			
		
	}
	public void doPost(String sql){
		
			Object params[]={};
			if(con!=null){
				try{		
					System.out.println(sql);
					pstm=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					for(int i=0;i<params.length;i++){
						pstm.setObject(i+1,params[i]);//sql语句里面的第i+1个问号的值是params[i]
					}
					pstm.execute();//这个值的返回在后面的函数调用
					System.out.println("sql语句成功"+sql);
				}catch(SQLException e){
					System.out.println("doPstm()方法出错！");
					e.printStackTrace();
				}				
			}
			
	}
	public List<String> getresult(){
		List<String> result = new ArrayList<String>();
		ResultSet rs=null;
		try {
			rs = pstm.getResultSet();
			if(rs!=null){
				while(rs.next()){
					String input = rs.getString(1);
					result.add(input);
				}
				rs.close();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return result;
	}
	public void close(){
		 try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
