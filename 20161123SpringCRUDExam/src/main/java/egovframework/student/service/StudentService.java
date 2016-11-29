package egovframework.student.service;

import java.util.List;
import egovframework.student.StudentVO;

/**
 * @Class Name : StudentService.java
 * @Description : Student Business class
 * @Modification Information
 *
 * @author 1.201600001
 * @since 2016.11.14
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
    void insertStudent(StudentVO vo) throws Exception;
    
    /**
	 * student 목록을 조회한다.
	 * @return student 목록
	 * @exception Exception
	 */
    List<StudentVO> selectStudent() throws Exception;
    
}
