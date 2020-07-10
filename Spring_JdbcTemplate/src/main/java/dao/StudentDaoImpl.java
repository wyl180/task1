package dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import pojo.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 韦延伦
 * @date 2020/6/14 9:25
 * @Description StudentDao接口具体实现类
 * @version 1.0
 */
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Student queryById(int id) {
        String sql = "select *from student_task1 where id=?";
        Object [] params={id};
        return jdbcTemplate.queryForObject(sql,params,new RowMap());
    }

    public List<Student> queryAll() {
        String sql = "select *from student_task1";
        return jdbcTemplate.query(sql,new RowMap());
    }

    public List<Student> queryByName(String name) {
        String sql = "select *from student_task1 where student_name like \'%\' ? \'%\'";
        Object[] params={name};
        return jdbcTemplate.query(sql,params,new RowMap());
    }

    public List<Student> queryByNumber(String number) {
        String sql = "select *from student_task1 where student_number like \'%\' ? \'%\'";
        Object[] params={number};
        return jdbcTemplate.query(sql,params,new RowMap());
    }

    public boolean updateById(String rowContend,int id) {
        String sql = "update student_task1 set school=? where id=?";
        Object[] params={rowContend,id};
        return jdbcTemplate.update(sql,params)>0? true:false;
    }

    public boolean deleteByid(int id) {
        String sql = "delete from student_task1 where id=?";
        Object[] params={id};
        return jdbcTemplate.update(sql,params)>0? true:false;
    }

    public int insert(Object[] params) {
        String sql = "insert into student_task1(student_name,enter_time,student_number,qq,school,study_type,log_link,slogan,brother,create_at,update_at) " +
                "values(?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,params);
    }
}

/**
 * 定义一个内部类RowMap实现RowMapper接口来获取从数据库返回的结果集
 */
class RowMap implements RowMapper<Student> {

    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("student_name"));
        student.setEnterTime((resultSet.getString("enter_time")));
        student.setQqNumber(resultSet.getString("qq"));
        student.setType(resultSet.getString("study_type"));
        student.setStudentNumber(resultSet.getString("student_number"));
        student.setSlogan(resultSet.getString("slogan"));
        student.setLogLink(resultSet.getString("log_link"));
        student.setSchool(resultSet.getString("school"));
        student.setUpdateTime(resultSet.getLong("update_at"));
        student.setCreateTime(resultSet.getLong("create_at"));
        student.setBrother(resultSet.getString("brother"));
        return student;
    }

}
