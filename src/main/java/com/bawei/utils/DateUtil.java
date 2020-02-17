package com.bawei.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	private static SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	//�������ռ�������
	public static int GetAgeBrithday(String birthday) throws ParseException {
		//��������Ҽ�
		Calendar calendar = Calendar.getInstance();
		//�������Ҽ��л�õ�ǰ����
		//�����
		int year = calendar.get(Calendar.YEAR);
		//�����
		int monday = calendar.get(Calendar.MONDAY);
		//�����
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		//�����ո������ؼ�
		Date date = sdf.parse(birthday);
		calendar.setTime(date);
		int birYear = calendar.get(Calendar.YEAR);
		int birMonday = calendar.get(Calendar.MONDAY);
		int birDay = calendar.get(Calendar.DAY_OF_MONTH);
		int age=year-birYear;
		//�����ǰ�·ݴ��������·ݣ�����+1
		if (monday>birMonday) {
			age++;
		}
		//�����ǰ���ڴ����������ڣ�����+1
		if (day>birDay) {
			age++;
		}
		return age;
	}
	


	
	//�������ռ�������
	public static int getAgeByBirthday(Date birthday) {
		//��������ؼ�
		Calendar calendar=Calendar.getInstance();
		//�������ؼ��л�õ�ǰ��������
		int year = calendar.get(Calendar.YEAR);
		int mouth = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		//�����ո��������ؼ�  �������
		calendar.setTime(birthday);
		int birYear = calendar.get(Calendar.YEAR);
		int birMouth = calendar.get(Calendar.MONTH);
		int birDay = calendar.get(Calendar.DAY_OF_MONTH);
		int age=year-birYear;
		//�����ǰ�·ݴ��������·�  ����+1
		if(mouth>birMouth) {
			age++;
		}
		//�·���������ǰ���ڴ�����������  ����+1
		if(birMouth==mouth && day>birDay) {
			age++;
		}
		
		return age;
		
	}
	//�ŵ����� ��������
	public static int getAgeByBirthday(String birthday) {
		Date birDate=null;
		try {
			birDate = sdf.parse("1992-1-1");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAgeByBirthday(birDate);
	}
	
	//�������������������
	public static int getDayNum(Date date1,Date date2) {
		
		//һ����ٺ���
		Long time=24L*60*60*1000;
		//��ý���ʱ��ĺ���
		long time1 = date2.getTime();
		//��ÿ�ʼʱ��ĺ���
		long time2 = date1.getTime();
		//�������  =���ĺ���
		//���ĺ���/һ����ٺ���=��
				
		if(time1>time2) {
			return (int) ((time1-time2)/time);
		}else {
			return (int) ((time2-time1)/time);
		}
		
	}
	//����������  ��������������
	public static int getDayNum(String date1,String date2) {
		try {
			return getDayNum(sdf.parse(date1), sdf.parse(date2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	//���ݸ�����ʱ��  ��õ��µĵ�һ���0ʱ0��0��  2019-12-12 == 2012-12-1 0:0:0
	public static Date getDateByInitMouth(Date date) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		//����ǰʱ��������ؼ����������ó�1
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		
		return calendar.getTime();//��������֮���ʱ��
		
	}
	
	//��õ��µ����һ��
	public static Date getDateByEndMouth(Date date) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);//2012-9-10
		//��ǰ�·�+1
		calendar.add(Calendar.MONTH, 1);//2012-10-10
		//ͨ����������ķ���  ��õ��¿�ʼʱ��
		Date dateByInitMouth = getDateByInitMouth(calendar.getTime());//2012-10-1 0:0:0
		calendar.setTime(dateByInitMouth);
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime();
		
	}
	
	//ͨ����ǰʱ�������24Сʱǰ��ʱ��
		public static String getIntervalDate(long millis) {
			//���ϵͳ��ǰ������
			Date date = new Date();
			long time = date.getTime();
			//�����Ҫ�õ���ǰϵͳ�ĺ���
			long time1 = time-millis;
			//ͨ����õĺ���õ�ʱ��
			date.setTime(time1);
			String format = sdf2.format(date);
			return format;
			
		}
	
}
