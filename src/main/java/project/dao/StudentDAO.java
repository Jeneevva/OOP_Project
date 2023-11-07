package project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import project.models.Student;

import java.util.List;

@Component
public class StudentDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> index(){
        return jdbcTemplate.query("SELECT * FROM Student", new BeanPropertyRowMapper<>(Student.class));
    }

    //если в этом списке есть хотя бы один объект класса студент он будет возвращен, если нет то вернет нулл
    public Student show(int uni_id){
        return jdbcTemplate.query("SELECT * FROM Student WHERE uni_id=?", new Object[]{uni_id}, new BeanPropertyRowMapper<>(Student.class))
                .stream().findAny().orElse(null);
    }

    public void save(Student student){
        jdbcTemplate.update("INSERT INTO Student VALUES (?,?,?,?,?)",
                student.getName(), student.getTel_number(), student.getAddress(), student.getLink(), student.getUni_id());

    }

    public void update(int uni_id, Student updatedStudent){
        jdbcTemplate.update("UPDATE Student SET name=?, tel_number=?, address=?, link=? WHERE uni_id=?",
                updatedStudent.getName(), updatedStudent.getTel_number(), updatedStudent.getAddress(), updatedStudent.getLink(), uni_id);
    }

    public void delete(int uni_id) {
        jdbcTemplate.update("DELETE FROM Student WHERE uni_id = ?", uni_id);
    }
}
