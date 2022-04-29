package com.fourfree.ffdb.main.controller;

import com.fourfree.ffdb.main.service.MainService;
import com.fourfree.ffdb.main.vo.MainVO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 1. 프로젝트명 : ffdb
 * 2. 패키지명   : com.fourfree.ffdb.controller
 * 3. 작성일     : 2022. 04. 27. 오후 12:31
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @PostMapping(value = "/menulist")
    @ResponseBody
    public Map<String,List<MainVO>> menulist(String name) {
        Gson gson = new Gson();
        List<MainVO> mainVOS = mainService.findByTABLE_SCHEMA();
        Map<String,List<MainVO>> maplist = mainVOS.stream().collect(Collectors.groupingBy(MainVO::getTable_schema));
        String maplist_st = gson.toJson(maplist);
        return maplist;
    }

    @GetMapping("/test01")
    public String test01(Model model) {

        model.addAttribute("name", "소야");
        model.addAttribute("flag", false);
        HashMap<String, HashMap<String, Object>> map = new HashMap<>();
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("fullname", "조소야");
        map1.put("tel", "01046938128");
        map.put("soya",map1);
        model.addAttribute("data", map);
        model.addAttribute("flag", false);

        return "test01";
    }
}
