package egovframework.student.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.student.service.StudentService;
import egovframework.student.StudentDefaultVO;
import egovframework.student.StudentVO;
import egovframework.student.service.StudentDAO;

/**
 * @Class Name : StudentServiceImpl.java
 * @Description : Student Business Implement class
 * @Modification Information
 *
 * @author 201212711
 * @since 2016.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("studentService")
public class StudentServiceImpl extends EgovAbstractServiceImpl implements
        StudentService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Resource(name="studentDAO")
    private StudentDAO studentDAO;
    
    /** ID Generation */
    //@Resource(name="{egovStudentIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * student을 등록한다.
	 * @param vo - 등록할 정보가 담긴 StudentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertStudent(StudentVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	studentDAO.insertStudent(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * student을 수정한다.
	 * @param vo - 수정할 정보가 담긴 StudentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateStudent(StudentVO vo) throws Exception {
        studentDAO.updateStudent(vo);
    }

    /**
	 * student을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 StudentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteStudent(StudentVO vo) throws Exception {
        studentDAO.deleteStudent(vo);
    }

    /**
	 * student을 조회한다.
	 * @param vo - 조회할 정보가 담긴 StudentVO
	 * @return 조회한 student
	 * @exception Exception
	 */
    public StudentVO selectStudent(StudentVO vo) throws Exception {
        StudentVO resultVO = studentDAO.selectStudent(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * student 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return student 목록
	 * @exception Exception
	 */
    public List<?> selectStudentList(StudentDefaultVO searchVO) throws Exception {
        return studentDAO.selectStudentList(searchVO);
    }

    /**
	 * student 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return student 총 갯수
	 * @exception
	 */
    public int selectStudentListTotCnt(StudentDefaultVO searchVO) {
		return studentDAO.selectStudentListTotCnt(searchVO);
	}
    
}
