package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import exeption.ProcessedApplicationNotFoundException;
import model.BaseApplication;

@RestController("/application")
public class ApplicationController {
	@GetMapping("/{id}")
	public BaseApplication getApplicationProcessingResultById(@PathVariable(name="id") int id) {
		return null;		
	}
	@PostMapping("/request")
	public BaseApplication setApplicationForProcessing(@RequestBody BaseApplication app) {
		return null;
	}
	@ExceptionHandler(ProcessedApplicationNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest request, ProcessedApplicationNotFoundException exception){
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId", exception.getAppId());
		mav.addObject("exception", exception);
		mav.addObject("url", request.getRequestURL()+"?"+request.getQueryString());
		mav.setViewName("productNotFound");
		return mav;
	}
	
}
