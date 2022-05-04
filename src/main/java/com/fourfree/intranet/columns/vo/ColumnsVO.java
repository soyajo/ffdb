package com.fourfree.intranet.columns.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 1. 프로젝트명 : ffdb
 * 2. 패키지명   : com.fourfree.ffdb.menu.vo
 * 3. 작성일     : 2022. 04. 28. 오후 5:25
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COLUMNS")
public class ColumnsVO {
    // 테이블 스키마
    @Column(name = "TABLE_SCHEMA")
    private String table_schema;
    // 테이블 이름
    @Column(name = "TABLE_NAME")
    private String table_name;
    // 컬럼 이름
    @Id
    @Column(name = "COLUMN_NAME")
    private String column_name;
    // 컬럼 내용
    @Column(name = "COLUMN_COMMENT")
    private String column_comment;
    // 컬럼 타입
    @Column(name = "COLUMN_TYPE")
    private String column_type;
    // 널 여부
    @Column(name = "IS_NULLABLE")
    private String is_nullable;
    // 컬럼 기본값
    @Column(name = "COLUMN_DEFAULT")
    private String column_default;
    // 컬럼 키
    @Column(name = "COLUMN_KEY")
    private String column_key;


    // 객체 타입
    @Transient
    private String object_type;
    // pk 유무
    @Transient
    private Boolean pk_flag;
    // 테이블 이름(카멜 케이스)
    @Transient
    private String camel_tb_name;
}
