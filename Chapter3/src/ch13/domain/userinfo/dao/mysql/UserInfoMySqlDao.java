package ch13.domain.userinfo.dao.mysql;

import ch13.domain.userinfo.UserInfo;
import ch13.domain.userinfo.dao.UserinfoDao;

public class UserInfoMySqlDao implements UserinfoDao{ //�̰Ŵ� Ŭ���̾�Ʈ�� ���ʿ䰡����. UserInfoDao�� ����ȴ�

	@Override
	public void insertUserInfo(UserInfo userInfo) {
		System.out.println("Insert into MySQL DB userID = " + userInfo.getUserId());
		
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		System.out.println("Update into MySQL DB userID = " + userInfo.getUserId());
		
	}

	@Override
	public void deleteUserInf(UserInfo userInfo) {
		System.out.println("Delete from MySQL DB where userID = " + userInfo.getUserId());
		
	}
	
}
