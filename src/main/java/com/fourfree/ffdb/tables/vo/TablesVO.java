package com.fourfree.ffdb.tables.vo;

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
@Table(name = "TABLES")
public class TablesVO {

    @Column(name = "TABLE_CATALOG")
    private String table_catalog;

    @Column(name = "TABLE_SCHEMA")
    private String table_schema;

    @Id
    @Column(name = "TABLE_NAME")
    private String table_name;

    @Column(name = "TABLE_TYPE")
    private String table_type;

    @Column(name = "ENGINE")
    private String engine;

    @Column(name = "VERSION")
    private Integer version;
}
