package com.fourfree.information_schema.tables.repository;


import com.fourfree.information_schema.tables.vo.TablesVO;
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
public interface TablesRepo extends JpaRepository<TablesVO, String>{
    List<TablesVO> findAllBy();

    @Query(nativeQuery = true, value = "SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA IN (:table_schemas)")
    List<TablesVO> findByTABLE_SCHEMAIn(@Param("table_schemas") List<String> table_schemas);
}
