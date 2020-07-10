package dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import pojo.Student;

import java.util.List;

/**
 * 使用mybatis注解来创建Mapper
 *
 * @author 韦延伦
 * @version 1.0
 */
public interface StudentAnnotationMapper {
    @Insert("insert into student_task1(\n" +
            "        student_name,enter_time,qq,school,student_number,study_type,log_link,slogan,brother,create_at,update_at)\n" +
            "         values (\n" +
            "        #{name},#{enterTime},#{qqNumber},#{school},#{studentNumber},#{type},#{logLink},#{slogan},#{brother},#{createTime},#{updateTime})\n")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    /**
     * 插入学生数据返回id
     * @date 2020/6/24 19:56
     * @param student
     * @return void
     **/
    void insertStudent(Student student);

    /**
     * 根据id删除学生
     * 删除方法
     *
     * @param id
     * @return boolean
     */
    @Delete("delete from student_task1 where id=#{id}")
    boolean deleteById(int id);

    /**
     * 使用动态sql去根据id更新学生
     *
     * @param student
     * @return boolean
     * @date 2020/6/24 19:59
     **/
    @UpdateProvider(type = StudentAnnotationInner.class, method = "updateById")
    boolean updateById(Student student);

    /**
     * 注解方式的resultMap
     *
     * @param id
     * @return
     */
    @Results(id = "studentResultMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "student_name", property = "name"),
            @Result(column = "enter_time", property = "enterTime"),
            @Result(column = "student_number", property = "studentNumber"),
            @Result(column = "qq", property = "qqNumber"),
            @Result(column = "school", property = "school"),
            @Result(column = "study_type", property = "type"),
            @Result(column = "log_link", property = "logLink"),
            @Result(column = "slogan", property = "slogan"),
            @Result(column = "brother", property = "brother")
    })
    @Select("select *from student_task1 where id=#{id}")
    /**
     * 根据id查找学生
     * @date 2020/6/24 20:03
     * @param id
     * @return pojo.Student
     **/
    Student selectById(int id);

    @ResultMap("studentResultMap")
    @Select("select *from student_task1")
    /**
     * 查找全部学生
     * @date 2020/6/24 20:03
     * @param
     * @return java.util.List<pojo.Student>
     **/
    List<Student> selectAll();

    @ResultMap("studentResultMap")
    @Select("select *from student_task1 where student_name like   CONCAT(#{name},'%')")
    /**
     * 根据姓名查找学生
     * @date 2020/6/24 20:04
     * @param name
     * @return java.util.List<pojo.Student>
     **/
    List<Student> selectByName(String name);

    @ResultMap("studentResultMap")
    @Select("select  *from student_task1 where student_number like CONCAT(#{studentNumber},'%')")
    /**
     * 根据学号查找学生
     * @date 2020/6/24 20:04
     * @param number
     * @return java.util.List<pojo.Student>
     **/
    List<Student> selectByNumber(String number);

    /**
     * 定义一个获取动态sql的内部类
     *
     * @author 韦延伦
     * @date 2020/6/24 15:02
     **/
    class StudentAnnotationInner {
        public String updateById(final Student student) {
            /**
             * 返回sql语句的匿名内部类
             */
            return new SQL() {
                {
                    UPDATE("student_task1");
                    if (student.getStudentNumber() != null) {
                        SET("student_number=#{studentNumber}");
                    }
                    if (student.getSchool() != null) {
                        SET("school=#{school}");
                    }
                    if (student.getQqNumber() != null) {
                        SET("qq=#{qqNumber}");
                    }
                    if (student.getType() != null) {
                        SET("study_type=#{type}");
                    }
                    if (student.getLogLink() != null) {
                        SET("log_link=#{logLink}");
                    }
                    if (student.getSlogan() != null) {
                        SET("slogan=#{slogan}");
                    }
                    if (student.getBrother() != null) {
                        SET("brother=#{brother}");
                    }
                    if (student.getEnterTime() != null) {
                        SET("enter_time=#{enterTime}");
                    }
                    if (student.getName() != null) {
                        SET("student_name=#{name}");
                    }
                    WHERE("id=#{id}");
                }
            }.toString();
            //mybatis 3.5.2开始的版本用这种方式插入动态sql，但是不会用它的非空判断
//                    .UPDATE("student_task1")
//                    .SET("student_number=#{studentNumber}")
//                    .SET("school=#{school}")
//                    .SET("qq=#{qqNumber}")
//                    .SET("study_type=#{type}")
//                    .SET("log_link=#{logLink}")
//                    .SET("slogan=#{slogan}")
//                    .SET("brother=#{brother}")
//                    .SET("enter_time=#{enterTime}")
//                    .SET("student_name=#{name}")
//                    .WHERE("id=#{id}")
//                    .toString();
        }

    }

}