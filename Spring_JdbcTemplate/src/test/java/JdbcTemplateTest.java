import dao.StudentDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Student;

import java.util.List;


/**
 * @author 韦延伦
 * @date 2020/6/14/ 9:37
 * @Description 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class JdbcTemplateTest {
    /**
     * 注入studentDao
     */
    @Autowired
    private StudentDao studentDao;

    /**
     * 测试插入数据
     */
    @Test
    public void insert() {
        Object[] params = {"韦", "2020年6月3日", "6601", "939070310", "哈哈", "java", "www.baidu.com", "好好学习天天向上", "师兄", System.currentTimeMillis(), 0};
        studentDao.insert(params);
    }

    /**
     * 测试根据id删除数据
     */
    @Test
    public void deleteById() {

        studentDao.deleteByid(1);

    }

    /**
     * 测试根据id更新数据
     */
    @Test
    public void updateById() {

        studentDao.updateById("修真院", 1);

    }

    /**
     * 测试查询列表所有信息
     */
    @Test
    public void findAll() {
        List<Student> studentList = studentDao.queryAll();
        for (Student student : studentList) {
            outPutStudent(student);
            System.out.println("---------分割线--------");
        }

    }

    /**
     * 测试根据id查询学生表
     */
    @Test
    public void findById() {
        try {
            Student student = studentDao.queryById(1);
            outPutStudent(student);
        }catch (EmptyResultDataAccessException e){
            System.out.println("没有找到此id的数据");
        }
    }

    /**
     * 测试根据姓名进行模糊查询
     */
    @Test
    public void findByName() {

        List<Student> studentList = studentDao.queryByName("韦");

        for (Student student : studentList) {
            outPutStudent(student);
        }
    }
    /**
     * 测试根据学号查询
     */
    @Test
    public void findByStudentNumber() {
        List<Student> studentList = studentDao.queryByNumber("6601");
        for (Student student : studentList) {
            outPutStudent(student);
        }
    }

    /**
     * 封装一个输出学生到控制台的方法
     * @param student
     */
    private void outPutStudent(Student student) {
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

