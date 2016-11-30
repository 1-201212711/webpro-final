package egovframework.student.web2;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.student.StudentVO;
import egovframework.student.service.StudentService;

/**
 * @Class Name : StudentController.java
 * @Description : Student Controller class
 * @Modification Information
 *
 * @author 1.201600001
 * @since 2016.11.14
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Controller
@SessionAttributes(types = StudentVO.class)
public class StudentController {

	@Resource(name = "studentService")
	private StudentService studentService;

	/**
	 * student 목록을 조회한다.
	 * 
	 * @return "/student/StudentList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/student/StudentList.do")
	public String selectStudentList(ModelMap model) throws Exception {

		List<?> studentList = studentService.selectStudentList();
		model.addAttribute("resultList", studentList);

		return "/student/StudentList";
	}
	
    @RequestMapping("/student/addStudentView.do")
    public String addStudentView(Model model)
            throws Exception {
        model.addAttribute("studentVO", new StudentVO());
        return "/student/StudentRegister";
    }

	@RequestMapping("/student/addStudent.do")
	public String addStudent(StudentVO studentVO, SessionStatus status)
			throws Exception {
		studentService.insertStudent(studentVO);
		status.setComplete();
		return "forward:/student/StudentList.do";
	}

}
