package net.huimin.yk.web.actions.admin;

import net.huimin.common.mvc.AbstractAction;
import net.huimin.common.page.PageBean;
import net.huimin.yk.web.model.customer.CustomerApplication;
import net.huimin.yk.web.services.common.AccountService;
import net.huimin.yk.web.services.common.CommonService;
import net.huimin.yk.web.services.customer.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 账户资金管理
 * @author Administrator
 *
 */
public class AccountAction extends AbstractAction{

	@Autowired
	private AccountService accountService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private CustomerService customerService;
	
	public String open() {
		//commonService.queryCustomerCountByAgentId(1);
		
		CustomerApplication customerApplication = new CustomerApplication();
		customerApplication.setAgentId(29);
		customerApplication.setEffectType(1);
		
        PageBean bean = this.getPage();
        bean.setStart(0);
        bean.setOffset(100);
        
		customerService.queryCustomerListForPage(bean, customerApplication);
		
		return "";
	}
}
