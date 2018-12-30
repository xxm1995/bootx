package site.xxm.gen;


import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.io.IOUtils;
import site.xxm.gen.utils.GenUtils;
import site.xxm.gen.utils.JdbcUtils;
import site.xxm.gen.utils.TableUtils;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

public class GenApplication {

    public static void main(String[] args) throws SQLException, ConfigurationException {
        PropertiesConfiguration configuration = new PropertiesConfiguration( "generator.properties" );
        String tableName = configuration.getString( "tableName" );
        GenUtils.generatorCode(tableName);
        System.out.println("生成成功");
    }

}
