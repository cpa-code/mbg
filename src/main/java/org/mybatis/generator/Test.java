package org.mybatis.generator;

import org.mybatis.generator.conf.Conf;
import org.mybatis.generator.conf.MBG;
import org.mybatis.generator.conf.TableEntity;
import org.mybatis.generator.exception.InvalidConfigurationException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void demo(String[] args) throws InterruptedException, SQLException, IOException, InvalidConfigurationException {
        List<TableEntity> list = new ArrayList<TableEntity>();
        list.add(new TableEntity("user", "User"));
        Conf conf = new Conf();
        conf.setEntityTargetPackage("com.llq.test.entity");
        MBG.generatorConfig(list, conf);
    }
}
