package guru.springframework.api.controller;

import guru.springframework.api.domain.User;
import guru.springframework.api.springclientexample.config.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class UserController {

    private final ApiService apiService;

    @Autowired
    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"", "/", "/index"})
    public String index() {
        return "index";
    }

    @PostMapping({"/users"})
    public String forPost(Model model, ServerWebExchange serverWebExchange) {
        Mono<MultiValueMap<String, String>> map = serverWebExchange.getFormData();
        int limit = 0;
        Mono<List<User>> users = map.map(s -> apiService.getUsers(Integer.valueOf(s.getFirst("limit"))));
        if (limit == 0) {
            limit = 10;
        }
        model.addAttribute("users", users);
        return "userlist";
    }

    @PostMapping({"/usersreactivemode"})
    public String forPostReeactive(Model model, ServerWebExchange serverWebExchange) {
      /*  Mono<MultiValueMap<String, String>> map = serverWebExchange.getFormData();
        int limit = 0;
        Mono<List<User>> users = map.map(s -> apiService.getUsers(Integer.valueOf(s.getFirst("limit"))));
        if ( limit == 0){
            limit = 10;
        }*/
        model.addAttribute("users",
                apiService.getUsers(serverWebExchange
                        .getFormData().map(data -> new Integer(data.getFirst("limit"))))
        );
        return "userlist";
    }
}
