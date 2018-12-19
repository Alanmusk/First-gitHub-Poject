package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class BaseDao {
	//˽�л���̬���ԣ�������ݰ�ȫ��
		private static String driver = null;
		private static String url = null;
		private static String user = null;
		private static String password = null;
		
		/**
		 * �Ѽ���������
		 * ��װ�ɾ�̬�����
		 */
		static {
			Properties proper=new Properties();//Properties����
			//�������������ļ�����������
			InputStream is=BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
			try {
				//ͨ��load()���������������ص�������
				proper.load(is);
			} catch (IOException e) {			
				e.printStackTrace();
			}finally {
				try {
					if(null!=is) {
						is.close();
					}				
				} catch (IOException e) {				
					e.printStackTrace();
				}
			}
			//Ϊ��̬������ֵ
			//ͨ����ֵ�Եķ�ʽ,�Ӷ����л�ȡ�����ļ���Ϣ
			//ͨ����֪��key(��)��ȡ��Ӧ��ֵ
			driver=proper.getProperty("driver");
			url=proper.getProperty("url");
			user=proper.getProperty("user");
			password=proper.getProperty("password");
		}
	
	protected Connection conn=null;
	protected PreparedStatement pstmt=null;
	protected ResultSet rs=null;
	
	/**
	 * ������Ӷ���
	 * @return
	 */
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
		
		/**
		 * �ر���Դ
		 * @param conn
		 * @param pstmt
		 * @param rs
		 */
		public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs) {
					
				try {
					if(null!=conn) {
						conn.close();
					}					
				} catch (Exception e) {					
					e.printStackTrace();				
			}
				
				try {
					if(null!=pstmt) {
						pstmt.close();
					}					
				} catch (Exception e) {					
					e.printStackTrace();				
			}
				
				try {
					if(null!=rs) {
						rs.close();
					}					
				} catch (Exception e) {					
					e.printStackTrace();				
			}
		}
		
		/**
		 * ��ѯ
		 * @param sql
		 * @param params
		 * @return
		 */
		public ResultSet executeQuery(String sql,Object[] params) {
			getConnection();//�������ӻ�ö���
			try {
				pstmt=conn.prepareStatement(sql);
				//Ϊռλ����ֵ
				if(null!=params) {
					for (int i = 0; i < params.length; i++) {
						pstmt.setObject(i+1, params[i]);
					}				
				}
				//��ò�ѯ�����
				rs=pstmt.executeQuery();
			} catch (Exception e) {				
				e.printStackTrace();
			}
			return rs;			
		}
		
		/**
		 * ��ɾ�Ĳ���
		 * 
		 */

		public int executeUpdate(String sql,Object[] params) {
			
			int result=-1;
			try {
				getConnection();//�������ӻ�ö���
				pstmt=conn.prepareStatement(sql);
				if(null!=params) {
					for (int i = 0; i < params.length; i++) {
						pstmt.setObject(i+1, params[i]);
					}
				}
				//���÷���
				result=pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				this.closeAll(conn, pstmt, rs);
			}
			return result;
		} 
}
