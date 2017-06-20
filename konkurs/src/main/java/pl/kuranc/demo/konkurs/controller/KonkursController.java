package pl.kuranc.demo.konkurs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class KonkursController {
	
	@RequestMapping(value={"","/","/glowny","start"},method = RequestMethod.GET)
	public String start(Model model){
		return "login";
	}

}
