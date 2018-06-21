package online.qsx.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * yml/properties文件对应的配置Bean
 */
@ConfigurationProperties(prefix = "author")
public class AutoAuthorProperties {
    private String loginName;
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AutoAuthorProperties{" +
                "loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
