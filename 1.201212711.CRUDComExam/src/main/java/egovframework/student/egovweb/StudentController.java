package egovframework.student.egovweb;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.student.service.StudentService;
import egovframework.student.StudentDefaultVO;
import egovframework.student.StudentVO;

/**
 * @Class Name : StudentController.java
 * @Description : Student Controller class
 * @Modification Information
 *
 * @author 201212711
 * @since 2016.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=StudentVO.class)
public class StudentController {

    @Resource(name = "studentService")
    private StudentService studentService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * student 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 StudentDefaultVO
	 * @return "/student/StudentList"
	 * @exception Exception
	 */
    @RequestMapping(value="/student/StudentList.do")
    public String selectStudentList(@ModelAttribute("searchVO") StudentDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> studentList = studentService.selectStudentList(searchVO);
        model.addAttribute("resultList", studentList);
        
        int totCnt = studentService.selectStudentListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/student/StudentList";
    } 
    
    @RequestMapping("/student/addStudentView.do")
    public String addStudentView(
            @ModelAttribute("searchVO") StudentDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("studentVO", new StudentVO());
        return "/student/StudentRegister";
    }
    
    @RequestMapping("/student/addStudent.do")
    public String addStudent(
            StudentVO studentVO,
            @ModelAttribute("searchVO") StudentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        studentService.insertStudent(studentVO);
        status.setComplete();
        return "forward:/student/StudentList.do";
    }
    
    @RequestMapping("/student/updateStudentView.do")
    public String updateStudentView(
            @RequestParam("no") int no ,
            @ModelAttribute("searchVO") StudentDefaultVO searchVO, Model model)
            throws Exception {
        StudentVO studentVO = new StudentVO();
        studentVO.setNo(no);
        // 변수명은 CoC 에 따라 studentVO
        model.addAttribute(selectStudent(studentVO, searchVO));
        return "/student/StudentRegister";
    }

    @RequestMapping("/student/selectStudent.do")
    public @ModelAttribute("studentVO")
    StudentVO selectStudent(
            StudentVO studentVO,
            @ModelAttribute("searchVO") StudentDefaultVO searchVO) throws Exception {
        return studentService.selectStudent(studentVO);
    }

    @RequestMapping("/student/updateStudent.do")
    public String updateStudent(
            StudentVO studentVO,
            @ModelAttribute("searchVO") StudentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        studentService.updateStudent(studentVO);
        status.setComplete();
        return "forward:/student/StudentList.do";
    }
    
    @RequestMapping("/student/deleteStudent.do")
    public String deleteStudent(
            StudentVO studentVO,
            @ModelAttribute("searchVO") StudentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        studentService.deleteStudent(studentVO);
        status.setComplete();
        return "forward:/student/StudentList.do";
    }

}
