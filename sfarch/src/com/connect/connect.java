package com.connect;
import java.sql.*;
import java.util.*;
public class connect {
	    PreparedStatement pstm=null;//这个是为了安全的技术
		Connection con =null;
		Statement sm=null;
		ResultSet rs=null;
		public Connection connect(){
			  Connection con = null;
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
		            con.close();
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

		public void doPstm(String sql,Object[] params){//如果params是空，那么就只是执行sql语句
			if(sql!=null&&!sql.equals("")){
				if(params==null)
					params=new Object[0];//if如果是没有打括号，作用的范围只有离他最近的一句话			
				connect();//调用上面的函数连接数据库
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
		}
		public ResultSet getRs() throws SQLException{
			//调用这个函数必须要先调用doPstm（）这样pstm里面就有值了。

			return pstm.getResultSet();		
		}
		public void closed(){
			try{
				if(pstm!=null)
					pstm.close();			
			}catch(SQLException e){
				System.out.println("关闭pstm对象失败！");
				e.printStackTrace();
			}
			try{
				if(con!=null){
					con.close();
				}
			}catch(SQLException e){
				System.out.println("关闭con对象失败！");
				e.printStackTrace();
			}
		}
			
		}
	




