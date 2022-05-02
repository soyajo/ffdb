package com.fourfree.intranet.main.controller;


import com.fourfree.intranet.columns.service.ColumnsService;
import com.fourfree.intranet.columns.vo.ColumnsVO;
import com.fourfree.intranet.tables.service.TablesService;

import com.fourfree.intranet.tables.vo.TablesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    ColumnsService columnsService;
    @Autowired
    TablesService tablesService;

    @PostMapping(value = "/menulist")
    @ResponseBody
    public Map<String,List<TablesVO>> menulist(String name) {
        List<TablesVO> mainVOS = tablesService.findByTABLE_SCHEMA();
        Map<String,List<TablesVO>> maplist = mainVOS.stream().collect(Collectors.groupingBy(TablesVO::getTable_schema));
        return maplist;
    }

    @GetMapping("/")
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

    @GetMapping("/test02")
    public String test02(Model model, String table_schema, String table_name) {

        List<ColumnsVO> columnsVOS = columnsService.findByTable_schemaAndTable_name(table_schema, table_name);
        model.addAttribute("table_schema", table_schema);
        model.addAttribute("table_name", table_name);
        model.addAttribute("columnsVOS", columnsVOS);
        return "test02";
    }
}
