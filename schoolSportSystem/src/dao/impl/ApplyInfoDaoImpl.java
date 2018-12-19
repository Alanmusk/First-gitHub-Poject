package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ApplyInfoDao;
import dao.BaseDao;
import entity.ApplyInfo;

public class ApplyInfoDaoImpl extends BaseDao implements ApplyInfoDao {
	
	/**
	 * 根据项目查询结果
	 */
	@Override
	public List<ApplyInfo> findAllApplyInfoByGame(String game) {
		
		String sql="SELECT applyId,`name`,age,classRoom,game FROM apply_info WHERE game=?";
		Object[] params= {game};
		ArrayList<ApplyInfo> list=null;
		try {
			rs=this.executeQuery(sql, params);
			if(rs!=null) {
				
				list=new ArrayList<ApplyInfo>();
				while(rs.next()) {
					ApplyInfo applyInfo=new ApplyInfo();
					applyInfo.setApplyId(rs.getInt("applyId"));
					applyInfo.setName(rs.getString("name"));
					applyInfo.setAge(rs.getInt("age"));
					applyInfo.setClassRoom(rs.getString("classRoom"));
					applyInfo.setGame(rs.getString("game"));
					list.add(applyInfo);
				}
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			this.closeAll(conn, pstmt, rs);			
		}
		
		return list;
	}

	/**
	 * 根据班级查询结果
	 */
	@Override
	public List<ApplyInfo> findAllApplyInfoByClassRoom(String classRoom) {
		
		String sql="SELECT applyId,`name`,age,classRoom,game FROM apply_info WHERE classRoom=?";
		Object[] params= {classRoom};
		ArrayList<ApplyInfo> list=null;
		try {
			rs=this.executeQuery(sql, params);
			if(rs!=null) {
				
				list=new ArrayList<ApplyInfo>();
				while(rs.next()) {
					ApplyInfo applyInfo=new ApplyInfo();
					applyInfo.setApplyId(rs.getInt("applyId"));
					applyInfo.setName(rs.getString("name"));
					applyInfo.setAge(rs.getInt("age"));
					applyInfo.setClassRoom(rs.getString("classRoom"));
					applyInfo.setGame(rs.getString("game"));
					list.add(applyInfo);
				}
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	/**
	 * 新增
	 */
	@Override
	public int insertApplyInfo(ApplyInfo applyInfo) {
		String sql="INSERT INTO apply_info(applyId,`name`,age,classRoom,game) VALUES(DEFAULT,?,?,?,?)";
		Object[] params= {applyInfo.getName(),applyInfo.getAge(),applyInfo.getClassRoom(),applyInfo.getGame()};
		
		int result=-1;		
		 try {
			result=this.executeUpdate(sql,params);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return result;
	}

	/**
	 * 删除
	 */
	@Override
	public int deleteApplyInfo(String name) {
		String sql="DELETE FROM apply_info WHERE name=?";
		Object[] params= {name};
		int result=-1;
		try {
			result=this.executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
