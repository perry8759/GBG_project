<!-- 編輯場地頁面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/fragment/topMVC.jsp" />
       <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${dos != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${dos == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${dos != null}">
                                    編輯使用者
                                </c:if>
                                <c:if test="${dos == null}">
                                    新增使用者
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${dos != null}">
                            <input type="hidden" name="id" value="<c:out value='${dos.DOS_ID}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>場地名稱</label> <input type="text" value="<c:out value='${dos.DOS_NAME}' />" class="form-control" name="name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>場地地址</label> <input type="text" value="<c:out value='${dos.DOS_ADDR}' />" class="form-control" name="email">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>場地最大容納人數</label> <input type="text" value="<c:out value='${dos.DOS_CY}' />" class="form-control" name="country">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        
</body>
</html>