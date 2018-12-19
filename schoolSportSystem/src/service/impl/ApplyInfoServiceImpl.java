package service.impl;

import java.util.List;

import dao.ApplyInfoDao;
import dao.impl.ApplyInfoDaoImpl;
import entity.ApplyInfo;
import service.ApplyInfoService;

public class ApplyInfoServiceImpl implements ApplyInfoService {
	
	ApplyInfoDao applyInfoDao=new ApplyInfoDaoImpl();
	/**
	 * ������Ŀ��ѯ���
	 */
	@Override
	public List<ApplyInfo> SearchApplyInfoByGame(String game) {
		
		return applyInfoDao.findAllApplyInfoByGame(game);
	}

	/**
	 * ���ݰ༶��ѯ���
	 */
	@Override
	public List<ApplyInfo> SearchApplyInfoByClassRoom(String classRoom) {
		
		return applyInfoDao.findAllApplyInfoByClassRoom(classRoom);
	}
	
	/**
	 * ����
	 */
	@Override
	public boolean addApplyInfo(ApplyInfo applyInfo) {
		int result=applyInfoDao.insertApplyInfo(applyInfo);
		if(result!=-1) {
			return true;
		}
		return false;
	}

	/**
	 * ɾ��
	 */
	@Override
	public boolean removeApplyInfo(String name) {
		int result=applyInfoDao.deleteApplyInfo(name);
		if(result!=-1) {
			return true;
		}
		return false;
	}

}
