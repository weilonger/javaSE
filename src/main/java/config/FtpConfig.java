package main.java.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FtpConfig {

    @Value("${spring.image.ftp.host}")
    private String host;

    @Value("${spring.image.ftp.port}")
    private int port;

    @Value("${spring.image.ftp.username}")
    private String username;

    @Value("${spring.image.ftp.password}")
    private String password;

    @Value("${spring.image.ftp.path}")
    private String path;

    @Value("${spring.image.ftp.ip}")
    private String ip;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
