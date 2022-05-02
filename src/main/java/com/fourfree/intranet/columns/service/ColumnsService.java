package com.fourfree.intranet.columns.service;

import com.fourfree.intranet.columns.vo.ColumnsVO;

import java.util.List;

/**
 * 1. 프로젝트명 : ffdb
 * 2. 패키지명   : com.fourfree.ffdb.menu.service
 * 3. 작성일     : 2022. 04. 28. 오후 5:25
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public interface ColumnsService {
    List<ColumnsVO> findByTable_schemaAndTable_name(String table_schema, String table_name);
}
