package com.fourfree.ffdb.main.repository;

import com.fourfree.ffdb.main.vo.MainVO;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
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
public interface MainRepo extends JpaRepository<MainVO, String>{
    List<MainVO> findAllBy();

    @Query(nativeQuery = true, value = "select * from information_schema.TABLES where TABLE_SCHEMA in (:table_schemas)")
    List<MainVO> findByTABLE_SCHEMAIn(@Param("table_schemas") List<String> table_schemas);
}
