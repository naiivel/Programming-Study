package c6_queue;

import java.util.LinkedList;
import java.util.Queue;

class Message{
	//명령
	String order;
	//받는이
	String to;
	
	public Message(String order, String to) {
		super();
		this.order = order;
		this.to = to;
	}

	@Override
	public String toString() {
		return "Message [order=" + order + ", to=" + to + "]";
	}
}

public class QueueExample {  //먼저들어간게 먼저 수행됨 선입선출 : 순서대로 작업이 진행되어야할 때

	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<>();
		messageQueue.offer(new Message("sendMail","최기근"));
		messageQueue.offer(new Message("sendSMS", "박보영"));
		messageQueue.offer(new Message("sendKakaoTalk","서현진"));
		System.out.println(messageQueue.size());
		Message peekMessage = messageQueue.peek();
		System.out.println(peekMessage.order);
		System.out.println(messageQueue.size());
		
		while( !messageQueue.isEmpty()) {
			Message m = messageQueue.poll();
			switch(m.order) {
			 	case "sendMail" :
			 		System.out.println(m.to + "님에게 메일을 전송합니다.");
			 		break;
			 	case "sendSMS" :
			 		System.out.println(m.to + "님에게 문자를 보냅니다.");
			 		break;
			 	case "sendKakaoTalk" :
			 		System.out.println(m.to + "님에게 카톡을 보냅니다");
			 		break;
			}
		} //while 종료
		System.out.println(messageQueue.size());
	}
}
