package org.mybatis.generator.myPlugin;

import org.mybatis.generator.util.Constants;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.lang.reflect.Field;
import java.util.List;

public class MyIsMergeablePlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        try {
            Field field = sqlMap.getClass().getDeclaredField(Constants.IS_MERGEABLE);
            field.setAccessible(Boolean.TRUE);
            field.setBoolean(sqlMap, Boolean.FALSE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}