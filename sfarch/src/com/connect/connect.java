package com.connect;
import java.sql.*;
import java.util.*;
public class connect {
	    PreparedStatement pstm=null;//�����Ϊ�˰�ȫ�ļ���
		Connection con =null;
		Statement sm=null;
		ResultSet rs=null;
		public Connection connect(){
			  Connection con = null;
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
		            con.close();
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

		public void doPstm(String sql,Object[] params){//���params�ǿգ���ô��ֻ��ִ��sql���
			if(sql!=null&&!sql.equals("")){
				if(params==null)
					params=new Object[0];//if�����û�д����ţ����õķ�Χֻ�����������һ�仰			
				connect();//��������ĺ����������ݿ�
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
		}
		public ResultSet getRs() throws SQLException{
			//���������������Ҫ�ȵ���doPstm��������pstm�������ֵ�ˡ�

			return pstm.getResultSet();		
		}
		public void closed(){
			try{
				if(pstm!=null)
					pstm.close();			
			}catch(SQLException e){
				System.out.println("�ر�pstm����ʧ�ܣ�");
				e.printStackTrace();
			}
			try{
				if(con!=null){
					con.close();
				}
			}catch(SQLException e){
				System.out.println("�ر�con����ʧ�ܣ�");
				e.printStackTrace();
			}
		}
			
		}
	




