package net.huimin.common.mvc;

public abstract class BaseModel {
	abstract public Integer getId();
	abstract public void setId(Integer id);
	
	public String getSecId(){
		return convert(String.valueOf(this.getId()));
	}
	
	public void setSecId(String secId){
		String res = convert(secId);
		Integer resInt = null;
		try{
			resInt = Integer.valueOf(res);
		}catch(Exception e){
			
		}
		this.setId(resInt);
	}
	
	public static String convert(String password){
		if(password == null) return null;
		char[]array=password.toCharArray();//获取字符数组  
        for(int i=0;i<array.length;i++)//遍历字符数组  
        {  
            array[i]=(char)(array[i] ^ 20140908);//对每个数组元素进行异或运算，异或的值可以自己选择  
        }  
        return new String(array);
	}
}
