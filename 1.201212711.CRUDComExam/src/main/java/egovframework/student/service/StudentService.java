package egovframework.student.service;

import java.util.List;
import egovframework.student.StudentDefaultVO;
import egovframework.student.StudentVO;

/**
 * @Class Name : StudentService.java
 * @Description : Student Business class
 * @Modification Information
 *
 * @author 201212711
 * @since 2016.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface StudentService {
	
	/**
	 * student을 등록한다.
	 * @param vo - 등록할 정보가 담긴 StudentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertStudent(StudentVO vo) throws Exception;
    
    /**
	 * student을 수정한다.
	 * @param vo - 수정할 정보가 담긴 StudentVO
	 * @return void형
	 * @exception Exception
	 */
    void updateStudent(StudentVO vo) throws Exception;
    
    /**
	 * student을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 StudentVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteStudent(StudentVO vo) throws Exception;
    
    /**
	 * student을 조회한다.
	 * @param vo - 조회할 정보가 담긴 StudentVO
	 * @return 조회한 student
	 * @exception Exception
	 */
    StudentVO selectStudent(StudentVO vo) throws Exception;
    
    /**
	 * student 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return student 목록
	 * @exception Exception
	 */
    List selectStudentList(StudentDefaultVO searchVO) throws Exception;
    
    /**
	 * student 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return student 총 갯수
	 * @exception
	 */
    int selectStudentListTotCnt(StudentDefaultVO searchVO);
    
}
