package org.example.spring.base.cap9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.example.spring.base.cap9.service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService testService;
}
