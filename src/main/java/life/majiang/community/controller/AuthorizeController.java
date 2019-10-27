package life.majiang.community.controller;

import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,@RequestParam(name="state")String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("1596995930b5521a65d0");
        accessTokenDTO.setClient_secret("5b3d464ffc94d8d6570f62b8d12082cebd3623ee");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        githubProvider.getAccessToken(accessTokenDTO);

        return "index";
    }
}
