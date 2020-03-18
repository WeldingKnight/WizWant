package com.shopping.view.chat;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
	@RequestMapping("/chat.do")
	public String showChatMain() {
		return "/views/chat/chat.jsp";
	}
}
//
//@Controller
//public class ChatController {
//	private List<ChatMessageVO> messages;
//	
//	
//	ChatController(){
//		messages = new ArrayList<>();
//	}
//	
//	@RequestMapping("/chat.do")
//	public String showChatMain() {
//		return "/views/chat/chat.jsp";
//	}
//	
//	@RequestMapping("/chat/doAddMessage")
//	public HashMap<String, Object> doAddMessage(String writer, String body) {
//		int id = messages.size()+1;
//		ChatMessageVO chatMessage = new ChatMessageVO(id, writer, body);
//		
//		messages.add(chatMessage);
//		
//		HashMap<String, Object> result = new HashMap<String, Object>();
//		result.put("msg", "메시지 전송");
//		return result;
//	}
//	
//	@RequestMapping("/chat/getAllMessages")
//	public List getAllMessages() {
//		return messages;
//	}
//	
//	@RequestMapping("/chat/getMessages")
//	public List getMessage(int from) {
//		return messages.subList(from, messages.size());
//	}
//	
//	@RequestMapping("/chat/clear")
//	public String clear() {
//		messages.clear();
//		return "전체 삭제";
//	}
//}
