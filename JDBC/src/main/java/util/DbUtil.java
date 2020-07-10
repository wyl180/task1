package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 *获得数据库连接的工具类
 *
 *  @author 韦延伦
 * @date 2020/6/15 20:34
 * @version 1.0
 */
public class DbUtil {
    /**
     * 驱动
     */
    private static String driver;
    /**
     * 数据库链接
     */
    private static String url;
    /**
     * 用户名
     */
    private static String user;
    /**
     * 密码
     */
    private static String password;
    public static Connection getConnection() throws SQLException {
        InputStream inputStream = DbUtil.class.getResourceAsStream("/db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(url, user, password);

    }

}
