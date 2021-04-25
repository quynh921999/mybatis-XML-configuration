package mybatis.main;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.mapper.entity.Student;

public class SelectAllTest {
    public static void main(String[] args) throws IOException {
        // read config file
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        // open session
        SqlSession session = sqlSessionFactory.openSession();

        // get all student
        List<Student> listStudents = session.selectList("Student.selectAllStudent");
        for (Student student : listStudents) {
            System.out.println(student);
        }

        // close session
        session.close();
    }
}
