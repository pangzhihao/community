package life.majiang.community.controller;

import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.User;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public String index(HttpServletRequest request, Model model){
        Cookie[] cookies = request.getCookies();// 我寻思这里要加个是否null的判断 否则会空指针异常
        if(cookies!=null&&cookies.length!=0){
        for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if (user!=null) {
                request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        }else{
            System.out.println("cookie为空!");
        }

        List<QuestionDTO> questionList= questionService.list();
        model.addAttribute("questions",questionList);

        return "index";
    }
}
