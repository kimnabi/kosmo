package a.b.c.com.kos.mem.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.common.CommandMap;
import a.b.c.com.common.chabun.service.KosChabunService;
import a.b.c.com.kos.mem.service.KosMemberMapService;

@Controller
public class KosMemberMapController {

	@Autowired(required = false)
	KosMemberMapService kosMemberMapService;

	// 필드 오토 와이어드
	@Autowired(required = false)
	private KosChabunService kosChabunService;

	private Logger logger = LoggerFactory.getLogger(KosMemberMapController.class);

	   @RequestMapping(value="/boardList" )
	    public @ResponseBody List<Map<String,Object>> openBoardList(Model m,@RequestBody  Map<String, Object> param) throws Exception {
		   	
		   logger.info("openBoardList 함수 진입 >>> : ");
			// 서비스 호출
		   List<Map<String,Object>> listAll = kosMemberMapService.kosMemberSelectAll(param);
	    //    listAll.size()
	   //     m.addAttribute("listAll", listAll);
	    //    m.addAttribute("Cnt",  listAll.size());
	        
	        return listAll;
	        
	    }

}
