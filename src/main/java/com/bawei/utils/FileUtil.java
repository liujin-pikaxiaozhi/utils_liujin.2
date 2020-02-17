package com.bawei.utils;

import java.io.File;

/**
 * 
 * @ClassName: FileUtil 
 * @Description: �ļ�������
 * @author:lq 
 * @date: 2020��1��2�� ����11:08:02
 */
public class FileUtil {
	
	
	//��ȡ�ļ���չ��
		public static String getSuffix(String fileName) {
			//a.ba.jpg   jpg
			if(fileName!=null && !"".equals(fileName)){
				//���.С��
				int lastIndexOf = fileName.lastIndexOf(".");
				return fileName.substring(lastIndexOf+1);
			}else {
				return "������Ч�ļ�";
			}
		}
	
		//### ɾ���ļ�
		//�����Ŀ¼����������ļ���������Ŀ¼�е��ļ���Ҫɾ��
		//ʹ�õݹ顣�漰���ݡ��ж�Ŀ¼�Ĵ����ԣ��ж��Ƿ�ΪĿ¼���ļ���ɾ��
			public static void deleteFile(File file) {
				//�ж��Ƿ����ļ���
				if(file.isDirectory()) {
					//��ô��ļ����µ����е��ļ������ļ���
					File[] listFiles = file.listFiles();
					for (File file2 : listFiles) {
						//�ݹ�ɾ���ļ�
						deleteFile(file2);
					}
					file.delete();
				}else {
					//�����ļ���   �����ļ�
					file.delete();//ֱ��ɾ��
				}
				
			}
			//��ȡ����ϵͳ�û�Ŀ¼
			public static String getSystemUserHome() {
				return System.getProperty("user.home");
			}

}
