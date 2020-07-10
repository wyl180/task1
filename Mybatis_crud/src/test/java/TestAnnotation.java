import dao.StudentAnnotationMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.Student;

import java.io.InputStream;
import java.util.List;

/**
 * 注解测试类
 * @author 韦延伦
 * @version 1.0
 * @date 2020/6/24 10:35
 */
public class TestAnnotation {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private StudentAnnotationMapper studentAnnotation;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        studentAnnotation = session.getMapper(StudentAnnotationMapper.class);
    }

    @After
    public void destroy() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testInsert() {
        Student student = new Student();
        student.setName("韦延伦");
        student.setEnterTime("20200605");
        student.setQqNumber("9392");
        student.setType("java");
        student.setStudentNumber("6603");
        student.setSlogan("加油思密达 ");
        student.setLogLink("www.jnshu.com");
        student.setSchool("修真院");
        student.setCreateTime(System.currentTimeMillis());
        student.setBrother("invild s");
        studentAnnotation.insertStudent(student);
        int id = student.getId();
        System.out.println("id=" + id + "的学生被插入数据库了");
    }
    @Test
    public void testDeleteById() {
        System.out.println(studentAnnotation.deleteById(1));
    }

    @Test
    public void testUpdateById() {
        Student student = new Student();
        student.setId(2);
        student.setName("韦延伦");
        student.setSchool("updateTest");
        System.out.println(studentAnnotation.updateById(student));
    }

    @Test
    public void testSelectById() {
        Student student = studentAnnotation.selectById(1);
        outPut(student);
    }

    @Test
    public void testSelectAll() {
        List<Student> studentList = studentAnnotation.selectAll();
        for (Student student : studentList) {
            outPut(student);
            System.out.println("--分割线--");
        }
    }

    @Test
    public void testSelectByNumber() {
        List<Student> studentList = studentAnnotation.selectByNumber("6603");
        for (Student student : studentList) {
            outPut(student);
            System.out.println("--分割线--");
        }
    }

    @Test
    public void testSelectByName() {
        List<Student> studentList = studentAnnotation.selectByName("韦延伦");
        for (Student student : studentList) {
            outPut(student);
            System.out.println("--分割线--");
        }
    }

    /**
     * 封装一个输出学生信息到控制台的方法
     * @param student
     */
    private void outPut(Student student) {
        System.out.println("姓名：\t" + student.getName());
        System.out.println("入学时间：\t" + student.getEnterTime());
        System.out.println("学号：\t" + student.getStudentNumber());
        System.out.println("QQ:\t " + student.getQqNumber());
        System.out.println("学校：\t" + student.getSchool());
        System.out.println("修真类型：\t" + student.getType());
        System.out.println("日报链接：\t" + student.getLogLink());
        System.out.println("立愿：\t" + student.getSlogan());
        System.out.println("辅导师兄：\t" + student.getBrother());
    }
}
