package net.huimin.common.mvc;

import java.sql.Connection;
import javax.sql.DataSource;
import net.huimin.common.helper.SpringHelper;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.annotation.Transactional;


import com.wabacus.config.database.datasource.AbsDataSource;
import com.wabacus.exception.WabacusRuntimeException;

@Transactional
public class ReportDataSource  extends AbsDataSource{
	
	private DataSource ds;   
	
	public ReportDataSource(){   
		this.ds =  (DataSource)SpringHelper.Context().getBean("DataSourceTarget");
    }   

	public Connection getConnection() {   
	
		try {   
	
			Connection conn = DataSourceUtils.doGetConnection(this.ds);
			return conn;
		} catch (Exception e) {   
			throw new WabacusRuntimeException("获取" + this.getName()   
		                    + "数据源的数据库连接失败", e);   
		}   
		
	}   

    public DataSource getDataSource() {   
            return this.ds;   
    }   
}
