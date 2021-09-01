package com.taeny.kms.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "my.application.properties")
@Getter @Setter
public class ApplicationProperties {

    private String localAesKey;
}
