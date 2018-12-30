package site.xxm.gen.utils;


import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import site.xxm.gen.config.Constant;
import site.xxm.gen.entity.ColumnDO;
import site.xxm.gen.entity.TableDO;
import site.xxm.gen.exception.BDException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.*;

/**
 * 代码生成器工具类
 */
public class GenUtils {

    /**
     * 模板
     * @return list
     */
    private static List<String> getTemplates() {
        List<String> templates = new ArrayList<>();
        templates.add("generator/Entity.java.vm");
        templates.add("generator/Dao.java.vm");
        templates.add("generator/Mapper.xml.vm");
        templates.add("generator/Service.java.vm");
        templates.add("generator/ServiceImpl.java.vm");
        templates.add("generator/Controller.java.vm");

        templates.add("generator/list.html.vm");
        templates.add("generator/add.html.vm");
        templates.add("generator/edit.html.vm");
        templates.add("generator/list.js.vm");
        templates.add("generator/add.js.vm");
        templates.add("generator/edit.js.vm");

        return templates;
    }

    /**
     * 生成代码
     */
    public static void generatorCode(String tableName) throws SQLException {
        //查询表信息
        Map<String, String> table = TableUtils.tabInfo(tableName);
        //查询列信息
        List<Map<String, String>> columns = TableUtils.listColumns(tableName);
        //配置信息
        Configuration config = getConfig();
        //表信息
        TableDO tableDO = new TableDO();
        tableDO.setTableName(table.get("tableName"));
        tableDO.setComments(table.get("tableComment"));
        //表名转换成Java类名
        String className = tableToJava(tableDO.getTableName(), config.getString("tablePrefix"), config.getString("autoRemovePre"));
        tableDO.setClassName(className);
        tableDO.setClassname(StringUtils.uncapitalize(className));

        //列信息
        List<ColumnDO> columsList = new ArrayList<>();
        for (Map<String, String> column : columns) {
            ColumnDO columnDO = new ColumnDO();
            columnDO.setColumnName(column.get("columnName"));
            columnDO.setDataType(column.get("dataType"));
            columnDO.setComments(column.get("columnComment"));
            columnDO.setExtra(column.get("extra"));

            //列名转换成Java属性名
            String attrName = columnToJava(columnDO.getColumnName());
            columnDO.setAttrName(attrName);
            columnDO.setAttrname(StringUtils.uncapitalize(attrName));

            //列的数据类型，转换成Java类型
            String attrType = config.getString(columnDO.getDataType(), "unknowType");
            columnDO.setAttrType(attrType);

            //是否主键
            if ("PRI".equalsIgnoreCase(column.get("columnKey")) && tableDO.getPk() == null) {
                tableDO.setPk(columnDO);
            }

            columsList.add(columnDO);
        }
        tableDO.setColumns(columsList);

        //没主键，则第一个字段为主键
        if (tableDO.getPk() == null) {
            tableDO.setPk(tableDO.getColumns().get(0));
        }

        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);

        //封装模板数据
        Map<String, Object> map = new HashMap<>(16);
        map.put("tableName", tableDO.getTableName());
        map.put("comments", tableDO.getComments());
        map.put("pk", tableDO.getPk());
        map.put("className", tableDO.getClassName());
        map.put("classname", tableDO.getClassname());
        map.put("pathName", config.getString("package").substring(config.getString("package").lastIndexOf(".") + 1));
        map.put("columns", tableDO.getColumns());
        map.put("package", config.getString("package"));
        map.put("author", config.getString("author"));
        map.put("email", config.getString("email"));
        map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
        VelocityContext context = new VelocityContext(map);

        //获取模板列表
        List<String> templates = getTemplates();
        for (String template : templates) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);
            try {
                String fileName = getFileName( template, tableDO.getClassname(), tableDO.getClassName(),
                        config.getString( "package" ).substring( config.getString( "package" ).lastIndexOf( "." ) + 1 ) );
                System.out.println(fileName);
                File file = new File( fileName );
                FileUtil.createNewFile(file);
                FileOutputStream fos = new FileOutputStream( file );
                IOUtils.write(sw.toString(), fos, "UTF-8");
                IOUtils.closeQuietly(sw,fos);
            } catch (IOException e) {
                throw new BDException("渲染模板失败，表名：" + tableDO.getTableName(),e);
            }
        }
    }

    /**
     * 列名转换成Java属性名
     */
    private static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }

    /**
     * 表名转换成Java类名
     */
    private static String tableToJava(String tableName, String tablePrefix, String autoRemovePre) {
        if (Constant.AUTO_REOMVE_PRE.equals(autoRemovePre)) {
            tableName = tableName.substring(tableName.indexOf("_") + 1);
        }
        if (StringUtils.isNotBlank(tablePrefix)) {
            tableName = tableName.replace(tablePrefix, "");
        }

        return columnToJava(tableName);
    }

    /**
     * 获取配置信息
     */
    private static Configuration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            throw new BDException("获取配置文件失败，", e);
        }
    }

    /**
     * 获取文件名
     */
    private static String getFileName(String template, String classname, String className, String packageName) {
        String packagePath = "gen" + File.separator + "java" +File.separator +  classname + File.separator;
        String path = "cb";
        if (template.contains("Entity.java.vm")) {
            return packagePath + "java"+ File.separator +"entity" + File.separator + className + "DO.java";
        }

        if (template.contains("Dao.java.vm")) {
            return packagePath + "java"+ File.separator +"dao" + File.separator + className + "Dao.java";
        }

        if (template.contains("Service.java.vm")) {
            return packagePath + "java"+ File.separator +"service" + File.separator + className + "service.java";
        }

        if (template.contains("ServiceImpl.java.vm")) {
            return packagePath + "java"+ File.separator +"service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
        }

        if (template.contains("Controller.java.vm")) {
            return packagePath + "java"+ File.separator +"controller" + File.separator + className + "Controller.java";
        }

        if (template.contains("Mapper.xml.vm")) {
            return packagePath + "resources" + File.separator +  "mybatis" +  File.separator + classname + File.separator + className + "Mapper.xml";
        }

        if (template.contains("list.html.vm")) {
            return packagePath + "resources" + File.separator + "templates" + File.separator + path+ File.separator
                    + classname + File.separator +  "list.html";
            //				+ "modules" + File.separator + "generator" + File.separator + className.toLowerCase() + ".html";
        }
        if (template.contains("add.html.vm")) {
            return packagePath + "resources" + File.separator + "templates" + File.separator + path+ File.separator
                    + classname + File.separator + "add.html";
        }
        if (template.contains("edit.html.vm")) {
            return packagePath + "resources" + File.separator + "templates" + File.separator + path+ File.separator
                    + classname + File.separator + "edit.html";
        }

        if (template.contains("list.js.vm")) {
            return packagePath + "resources" + File.separator + "static" + File.separator + "js" + File.separator
                    + "appjs"+ File.separator + path + File.separator + classname + File.separator +  "list.js";
            //		+ "modules" + File.separator + "generator" + File.separator + className.toLowerCase() + ".js";
        }
        if (template.contains("add.js.vm")) {
            return packagePath + "resources" + File.separator + "static" + File.separator + "js" + File.separator
                    + "appjs" + File.separator + path+ File.separator + classname + File.separator +  "add.js";
        }
        if (template.contains("edit.js.vm")) {
            return packagePath + "resources" + File.separator + "static" + File.separator + "js" + File.separator
                    + "appjs" + File.separator + path  + File.separator + classname + File.separator + "edit.js";
        }
        return null;
    }
}
