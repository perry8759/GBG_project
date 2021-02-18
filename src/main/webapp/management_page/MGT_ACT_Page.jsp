<!-- 管理活動頁面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <jsp:include page="/fragment/topMVC.jsp" />
<header>
                 
            </header>
            <br>

            <div class="row">
                <div class="container">
                    <h3 class="text-center">場地列表</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="DOS_new" class="btn btn-success">加入新場地</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>DOS_NAME</th>
                                <th>DOS_ADDR</th>
                                <th>DOS_CY</th>
                                <th>DOS_PAY</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   列出場地  -->
                            <c:forEach var="act" items="${AllACT}">

                                <tr>
                                    <td>
                                        <c:out value="${act.ACT_TITLE}" />
                                    </td>
                                    <td>
                                        <c:out value="${act.ACT_PNUM}" />
                                    </td>
                                    <td>
                                        <c:out value="${act.ACT_RUN_C}" />
                                    </td>
                                    <td>
                                        <c:out value="${act.ACT_RUN_O}" />
                                    </td>
                                    
                                    <td><a href="DOS_edit?dosid=${dos.DOS_ID}">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="DOS_delete?dosid=<c:out value='${dos.DOS_ID}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>
</html>