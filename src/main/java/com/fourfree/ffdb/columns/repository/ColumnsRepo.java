package com.fourfree.ffdb.columns.repository;


import com.fourfree.ffdb.columns.vo.ColumnsVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 1. 프로젝트명 : ffdb
 * 2. 패키지명   : com.fourfree.ffdb.main.repository
 * 3. 작성일     : 2022. 04. 28. 오후 5:28
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Repository
@Transactional
public interface ColumnsRepo extends JpaRepository<ColumnsVO, String>{
    List<ColumnsVO> findAllBy();

    //    @Query(nativeQuery = true, value = "" +
//            "SELECT * \n" +
//            "FROM INFORMATION_SCHEMA.COLUMNS \n" +
//            "WHERE TABLE_SCHEMA  = :table_schema \n" +
//            "AND TABLE_NAME = :table_name")
    List<ColumnsVO> findByTable_schemaAndTable_name(@Param("table_schema") String table_schema, @Param("table_name") String table_name);
}
