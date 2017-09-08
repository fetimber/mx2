package net.huimin.yk.web.actions.admin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import net.huimin.common.helper.FileHelper;
import net.huimin.common.helper.Judge;
import net.huimin.common.helper.SpringHelper;
import net.huimin.common.mvc.AbstractAction;
import net.huimin.yk.web.dao.common.FilesMapper;
import net.huimin.yk.web.model.common.Files;
import net.huimin.yk.web.services.sea.SeaService;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UploadAction extends AbstractAction {
	private File upload; //上传的文件
	
	private File upload_btn_ext; //上传的文件
	
    private String uploadFileName; //文件名称
    private String uploadContentType; //文件类型
    
    private Boolean createMedia;
    
    private Boolean saveFile;
    private String fileType;
    
    private String useType;
    
    
	@Autowired
	private SeaService seaService;
    
	private String rondom() {
		int max = 9999;
		int min = 1000;
		Random random = new Random();

		int s = random.nextInt(max) % (max - min + 1) + min;
		return String.valueOf(s);
	}

	public String extFile(){
		try {
    		String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
        	if (upload != null) {
        		String rondom = rondom();
        		String subfix = this.uploadFileName.substring(this.uploadFileName.lastIndexOf("."));
        		
        		
        		String target_name = new SimpleDateFormat("yyyyMMddHHmmssS").format(new Date()).concat(rondom).concat(subfix);
                File savefile = new File(new File(realpath), target_name);
                if (!savefile.getParentFile().exists())
                    savefile.getParentFile().mkdirs();
                FileUtils.copyFile(upload, savefile);
                this.pushJSON("result", Boolean.TRUE);
                this.pushJSON("upload_path", "upload/" + target_name);
                this.pushJSON("file_name", uploadFileName);
            }
		} catch (Exception e) {
			this.pushJSON("result", Boolean.FALSE);
		}
    	return "json";
	}
    public String execute(){
    	try {
    		String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
        	if (upload != null) {
        		String rondom = rondom();
        		String subfix = this.uploadFileName.substring(this.uploadFileName.lastIndexOf("."));
        		if(!subfix.contains(".jpg")
        				&& !subfix.contains(".jpeg")
        				&& !subfix.contains(".bmp")
        				&& !subfix.contains(".png")){
        			this.pushJSON("filetype", "文件类型错误无法上传");
        			this.pushJSON("result", Boolean.FALSE);
        			return "json";
        		}
        		
        		String target_name = new SimpleDateFormat("yyyyMMddHHmmssS").format(new Date()).concat(rondom).concat(subfix);
                File savefile = new File(new File(realpath), target_name);
                if (!savefile.getParentFile().exists())
                    savefile.getParentFile().mkdirs();
                FileUtils.copyFile(upload, savefile);
                this.pushJSON("result", Boolean.TRUE);
                this.pushJSON("upload_path", "upload/" + target_name);
                
                BufferedImage sourceImg =ImageIO.read(new FileInputStream(savefile)); 
                
                this.pushJSON("width", sourceImg.getWidth());
                this.pushJSON("height", sourceImg.getHeight());
                
                if(null != this.createMedia && this.createMedia){
                	//上传微信服务器
                    // MediaFile mediaFile = new MediaFile();   //创建示例对象
                    //上传文件，并且得到上传后的mediaId
                    //String mediaId = mediaFile.upload(savefile, MediaType.image);
                    //this.pushJSON("mediaId", mediaId);
                }
                
                //保存到图片表
                if(null != this.saveFile && this.saveFile){
                	Files file = new Files();
                	file.setFileName(savefile.getName());
                	file.setFilePath("upload/" + savefile.getName());
                	file.setFileSize(String.valueOf(savefile.getTotalSpace()));
                	file.setFileType(Integer.valueOf(this.fileType));
                	file.setUploadTime(new Date());
                	SpringHelper.Context().getBean(FilesMapper.class).insertSelective(file);
                	this.pushJSON("id", file.getId());
                }
            }
		} catch (Exception e) {
			this.pushJSON("result", Boolean.FALSE);
		}
    	return "json";
    }
    
    public String excel(){
    	try {
    		String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
        	if (upload != null) {
        		String rondom = rondom();
        		String subfix = this.uploadFileName.substring(this.uploadFileName.lastIndexOf("."));
        		if(!subfix.contains(".xls")){
        			this.pushJSON("remark", "文件类型错误无法上传");
        			this.pushJSON("result", Boolean.FALSE);
        			return "json";
        		}
        		
        		
        		String target_name = new SimpleDateFormat("yyyyMMddHHmmssS").format(new Date()).concat(rondom).concat(subfix);
                File savefile = new File(new File(realpath), target_name);
                if (!savefile.getParentFile().exists())
                    savefile.getParentFile().mkdirs();
                FileUtils.copyFile(upload, savefile);
                this.pushJSON("result", Boolean.TRUE);
                this.pushJSON("upload_path", "upload/" + target_name);
                
                List<String[]> list = FileHelper.parseXls4ReimburseData(savefile,this.fileType);  
                this.pushJSON("remark", " ");
                if(Judge.isNull(list)){
                	this.pushJSON("remark", "EXCEL文件格式不正确请核实");
                	this.pushJSON("result", Boolean.FALSE);
                }
                
                if(Judge.isNotNull(list)
                		&& list.size() > 0){
            	   if("99".equals(this.fileType)){
                  	  list =  seaService.honorImport(list,this.logined(true));
                   }
                  
                  if("88".equals(this.fileType)){
                  	  list =   seaService.poorWorkerImport(list,this.logined(true));
                  }	
                }
              
                
                
                if(Judge.isNotNull(list)
              		  && list.size() >0 ){
                	String remark = "";
                	for(int i=0 ; i < list.size() ; i ++){
                		remark += list.get(i)[0]+ " ";      		
                	}
                	
                	if(!"".equals(remark)){
                		this.pushJSON("remark", "身份证号:" + remark + " 已存在");
                	}else{
                		this.pushJSON("remark", " ");
                	}
                }
                
                //保存到图片表
                if(null != this.saveFile && this.saveFile){
                	Files file = new Files();
                	file.setFileName(savefile.getName());
                	file.setFilePath("upload/" + savefile.getName());
                	file.setFileSize(String.valueOf(savefile.getTotalSpace()));
                	file.setFileType(Integer.valueOf(this.fileType));
                	file.setUploadTime(new Date());
                	SpringHelper.Context().getBean(FilesMapper.class).insertSelective(file);
                	this.pushJSON("id", file.getId());
                }
            }
		} catch (Exception e) {
			this.pushJSON("result", Boolean.FALSE);
		}
    	return "json";
    }
    

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public Boolean getCreateMedia() {
		return createMedia;
	}

	public void setCreateMedia(Boolean createMedia) {
		this.createMedia = createMedia;
	}

	public Boolean getSaveFile() {
		return saveFile;
	}

	public void setSaveFile(Boolean saveFile) {
		this.saveFile = saveFile;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public File getUpload_btn_ext() {
		return upload_btn_ext;
	}

	public void setUpload_btn_ext(File upload_btn_ext) {
		this.upload_btn_ext = upload_btn_ext;
	}

	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}
}
