package com.fourfree.intranet.columns.service.impl;


import com.fourfree.intranet.columns.repository.ColumnsRepo;
import com.fourfree.intranet.columns.service.ColumnsService;
import com.fourfree.intranet.columns.vo.ColumnsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.JdbcUtils;
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
        if (table_name != null && table_schema != null) {
            List<ColumnsVO> columnsVOS  = columnsRepo.findByTable_schemaAndTable_name(table_schema, table_name);
            columnsVOS.stream().forEach(columnsVO -> {
                // db 컬럼 타입에 맞춰 객체 타입 만들어 주기
                if (columnsVO != null) {
                    if (columnsVO.getColumn_type() != null) {
                        if (columnsVO.getColumn_type().contains("int")) {
                            columnsVO.setObject_type("Integer");
                        } else if (columnsVO.getColumn_type().contains("blob")) {
                            columnsVO.setObject_type("Integer");
                        } else if (columnsVO.getColumn_type().contains("char") || columnsVO.getColumn_type().contains("varbinary")) {
                            columnsVO.setObject_type("String");
                        } else if (columnsVO.getColumn_type().contains("binary") || columnsVO.getColumn_type().contains("byte")) {
                            columnsVO.setObject_type("String");
                        } else if (columnsVO.getColumn_type().contains("set") || columnsVO.getColumn_type().contains("enum")) {
                            columnsVO.setObject_type("String");
                        } else if (columnsVO.getColumn_type().contains("text")) {
                            columnsVO.setObject_type("Text");
                        } else if (columnsVO.getColumn_type().contains("time") || columnsVO.getColumn_type().contains("date") || columnsVO.getColumn_type().contains("year")) {
                            columnsVO.setObject_type("Date");
                        } else if (columnsVO.getColumn_type().contains("float") || columnsVO.getColumn_type().contains("decimal")) {
                            columnsVO.setObject_type("Float");
                        } else if (columnsVO.getColumn_type().contains("double")) {
                            columnsVO.setObject_type("Double");
                        } else {
                            columnsVO.setObject_type("타입");
                        }
                    }
                    // pk 유무 확인
                    if (columnsVO.getColumn_key() != null) {
                        if (columnsVO.getColumn_key().contains("PRI")) {
                            columnsVO.setPk_flag(true);
                        } else {
                            columnsVO.setPk_flag(false);
                        }
                    } else {
                        columnsVO.setPk_flag(false);
                    }
                    if (columnsVO.getTable_name() != null) {
                        String camel_tb_name = JdbcUtils.convertUnderscoreNameToPropertyName(columnsVO.getTable_name());
                        columnsVO.setCamel_tb_name(camel_tb_name);
                    }
                }
            });
            return columnsVOS;
        } else {
            return new ArrayList<>();
        }

    }
}
