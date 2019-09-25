package br.com.supercloud.surfer.users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("users-service")
public class UserConfiguration {

    private final Thumbnail thumbnail = new Thumbnail();

    @Getter
    @Setter
    class Thumbnail {
        private int height;
        private int width;
    }

}
