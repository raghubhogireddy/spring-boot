package io.spring.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ToDoController {
    
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello! What are you learning today ?";
    }
    
    @RequestMapping("/hello-html")
    @ResponseBody
    public String helloHtml() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>");
        stringBuffer.append("<head>");
        stringBuffer.append("<title>");
        stringBuffer.append("page in Html");
        stringBuffer.append("</title>");
        stringBuffer.append("</head>");
        stringBuffer.append("<body>");
        stringBuffer.append("Body for Html page");
        stringBuffer.append("</body>");
        stringBuffer.append("</html>");
        return stringBuffer.toString();
    }
}
