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
		 * 主菜单
		 */
	public void menu() {
		boolean isExit = false;
			int num=0;
				do {
				System.out.println("**************************欢迎使用运动会报名系统**************************");
				System.out.println("1.学生报名"+",2.按比赛项目查询"+",3.按班级查询"+",4.取消报名"+",5.退出系统");			
				System.out.println("请选择(1~5):");
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
				
				System.out.println("谢谢使用！");
		}	
		/**
		 * 学生报名
		 */
		public void addInfo() {
			System.out.print("请输入姓名:");
			String name=input.next();
			System.out.print("请输入年龄:");
			int age=input.nextInt();
			System.out.print("请输入选择班级:(1.一班 ,2.二班,3.三班):");
			int no=input.nextInt();
			String classRoom=null;
			switch (no) {
			case 1:
				classRoom="一班";
				break;
			case 2:
				classRoom="二班";
				break;
			case 3:
				classRoom="三班";
				break;		
			}
			System.out.print("请选择报名项目(1.跳远, 2.接力跑 ,3.跳绳):");
			int id=input.nextInt();
			String game=null;
			switch (id) {
			case 1:
				game="跳远";
				break;
			case 2:
				game="接力跑";
				break;
			case 3:
				game="跳绳";
				break;		
			}
			
			ApplyInfo applyInfo=new ApplyInfo(name,age,classRoom,game);
			boolean result=applyInfoservice.addApplyInfo(applyInfo);
			if(result) {
				System.out.println("报名成功!");
			}else {
				System.out.println("报名失败!");
			}				
		}
		
		/**
		 * 根据比赛项目查询
		 */
		public void findByGame() {
			System.out.print("请选择要查询的比赛项目(1.跳跃,2.接力跑,3.跳绳)");
			int mun=input.nextInt();
			String game=null;
			switch (mun) {
			case 1:
				game="跳跃";
				break;
			case 2:
				game="接力跑";
				break;
			case 3:
				game="跳绳";
				break;			
			}
			List<ApplyInfo> list=applyInfoservice.SearchApplyInfoByGame(game);
			System.out.println("项目"+"\t"+"姓名"+"\t"+"班级"+"\t"+"年龄");
			for (int i = 0; i < list.size(); i++) {
				ApplyInfo info=list.get(i);
				System.out.println(info.getGame()+"\t"+info.getName()
				+"\t"+info.getClassRoom()+"\t"+info.getAge());
			}

		}
		
		/**
		 * 根据班级查询
		 */
		public void findByClassRoom() {
						
			System.out.print("请选择要查询的班级(1.一班,2.二班,3.三班)");
			int id=input.nextInt();
			String classRoom=null;
			switch (id) {
			case 1:
				classRoom="一班";
				break;
			case 2:
				classRoom="二班";
				break;
			case 3:
				classRoom="三班";
				break;			
			}
			List<ApplyInfo> list=applyInfoservice.SearchApplyInfoByClassRoom(classRoom);
			System.out.println("项目"+"\t"+"姓名"+"\t"+"班级"+"\t"+"年龄");
			for (int i = 0; i < list.size(); i++) {
				ApplyInfo info=list.get(i);
				System.out.println(info.getGame()+"\t"+info.getName()
				+"\t"+info.getClassRoom()+"\t"+info.getAge());
			}
						
		}
		
		/**
		 * 取消报名
		 */
		public void deleteStudent() {
			System.out.println("请输入取消报名的学生姓名：");
			String name=input.next();
			boolean result=applyInfoservice.removeApplyInfo(name);
			if(result) {
				System.out.println("取消报名成功！");
			}else {
				System.out.println("取消报名失败！");
			}
		}		
	}	

