package br.com.supercloud.surfer.users.proxy;

import br.com.supercloud.surfer.users.model.QuiverBean;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class QuiverServiceProxyFallback implements QuiverServiceProxy {

    @Override
    public List<QuiverBean> retrieveQuivers(Long userId) {
        return Collections.emptyList();
    }
}
