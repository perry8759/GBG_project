<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 管理場地頁面 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
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

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">加入新場地</a>
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
                            <c:forEach var="dos" items="${AllDOS}">

                                <tr>
                                    <td>
                                        <c:out value="${dos.DOS_NAME}" />
                                    </td>
                                    <td>
                                        <c:out value="${dos.DOS_ADDR}" />
                                    </td>
                                    <td>
                                        <c:out value="${dos.DOS_CY}" />
                                    </td>
                                    <td>
                                        <c:out value="${dos.DOS_PAY}" />
                                    </td>
                                    
                                    <td><a href="edit?dosid=${dos.DOS_ID}">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>
</html>