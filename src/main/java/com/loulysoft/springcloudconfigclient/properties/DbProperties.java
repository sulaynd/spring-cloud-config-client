package com.loulysoft.springcloudconfigclient.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//@Component
@Configuration
@Data
//@ConfigurationProperties(prefix = "db")
@ConfigurationProperties("db")
public class DbProperties {

    //private Map<String, String> connection;
    private String connection;
    private String host;
    private int port;
}
