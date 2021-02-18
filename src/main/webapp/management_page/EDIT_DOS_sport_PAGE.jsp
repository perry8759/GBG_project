<!-- 編輯運動種類頁面 -->
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
                        <c:if test="${dos_sport != null}">
                            <form action="DOS_sport_update" method="post" id="DOSform">
                        </c:if>
                        <c:if test="${dos_sport == null}">
                            <form action="DOS_sport_insert" method="post" id="DOSform">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${dos_sport != null}">
                                    編輯運動種類
                                </c:if>
                                <c:if test="${dos_sport == null}">
                                    新增運動種類
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${dos_sport != null}">
                            <input type="hidden" name="id" value="<c:out value='${dos_sport.DOS_SPORT_ID}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>運動種類名稱</label> <input type="text" value="<c:out value='${dos_sport.DOS_SPORT_NAME}' />" class="form-control" name="dos_sport_name" required="required">
                        </fieldset>

                        
                       
                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        
</body>
<script>

$("#progressbarTWInput").change(function(){

  readURL(this);

});

 

function readURL(input){

  if(input.files && input.files[0]){

    var reader = new FileReader();

    reader.onload = function (e) {

       $("#preview_progressbarTW_img").attr('src', e.target.result);

    }

    reader.readAsDataURL(input.files[0]);

  }

}

</script>
</html>