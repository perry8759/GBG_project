<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
      integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
      crossorigin="anonymous"
    />
    <!-- 自己寫的css記得放在bootstrap的下方，避免被覆蓋掉 -->
    <title>GBG</title>
  </head>
  <body>
    <!-- navbar ====================================-->
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
      <!-- 這邊改顏色/ expand改啥寬度產生rwd變化 -->
      <div class="container">
        <!-- 用container增加padding -->
        <div class="container-fluid">
          <a class="navbar-brand" href="#">GBG</a>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="<c:url value='/index.jsp' />">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<c:url value='/ACT/ACT_Index' />">賽事專區</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<c:url value='/DOS/DOS_Index' />">舉辦活動</a>
              </li>
  			  <li class="nav-item">
                <a class="nav-link" href="<c:url value='/DOS/DOS_Index' />">場地查詢</a>
              </li>
              <c:choose>
		          <c:when test="${LoginOK.member_perm_id.member_perm_id==2 }">
		             <li class="nav-item">
		             	<a class="nav-link" a href="#">管理活動</a>
		             </li>
		          </c:when>
		          <c:when test="${LoginOK.member_perm_id.member_perm_id==3 }">
		          	<li class="nav-item">
		             	<a class="nav-link" a href="#">管理活動</a>
		             </li>
		             <li class="nav-item">
		             	<a class="nav-link" href="<c:url value='/DOS/DOS_list' />">管理場地</a>
		             </li>
		             <li class="nav-item">
		             	<a class="nav-link" href="#">管理商品</a>
		             </li>
		          </c:when>	          
		    </c:choose>
            </ul>

            <!--視需求新增欄位 li -->
            <ul class="navbar-nav ml-auto">
            <c:if test="${empty  LoginOK}">
              <li class="nav-item">
                <a class="nav-link" href="<c:url value='/register/register.jsp' />">註冊</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<c:url value='/login/login2.jsp' />">登入</a>
              </li>
             </c:if>
             <c:if test="${! empty LoginOK}">  
             	<c:choose>
		          <c:when test="${LoginOK.member_perm_id.member_perm_id==1 }">
		          <li class="nav-item nav-link">一般會員主辦方${LoginOK.member_account }</li>
		           </c:when>
		           <c:when test="${LoginOK.member_perm_id.member_perm_id==2 }">
		          <li class="nav-item nav-link">主辦方${LoginOK.member_account }</li>
		           </c:when>
		           <c:when test="${LoginOK.member_perm_id.member_perm_id==3 }">
		          <li class="nav-item nav-link">管理員${LoginOK.member_account }</li>
		           </c:when>	
		        </c:choose>
            	<li class="nav-item">
            	<a class="nav-link" href="<c:url value='/login/logout.jsp' />">登出</a></li>
            </c:if>
            </ul>
          </div>
        </div>
      </div>
    </nav>
    
    <script
      src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
      integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
      crossorigin="anonymous"
    ></script>
      </body>
</html>
    