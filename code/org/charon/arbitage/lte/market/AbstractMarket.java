package org.charon.arbitage.lte.market;

import org.charon.arbitage.inter.IBroker;

public abstract class AbstractMarket implements IBroker {

	/*
	 * �û���
	 */
	String userName;
	/*
	 * ����
	 */
	String password;
	
	AbstractMarket(String userName, String password){
		this.initUserAccount(userName, password);
	}
	

	public void initUserAccount(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
}
