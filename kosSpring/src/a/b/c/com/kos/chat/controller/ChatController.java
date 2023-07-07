package a.b.c.com.kos.chat.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import a.b.c.com.kos.board.controller.KosBoardController;

@Controller
public class ChatController {
 
	private Logger logger = LogManager.getLogger(KosBoardController.class);
	
	//채팅 폼 호출
	@RequestMapping(value="chat")
	public String chatForm() {
		logger.info("ChatController chatForm  블록진입");
		return "chat/chat";
	}
}
