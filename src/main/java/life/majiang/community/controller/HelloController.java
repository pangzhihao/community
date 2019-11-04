package life.majiang.community.controller;

import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
    public String index(HttpServletRequest request){
//        Cookie[] cookies = request.getCookies();// 我寻思这里要加个是否null的判断 否则会空指针异常
//        for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("token")) {
//                String token = cookie.getValue();
//                User user = userMapper.findByToken(token);
//                if (user!=null) {
//                request.getSession().setAttribute("user",user);
//                }
//                break;
//            }
//        }
        return "index";
    }
}
