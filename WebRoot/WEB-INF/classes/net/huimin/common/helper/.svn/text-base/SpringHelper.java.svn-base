package net.huimin.common.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

@Repository
public class SpringHelper implements ApplicationContextAware {

	private static ApplicationContext CONTEXT;

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		CONTEXT = arg0;
	}

	public static ApplicationContext Context() {
		return CONTEXT;
	}
}
