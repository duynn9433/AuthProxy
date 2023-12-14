package com.viettel.vtnet.authproxy.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthProxyController {
  @RequestMapping("/")
  public ResponseEntity<?> requestHandler(HttpServletRequest request){
    StringBuilder sb = new StringBuilder();
    System.out.println("URL: " + request.getRequestURL().toString());
    sb.append(request.getRequestURL().toString() + " \n ");
    System.out.println("Method: " + request.getMethod());
    sb.append(request.getMethod() + " \n ");

    // Get all header names from the request
    Enumeration<String> headerNames = request.getHeaderNames();

    // Iterate through the header names and print their values
    while (headerNames.hasMoreElements()) {
      String headerName = headerNames.nextElement();
      String headerValue = request.getHeader(headerName);
      System.out.println(headerName + ": " + headerValue);
      sb.append(headerName + ": " + headerValue + " \n ");
    }
    ResponseEntity responseEntity = ResponseEntity.ok(sb.toString());
    System.out.println("Response: " + responseEntity.toString());
    return responseEntity;
  }
}
