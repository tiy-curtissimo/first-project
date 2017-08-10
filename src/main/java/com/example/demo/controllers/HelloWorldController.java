package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Adder;
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
	
	// Create a class named Whisperer that makes Strings lower case
	// Using the method below, create a method named "whisper" for a GetMapping that
	//   does essentially the same thing *BUT* uses Whisperer.
	//   This means that you should map a GET to the path "whisper"
	//   This means you should have a method named "whisper" that returns a ModelAndView
	
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
	 
	@PostMapping("adder")
	public String addTwoNumbers(
			@RequestParam(name="left") int first, 
			@RequestParam(name="right") double second, 
			Model model
		) {
		Adder adder = new Adder(first, second);
		double result = adder.calculate();
		
		model.addAttribute("sum", result);
		return "helloworld/sum-result";
	}
	
}


















