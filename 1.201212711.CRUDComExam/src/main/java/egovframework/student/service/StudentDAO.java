package egovframework.student.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.student.StudentVO;

/**
 * @Class Name : StudentDAO.java
 * @Description : Student DAO Class
 * @Modification Information
 *
 * @author 1.201600001
 * @since 2016.11.14
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Repository("studentDAO")
public class StudentDAO extends EgovComAbstractDAO{

	/**
	 * student을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 StudentVO
	 * @exception Exception
	 */
	public void insertStudent(StudentVO vo) throws Exception {
		insert("insert", vo);
	}

	/**
	 * student 목록을 조회한다.
	 * 
	 * @return student 목록
	 * @exception Exception
	 */
	public List<?> selectStudent() throws Exception {
		return list("select");
	}

}
