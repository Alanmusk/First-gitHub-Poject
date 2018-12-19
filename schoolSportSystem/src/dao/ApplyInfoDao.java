package dao;

import java.util.List;

import entity.ApplyInfo;

public interface ApplyInfoDao {
	
	/**
	 * ������Ŀ��ѯ���
	 * @param game
	 * @return
	 */
	public List<ApplyInfo> findAllApplyInfoByGame(String game);
	
	/**
	 * ���ݰ༶��ѯ���
	 * @param classRoom
	 * @return
	 */
	public List<ApplyInfo> findAllApplyInfoByClassRoom(String classRoom);
	
	/**
	 * ����
	 * @param applyInfo
	 * @return
	 */
	public int insertApplyInfo(ApplyInfo applyInfo);
	
	/**
	 * ɾ��
	 * @param name
	 * @return
	 */
	public int deleteApplyInfo(String name);
	
	
	
	
}
