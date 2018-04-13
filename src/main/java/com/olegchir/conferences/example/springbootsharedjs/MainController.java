package com.olegchir.conferences.example.springbootsharedjs;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class MainController {
    private JSExecutor executor;

    @PostConstruct
    public void postConstruct() {
        executor = new JSExecutor();
    }

    @RequestMapping("/")
    public String main(@RequestParam("id") Integer id) {
        Object result = executor.executeFunction("validate", id);
        //Object result = executor.execute(String.format("validate(%d);", id));
        return null != result ? result.toString() : "error";
    }
}
