package net.huimin.yk.channel.msg;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*.xml")
public class TestMsg {

	@Resource
	private MessageAPI api;
	
	@Test
	public void test1(){
		System.out.println(this.api.send("13605179121", "[房小帅]短信测试" + String.valueOf(new Date().getTime())));;
	}
	
	@Test
	public void test2(){
		//System.out.println(this.api.sendValidateCode("13605179121",1));
	}
	
	@Test
	public void test3(){
		//System.out.println(this.api.validateCode("18351888522", "5200"));
	}
	
}
