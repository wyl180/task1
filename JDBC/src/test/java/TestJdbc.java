import dao.StudentDao;
import dao.StudentDaoImpl;
import org.junit.Test;
import pojo.Student;

import java.util.List;

/**
 * 测试类
 *
 * @author 韦延伦
 * @version 1.0
 * @date 2020/6/15 21:29
 */
public class TestJdbc {
    private StudentDao studentDao = new StudentDaoImpl();

    /**
     * 测试添加数据
     */
    @Test
    public void testInsert() {
        String sql = "insert into student_task1(student_name,enter_time,student_number,qq,school,study_type,log_link,slogan,brother,create_at) values(?,?,?,?,?,?,?,?,?,?)";
        Student student = new Student();
        student.setSchool("贵航");
        student.setName("韦延伦");
        student.setType("java");
        student.setStudentNumber("6601");
        student.setSlogan("好好学习天天向上");
        student.setEnterTime("20200605");
        student.setLogLink("www.baidu.com");
        student.setBrother("暗灭");
        student.setQqNumber("939070310");
        int id = studentDao.insert(sql, student);
        System.out.println("id是" + id + "的数据被插入");
    }

    /**
     * 测试删除数据
     */
    @Test
    public void testDeleteById() {
        String sql = "delete from student_task1 where id=?";
        System.out.println(studentDao.deleteById(sql, 6));
    }

    /**
     * 测试更新数据
     */
    @Test
    public void testUpdateById() {
        String sql = "update student_task1 set school=? where id=?";
        System.out.println(studentDao.updateById(sql, "修真院", 1));
    }

    /**
     * 测试查找全部数据
     */
    @Test
    public void testSelectAll() {
        String sql = "select *from student_task1";
        List<Student> studentList = studentDao.selectAll(sql);
        for (Student student : studentList) {
            outPutStudent(student);
            System.out.println("---------分割线--------");
        }
    }

    /**
     * 测试按id查找数据
     */
    @Test
    public void testSelectById() {

        String sql = "select *from student_task1 where id=?";
        Student student = studentDao.selectById(sql, 1);
        outPutStudent(student);

    }

    /**
     * 测试按姓名查找数据
     */
    @Test
    public void testSelectByName() {
        String sql = "select *from student_task1 where student_name like \'%\' ? \'%\'";
        List<Student> studentList = studentDao.selectByName(sql, "韦延伦");
        if (studentList.size() != 0) {
            for (Student student : studentList) {
                outPutStudent(student);
                System.out.println("---------分割线--------");
            }
        }
    }

    /**
     * 测试按学号查找数据
     */
    @Test
    public void testSelectByNumber() {
        String sql = "select *from student_task1 where student_number like \'%\' ? \'%\'";
        List<Student> studentList = studentDao.selectByNumber(sql, "6601");
        if (studentList.size() != 0) {
            for (Student student : studentList) {
                outPutStudent(student);
                System.out.println("---------分割线--------");
            }
        }
    }

    /**
     * 封装一个输出学生信息到控制台的方法
     *
     * @param student
     */
    private void outPutStudent(Student student) {
        System.out.println("id:\t" + student.getId());
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


