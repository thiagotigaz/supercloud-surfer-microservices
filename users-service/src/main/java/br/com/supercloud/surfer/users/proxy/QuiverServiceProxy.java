package br.com.supercloud.surfer.users.proxy;

import br.com.supercloud.surfer.users.model.QuiverBean;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// The FeignClient annotation already uses @RibbonClient for client side load balancing
@FeignClient(name = "zuul-server")
public interface QuiverServiceProxy {

    @GetMapping("/quivers-service/quivers/user/{userId}")
    List<QuiverBean> retrieveQuivers(@PathVariable Long userId);

}
