package pl.dawidbasa.cats.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class ExceptionController {

	private Log logger = LogFactory.getLog(ExceptionController.class);

	@ExceptionHandler(value = Exception.class)
	public String handleError(HttpServletRequest req, Exception exception, Model model) {
		logger.error("Request: " + req.getRequestURL() + " raised " + exception);
		model.addAttribute("errorMsg",exception);
		return "error";
	}
}