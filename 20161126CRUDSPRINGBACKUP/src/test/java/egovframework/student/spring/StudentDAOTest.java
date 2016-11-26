package egovframework.student.spring;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import egovframework.student.StudentVO;
import egovframework.student.service.StudentDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class StudentDAOTest {

	@Inject
	private StudentDAO dao;

	@Test
	public void testInsertStudent() throws Exception {

		StudentVO vo = new StudentVO();
		vo.setNumber("201600001");
		vo.setName("Seok");

		dao.insertStudent(vo);

	}

}
