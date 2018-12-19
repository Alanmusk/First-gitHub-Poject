package service;

import java.util.List;

import entity.ApplyInfo;

public interface ApplyInfoService {
	
	/**
	 * ������Ŀ��ѯ���
	 * @param game
	 * @return
	 */
	public List<ApplyInfo> SearchApplyInfoByGame(String game);
	
	/**
	 * ���ݰ༶��ѯ���
	 * @param classRoom
	 * @return
	 */
	public List<ApplyInfo> SearchApplyInfoByClassRoom(String classRoom);
	
	/**
	 * ����
	 * @param applyInfo
	 * @return
	 */
	public boolean addApplyInfo(ApplyInfo applyInfo);
	
	/**
	 * ɾ��
	 * @param name
	 * @return
	 */
	public boolean removeApplyInfo(String name);
	
}
