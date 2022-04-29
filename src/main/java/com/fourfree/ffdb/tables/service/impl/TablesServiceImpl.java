package com.fourfree.ffdb.tables.service.impl;

import com.fourfree.ffdb.tables.repository.TablesRepo;
import com.fourfree.ffdb.tables.service.TablesService;
import com.fourfree.ffdb.tables.vo.TablesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 프로젝트명 : ffdb
 * 2. 패키지명   : com.fourfree.ffdb.main.service.impl
 * 3. 작성일     : 2022. 04. 28. 오후 5:29
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Service
public class TablesServiceImpl implements TablesService {
    @Autowired
    TablesRepo mainRepo;

    @Override
    public List<TablesVO> findAllBy() {

        return mainRepo.findAllBy();
    }

    @Override
    public List<TablesVO> findByTABLE_SCHEMA() {
        List<String> schemalist = new ArrayList<>();
        schemalist.add("fourfree_intranet");
        schemalist.add("fourfree_sales");
        schemalist.add("fourfree_fhome");
        schemalist.add("fourfree_farm");
        schemalist.stream().forEach(s ->{
            System.out.println(s);
        });
        return mainRepo.findByTABLE_SCHEMAIn(schemalist);
//        return null;/

    }

}
