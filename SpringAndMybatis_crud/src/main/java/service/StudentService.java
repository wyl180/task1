package service;

import pojo.Student;

import java.util.List;


/**
 * service层
 * @author 韦延伦
 */
public interface StudentService {
    /**
     * 插入学生
     *
     * @param student
     * @return int
     * @date 2020/6/23 22:26
     **/
    int insertStudent(Student student);
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
     * 查询所有学生
     * @date 2020/6/24 18:13
     * @param
     * @return java.util.List<pojo.Student>
     **/
    List<Student> selectAll();

    /**
     * 根据id查找学生
     * @date 2020/6/24 18:13
     * @param id
     * @return java.util.List<pojo.Student>
     **/
    List<Student> selectById(int id);

    /**
     * 根据学号查找学生
     * @date 2020/6/24 18:14
     * @param number
     * @return java.util.List<pojo.Student>
     **/
    List<Student> selectByNumber(String number);

    /**
     * 根据姓名查找学生
     * @date 2020/6/24 18:14
     * @param name
     * @return java.util.List<pojo.Student>
     **/
    List<Student> selectByName(String name);
}
