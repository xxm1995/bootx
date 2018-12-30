package site.xxm.gen.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TableUtils {
    /**
     * 获取表信息
     * @param tableName 表名
     * @return map
     */
    public static Map tabInfo(String tableName) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select table_name tableName, engine, table_comment tableComment, create_time createTime " +
                "from information_schema.tables " +
                "where table_schema = (select database()) and table_name = ?";
        return runner.query( sql, new MapHandler(),tableName);
    }
    /**
     * 获取列信息
     * @param tableName 表名
     * @return list
     */
    public static List listColumns(String tableName) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select column_name columnName, data_type dataType, column_comment columnComment, column_key columnKey, extra " +
                "from information_schema.columns " +
                " where table_name = ? and table_schema = (select database()) order by ordinal_position";
        return runner.query( sql, new MapListHandler(), tableName);
    }
}
