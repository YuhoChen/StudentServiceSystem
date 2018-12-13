<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@include file="/common/head.jsp" %>

<c:set var="module" value="course"/>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <form action="${ctx }/admin/course/save?id=${n.id }" id="detail-form" class="form-horizontal" method="post">



    <div class="form-group">
        <label class="col-sm-2 control-label">课程号</label>
        <div class="col-sm-4">
            <input type="text" ${empty n.id ? '' : 'readonly' } class="form-control" id="courseNumber" name="courseNumber" value="${n.courseNumber}">
        </div>

        <label class="col-sm-2 control-label">课程名称</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="courseName" name="courseName" value="${n.courseName}">
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label">任课老师</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="teacher" name="teacher" value="${n.teacher}">
        </div>

        <label class="col-sm-2 control-label">上课地点</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="courseInfo" name="courseInfo" value="${n.courseInfo}">
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label">学分</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="courseCredit" name="courseCredit" value="${n.courseCredit}">
        </div>
            <label class="col-sm-2 control-label">上课时间</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="courseDate" name="" value="${msg}">
            </div>
    </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">课程时间调整</label>
            <select name="Week">
                <option value="0">双周</option>
                <option value="1">单周</option>
                <option value="2">单双周</option>
            </select>
            <select name="Day">
                <option value="0">周日</option>
                <option value="1">周一</option>
                <option value="2">周二</option>
                <option value="3">周三</option>
                <option value="4">周四</option>
                <option value="5">周五</option>
                <option value="6">周六</option>
            </select>
            <select name="Jieshu">
                <option value="1">1~2节</option>
                <option value="2">3~4节</option>
                <option value="3">5~6节</option>
                <option value="4">7~8节</option>
                <option value="5">9~11节</option>
            </select>
            <select name="Biaozhi">
                <option value="0">静置</option>
                <option value="1">添加</option>
                <option value="2">修改</option>
            </select>
        </div>
    </form>

</div>

<%@include file="/common/foot.jsp" %>

</body>

