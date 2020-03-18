package com.shopping.view.chat;


import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.MVC_reshop.chat.ChatMessageVO;

@Controller
public class ChatController {
	@RequestMapping("/chat.do")
	public String showChatMain() {
		return "/views/chat/chat.jsp";
	}
	
	@MessageMapping("/message")
	@SendToUser("/chat/reply")
	public ChatMessageVO sendMessage(ChatMessageVO message) throws Exception{
		ChatMessageVO chat = new ChatMessageVO();
		chat.setBody(message.getBody());
		chat.setWriter(message.getWriter());
		return chat; 
	}
	
	@MessageExceptionHandler
	@SendToUser("/chat/error")
	public String handleException(Throwable exception) {
		return exception.getMessage();
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
