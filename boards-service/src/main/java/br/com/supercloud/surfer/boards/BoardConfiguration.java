package br.com.supercloud.surfer.boards;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("boards-service")
public class BoardConfiguration {

    private String defaultColor;

}
