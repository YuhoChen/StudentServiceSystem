<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@include file="/common/head.jsp" %>

<c:set var="module" value="studentCourse"/>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">

                <div class="ibox-content">
                    <form role="form" class="form-inline" id="query-form" method="post" >
                        <div class="form-group">
                            <label for="cudate">当前周</label>
                            <select  id="cudate" class="form-control" onclick="sel()">
                                <option value="0">第1周</option>
                                <option value="1">第2周</option>
                                <option value="2">第3周</option>
                                <option value="3">第4周</option>
                                <option value="4">第5周</option>
                                <option value="5">第6周</option>
                                <option value="6">第7</option>
                                <option value="7">第8周</option>
                                <option value="8">第9周</option>
                                <option value="9">第10周</option>
                                <option value="10">第11周</option>
                                <option value="11">第12周</option>
                                <option value="12">第13周</option>
                                <option selected value="13">第14周</option>
                                <option value="14">第15周</option>
                                <option value="15">第16周</option>

                            </select>
                        </div>
                    </form>

                    <table id="table" data-toggle="table" data-striped="true" data-click-to-select="true" data-mobile-responsive="true">
                        <thead>
                        <tr>
                            <th data-field="-1" >节次\星期</th>
                            <th data-field="0" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="1" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期一&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="2" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期二&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="3" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期三&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="4" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期四&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="5" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期五&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="6" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期六&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                        </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${CourseAll}" var="n" varStatus="idx">
                                <tr >
                                        <c:if test="${idx.index==0}">
                                            <td >第1~2节</td>
                                        </c:if>
                                        <c:if test="${idx.index==1}">
                                            <td >第3~4节</td>
                                        </c:if>
                                        <c:if test="${idx.index==2}">
                                            <td >第5~6节</td>
                                        </c:if>
                                        <c:if test="${idx.index==3}">
                                            <td >第7~8节</td>
                                        </c:if>
                                        <c:if test="${idx.index==4}">
                                            <td >第9~11节</td>
                                        </c:if>

                                    <c:forEach items="${n}" var="nn" varStatus="id">
                                        <c:if test="${nn !=null}">
                                            <td >${nn.courseName}&nbsp;@${nn.courseInfo}</td>
                                        </c:if>
                                        <c:if test="${nn==null}">
                                            <td ></td>
                                        </c:if>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <table id="table1" hidden data-toggle="table" data-striped="true" data-click-to-select="true" data-mobile-responsive="true">
                        <thead>
                        <tr>
                            <th data-field="-1" >节次\星期</th>
                            <th data-field="0" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="1" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期一&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="2" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期二&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="3" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期三&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="4" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期四&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="5" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期五&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="6" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期六&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${CourseDouble}" var="n" varStatus="idx">
                            <tr >
                                <c:if test="${idx.index==0}">
                                    <td >第1~2节</td>
                                </c:if>
                                <c:if test="${idx.index==1}">
                                    <td >第3~4节</td>
                                </c:if>
                                <c:if test="${idx.index==2}">
                                    <td >第5~6节</td>
                                </c:if>
                                <c:if test="${idx.index==3}">
                                    <td >第7~8节</td>
                                </c:if>
                                <c:if test="${idx.index==4}">
                                    <td >第9~11节</td>
                                </c:if>

                                <c:forEach items="${n}" var="nn" varStatus="id">
                                    <c:if test="${nn !=null}">
                                        <td >${nn.courseName}&nbsp;@${nn.courseInfo}</td>
                                    </c:if>
                                    <c:if test="${nn==null}">
                                        <td ></td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <table id="table2" hidden data-toggle="table" data-striped="true" data-click-to-select="true" data-mobile-responsive="true">
                        <thead>
                        <tr>
                            <th data-field="-1" >节次\星期</th>
                            <th data-field="0" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="1" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期一&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="2" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期二&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="3" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期三&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="4" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期四&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="5" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期五&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th data-field="6" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;星期六&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${CourseSingle}" var="n" varStatus="idx">
                            <tr >
                                <c:if test="${idx.index==0}">
                                    <td >第1~2节</td>
                                </c:if>
                                <c:if test="${idx.index==1}">
                                    <td >第3~4节</td>
                                </c:if>
                                <c:if test="${idx.index==2}">
                                    <td >第5~6节</td>
                                </c:if>
                                <c:if test="${idx.index==3}">
                                    <td >第7~8节</td>
                                </c:if>
                                <c:if test="${idx.index==4}">
                                    <td >第9~11节</td>
                                </c:if>

                                <c:forEach items="${n}" var="nn" varStatus="id">
                                    <c:if test="${nn !=null}">
                                        <td >${nn.courseName}&nbsp;@${nn.courseInfo}</td>
                                    </c:if>
                                    <c:if test="${nn==null}">
                                        <td ></td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>
</div>


<script>


    window.onload=function () {

        var options=$("#cudate option:selected");  //获取选中的项

        var  table= document.getElementById('table');    // table 的 id
        var  table_rows = table.rows;                    // 获取表格所有行


        if(options.val()%2==0){ //单周

            var tb1 = document.getElementById('table2');
            var rows1 = tb1.rows;
            for(var k = 1; k<rows1.length; k++ ){
                for(var z = 1; z<rows1[k].cells.length; z++ ){
                    if(rows1[k].cells[z].innerHTML!=''){
                        table_rows[k].cells[z].innerHTML='';

                    }
                }
            }

            var tb = document.getElementById('table1');
            var rows = tb.rows;
            for(var i = 1; i<rows.length; i++ ){
                for(var j = 1; j<rows[i].cells.length; j++ ){
                    if(rows[i].cells[j].innerHTML!=''){
                        table_rows[i].cells[j].innerHTML=rows[i].cells[j].innerHTML

                    }
                }
            }


        }else { //双周


            var tb1 = document.getElementById('table2');
            var rows1 = tb1.rows;
            for(var k = 1; k<rows1.length; k++ ){
                for(var z = 1; z<rows1[k].cells.length; z++ ){
                    if(rows1[k].cells[z].innerHTML!=''){
                        table_rows[k].cells[z].innerHTML='';

                    }
                }
            }

            var tb = document.getElementById('table1');
            var rows = tb.rows;
            for(var i = 1; i<rows.length; i++ ){
                for(var j = 1; j<rows[i].cells.length; j++ ){
                    if(rows[i].cells[j].innerHTML!=''){
                        table_rows[i].cells[j].innerHTML=rows[i].cells[j].innerHTML

                    }
                }
            }

        }

    }


    function sel() {
        var options=$("#cudate option:selected");  //获取选中的项

        if(options.val()%2==0) { //单周

            single()

        }else {

            double()

        }



    }

    function single() {

        var  table= document.getElementById('table');    // table 的 id
        var  table_rows = table.rows;

        var tb1 = document.getElementById('table1');
        var rows1 = tb1.rows;
        for(var k = 1; k<rows1.length; k++ ){
            for(var z = 1; z<rows1[k].cells.length; z++ ){
                if(rows1[k].cells[z].innerHTML!=''){
                    table_rows[k].cells[z].innerHTML='';

                }
            }
        }

        var tb = document.getElementById('table2');
        var rows = tb.rows;
        for(var i = 1; i<rows.length; i++ ){
            for(var j = 1; j<rows[i].cells.length; j++ ){
                if(rows[i].cells[j].innerHTML!=''){
                    table_rows[i].cells[j].innerHTML=rows[i].cells[j].innerHTML

                }
            }
        }


    }

    function double() {


        var  table= document.getElementById('table');    // table 的 id
        var  table_rows = table.rows;

        var tb1 = document.getElementById('table2');
        var rows1 = tb1.rows;
        for(var k = 1; k<rows1.length; k++ ){
            for(var z = 1; z<rows1[k].cells.length; z++ ){
                if(rows1[k].cells[z].innerHTML!=''){
                    table_rows[k].cells[z].innerHTML='';

                }
            }
        }

        var tb = document.getElementById('table1');
        var rows = tb.rows;
        for(var i = 1; i<rows.length; i++ ){
            for(var j = 1; j<rows[i].cells.length; j++ ){
                if(rows[i].cells[j].innerHTML!=''){
                    table_rows[i].cells[j].innerHTML=rows[i].cells[j].innerHTML

                }
            }
        }

    }





</script>




<%@include file="/common/foot.jsp" %>

</body>
