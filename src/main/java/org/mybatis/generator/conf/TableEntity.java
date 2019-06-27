package org.mybatis.generator.conf;

import lombok.Data;

@Data
public class TableEntity {
    private String tableName;
    private String domainObjectName;
    private Boolean selectByExampleEnable = Boolean.FALSE;
    private Boolean deleteByExampleEnable = Boolean.FALSE;
    private Boolean countByExampleEnable = Boolean.FALSE;
    private Boolean updateByExampleEnable = Boolean.FALSE;

    public TableEntity(String tableName, String domainObjectName) {
        this.tableName = tableName;
        this.domainObjectName = domainObjectName;
    }
}