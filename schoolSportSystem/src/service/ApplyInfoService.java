package service;

import java.util.List;

import entity.ApplyInfo;

public interface ApplyInfoService {
	
	/**
	 * 根据项目查询结果
	 * @param game
	 * @return
	 */
	public List<ApplyInfo> SearchApplyInfoByGame(String game);
	
	/**
	 * 根据班级查询结果
	 * @param classRoom
	 * @return
	 */
	public List<ApplyInfo> SearchApplyInfoByClassRoom(String classRoom);
	
	/**
	 * 新增
	 * @param applyInfo
	 * @return
	 */
	public boolean addApplyInfo(ApplyInfo applyInfo);
	
	/**
	 * 删除
	 * @param name
	 * @return
	 */
	public boolean removeApplyInfo(String name);
	
}
