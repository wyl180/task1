
import pojo.Student;
import util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @ClassName TestInsertData
 * @Description 创建一个线程类，一个提交300w
 * @Author 韦延伦
 * @Date 2020/6/18 16:44
 * @Version 1.0
 */
public class InsertData extends Thread {
    private PreparedStatement preparedStatement = null;
    private Connection connection = null;

    public void run() {
        Student student = new Student();
        student.setSchool("贵航");
        student.setName("韦延伦");
        student.setType("java");
        student.setStudentNumber("6601");
        student.setSlogan("好好学习天天向上");
        student.setEnterTime("20200605");
        student.setLogLink("www.baidu.com");
        student.setBrother("辅导师兄");
        student.setQqNumber("939070310");
        long start = System.currentTimeMillis();
        String sql = "insert into student_task1" +
                "(student_name,enter_time,student_number,qq,school,study_type,log_link,slogan,brother) " +
                "values(?,?,?,?,?,?,?,?,?)";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //设置为手动提交
            connection.setAutoCommit(false);
            //每次提交10万一共提交30次
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < 100; j++) {
                    preparedStatement.setString(1, student.getName());
                    preparedStatement.setString(2, student.getEnterTime());
                    preparedStatement.setString(3, student.getStudentNumber());
                    preparedStatement.setString(4, student.getQqNumber());
                    preparedStatement.setString(5, student.getSchool());
                    preparedStatement.setString(6, student.getType());
                    preparedStatement.setString(7, student.getLogLink());
                    preparedStatement.setString(8, student.getSlogan());
                    preparedStatement.setString(9, student.getBrother());
                    preparedStatement.addBatch();
                }
                //够十万就提交一次
                preparedStatement.executeBatch();
                //清空Batch
                preparedStatement.clearBatch();
                connection.commit();
            }
            //如果这个线程已经执行完上面的语句就中断线程
            Thread.interrupted();
            long end = System.currentTimeMillis();
            System.out.println("插入3000万数据用了" + (end - start) / 1000 + "秒");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }
}

