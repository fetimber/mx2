package net.huimin.yk.web.actions.admin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import net.huimin.common.cnst.ConstConfig;
import net.huimin.common.helper.Judge;
import net.huimin.common.mvc.AbstractAction;
import net.huimin.yk.web.model.common.Config;
import net.huimin.yk.web.model.common.WechatButton;
import net.huimin.yk.web.model.system.WechatAuto;
import net.huimin.yk.web.model.system.WechatConfig;
import net.huimin.yk.web.services.common.CommonService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.sword.lang.HttpUtils;
import org.sword.wechat4j.token.TokenProxy;

/**
 * 配置管理
 * @author Administrator
 */
public class ConfigAction extends AbstractAction {

	private String openRed;

	private String redMax;

	private String redMin;

	private String frozenPer;

	private String frozenOrd;

	private WechatConfig config;

	private WechatAuto auto;
	
	private String old_url,new_url;
	
	@Autowired
	private CommonService commonService;

	public String setting_base() {
		// 加载参数
		this.config = WechatConfig.load();
		return "setting-base";
	}

	public String setting_base_save() {
		// 写入新的配置文件
		try {
			Properties p = new Properties();

			String p_path = System.getProperty("app.root.yk").concat(File.separator).concat("WEB-INF").concat(File.separator).concat("classes").concat(File.separator).concat("other").concat(File.separator).concat("wechat4j.properties");
			InputStream inStream = new FileInputStream(new File(p_path));
			p.load(inStream);
			inStream.close();
			p.setProperty("wechat.url", this.config.getUrl());
			p.setProperty("wechat.token", this.config.getToken());
			p.setProperty("wechat.encodingaeskey", this.config.getEncodingAESKey());
			p.setProperty("wechat.appid", this.config.getAppid());
			p.setProperty("wechat.appsecret", this.config.getAppSecret());
			p.setProperty("wechat.auto.switch", this.config.getAutoSwitch().toString());
			OutputStream outputStream = new FileOutputStream(new File(p_path));
			p.store(outputStream, "修改时间:" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			outputStream.close();
			org.sword.wechat4j.common.Config.reload();
		} catch (Exception e) {}
		this.pushRequest("result", Boolean.TRUE);
		this.pushRequest("success_url", "admin/config!setting_base");
		this.pushRequest("success_name", "继续修改");
		return "operate-result";
	}
	
	public String setting_auto_switch() {
		// 写入新的配置文件
		try {
			Properties p = new Properties();
			String p_path = System.getProperty("app.root.yk").concat(File.separator).concat("WEB-INF").concat(File.separator).concat("classes").concat(File.separator).concat("other").concat(File.separator).concat("wechat4j.properties");
			InputStream inStream = new FileInputStream(new File(p_path));
			p.load(inStream);
			inStream.close();
			p.setProperty("wechat.url", org.sword.wechat4j.common.Config.instance().getUrl());
			p.setProperty("wechat.token", org.sword.wechat4j.common.Config.instance().getToken());
			p.setProperty("wechat.encodingaeskey", org.sword.wechat4j.common.Config.instance().getEncodingAESKey());
			p.setProperty("wechat.appid", org.sword.wechat4j.common.Config.instance().getAppid());
			p.setProperty("wechat.appsecret", org.sword.wechat4j.common.Config.instance().getAppSecret());
			p.setProperty("wechat.auto.switch", this.config.getAutoSwitch().toString());
			OutputStream outputStream = new FileOutputStream(new File(p_path));
			p.store(outputStream, "修改时间:" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			outputStream.close();
			org.sword.wechat4j.common.Config.reload();
			this.pushJSON("result", Boolean.TRUE);
		} catch (Exception e) {
			this.pushJSON("result", Boolean.FALSE);
			this.pushJSON("descript", "写入配置文件时发生错误");
		}
		return "json";
	}

	@SuppressWarnings("unchecked")
	public String setting_menu() throws IOException {
		//获取菜单
		URL url = new URL("https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", TokenProxy.accessToken()));
		URLConnection con = url.openConnection();
		InputStreamReader bis = new InputStreamReader(con.getInputStream(),"utf-8");
		BufferedReader bf = new BufferedReader(bis);
		String line = "";
		StringBuffer buffer = new StringBuffer();
		while ((line = bf.readLine()) != null) {
			buffer.append(line);
		}
		bis.close();
		JSONObject jo = JSONObject.fromObject(URLDecoder.decode(buffer.toString(),"utf-8"));
		JSONObject menu = jo.getJSONObject("menu");
		List<WechatButton> list = new ArrayList<WechatButton>();
		if(Judge.isNotNull(menu)){
			try {
				JSONArray buttons = menu.getJSONArray("button");
				if(Judge.isNotNull(buttons) && !buttons.isEmpty()){
					Iterator<JSONObject> iterator = buttons.iterator();
					while (iterator.hasNext()) {
						JSONObject j_button = iterator.next();
						WechatButton wb = this.convertJson(j_button);
						list.add(wb);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.pushRequest("menus", list);
		
		return "setting-menu";
	}
	
	public String setting_menu_save() throws IOException {
		boolean rslt = false;
		try {
			//获取菜单
			URL url = new URL("https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", TokenProxy.accessToken()));
			URLConnection con = url.openConnection();
			InputStreamReader bis = new InputStreamReader(con.getInputStream(),"utf-8");
			BufferedReader bf = new BufferedReader(bis);
			String line = "";
			StringBuffer buffer = new StringBuffer();
			while ((line = bf.readLine()) != null) {
				buffer.append(line);
			}
			bis.close();
			JSONObject jo = JSONObject.fromObject(URLDecoder.decode(buffer.toString(),"utf-8"));
			JSONObject menu = jo.getJSONObject("menu");
			
			String config = menu.toString();
			
			config = config.replaceFirst(old_url, new_url);
			
			rslt = this.upload_menu(config);
		} catch (Exception e) {
			this.pushJSON("description", "更新菜单信息时，与微信服务器通信发生错误");
		}
		this.pushJSON("result", Boolean.valueOf(rslt));
		return "json";
	}

	private boolean upload_menu(String config2) {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", TokenProxy.accessToken());
		String result = HttpUtils.post(url, config2);
		JSONObject jo = JSONObject.fromObject(result);
		return 0 == jo.getInt("errcode");
	}

	@SuppressWarnings("unchecked")
	private WechatButton convertJson(JSONObject j_button) throws UnsupportedEncodingException {
		WechatButton root = new WechatButton();
		root.setName(j_button.getString("name"));
		if(j_button.has("type")){
			root.setType(j_button.getString("type"));
		} else {
			root.setOpenId(Boolean.FALSE);
			root.setType("menu");
		}
		if(j_button.has("url")){
			String url = URLDecoder.decode(j_button.getString("url"), "utf-8");
			String[] strs = url.split("\\?");
			String url_first = strs[0];
			if(strs.length == 1){
				root.setUrl(url_first);
				root.setOpenId(Boolean.FALSE);
			} else {
				String[] str_param = strs[1].split("&");
				for (int i = 0; i < str_param.length; i++) {
					String[] str_key_val = str_param[i].split("=");
					if("redirect_uri".equals(str_key_val[0])){
						root.setUrl(str_key_val[1]);
						root.setOpenId(Boolean.TRUE);
					}
				}
				if(Judge.isEmpty(root.getUrl())){
					root.setUrl(url);
					root.setOpenId(Boolean.FALSE);
				}
			}
			
		}
		if(j_button.has("sub_button")){
			JSONArray array = j_button.getJSONArray("sub_button");
			if(Judge.isNotNull(array) && !array.isEmpty()){
				List<WechatButton> list = new ArrayList<WechatButton>();
				root.setSub_button(list);
				Iterator<JSONObject> iterator = array.iterator();
				while (iterator.hasNext()) {
					JSONObject sub = iterator.next();
					WechatButton wb = this.convertJson(sub);
					list.add(wb);
				}
			}
		} 
		return root;
	}
	
	public String setting_auto() {
		this.config = WechatConfig.load();
		// 加载现在已经存在的规则
		List<WechatAuto> keyword_autos = this.commonService.queryAllKeywordAutos();
		this.pushRequest("keyword_autos", keyword_autos);
		WechatAuto gz_auto = this.commonService.queryGuanzhuAuto();
		this.pushRequest("gz_auto", gz_auto);
		return "setting-auto";
	}

	public String setting_auto_save() {
		this.auto.setAutoType(Integer.valueOf(1));
		this.auto.setCreateTime(new Date());
		this.commonService.saveAuto(this.auto);
		this.pushRequest("result", Boolean.TRUE);
		this.pushRequest("success_url", "admin/config!setting_auto");
		this.pushRequest("success_name", "继续修改");
		return "operate-result";
	}
	
	public String setting_auto_guanzhu_save() {
		this.auto.setAutoType(Integer.valueOf(0));
		this.auto.setCreateTime(new Date());
		this.commonService.saveAuto(this.auto);
		this.pushRequest("result", Boolean.TRUE);
		this.pushRequest("success_url", "admin/config!setting_auto");
		this.pushRequest("success_name", "继续修改");
		return "operate-result";
	}
	
	public String setting_auto_delete() {
		this.commonService.deleteAuto(this.auto.getId());
		this.pushRequest("result", Boolean.TRUE);
		this.pushRequest("success_url", "admin/config!setting_auto");
		this.pushRequest("success_name", "继续修改");
		return "operate-result";
	}

	public String red() {
		openRed = commonService.queryConfig(ConstConfig.OPEN_STATUS).getConfigKey();
		redMax = commonService.queryConfig(ConstConfig.RED_MAX).getConfigKey();
		redMin = commonService.queryConfig(ConstConfig.RED_MIN).getConfigKey();

		return "red";
	}

	public String frozen() {
		frozenPer = commonService.queryConfig(ConstConfig.FROZEN_PER).getConfigKey();
		frozenOrd = commonService.queryConfig(ConstConfig.FROZEN_ORD).getConfigKey();

		return "frozen";
	}

	/**
	 * 红包管理
	 * @return
	 */
	public String editred() {
		Boolean resutlt = false;

		if (Judge.isNotNull(openRed)) {
			Config config = new Config();

			config.setGroupKey(ConstConfig.OPEN_STATUS);
			config.setConfigKey(openRed);
			resutlt = commonService.updateConfig(config);

			config.setGroupKey(ConstConfig.RED_MAX);
			config.setConfigKey(redMax);
			resutlt = commonService.updateConfig(config);

			config.setGroupKey(ConstConfig.RED_MIN);
			config.setConfigKey(redMin);
			resutlt = commonService.updateConfig(config);

		}

		this.pushJSON("result", resutlt);
		return RESULT_JSON;
	}

	public String editfrozen() {
		Boolean resutlt = false;

		if (Judge.isNotNull(frozenPer) && Judge.isNotNull(frozenOrd)) {
			Config config = new Config();

			config.setGroupKey(ConstConfig.FROZEN_PER);
			config.setConfigKey(frozenPer);
			resutlt = commonService.updateConfig(config);

			config.setGroupKey(ConstConfig.FROZEN_ORD);
			config.setConfigKey(frozenOrd);
			resutlt = commonService.updateConfig(config);

		}

		this.pushJSON("result", resutlt);
		return RESULT_JSON;
	}

	public String getOpenRed() {
		return openRed;
	}

	public void setOpenRed(String openRed) {
		this.openRed = openRed;
	}

	public String getRedMax() {
		return redMax;
	}

	public void setRedMax(String redMax) {
		this.redMax = redMax;
	}

	public String getRedMin() {
		return redMin;
	}

	public void setRedMin(String redMin) {
		this.redMin = redMin;
	}

	public String getFrozenPer() {
		return frozenPer;
	}

	public void setFrozenPer(String frozenPer) {
		this.frozenPer = frozenPer;
	}

	public String getFrozenOrd() {
		return frozenOrd;
	}

	public void setFrozenOrd(String frozenOrd) {
		this.frozenOrd = frozenOrd;
	}

	public WechatConfig getConfig() {
		return config;
	}

	public void setConfig(WechatConfig config) {
		this.config = config;
	}

	public WechatAuto getAuto() {
		return auto;
	}

	public void setAuto(WechatAuto auto) {
		this.auto = auto;
	}

	public String getOld_url() {
		return old_url;
	}

	public void setOld_url(String old_url) {
		this.old_url = old_url;
	}

	public String getNew_url() {
		return new_url;
	}

	public void setNew_url(String new_url) {
		this.new_url = new_url;
	}
}
