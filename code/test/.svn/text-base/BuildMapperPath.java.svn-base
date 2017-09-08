package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 配置文件生成类，mybatis.xml，spring-dao配置文件有变动执行该类
 *
 */
public class BuildMapperPath
{
    public static void main(String[] args)
    {
        File root = new File(FILE_PATH + "\\mappers");
        File[] models = root.listFiles();
        StringBuffer buffer2 = new StringBuffer();
        for (int i = 0; i < models.length; i++)
        {
            if (models[i].isDirectory())
            {
                File[] tables = models[i].listFiles();
                for (int j = 0; j < tables.length; j++)
                {
                    if (!models[i].getName().equals("response"))
                    {
                        buffer2.append("\t<bean id=\"");
                        buffer2.append(tables[j].getName().substring(0, tables[j].getName().indexOf(".")));
                        buffer2.append("\" class=\"org.mybatis.spring.mapper.MapperFactoryBean\">");
                        buffer2.append("<property name=\"mapperInterface\" value=\"net.huimin.yk.web.dao.");
                        buffer2.append(models[i].getName()).append(".");
                        buffer2.append(tables[j].getName().substring(0, tables[j].getName().indexOf(".")));
                        buffer2.append("\" /></bean>\n");
                    }
                }
            }
        }
        
        String springDaoFile = SPRING_DAO.replace("@springDao", buffer2.toString());
        
        // 写成配置文件
        writeFile(springDaoFile);
        
        // 角色添加需要获取自动增长Id
        //replaceGeneratedKeys("system/RoleMapper.xml");
        
        System.out.println("BuildMapper file success!");
    }
    
    
    /**
     * 写入mybatis.xml spring-dao.xml文件
     * @param mybatisFile mybatisFile文件内容
     * @param springDaoFile spring-dao文件内容
     */
    private static void writeFile(String springDaoFile)
    {
        try
        {
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(FILE_PATH + "\\spring\\spring-dao.xml"), false));
            bw.write(springDaoFile);
            
            bw.flush();
            bw.close();
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * spring-dao.xml配置文件内容
     */
    private static String SPRING_DAO = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
            + "\r\n"
            + "<beans xmlns=\"http://www.springframework.org/schema/beans\""
            + "\r\n"
            + "	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:context=\"http://www.springframework.org/schema/context\""
            + "\r\n"
            + "	xmlns:aop=\"http://www.springframework.org/schema/aop\" xmlns:tx=\"http://www.springframework.org/schema/tx\""
            + "\r\n" + "	xsi:schemaLocation=\"http://www.springframework.org/schema/beans" + "\r\n"
            + "           http://www.springframework.org/schema/beans/spring-beans-3.0.xsd" + "\r\n"
            + "           http://www.springframework.org/schema/aop " + "\r\n"
            + "           http://www.springframework.org/schema/aop/spring-aop-3.0.xsd" + "\r\n"
            + "           http://www.springframework.org/schema/tx" + "\r\n"
            + "     	   http://www.springframework.org/schema/tx/spring-tx-3.0.xsd" + "\r\n"
            + "           http://www.springframework.org/schema/context" + "\r\n"
            + "           http://www.springframework.org/schema/context/spring-context-3.0.xsd\">" + "\r\n"
            + "@springDao" + "</beans>" + "\r\n";
    
    /**
     * 文件基础路径
     */
   private static String FILE_PATH = "F:\\富久贷\\trunk\\Source\\P2PFlatform\\config";
}
