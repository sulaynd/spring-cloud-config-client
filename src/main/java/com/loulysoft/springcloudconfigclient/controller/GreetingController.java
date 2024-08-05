package com.loulysoft.springcloudconfigclient.controller;


import com.loulysoft.springcloudconfigclient.properties.DbProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class GreetingController {
    @Value("${my.greeting}")
    private String greetingMessage;

    @Value("some static Message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

//    @Value("#{${my.dbValues}}")
//    private Map<String, String> dbValues;

   // @Autowired
   // private  DbProperties db;

    private final DbProperties db;
    private final Environment env;

    public GreetingController(DbProperties db, Environment env){

        this.db = db;
        this.env = env;
    }

  //  public GreetingController(){}

    @GetMapping("/greeting")
    public String greeting(){
        return greetingMessage;
       // return "url: " + db.getConnection() + " ,host: " + db.getHost() + " ,port: " + db.getPort();
    }

    @GetMapping("/envDetails")
    public String[] envDetails(){
        return env.getActiveProfiles();
    }
}
