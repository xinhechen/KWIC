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
	PreparedStatement pstm=null;//�����Ϊ�˰�ȫ�ļ���
	Connection con =null;
	Statement sm=null;
	ResultSet rs=null;
	public Connection connect(){
		 //����Connection����
        System.out.print("������");
        //����������
        String driver = "com.mysql.jdbc.Driver";
        //URLָ��Ҫ���ʵ����ݿ���mydata
        String url = "jdbc:mysql://localhost:3306/sf";
        //MySQL����ʱ���û���
        String user = "root";
        //MySQL����ʱ������
        String password = "root";
        //������ѯ�����
        try {
            //������������
            Class.forName("com.mysql.jdbc.Driver");
            //1.getConnection()����������MySQL���ݿ⣡��
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("���ݿ����ӳɹ�");
        } catch(ClassNotFoundException e) {   
            //���ݿ��������쳣����
            System.out.println("���ݿ�����ʧ��");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //���ݿ�����ʧ���쳣����
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
						pstm.setObject(i+1,params[i]);//sql�������ĵ�i+1���ʺŵ�ֵ��params[i]
					}
					pstm.execute();//���ֵ�ķ����ں���ĺ�������
					System.out.println("sql���ɹ�"+sql);
				}catch(SQLException e){
					System.out.println("doPstm()��������");
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
