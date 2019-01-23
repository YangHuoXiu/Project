package com.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
public class UploadAction extends ActionSupport{
	private File uploadImage;//得到上传的文件
    private String uploadImageContentType;//得到文件的类型
    private String uploadImageFileName;//得到文件的名称
    
    
	public File getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(File uploadImage) {
		this.uploadImage = uploadImage;
	}

	public String getUploadImageContentType() {
		return uploadImageContentType;
	}

	public void setUploadImageContentType(String uploadImageContentType) {
		this.uploadImageContentType = uploadImageContentType;
	}

	public String getUploadImageFileName() {
		return uploadImageFileName;
	}

	public void setUploadImageFileName(String uploadImageFileName) {
		this.uploadImageFileName = uploadImageFileName;
	}

	public String upload() throws Exception{

	Properties prop =new Properties();
    InputStream in=this.getClass().getClassLoader().getResourceAsStream("imgPath.properties");
    prop.load(in);
      //获取真实物理路径
    String imgRealPath = prop.getProperty("imgRealPath").trim();
    //获取虚拟路径
    String imgPath=prop.getProperty("imgPath");
    System.out.println(imgPath);
    System.out.println(imgRealPath);
   File file = new File(imgRealPath);
    if(!file.exists()){
    	file.mkdirs();
    }
  FileUtils.copyFile(uploadImage,new File(imgRealPath,this.uploadImageFileName));
  String newPicturePath=imgPath+"/"+this.uploadImageFileName;
  System.out.println(newPicturePath);
   return null;
   }
/*private ServletActionContext getServletConfig(){

return null;
}*/
	/*private File photo;
	//struts2在文件上传时提供的属性
	private String photoFileName;//上传的文件名。上传字段名称+FileName  注意大小写
	private String photoContentType;//上传文件的MIME类型。上传字段名称+ContentType 注意大小写
	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}*/
/*
	public String upload() throws IOException{
		//1.拿到ServletContext
		ServletContext application = ServletActionContext.getServletContext();
		//2.调用realPath方法，获取根据一个虚拟目录得到的真实目录
		String filePath = application.getRealPath("/WEB-INF/files");
		System.out.println(filePath);
		//3.如果这个真实的目录不存在，需要创建
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		Properties prop =new Properties();
	    InputStream in=this.getClass().getClassLoader().getResourceAsStream("imgPath.properties");
	    prop.load(in);
	      //获取真实物理路径
	    String imgRealPath = prop.getProperty("imgRealPath").trim();
	    System.out.println(imgRealPath);
	    File file = new File(imgRealPath);
	    if(!file.exists()){
	    	file.mkdirs();
	    }
		
		//4.把photo存过去
		//拷贝：    。注意：临时文件还在
		//FileUtils.copyFile(photo, new File(file,photoFileName));
		
		//剪切：把临时文件剪切指定的位置，并且给他重命名。 注意：临时文件没有了
		photo.renameTo(new File(file,photoFileName));
		
		return null;
	}*/

	
	
	}


	
  
