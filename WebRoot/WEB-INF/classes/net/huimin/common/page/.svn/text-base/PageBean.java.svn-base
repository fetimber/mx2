/** 
 * @Title: PageBean.java 
 * @author 胡笑尘 <a>huxiaochen@hmeg.net</a>
 * @date 2014-11-17 下午07:31:21
 * @version V1.0
 */
package net.huimin.common.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.huimin.common.helper.CodeHelper;

/**
 * 分页参数
 * 
 * @author 胡笑尘 huxiaochen@hmeg.net
 * @date 2014-11-17 下午07:31:21
 */
public class PageBean implements Serializable {
	private static final long serialVersionUID = -2546160730199037877L;

	public PageBean() {
		if (CodeHelper.isNull(this.current)) {
			this.current = 1;
		}
		if (CodeHelper.isNull(this.beans)) {
			this.beans = new ArrayList<Object>();
		}
		if (CodeHelper.isNull(this.count)) {
			this.count = 0;
		}
		if (CodeHelper.isNull(this.offset)) {
			this.offset = 10;
		}
		if (CodeHelper.isNull(this.totalPage)) {
			this.totalPage = 1;
		}
		if (CodeHelper.isNull(this.start)) {
			this.start = 0;
		}
	}
	
	public static void Counter(PageBean page,Integer count, Integer current , List<? extends Object> beans){
		page.setCount(count);
		if(CodeHelper.isNotNull(current)){
			page.setCurrent(current);
			page.setStart((current -1 ) * page.getOffset());
		}
		page.setTotalPage(count % page.getOffset() == 0 ? count / page.getOffset() : count / page.getOffset() + 1);
		page.setBeans(beans);
		
		//计算其他页码
		page.setPrePage(page.getCurrent().intValue() == 1 ? 1 : page.getCurrent().intValue() - 1);
		page.setNextPage(page.getCurrent().intValue() < page.getTotalPage().intValue() ? page.getCurrent().intValue() + 1 : page.getTotalPage().intValue());
		List<String> pages = new ArrayList<String>();
		if(page.getTotalPage() < 11){
			for (int i = 1; i < page.getTotalPage().intValue(); i++) {
				pages.add(Integer.valueOf(i).toString());
			}
		} else {
			pages.add("1");
			int s = page.getCurrent() / 10 * 10;
			pages.add("-10");
			int e = s + 10;
			if(e > page.getTotalPage().intValue()){
				e = page.getTotalPage().intValue();
			}
			for (int i = s; i < e; i++) {
				pages.add("+10");
			}
			if(e + 2 < page.getTotalPage().intValue()){
				pages.add(String.valueOf(e + 1));
			} else if(e < page.getTotalPage().intValue()){
				pages.add(page.getTotalPage().toString());
			}
			
		}
		page.setPages(pages.toArray(new String[pages.size()]));
	}

	/**
	 * 当前页数
	 */
	private Integer current;

	/**
	 * 总计条数
	 */
	private Integer count;

	/**
	 * 偏移量
	 */
	private Integer offset;

	
	/**
	 * 开始点
	 */
	private Integer start;

	
	/**
	 * 总页数
	 */
	private Integer totalPage;
	
	private Integer prePage;
	
	private Integer nextPage;
	
	private String[] pages;

	private List<? extends Object> beans;
	
	private Map<String, Object> parameters = new HashMap<String, Object>();

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public List<? extends Object> getBeans() {
		return beans;
	}

	public void setBeans(List<? extends Object> beans) {
		this.beans = beans;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPrePage() {
		return prePage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public String[] getPages() {
		return pages;
	}

	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public void setPages(String[] pages) {
		this.pages = pages;
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	public Integer getStart() {
		return this.getCurrent() * this.getOffset() - this.getOffset();
	}

	public void setStart(Integer start) {
		this.start = start;
	}

}
