package PolyLand;

import java.util.Scanner;

public class Main {

	static int totalordercount = 0;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			MakeTotalList makeTotalList = new MakeTotalList();
			while (true) {
				int ticket = InputClass.get_ticket();
				int age = InputClass.get_age();
				int price = InputClass.get_price(ticket, age);
				int count = InputClass.get_count();
				int first = InputClass.get_first();
				double discount = InputClass.get_discount(first);
				double total = price * count * discount;
				makeTotalList.OrderList(ticket, age, price, count, first, discount, total);
				System.out.printf("가격은 %.0f 원 입니다.\n", total);
				System.out.print("감사합니다.\n");

				System.out.print("계속 발권하시겠습니까?\n");
				System.out.print("1. 티켓 발권\n");
				System.out.print("2. 종료\n");
				int end = sc.nextInt();

				if (end == 2) {
					break;
				}
				totalordercount++;
			}

			System.out.print("티켓 발권을 종료합니다. 감사합니다.\n\n");

			PrintClass.printTotalList(makeTotalList);

			System.out.print("계속 진행(1: 새로운 주문, 2: 프로그램 종료):");
			int ing = sc.nextInt();
			if (ing == 2) {
				break;
			}
		}
	}

	
}
