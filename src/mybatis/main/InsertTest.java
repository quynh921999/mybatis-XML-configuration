package mybatis.main;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.mapper.entity.Student;

public class InsertTest {
    public static void main(String[] args) throws IOException {
        // read config file
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        // open session
        SqlSession session = sqlSessionFactory.openSession();

        // insert student
        Student student = new Student("Jim John", "IT", 89, 12399967, "jim-it12@gmail.com");
        session.insert("Student.insertStudent", student);
        session.commit();

        // close session
        session.close();
    }
}
