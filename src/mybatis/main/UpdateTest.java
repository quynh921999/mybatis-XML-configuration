package mybatis.main;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.mapper.entity.Student;

public class UpdateTest {
    public static void main(String[] args) throws IOException {
        // read config file
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        // open session
        SqlSession session = sqlSessionFactory.openSession();

        // insert student
        Student student = session.selectOne("Student.selectStudentById", 10);
        student.setName("Jim Smith");
        student.setPhone(12399888);
        session.update("Student.updateStudent", student);
        session.commit();

        // close session
        session.close();
    }
}
