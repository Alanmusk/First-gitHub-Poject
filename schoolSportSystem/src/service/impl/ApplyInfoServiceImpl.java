package service.impl;

import java.util.List;

import dao.ApplyInfoDao;
import dao.impl.ApplyInfoDaoImpl;
import entity.ApplyInfo;
import service.ApplyInfoService;

public class ApplyInfoServiceImpl implements ApplyInfoService {
	
	ApplyInfoDao applyInfoDao=new ApplyInfoDaoImpl();
	/**
	 * 根据项目查询结果
	 */
	@Override
	public List<ApplyInfo> SearchApplyInfoByGame(String game) {
		
		return applyInfoDao.findAllApplyInfoByGame(game);
	}

	/**
	 * 根据班级查询结果
	 */
	@Override
	public List<ApplyInfo> SearchApplyInfoByClassRoom(String classRoom) {
		
		return applyInfoDao.findAllApplyInfoByClassRoom(classRoom);
	}
	
	/**
	 * 新增
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
	 * 删除
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
