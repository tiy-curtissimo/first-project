package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Whisperer;
import com.example.demo.models.Yeller;

@Controller
@RequestMapping({"/", "/HelloWorld"})
public class HelloWorldController {
	
	private String title;
	
	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}
	
	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}
	
	@GetMapping("whisper")
	public ModelAndView makeThingsQuiet(
		@RequestParam(required=false, defaultValue="«shhhhhh»") String submittedMessage
	) {
		Whisperer quietMaker = new Whisperer(submittedMessage);
		String result = quietMaker.quiet();
		
		ModelAndView mv = new ModelAndView("helloworld/message");
		mv.addObject("title", title);
		mv.addObject("thisIsWhatIShouldShow", result);
		return mv;
	}
	
	
	@GetMapping("message-path") // URL to which the form submits
	public ModelAndView messageMethod(
			@RequestParam(required=false, defaultValue="«silence»") String submittedMessage
		) {
		Yeller asdlkjfnalsdfkj = new Yeller(submittedMessage);
		String result = asdlkjfnalsdfkj.repeatWhatISayButLouder();
		
		ModelAndView mv = new ModelAndView("helloworld/message");
		mv.addObject("pageTitle", title);
		mv.addObject("thisIsWhatIShouldShow", result);
		return mv;
	}
	
	@GetMapping("say-something")
	public String makeAChoice(
		String speechChoice,
		String submittedMessage,
		Model theThingIPutDataIntoForTheView
	) {
		// if speechChoice is yell
		if (speechChoice.equals("yell")) {
			// make submittedMessage loud
			Yeller aVariableThatHoldsAYellerObject = new Yeller(submittedMessage);
			String loud = aVariableThatHoldsAYellerObject.repeatWhatISayButLouder();
			theThingIPutDataIntoForTheView.addAttribute("output", loud);
		} else { // otherwise
			//make submittedMessage quiet
			Whisperer someQuietThing = new Whisperer(submittedMessage);
			String quiet = someQuietThing.quiet();
			theThingIPutDataIntoForTheView.addAttribute("output", quiet);
		}
		return "helloworld/mixed-messages";
	}
	
}


















