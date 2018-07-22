package net.xdclass.demo2.controller;

import net.xdclass.demo2.domain.ServerSetting;
import net.xdclass.demo2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GetController {

    private Map<String, Object> params = new HashMap<>();

//    @RequestMapping(path = "/{city_id}/{user_id}", method = RequestMethod.GET)
//    public Object findUser(@PathVariable("city_id") String cityId, @PathVariable("user_id") String userId){
//        params.clear();
//        params.put("cityId", cityId);
//        params.put("userId", userId);
//        return params;
//    }
    @GetMapping(value = "/v1/page_user1")
    public Object pageUser(int from, int size){
        params.clear();
        params.put("from", from);
        params.put("size", size);
        System.out.println("热加载");
        return params;
    }

    @GetMapping(value = "/v1/page_user2")
    public Object pageUser2(@RequestParam(defaultValue = "0", name = "page") int from, int size){
        params.clear();
        params.put("from", from);
        params.put("size", size);
        return params;
    }

    /**
     * 需要指定http头为 content-type  application/json
     * @param user
     * @return
     */
    @RequestMapping("/v1/save_user")
    public Object saveUser(@RequestBody User user){
        params.clear();
        params.put("user", user);
        return params;
    }

    @GetMapping("/v1/get_header")
    public Object getHeader(@RequestHeader("access_token") String accessToken, String id){
        params.clear();
        params.put("access_token", accessToken);
        params.put("id", id);
        return params;
    }

    @GetMapping("/v1/test_request")
    public Object testRequest(HttpServletRequest request){
        params.clear();
        String id = request.getParameter("id");
        params.put("id", id);
        return params;
    }

    @Autowired
    private ServerSetting serverSetting;

    @GetMapping("/v1/test_properties")
    public Object testPeroperties(HttpServletRequest request){
        int order = Ordered.HIGHEST_PRECEDENCE;
        return serverSetting;
    }

    @GetMapping("/api2/v1/test_ext")
    public Object testinter(HttpServletRequest request){
        System.out.println("controller =---->accoutn");
        params.put("money", 1000);
        return params;
    }
}
