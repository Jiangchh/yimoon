package com.yimoom.pplay.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
@PreAuthorize("hasRole('USER')")
public class TodoController {
    // 略去
} 
