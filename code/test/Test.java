package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		String filepath = "F:\\pic";
		File file = new File(filepath);
		 String[] filelist = file.list();
		 
		 for(int i = 0 ; i < filelist.length; i ++){
			 
			 File renameFile = new File(filepath + "\\" + filelist[i]);
			 renameFile.renameTo(new File(filepath + "\\" + (i+1) + ".jpg"));
			 
		 }
		
		//readfile("F:\\pic");
		
	}
	
	
	 /**
     * 读取某个文件夹下的所有文件
     */
    public static boolean readfile(String filepath) throws FileNotFoundException, IOException {
            try {

                    File file = new File(filepath);
                    if (!file.isDirectory()) {
                            System.out.println("文件");
                            System.out.println("path=" + file.getPath());
                            System.out.println("absolutepath=" + file.getAbsolutePath());
                            System.out.println("name=" + file.getName());

                    } else if (file.isDirectory()) {
                            System.out.println("文件夹");
                            String[] filelist = file.list();
                            for (int i = 0; i < filelist.length; i++) {
                                    File readfile = new File(filepath + "\\" + filelist[i]);
                                    if (!readfile.isDirectory()) {
                                            System.out.println("path=" + readfile.getPath());
                                            System.out.println("absolutepath="
                                                            + readfile.getAbsolutePath());
                                            System.out.println("name=" + readfile.getName());

                                    } else if (readfile.isDirectory()) {
                                            readfile(filepath + "\\" + filelist[i]);
                                    }
                            }

                    }

            } catch (FileNotFoundException e) {
                    System.out.println("readfile()   Exception:" + e.getMessage());
            }
            return true;
    }

}
