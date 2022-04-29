package com.fourfree.ffdb.columns.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "Columns")
public class ColumnsVO {

    @Column(name = "TABLE_SCHEMA")
    private String table_schema;

    @Column(name = "TABLE_NAME")
    private String table_name;

    @Id
    @Column(name = "COLUMN_NAME")
    private String column_name;

    @Column(name = "COLUMN_TYPE")
    private String column_type;

    @Column(name = "IS_NULLABLE")
    private Integer is_nullable;

    @Column(name = "COLUMN_DEFAULT")
    private Integer column_default;
}
