package mgr;

import java.util.List;
import java.util.Scanner;
import entity.ApplyInfo;
import service.ApplyInfoService;
import service.impl.ApplyInfoServiceImpl;

public class GameMar {
	
		ApplyInfoService applyInfoservice=new ApplyInfoServiceImpl();	
		Scanner input=new Scanner(System.in);
		/**
		 * ���˵�
		 */
	public void menu() {
		boolean isExit = false;
			int num=0;
				do {
				System.out.println("**************************��ӭʹ���˶��ᱨ��ϵͳ**************************");
				System.out.println("1.ѧ������"+",2.��������Ŀ��ѯ"+",3.���༶��ѯ"+",4.ȡ������"+",5.�˳�ϵͳ");			
				System.out.println("��ѡ��(1~5):");
				num=input.nextInt();						
				switch(num) {
				case 1:				
					isExit = false;
					addInfo();
					break;
				case 2:
					isExit = false;
					findByGame();
					break;
				case 3:
					isExit = false;
					findByClassRoom();
					break;
				case 4:
					isExit = false;
					deleteStudent();
					break;
				case 5:
					isExit = true;
					break;										
				}
				}while(!isExit);
				
				System.out.println("ллʹ�ã�");
		}	
		/**
		 * ѧ������
		 */
		public void addInfo() {
			System.out.print("����������:");
			String name=input.next();
			System.out.print("����������:");
			int age=input.nextInt();
			System.out.print("������ѡ��༶:(1.һ�� ,2.����,3.����):");
			int no=input.nextInt();
			String classRoom=null;
			switch (no) {
			case 1:
				classRoom="һ��";
				break;
			case 2:
				classRoom="����";
				break;
			case 3:
				classRoom="����";
				break;		
			}
			System.out.print("��ѡ������Ŀ(1.��Զ, 2.������ ,3.����):");
			int id=input.nextInt();
			String game=null;
			switch (id) {
			case 1:
				game="��Զ";
				break;
			case 2:
				game="������";
				break;
			case 3:
				game="����";
				break;		
			}
			
			ApplyInfo applyInfo=new ApplyInfo(name,age,classRoom,game);
			boolean result=applyInfoservice.addApplyInfo(applyInfo);
			if(result) {
				System.out.println("�����ɹ�!");
			}else {
				System.out.println("����ʧ��!");
			}				
		}
		
		/**
		 * ���ݱ�����Ŀ��ѯ
		 */
		public void findByGame() {
			System.out.print("��ѡ��Ҫ��ѯ�ı�����Ŀ(1.��Ծ,2.������,3.����)");
			int mun=input.nextInt();
			String game=null;
			switch (mun) {
			case 1:
				game="��Ծ";
				break;
			case 2:
				game="������";
				break;
			case 3:
				game="����";
				break;			
			}
			List<ApplyInfo> list=applyInfoservice.SearchApplyInfoByGame(game);
			System.out.println("��Ŀ"+"\t"+"����"+"\t"+"�༶"+"\t"+"����");
			for (int i = 0; i < list.size(); i++) {
				ApplyInfo info=list.get(i);
				System.out.println(info.getGame()+"\t"+info.getName()
				+"\t"+info.getClassRoom()+"\t"+info.getAge());
			}

		}
		
		/**
		 * ���ݰ༶��ѯ
		 */
		public void findByClassRoom() {
						
			System.out.print("��ѡ��Ҫ��ѯ�İ༶(1.һ��,2.����,3.����)");
			int id=input.nextInt();
			String classRoom=null;
			switch (id) {
			case 1:
				classRoom="һ��";
				break;
			case 2:
				classRoom="����";
				break;
			case 3:
				classRoom="����";
				break;			
			}
			List<ApplyInfo> list=applyInfoservice.SearchApplyInfoByClassRoom(classRoom);
			System.out.println("��Ŀ"+"\t"+"����"+"\t"+"�༶"+"\t"+"����");
			for (int i = 0; i < list.size(); i++) {
				ApplyInfo info=list.get(i);
				System.out.println(info.getGame()+"\t"+info.getName()
				+"\t"+info.getClassRoom()+"\t"+info.getAge());
			}
						
		}
		
		/**
		 * ȡ������
		 */
		public void deleteStudent() {
			System.out.println("������ȡ��������ѧ��������");
			String name=input.next();
			boolean result=applyInfoservice.removeApplyInfo(name);
			if(result) {
				System.out.println("ȡ�������ɹ���");
			}else {
				System.out.println("ȡ������ʧ�ܣ�");
			}
		}		
	}	

