package org.mybatis.generator.conf;

import lombok.Data;

@Data
public class Conf {
    //驱动路径
    private String driverClass = "com.mysql.jdbc.Driver";
    //数据库连接串
    private String connectionURL = "jdbc:mysql://localhost:3306/test?useSSL=false&useUnicode=true&characterEncoding=utf8";
    //数据库用户名
    private String userId = "root";
    //数据库密码
    private String password = "root";
    //entity文件相对路径
    private String entityTargetPackage = "com.llq.demo.entity";
    //entity文件根路径
    private String entityTargetProject = "src/main/java";
    //sql文件相对路径
    private String sqlTargetPackage = "mapper";
    //sql文件根路径
    private String sqlTargetProject = "src/main/resources";
    //mapper文件相对路径
    private String daoTargetPackage = "com.llq.demo.mapper";
    //mapper文件根路径
    private String daoTargetProject = "src/main/java";
    private String contextTargetRuntime = "MyBatis3";
    private String contextId = "mysql";
    private String javaClientConfigurationType = "XMLMAPPER";
    private Boolean isMergeable = Boolean.TRUE;
    private String defaultModelType = "MyBatis3Simple";

}