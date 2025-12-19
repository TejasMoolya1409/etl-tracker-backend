package com.etlTracker.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value = UserNotFoundException.class , produces = {"application/json"})
	public String userNotfoundHandler() {

		JsonObject json = new JsonObject();

		json.addProperty("msg", "invalid user email or password");
		json.addProperty("status", "failure");

		return json.toString();

	}

}
