package PolyLand;

import java.util.ArrayList;
import java.util.List;

public class MakeTotalList {

	/* �ڷ����� ������� ���� �������� ����Ʈ �����*/
	public List<OrderList> data = new ArrayList<OrderList>();
	OrderList orderList = null;


	public void OrderList(int ticket,int age,int price,int count,int first,double discount,double total) {
		OrderList order = new OrderList();
		order.setTicket(ticket);
		order.setAge(age);
		order.setPrice(price);
		order.setCount(count);
		order.setFirst(first);
		order.setDiscount(discount);
		order.setTotal(total);

		data.add(order);
	}

	public List<OrderList> getData() {
		return data;
	}
}
