package a.b.c.com.common;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import com.oreilly.servlet.MultipartRequest;

public class FileUploadUtil {
	
	private String imgfilePaths;
	private int imgfileSize; 
	private String encodeType;	
	private MultipartRequest mr;

	public FileUploadUtil(String imgfilePaths, int imgfileSize, String encodeType) {
		this.imgfilePaths = imgfilePaths;
		this.imgfileSize = imgfileSize;
		this.encodeType = encodeType;		
	}
	
	public boolean imgfileUpload(HttpServletRequest req) {		
		boolean bool = imgfileUpload(req, imgfilePaths);		
		return bool;
	}
	


	public boolean imgfileUpload(HttpServletRequest req, String filePath) {
		boolean bool = false;
		try {
			String savePath =req.getServletContext().getRealPath("/fileupload/board");
			mr = new MultipartRequest(req, savePath, imgfileSize, encodeType, new FileRename());
			
			System.out.println("mr >>> : " + mr);
			System.out.println("mr >>> : " + savePath);
			bool=true;
		}catch(Exception e) {
			System.out.println("imgfileUploadUtil.imgfileUpload() >>> : " + mr);			
		}		
		return bool;
	}
	
	public String getParameter(String s){
		return mr.getParameter(s);
	}
	
	public String[] getParameterValues(String s){
		return mr.getParameterValues(s);		
	}
	
	public String getFileName(String f){
		return mr.getFilesystemName(f);
	}
	
	public ArrayList<String> getFileNames(){
		@SuppressWarnings("unchecked")
		Enumeration<String> en = mr.getFileNames();
		ArrayList<String> a = new ArrayList<String>();
		
		while (en.hasMoreElements()){
			String f = en.nextElement().toString();
			a.add(mr.getFilesystemName(f));
		}		
		return a;
	}
}
