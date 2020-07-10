package dao;

import pojo.Student;
import util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 增删改查接口实现类
 *
 * @author 韦延伦
 * @version 1.0
 * @date 2020/6/24 19:00
 */
public class StudentDaoImpl implements StudentDao {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public int insert(String sql, Student student) {
        int id = 0;
        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEnterTime());
            preparedStatement.setString(3, student.getStudentNumber());
            preparedStatement.setString(4, student.getQqNumber());
            preparedStatement.setString(5, student.getSchool());
            preparedStatement.setString(6, student.getType());
            preparedStatement.setString(7, student.getLogLink());
            preparedStatement.setString(8, student.getSlogan());
            preparedStatement.setString(9, student.getBrother());
            preparedStatement.setLong(10, System.currentTimeMillis());
            //测试DB中断后trycatch能不能捕获异常
            connection.close();
            preparedStatement.executeUpdate();
            //获取返回的id
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("DB已经断开" + e.getMessage());
        } finally {
            close(connection, preparedStatement, resultSet);
        }
        return id;
    }


    @Override
    public boolean deleteById(String sql, int id) {
        boolean flag = false;
        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            flag = preparedStatement.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
        return flag;
    }


    @Override
    public boolean updateById(String sql, String rowContent, int id) {
        boolean flag = false;
        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rowContent);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            flag = preparedStatement.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
        return flag;
    }


    @Override
    public List<Student> selectAll(String sql) {
        List<Student> studentList = new ArrayList<Student>();

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            studentList = getStudent(resultSet, studentList);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
        return studentList;
    }


    @Override
    public Student selectById(String sql, int id) {


        List<Student> studentList = new ArrayList<>();
        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            studentList = getStudent(resultSet, studentList);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
        return studentList.get(0);
    }


    @Override
    public List<Student> selectByNumber(String sql, String number) {
        List<Student> studentList = new ArrayList<Student>();
        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, number);
            resultSet = preparedStatement.executeQuery();
            studentList = getStudent(resultSet, studentList);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
        return studentList;
    }


    @Override
    public List<Student> selectByName(String sql, String name) {
        List<Student> studentList = new ArrayList<Student>();
        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            studentList = getStudent(resultSet, studentList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    /**
     * 封装一个从result获取学生的接口
     *
     * @param resultSet
     * @param studentList
     * @return
     * @throws SQLException
     */
    private List<Student> getStudent(ResultSet resultSet, List<Student> studentList) throws SQLException {
        Student student = null;
        if (resultSet != null) {
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("student_name"));
                student.setEnterTime(resultSet.getString("enter_time"));
                student.setBrother(resultSet.getString("brother"));
                student.setQqNumber(resultSet.getString("qq"));
                student.setLogLink(resultSet.getString("log_link"));
                student.setSlogan(resultSet.getString("slogan"));
                student.setType(resultSet.getString("study_type"));
                student.setStudentNumber(resultSet.getString("student_number"));
                student.setSchool(resultSet.getString("school"));
                studentList.add(student);
            }
        }

        return studentList;
    }

    /**
     * 封装一个关闭连接的方法
     *
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    private void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
