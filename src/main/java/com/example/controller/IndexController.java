package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @RequestMapping(path={"/index","/"})
    @ResponseBody
    public String index(){
        return "Hello World";
    }

    @RequestMapping(value={"/profile/{groupId}/{userId}"})
    @ResponseBody
    public String profile(@PathVariable("groupId") String goupId,
                          @PathVariable("userId") int userId,
                          @RequestParam(value = "type", defaultValue = "1") int type,
                          @RequestParam(value = "key", defaultValue = "nowcoder") String key){
        return String.format("{%s},{%d},{%d},{%s}",goupId,userId,type,key);
    }

    @RequestMapping(value={"/vm"})
    public String news(Model model){

        model.addAttribute("value1","vv1");

        List<String> list = new ArrayList<String>();
        for(int j = 0; j < 4; j++){
            list.add(String.valueOf(j));
        }
        model.addAttribute("list",list);

        Map<String,String> map = new HashMap<String,String>();
        for(int i = 0; i < 4; i++){
            map.put(String.valueOf(i),String.valueOf(i*i));
        }
        model.addAttribute("map",map);
        return "news";
    }
}
