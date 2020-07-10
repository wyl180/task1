package dao;


import pojo.Student;
import java.util.List;

/**
 * 学生增删改查Mapper
 * @author 韦延伦
 * @version 1.0
 */
public interface StudentMapper {
    /**
     * 插入学生
     *
     * @param student
     * @return int
     * @date 2020/6/23 22:26
     **/
    void insertStudent(Student student);
    /**
     * 根据id删除学生
     * @date 2020/6/24 18:13
     * @param id
     * @return boolean
     **/
    boolean deleteById(int id);
    /**
     * 根据id更新学生
     *
     * @param student
     * @return boolean
     * @date 2020/6/23 22:25
     **/
    boolean updateById(Student student);

    /**
     * 根据id查找学生
     * @date 2020/6/24 18:13
     * @param id
     * @return java.util.List<pojo.Student>
     **/
    Student selectById(int id);

    /**
     * 查询所有学生
     * @date 2020/6/24 18:13
     * @param
     * @return java.util.List<pojo.Student>
     **/

    List<Student> selectAll();
    /**
     * 根据姓名查找学生
     * @date 2020/6/24 18:14
     * @param name
     * @return java.util.List<pojo.Student>
     **/

    List<Student> selectByName(String name);

    /**
     * 根据姓名查找学生
     * @date 2020/6/24 18:14
     * @param number
     * @return java.util.List<pojo.Student>
     **/
    List<Student> selectByNumber(String number);


}
