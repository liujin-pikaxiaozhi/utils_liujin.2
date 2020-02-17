package com.bawei.utils;
/**
 * 
 * @ClassName: StringUtil 
 * @Description: �ַ���������
 * @author:lq 
 * @date: 2020��1��3�� ����9:01:13
 */
public class StringUtil {

	//�ж��ַ����Ƿ�Ϊ��
	public static boolean isNull(String str) {
		if (null!=str&&!"".equals(str)) {
			return true;
		}else {
			return false;
		}
	}
	
	//�ж��ַ����ǲ��ǲ�Ϊ��
	public static boolean isNotNull(String str) {
		if (null!=str&&!"".equals(str)) {
			return false;
		}else {
			return true;
		}
	}
	
	//�ж��ַ����Ƿ�Ϊ����
	public static boolean isEmail(String str) {
		String str_Email="^\\w+@$\\w+\\.(com|cn|net|com\\.cn)";
		boolean matches = str.matches(str_Email);
		return matches;
	}
	
	//�ж��ַ����Ƿ����ֻ���
	public static boolean isPhone(String str) {
		String str_Phone="^1[3-9]\\d{9}$";
		boolean matches = str.matches(str_Phone);
		return matches;
	}
	
	//�ж�Դ�ַ����Ƿ���ֵ�������źͿո�Ҳ��ûֵ
		public static boolean isNotEmpty(String str) {
			
			if(null!=str && !"".equals(str)) {
				if(str.trim().length()==0) {
					return false;
				}
				return true;
			}
			return false;
		}
		
		
		public static void main(String[] args) {
			boolean number = isNumber("70");
			System.out.println(number);
		}
		
		//�ж��Ƿ�������
			public static boolean isNumber(String str) {
				String reg_str="^([1-9][0-9]*)|((([0-9])|([1-9]\\d+))\\.\\d)$";
				boolean matches = str.matches(reg_str);
				return matches;
			}
	
}
