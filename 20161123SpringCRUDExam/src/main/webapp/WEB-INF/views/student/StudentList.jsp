<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%
	/**
	 * @Class Name : StudentList.jsp
	 * @Description : Student List 화면
	 * @Modification Information
	 * 
	 * @author 1.201212711
	 * @since 2016.11.16
	 * @version 1.0
	 * @see
	 *  
	 * Copyright (C) All right reserved.
	 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>목록</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value='../../../css/egovframework/sample.css'/>" />
<script type="text/javaScript" language="javascript" defer="defer">
<!--
	/* 글 수정 화면 function */

	function fn_egov_select(number) {
		document.getElementById("listForm").number.value = number;
		document.getElementById("listForm").action = "<c:url value='/student/updateStudentView.do'/>";
		document.getElementById("listForm").submit();
	}

	/* 글 등록 화면 function */
	function fn_egov_addView() {
		document.getElementById("listForm").action = "<c:url value='/student/addStudentView.do'/>";
		document.getElementById("listForm").submit();
	}

	/* pagination 페이지 링크 function */
	function fn_egov_link_page(pageNo) {
		document.getElementById("listForm").pageIndex.value = pageNo;
		document.getElementById("listForm").action = "<c:url value='/student/StudentList.do'/>";
		document.getElementById("listForm").submit();
	}
// -->
</script>

<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

<script>

	var toggle = true;

	$(document).ready(function(){

		setInterval(table_border_action,500); // 일정 시간마다 함수 호출 하는 자바스크립트 메소드
		
	})
	
	function table_border_action()
	{
		toggle = !toggle;
		
		if(!toggle)
		{
			
			$("#student_view").css("border","4px solid yellow");
			$("#student_view th").css("background-color","#ffffff");
			$("#student_view th").css("color","#000000");			
		}
		else
		{
			
			$("#student_view").css("border","4px solid red");
			$("#student_view th").css("background-color","#000000");
			$("#student_view th").css("color","#ffffff");	
		}
	}	
	
</script>

<style>

	#student_view {border:4px solid yellow;color:white}
	#student_view th {text-align: center;background-color: #000000}
	#student_view td {text-align: center;}
	#student_view tr:nth-child(odd) td {background-color: #606060;}
	#student_view tr:nth-child(even) td {background-color: #7f7f7f;}
	
</style>

</head>
<body>
	<div data-role='page' id='studentList' data-theme='c'>
		<div data-role='header'>
			<a data-ajax='false' data-icon='action' data-iconpos='notext' href="javascript:fn_egov_addView();">등록</a>
			<h3>학생 정보 목록</h3>		
		</div>
		<div data-role='content'>		
			<form:form commandName="searchVO" name="listForm" id="listForm"
				method="post">
				<input type="hidden" name="number" />
				<div id="content_pop">
					<!-- 타이틀 -->
					<center>
					
						<label for='student_view'><h1 style="color:green;">List</h1></label>
						
						<form>
							<input id="tableFilter" data-type="search"></input>
						</form>
												
					</center>
			
					<!-- // 타이틀 -->
					<!-- List -->
					<div id="table">
						<table data-role='table' id='student_view' data-mode='columntoggle:none' class='ui-responsive' data-filter="true" data-input="#tableFilter">
							<thead>
								<tr>
									<th>student_no</th>
									<th data-priority="1">Number</th>
									<th data-priority="2">Name</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="result" items="${resultList}" varStatus="status">
								<tr>
									<td class="listtd">
										<c:out value="${result.no}" /></a>&nbsp;
									</td>
									<td class="listtd">
										<c:out value="${result.number}" /></a>&nbsp;
									</td>
									<td class="listtd">
										<c:out value="${result.name}" />&nbsp;							
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>			
					<ul data-role='listview' data-inset='true' data-theme='c'>
						<li data-role='listview-driver'><a data-ajax='false' data-type='button' href="javascript:fn_egov_addView();">등록</a></li>
					</ul>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
