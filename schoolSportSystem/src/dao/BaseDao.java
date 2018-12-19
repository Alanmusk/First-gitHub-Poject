package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class BaseDao {
	//私有化静态属性，提高数据安全性
		private static String driver = null;
		private static String url = null;
		private static String user = null;
		private static String password = null;
		
		/**
		 * 把加载驱动类
		 * 封装成静态代码块
		 */
		static {
			Properties proper=new Properties();//Properties对象
			//加载属性配置文件到输入流中
			InputStream is=BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
			try {
				//通过load()方法把输入流加载到对象中
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
			//为静态变量赋值
			//通过键值对的方式,从对象中获取配置文件信息
			//通过所知的key(键)获取对应的值
			driver=proper.getProperty("driver");
			url=proper.getProperty("url");
			user=proper.getProperty("user");
			password=proper.getProperty("password");
		}
	
	protected Connection conn=null;
	protected PreparedStatement pstmt=null;
	protected ResultSet rs=null;
	
	/**
	 * 获得连接对象
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
		 * 关闭资源
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
		 * 查询
		 * @param sql
		 * @param params
		 * @return
		 */
		public ResultSet executeQuery(String sql,Object[] params) {
			getConnection();//调用连接获得对象
			try {
				pstmt=conn.prepareStatement(sql);
				//为占位符赋值
				if(null!=params) {
					for (int i = 0; i < params.length; i++) {
						pstmt.setObject(i+1, params[i]);
					}				
				}
				//获得查询结果集
				rs=pstmt.executeQuery();
			} catch (Exception e) {				
				e.printStackTrace();
			}
			return rs;			
		}
		
		/**
		 * 增删改操作
		 * 
		 */

		public int executeUpdate(String sql,Object[] params) {
			
			int result=-1;
			try {
				getConnection();//调用连接获得对象
				pstmt=conn.prepareStatement(sql);
				if(null!=params) {
					for (int i = 0; i < params.length; i++) {
						pstmt.setObject(i+1, params[i]);
					}
				}
				//调用方法
				result=pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				this.closeAll(conn, pstmt, rs);
			}
			return result;
		} 
}
