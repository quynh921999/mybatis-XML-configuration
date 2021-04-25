package mybatis.main;

import java.io.IOException;
import java.io.Reader;

import mybatis.mapper.entity.Student;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SelectByIdTest {
    public static void main(String[] args) throws IOException {
        // read config file
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        // open session
        SqlSession session = sqlSessionFactory.openSession();

        // get student by Id
        Student student = session.selectOne("Student.selectStudentById", 10);
        System.out.println(student);

        // close session
        session.close();
    }
}
