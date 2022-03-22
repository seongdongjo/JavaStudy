package ch13.web.userinfo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import ch13.domain.userinfo.UserInfo;
import ch13.domain.userinfo.dao.UserinfoDao;
import ch13.domain.userinfo.dao.mysql.UserInfoMySqlDao;
import ch13.domain.userinfo.dao.oracle.UserInfoOracleDao;

public class UserInfoClient {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("db.properties");
		
		Properties prop = new Properties();
		prop.load(fis);

		String dbType = prop.getProperty("DBTYPE"); //key를 적으면 value를 반환해준다.
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId("12345");
		userInfo.setPasswd("!@#$%");
		userInfo.setUserName("이순신");
		
		
		UserinfoDao userInfoDao = null; //인터페이스타입으로 선언
		
		if(dbType.equals("ORACLE")){ //이런게다형성이다. 하나의인터페이스(userInfoDao)에서 
			userInfoDao = new UserInfoOracleDao();
		}
		else if(dbType.equals("MYSQL")){
			userInfoDao = new UserInfoMySqlDao();
		}
		else{
			System.out.println("db support error");
			return;
		}
		
		userInfoDao.insertUserInfo(userInfo);
		userInfoDao.updateUserInfo(userInfo);
		userInfoDao.deleteUserInf(userInfo);
	}

}
