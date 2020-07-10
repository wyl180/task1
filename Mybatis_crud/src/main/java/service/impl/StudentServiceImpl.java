package service.impl;
import dao.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Student;
import service.StudentService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 学生service实现类
 * @author 韦延伦
 * @version 1.0
 */
public class StudentServiceImpl implements StudentService {
    private SqlSession sqlSession;
    private InputStream in;
    private StudentMapper studentMapper;

    {
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            sqlSession = factory.openSession();
            //获取mapper
            studentMapper = sqlSession.getMapper(StudentMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertStudent(Student student) {
        studentMapper.insertStudent(student);
        close(in, sqlSession);
    }

    public boolean deleteById(int id) {
        boolean flag = studentMapper.deleteById(id);
        close(in, sqlSession);
        return flag;
    }

    public boolean updateById(Student student) {
        boolean flag = studentMapper.updateById(student);
        close(in, sqlSession);
        return flag;
    }

    public Student selectById(int id) {

        Student student = studentMapper.selectById(id);
        close(in, sqlSession);
        return student;
    }

    public List<Student> selectAll() {
        List<Student> studentList = studentMapper.selectAll();
        close(in, sqlSession);
        return studentList;
    }

    public List<Student> selectByName(String name) {
        List<Student> studentList = studentMapper.selectByName(name);
        close(in, sqlSession);
        return studentList;
    }

    public List<Student> selectByNumber(String number) {
        List<Student> studentList = studentMapper.selectByNumber(number);
        close(in, sqlSession);
        return studentList;
    }



    /**
     * 封装一个关闭连接并提交事务的方法
     * @date 2020/6/24 18:40
     * @param in
     * @param sqlSession
     *
     **/
    public void close(InputStream in, SqlSession sqlSession) {
        sqlSession.commit();
        sqlSession.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
