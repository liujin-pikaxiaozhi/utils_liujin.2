package com.bawei.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Random;
/**
 * 
 * @ClassName: RandomUtil 
 * @Description: �����������
 * @author:lq 
 * @date: 2020��1��3�� ����9:28:30
 */
public class RandomUtil {

	//����ĳ��ʱ��ε����ݣ��緵��������1-120֮�䣩
	public static int getRanOnTime(int max,int min) {
		Random random = new Random();
		return random.nextInt(max-min+1)+min;
	}
	
	//������Ӣ���ַ�
	public static char getRandomChar() {
		Random random=new Random();
		//��ÿ�ʼ�ַ���ASCII��
		int startChar='a'+0;
		
		return 	(char) (random.nextInt(26)+startChar);

	}
	
	
	//����4λ��֤�룬�ɰ������ֺ���ĸ
	public static String getMEString() {
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			int nextInt = random.nextInt(36);
			if (nextInt>10) {
				buffer.append(getRandomChar());
			}else {
				buffer.append(getRandomNum());
			}
		}
		return buffer.toString();
	}
	
	
	//������0-9֮�������
		public static int getRandomNum() {
			Random random=new Random();
			int nextInt = random.nextInt(10);
			return nextInt;
		}
		
		//������0-9֮���ָ������������
		public static int[] getRandomNum(int subs) {
			int [] arr=new int[subs];
			for(int i=0;i<subs;i++){
				int randomNum = getRandomNum();
				arr[i]=randomNum;
			}
			return arr;
		}
		
		//���һ�������ڵ�������� 3   15
		public static int getRandomNum(int min,int max) {
			Random random=new Random();
			
			return random.nextInt(max-min+1)+min;
			
		}

		//���һ�������ڵ�n�������ظ���������� 3   15
		public static int[] getRandomNum(int min,int max,int subs) {
			int [] arr=new int[subs];
			HashSet<Integer> set=new HashSet<Integer>();
			//������ϵĳ���С����Ҫ��������ĸ���
			while(set.size()<subs) {
				set.add(getRandomNum(min,max));
			}
			
			//��������  �� set�����е�ֵ��  arr����
			int i=0;
			for (Integer integer : set) {
				arr[i]=integer;
				i++;
			}
			return arr;
					
		}
	
		//��ȡ1����������ַ���
		public static String getRandomChineseString() {
			Random random=new Random();
			//���ú��ֵĸ�λ�ֽ���Сֵ��176 
			//39 һ������ 16-55��  55-16=39
			int highPos=176+Math.abs(random.nextInt(39));
			//���ú��ֵĵ�λ�ֽ���Сֵ��161  a0 0+160+1
			int lowPos=161+Math.abs(random.nextInt(93));
			
			
			byte bytehigh = new Integer(highPos).byteValue();
			byte byteLow= new Integer(lowPos).byteValue();
			
			byte[] b=new byte[2];
			b[0]=bytehigh;
			b[1]=byteLow;
			String str=null;
			try {
				str= new String(b,"GB2312");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return str;
			
		}
		//��ö������
		public static String getRandomChineseString(int subs) {
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<subs;i++) {
				sb.append(getRandomChineseString());
			}
			
			return sb.toString();
		}

		//ȡ��
		public static String getRandomName() {
			String[] surname = { "��", "Ǯ", "��", "��", "��", "��", "֣", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					"��", "��", "��", "��", "ʩ", "��", "��", "��", "��", "��", "��", "κ", "��", "��", "��", "л", "��", "��", "��", "ˮ", "�",
					"��", "��", "��", "��", "��", "��", "��", "��", "��", "³", "Τ", "��", "��", "��", "��", "��", "��", "��", "��", "Ԭ", "��",
					"ۺ", "��", "ʷ", "��", "��", "��", "�", "Ѧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					"��", "ʱ", "��", "Ƥ", "��", "��", "��", "��", "��", "Ԫ", "��", "��", "��", "ƽ", "��", "��", "��", "��", "��", "Ҧ", "��",
					"տ", "��", "��", "ë", "��", "��", "��", "��", "��", "�", "��", "��", "��", "��", "̸", "��", "é", "��", "��", "��", "��",
					"��", "��", "ף", "��", "��", "��", "��", "��", "��", "ϯ", "��", "��", "ǿ", "��", "·", "¦", "Σ", "��", "ͯ", "��", "��",
					"÷", "ʢ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "֧", "��", "��",
					"��", "¬", "Ī", "��", "��", "��", "��", "��", "��", "Ӧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					"��", "ʯ", "��", "��", "ť", "��", "��", "��", "��", "��", "��", "½", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɽ", "��",
					"��", "��", "�", "��", "ȫ", "ۭ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					"��", "��", "��", "��", "ղ", "��", "��", "Ҷ", "��", "˾", "��", "۬", "��", "��", "��", "ӡ", "��", "��", "��", "��", "ۢ",
					"��", "��", "��", "��", "��", "��", "׿", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "˫", "��", "ݷ", "��",
					"��", "̷", "��", "��", "��", "��", "��", "��", "��", "Ƚ", "��", "۪", "Ӻ", "ȴ", "�", "ɣ", "��", "�", "ţ", "��", "ͨ",
					"��", "��", "��", "��", "��", "��", "ũ", "��", "��", "ׯ", "��", "��", "��", "��", "��", "Ľ", "��", "��", "ϰ", "��", "��",
					"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					"��", "��", "»", "��", "��", "ŷ", "�", "��", "��", "ε", "Խ", "��", "¡", "ʦ", "��", "��", "��", "��", "��", "��", "��",
					"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɳ", "ؿ", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					"��", "��", "��", "��", "ۣ", "��", "Ȩ", "��", "��", "��", "��", "��", "��", "��", "��", "˧", "��", "��", "��", "�C", "��",
					"��", "��", "��", "��", "��", "��", "��", "��", "۳", "Ϳ", "��", "��", "Ĳ", "��", "٦", "��", "��", "ī", "��", "��", "��",
					"��", "��", "��", "١", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "չ", "��", "̴", "��", "��", "��", "��",
					"˴", "¥", "��", "ð", "��", "ֿ", "��", "��", "��", "��", "ԭ", "��", "��", "��", "��", "��", "�", "��", "��", "��", "�",
					"��", "��", "��", "��", "��", "��", "��", "ľ", "��", "��", "ۨ", "��", "ö", "��", "��", "�", "��", "��", "��", "��", "��",
					"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "�G", "��ٹ", "˾��", "�Ϲ�", "ŷ��",
					"�ĺ�", "���", "����", "����", "����", "�ʸ�", "����", "ξ��", "����", "�̨", "��ұ", "����", "���", "����", "����", "̫��", "����",
					"����", "����", "��ԯ", "���", "����", "����", "����", "Ľ��", "����", "����", "˾ͽ", "˾��", "أ��", "˾��", "����", "����", "�ӳ�",
					"���", "��ľ", "����", "����", "���", "����", "����", "����", "�ذ�", "�й�", "�׸�", "����", "�θ�", "����", "����", "΢��", "����",
					"����", "����", "����", "�Ϲ�", "����", "����", "����", "̫ʷ", "�ٳ�", "����", "��ͻ", "����", "����", "����", "��ĸ", "˾��", "����",
					"Ӻ��", "����", "����", "����", "��®", "����", "�Ϲ�", "����", "����" };
			
			//�������
			String name1=surname[getRandomNum(0, surname.length-1)];
			//�������
			String  name2= getRandomChineseString(getRandomNum(1,2));
			return name1+name2;
				
				
		}
		
		/*
		 * �ٷֱȼ��㷽��������ֵֻҪ������ҪС��
		 * ��һ����ǰ������һ�����������㵱ǰ���ٷֱȣ��������Ϊ5��10�������ڲ�
		 * 5����10��0.5���ٳ���100������50��ע���������롣ҳ��Ϳ�����ʾ50%
		 */
		public static int getPercent(int current,int total) {
			int result=current/total*100;
			return result;
		}
		
}