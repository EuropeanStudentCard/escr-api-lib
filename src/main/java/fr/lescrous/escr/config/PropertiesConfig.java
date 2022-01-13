package fr.lescrous.escr.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

import java.io.File;

@Configuration
@EnableConfigurationProperties
public class PropertiesConfig {

    private final Logger LOG = LoggerFactory.getLogger(PropertiesConfig.class);

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        LOG.error("CA COMMENCE CAC COMMENCECN ECJ EJC OIEJFOIHFOIHSDOI");
        PropertySourcesPlaceholderConfigurer properties =
                new PropertySourcesPlaceholderConfigurer();
        File jarPath=new File(PropertiesConfig.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String propertiesPath=jarPath.getParentFile().getAbsolutePath();
        properties.setLocation(new FileSystemResource(propertiesPath+"/application-escr.properties"));
        properties.setIgnoreResourceNotFound(false);
        return properties;
    }
}
