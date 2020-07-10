package service.impl;

import dao.StudentMapper;
import org.springframework.stereotype.Service;
import pojo.Student;
import service.StudentService;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author 韦延伦
 * service具体实现类
 * @version 1.0
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    public boolean deleteById(int id) {
        return studentMapper.deleteById(id);
    }

    public boolean updateById(Student student) {
        return studentMapper.updateById(student);
    }

    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    public List<Student> selectById(int id) {
        return studentMapper.selectById(id);
    }

    public List<Student> selectByNumber(String number) {
        return studentMapper.selectByNumber(number);
    }

    public List<Student> selectByName(String name) {
        return studentMapper.selectByName(name);
    }
}
