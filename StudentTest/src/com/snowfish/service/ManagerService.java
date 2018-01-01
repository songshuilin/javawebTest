package com.snowfish.service;

import com.snowfish.dao.ManagerDao;
import com.snowfish.dao.ManagerDaoByMybaties;
import com.snowfish.domain.Manager;

public class ManagerService {
	// ManagerDao dao=new ManagerDao();
	ManagerDaoByMybaties dao=new ManagerDaoByMybaties();
      public void regist(Manager manager) {
    	  dao.add(manager);
      }
      public boolean find(Manager manager) {
    	  return dao.find(manager);
      }
}
