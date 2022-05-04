package com.fourfree.intranet.main.controller;


import com.fourfree.common.controller.BaseController;
import com.fourfree.intranet.columns.service.ColumnsService;
import com.fourfree.intranet.columns.vo.ColumnsVO;
import com.fourfree.intranet.tables.service.TablesService;

import com.fourfree.intranet.tables.vo.TablesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.JdbcUtils;
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
public class MainController extends BaseController {


    @Autowired
    ColumnsService columnsService;
    @Autowired
    TablesService tablesService;

//    @PostMapping(value = "/menulist")
//    @ResponseBody
//    public Map<String,List<TablesVO>> menulist(String name) {
//        List<TablesVO> mainVOS = tablesService.findByTABLE_SCHEMA();
//        Map<String,List<TablesVO>> maplist = mainVOS.stream().collect(Collectors.groupingBy(TablesVO::getTable_schema));
//        return maplist;
//    }

    @GetMapping("/")
    public String index(Model model,String db_type, String table_schema, String table_name) {

        List<ColumnsVO> columnsVOS = columnsService.findByTable_schemaAndTable_name(table_schema, table_name);
        String camel_tb_name = JdbcUtils.convertUnderscoreNameToPropertyName(table_name);

        model.addAttribute("db_type", db_type);
        model.addAttribute("table_schema", table_schema);
        model.addAttribute("table_name", table_name);
        model.addAttribute("camel_tb_name", camel_tb_name);
        model.addAttribute("table_name", table_name);
        model.addAttribute("columnsVOS", columnsVOS);
        return "main/index";
    }
}
