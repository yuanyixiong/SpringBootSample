package online.qsx.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = AutoAuthorProperties.class)//加载的配置属性Bean
@ConditionalOnClass(AutoAuthor.class)//当类路径下有指定的类情况下
@ConditionalOnProperty(prefix = "author",value ="enable",matchIfMissing = true)//指定的属性是否有指定的值
public class AutoAuthorConfigurtaion {

    @Autowired
    private AutoAuthorProperties autoAuthorProperties;

    @Bean
    @ConditionalOnMissingBean(AutoAuthor.class)//当容器中没有指定Bean的情况下
    public AutoAuthor createAutoAuthor(){
        AutoAuthor autoAuthor=new AutoAuthor();
        autoAuthor.setPassword(this.autoAuthorProperties.getPassword());
        autoAuthor.setLoginName(this.autoAuthorProperties.getLoginName());
        return autoAuthor;
    }
}
