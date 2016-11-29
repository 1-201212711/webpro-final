package egovframework.student.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.student.StudentVO;
import egovframework.student.StudentDefaultVO;

/**
 * @Class Name : StudentDAO.java
 * @Description : Student DAO Class
 * @Modification Information
 *
 * @author 201212711
 * @since 2016.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("studentDAO")
public class StudentDAO extends EgovAbstractDAO {

	/**
	 * student을 등록한다.
	 * @param vo - 등록할 정보가 담긴 StudentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertStudent(StudentVO vo) throws Exception {
        return (String)insert("studentDAO.insertStudent_S", vo);
    }

    /**
	 * student을 수정한다.
	 * @param vo - 수정할 정보가 담긴 StudentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateStudent(StudentVO vo) throws Exception {
        update("studentDAO.updateStudent_S", vo);
    }

    /**
	 * student을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 StudentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteStudent(StudentVO vo) throws Exception {
        delete("studentDAO.deleteStudent_S", vo);
    }

    /**
	 * student을 조회한다.
	 * @param vo - 조회할 정보가 담긴 StudentVO
	 * @return 조회한 student
	 * @exception Exception
	 */
    public StudentVO selectStudent(StudentVO vo) throws Exception {
        return (StudentVO) select("studentDAO.selectStudent_S", vo);
    }

    /**
	 * student 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return student 목록
	 * @exception Exception
	 */
    public List<?> selectStudentList(StudentDefaultVO searchVO) throws Exception {
        return list("studentDAO.selectStudentList_D", searchVO);
    }

    /**
	 * student 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return student 총 갯수
	 * @exception
	 */
    public int selectStudentListTotCnt(StudentDefaultVO searchVO) {
        return (Integer)select("studentDAO.selectStudentListTotCnt_S", searchVO);
    }

}
