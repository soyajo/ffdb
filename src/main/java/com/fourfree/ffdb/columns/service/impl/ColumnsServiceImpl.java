package com.fourfree.ffdb.columns.service.impl;

import com.fourfree.ffdb.columns.repository.ColumnsRepo;
import com.fourfree.ffdb.columns.service.ColumnsService;
import com.fourfree.ffdb.columns.vo.ColumnsVO;
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
public class ColumnsServiceImpl implements ColumnsService {
    @Autowired
    ColumnsRepo columnsRepo;

    @Override
    public List<ColumnsVO> findByTable_schemaAndTable_name(String table_schema, String table_name) {

        return columnsRepo.findByTable_schemaAndTable_name(table_schema, table_name);
    }
}
