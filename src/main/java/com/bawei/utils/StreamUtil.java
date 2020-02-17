package com.bawei.utils;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @ClassName: StreamUtil 
 * @Description: ���Ĺ�����
 * @author:lq 
 * @date: 2020��1��2�� ����10:03:34
 */
public class StreamUtil {
	
	
	//���ж�ȡ�ı��ļ�
		public static List<String> readLine(InputStream ips){
			List<String> list=new ArrayList<String>();
			//��ȡ�ı��ļ�
			String readLine;
			try {
				Reader reader=new InputStreamReader(ips,"utf-8");
				BufferedReader bf=new BufferedReader(reader);
				readLine = bf.readLine();
				while(readLine!=null) {
					list.add(readLine);
					readLine = bf.readLine();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
		
		/**
		 * 
		 * @Title: close 
		 * @Description: �رն��������
		 * @param autoCloseables
		 * @return: void
		 */
		public static void close(AutoCloseable... autoCloseables){
			if(autoCloseables!=null) {//�����Ϊ��
				for (AutoCloseable autoCloseable : autoCloseables) {
					try {
						autoCloseable.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		
		
		/**
		 * 
		 * @Title: readTextFile 
		 * @Description: �����ֽ�����ȡ�ļ�
		 * @param file
		 * @return
		 * @return: String
		 */
		public static String readTextFile(File file) {
			StringBuffer sb=new StringBuffer();
			InputStream ips=null;
			try {
				 ips=new FileInputStream(file);
				byte[] b=new byte[1024];
				//��ȡb.length���ֽ�
				int read = ips.read(b);
				while(read!=-1) {
					sb.append(new String(b));
					read=ips.read();
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(ips);
			}
			
			return sb.toString();
		}
		
		public static String readTextFile(String fileName) {
			return readTextFile(new File(fileName));
		}
		
		
		
		public static void writeTextFile(String content,File file) {
				//e:/aa/bb/aa.txt
			String parent = file.getParent();//e:/aa/bb
			//��Ŀ¼   �ļ���
			File parentFile=new File(parent);
			if(!parentFile.exists()) {
				parentFile.mkdirs();
			}
			//д���ļ�
			Writer fw = null;
			BufferedWriter bw=null;
			try {
				fw = new FileWriter(file);
				 bw=new BufferedWriter(fw);
				 bw.write(content);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(bw,fw);
			}
			
		}

	

}
