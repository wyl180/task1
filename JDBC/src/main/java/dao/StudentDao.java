package dao;

import pojo.Student;

import java.util.List;

/**
 * 学生增删改查接口
 * @author 韦延伦
 * @version 1.0
 * @date 2020/6/24 18:51
 */
public interface StudentDao {
    /**
     * 插入学生数据
     * @date 2020/6/24 18:51
     * @param sql sql语句
     * @param student
     * @return int
     **/
    int insert(String sql,Student student) ;

    /**
     *根据id删除学生
     * @date 2020/6/24 18:52
     * @param sql
     * id
     * @return boolean
     **/
    boolean deleteById(String sql,int id) ;

    /**
     * 根据id更新学生
     * @param sql
     * @param rowContent 要更新的列的内容
     * @param id
     * @return
     */
    boolean updateById(String sql,String rowContent,int id);

    /**
     * 查找所有学生
     * @param sql
     * @return
     */
    List<Student> selectAll(String sql);

    /**
     * 根据id查找学生
     * @param sql
     * @param id
     * @return
     */
    Student selectById(String sql,int id);

    /**
     * 根据学号查找学生
     * @param sql
     * @param number
     * @return
     */
    List<Student> selectByNumber(String sql,String number);

    /**
     * 根据姓名查找学生
     * @param sql
     * @param name
     * @return
     */
    List<Student> selectByName(String sql,String name);


}
