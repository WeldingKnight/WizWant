package com.shopping.view.chat;


import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.MVC_reshop.chat.ChatMessageVO;

@Controller
public class ChatController {
	@RequestMapping("/chat.do")
	public String showChatMain() {
		return "/views/chat/chat.jsp";
	}
	
	@MessageMapping("/chat")
	@SendTo("/chat/roomId")
	public ChatMessageVO sendMessage(ChatMessageVO message) throws Exception{
		ChatMessageVO chat = new ChatMessageVO();
		chat.setWriter(message.getWriter());
		chat.setBody(message.getBody());
		return message;
	}
	
	@MessageExceptionHandler
	@SendTo("/chat/error")
	public String handleException(Throwable exception) {
		return exception.getMessage();
	}
	
	
}