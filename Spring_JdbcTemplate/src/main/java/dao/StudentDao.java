package dao;


import pojo.Student;

import java.util.List;

/**
 * Student增删改查接口
 *
 * @author 韦延伦
 * @version 1.0
 */
public interface StudentDao {
    /**
     * 插入学生
     *
     * @param params
     * @return int
     * @date 2020/6/24 18:23
     **/
    int insert(Object[] params);

    /**
     * 根据id更新学生
     *
     * @param rowContend id
     * @return boolean
     * @date 2020/6/24 18:23
     **/
    boolean updateById(String rowContend, int id);

    /**
     * 根据id删除学生
     *
     * @param id
     * @return boolean
     * @date 2020/6/24 18:24
     **/
    boolean deleteByid(int id);

    /**
     * 根据id查找学生
     *
     * @param id
     * @return pojo.Student
     * @date 2020/6/24 18:21
     **/
    Student queryById(int id);

    /**
     * 查找全部学生
     *
     * @param
     * @return java.util.List<pojo.Student>
     * @date 2020/6/24 18:21
     **/
    List<Student> queryAll();

    /**
     * 根据姓名查找学生
     *
     * @param name
     * @return java.util.List<pojo.Student>
     * @date 2020/6/24 18:22
     **/
    List<Student> queryByName(String name);

    /**
     * 根据学号查找学生
     *
     * @param number
     * @return java.util.List<pojo.Student>
     * @date 2020/6/24 18:22
     **/
    List<Student> queryByNumber(String number);


}
