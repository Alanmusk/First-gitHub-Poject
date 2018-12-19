package dao;

import java.util.List;

import entity.ApplyInfo;

public interface ApplyInfoDao {
	
	/**
	 * 根据项目查询结果
	 * @param game
	 * @return
	 */
	public List<ApplyInfo> findAllApplyInfoByGame(String game);
	
	/**
	 * 根据班级查询结果
	 * @param classRoom
	 * @return
	 */
	public List<ApplyInfo> findAllApplyInfoByClassRoom(String classRoom);
	
	/**
	 * 新增
	 * @param applyInfo
	 * @return
	 */
	public int insertApplyInfo(ApplyInfo applyInfo);
	
	/**
	 * 删除
	 * @param name
	 * @return
	 */
	public int deleteApplyInfo(String name);
	
	
	
	
}
