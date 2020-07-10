import org.junit.Test;
import pojo.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import java.util.List;
/**
 * Service层
 * @Author 韦延伦
 * @Description 测试类
 * @Date 2020/6/23 16:04
 * @Param
 * @return
 **/
public class TestXml {
    //获取Service
    private StudentService studentService = new StudentServiceImpl();
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
        studentService.insertStudent(student);
        int id = student.getId();
        System.out.println("id=" + id + "的学生被插入数据库了");
    }

    @Test
    public void testDeleteById() {

        System.out.println(studentService.deleteById(2));
    }

    @Test
    public void testUpdateById() {
        Student student = new Student();
        student.setId(2);
        student.setSchool("trim");
        student.setUpdateTime(System.currentTimeMillis());
        System.out.println(studentService.updateById(student));
    }

    @Test
    public void testSelectById() {
        Student student = studentService.selectById(1);
        outPut(student);
    }


    @Test
    public void testSelectByName() {
        List<Student> studentList = studentService.selectByName("韦延伦");
        for (Student student : studentList) {
            outPut(student);
        }
    }
    @Test
    public void testSelectByNumber() {
        List<Student> studentList = studentService.selectByNumber("6601");
        for (Student student : studentList) {
            outPut(student);
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
