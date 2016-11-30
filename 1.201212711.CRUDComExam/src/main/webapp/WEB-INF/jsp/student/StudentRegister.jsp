<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
 /**
  * @Class Name : StudentRegister.jsp
  * @Description : Student Register 화면
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

<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<c:set var="registerFlag" value="${empty studentVO.number ? '등록' : '수정'}"/>			

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!-- For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="studentVO" staticJavascript="false" xhtml="true" cdata="false"/ -->


<script type="text/javaScript" language="javascript" defer="defer">

<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/student/StudentList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/student/deleteStudent.do'/>";
   	document.getElementById("detailForm").submit();		
}
-->

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "/CRUDComExam/student/addStudent.do";
    frm.submit();

}




</script>

</head>
<body>

<form:form commandName="studentVO" name="detailForm" id="detailForm" >
<div data-role='page' id="content_pop">
	<!-- 타이틀 -->
	<div data-role='header' id="title">
		<h3><c:out value="${registerFlag}"/></h3>
	</div>
	<!-- // 타이틀 -->
	<div data-role='content' id="table">				
			<c:if test="${registerFlag == '수정'}">
			</c:if>
			<c:if test="${registerFlag == '등록'}">
			</c:if>	
				
				<label for='number'><h3>number</h3></label>
				<form:input path="number" cssClass="txt"/>
				&nbsp;<form:errors path="number" />	
				<label for='name'><h3>name</h3></label>
				<form:input path="name" cssClass="txt"/>
				&nbsp;<form:errors path="name" />
					 
		<ul data-role='listview' data-inset='true'>
			<li data-icon='back'><a data-ajax='false' href="javascript:fn_egov_selectList();">List</a></li>
			<li data-icon='action'><a href="javascript:fn_egov_save();"><c:out value='${registerFlag}'/></a></li>
			<li data-icon='refresh'><a href="javascript:document.detailForm.reset();">Reset</a></li>
		</ul>
		</div>
</div>
<!-- 검색조건 유지 -->
<input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
<input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
</form:form>
</body>
</html>

