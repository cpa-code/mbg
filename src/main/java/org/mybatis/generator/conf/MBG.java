package org.mybatis.generator.conf;

import org.mybatis.generator.util.Constants;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MBG {
    public static void generatorConfig(List<TableEntity> tableList, Conf conf) throws InvalidConfigurationException, InterruptedException, SQLException, IOException {
        Context context = new Context(ModelType.FLAT);
        DefaultShellCallback callback = new DefaultShellCallback(Boolean.TRUE);
        MyBatisGenerator myBatisGenerator = null;

        addPlugins(context, conf);

        addGeneratorConfig(context, conf);

        addTableList(context, tableList);

        myBatisGenerator = new MyBatisGenerator(addConfig(context), callback, new ArrayList<String>());

        myBatisGenerator.generate(null);
    }

    private static Configuration addConfig(Context context) {
        Configuration config = new Configuration();
        config.addContext(context);
        return config;
    }

    private static void addPlugins(Context context, Conf conf) {
        if (conf.getIsMergeable()) {
            PluginConfiguration pluginConfiguration = new PluginConfiguration();
            pluginConfiguration.setConfigurationType(Constants.MY_IS_MERGEABLE_PLUGIN);
            context.addPluginConfiguration(pluginConfiguration);
        }
    }

    private static void addTableList(Context context, List<TableEntity> tableList) {
        tableList.stream().forEach(tableEntity -> {
            TableConfiguration tableConfiguration = new TableConfiguration(context);
            tableConfiguration.setTableName(tableEntity.getTableName());
            tableConfiguration.setDomainObjectName(tableEntity.getDomainObjectName());
            tableConfiguration.setSelectByExampleStatementEnabled(tableEntity.getSelectByExampleEnable());
            tableConfiguration.setDeleteByExampleStatementEnabled(tableEntity.getDeleteByExampleEnable());
            tableConfiguration.setCountByExampleStatementEnabled(tableEntity.getCountByExampleEnable());
            tableConfiguration.setUpdateByExampleStatementEnabled(tableEntity.getUpdateByExampleEnable());
            context.addTableConfiguration(tableConfiguration);
        });
    }

    private static void addGeneratorConfig(Context context, Conf conf) {

        CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
        commentGeneratorConfiguration.addProperty("suppressDate", "true");
        commentGeneratorConfiguration.addProperty("suppressAllComments", "true");

        /*数据库链接URL，用户名、密码 */
        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setDriverClass(conf.getDriverClass());
        jdbcConnectionConfiguration.setConnectionURL(conf.getConnectionURL());
        jdbcConnectionConfiguration.setUserId(conf.getUserId());
        jdbcConnectionConfiguration.setPassword(conf.getPassword());

        JavaTypeResolverConfiguration javaTypeResolverConfiguration = new JavaTypeResolverConfiguration();
        javaTypeResolverConfiguration.addProperty("forceBigDecimals", "false");

        /*生成模型的包名和位置*/
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetPackage(conf.getEntityTargetPackage());
        javaModelGeneratorConfiguration.setTargetProject(conf.getEntityTargetProject());
        javaModelGeneratorConfiguration.addProperty("enableSubPackages", "true");
        javaModelGeneratorConfiguration.addProperty("trimStrings", "true");

        /*生成映射文件的包名和位置*/
        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetPackage(conf.getSqlTargetPackage());
        sqlMapGeneratorConfiguration.setTargetProject(conf.getSqlTargetProject());
        sqlMapGeneratorConfiguration.addProperty("enableSubPackages", "true");

        /*生成DAO的包名和位置*/
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setConfigurationType(conf.getJavaClientConfigurationType());
        javaClientGeneratorConfiguration.setTargetPackage(conf.getDaoTargetPackage());
        javaClientGeneratorConfiguration.setTargetProject(conf.getDaoTargetProject());
        javaClientGeneratorConfiguration.addProperty("enableSubPackages", "true");

        context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);
        context.setJavaTypeResolverConfiguration(javaTypeResolverConfiguration);
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
        context.setTargetRuntime(conf.getContextTargetRuntime());
        context.setId(conf.getContextId());

    }





}
