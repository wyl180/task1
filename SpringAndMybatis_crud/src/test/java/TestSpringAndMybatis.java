import config.ConfigClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Student;
import service.StudentService;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
//使用配置类
@ContextConfiguration(classes = ConfigClass.class)
public class TestSpringAndMybatis {
    @Autowired
    private StudentService studentService;

    /**
     * 测试插入学生
     */
    @Test
    public void testInsert() {
        Student student = new Student();
        student.setName("韦延伦11111111111111");
        student.setEnterTime("20200605");
        student.setQqNumber("9392");
        student.setType("java");
        student.setStudentNumber("6603");
        student.setSlogan("加油思密达 ");
        student.setLogLink("www.jnshu.com");
        student.setSchool("修真院");
        student.setUpdateTime(System.currentTimeMillis());
        student.setCreateTime(System.currentTimeMillis());
        student.setBrother("invild s");
        //返回的id
        studentService.insertStudent(student);
        int id = student.getId();
        System.out.println("id=" + id + "被插入了数据库");
    }

    /**
     * 测试根据id更新学生数据
     */
    @Test
    public void testUpdateById() {
        Student student = new Student();
        student.setName("到我了没有");
        student.setId(1);
        boolean flag = studentService.updateById(student);
        if (flag == true) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }

    /**
     * 测试根据id删除学生
     */
    @Test
    public void testDeleteById() {
        boolean flag = studentService.deleteById(1);
        if (flag == true) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 测试查找所有学生
     */
    @Test
    public void testSelectAll() {
        List<Student> studentList = studentService.selectAll();
        for (Student student : studentList) {
            outPutStudent(student);
            System.out.println("------分割线------");
        }


    }

    /**
     * 测试根据id查找学生
     */
    @Test
    public void testSelectById() {
        List<Student> studentList = studentService.selectById(2);
        for (Student student : studentList) {
            outPutStudent(student);
            System.out.println("------分割线------");
        }
    }

    /**
     * 测试根据姓名查询学生
     */
    @Test
    public void testSelectByName() {
        List<Student> studentList = studentService.selectByName("韦延伦");

        for (Student student : studentList) {
            outPutStudent(student);
            System.out.println("------分割线------");

        }
    }
    /**
     * 测试根据学号查询学生
     */
    @Test
    public void testSelectByNumber() {
        List<Student> studentList = studentService.selectByNumber("6603");

        for (Student student : studentList) {
            outPutStudent(student);
            System.out.println("------分割线------");

        }
    }

    /**
     * 封装一个打印学生信息到控制台的方法
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





