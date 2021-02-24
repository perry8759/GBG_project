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
                            <form action="DOS_update" method="post" id="DOSform">
                        </c:if>
                        <c:if test="${dos == null}">
                            <form action="DOS_insert" method="post" id="DOSform">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${dos != null}">
                                    編輯場地
                                </c:if>
                                <c:if test="${dos == null}">
                                    新增場地
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${dos != null}">
                            <input type="hidden" name="id" value="<c:out value='${dos.DOS_ID}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>場地名稱</label> <input type="text" value="<c:out value='${dos.DOS_NAME}' />" class="form-control" name="dos_name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>場地地址</label> <input type="text" value="<c:out value='${dos.DOS_ADDR}' />" class="form-control" name="dos_addr">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>場地最大容納人數</label> <input type="text" value="<c:out value='${dos.DOS_CY}' />" class="form-control" name="dos_cy">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>場地備註</label> <textarea rows="4" cols="50" name="dos_ps" form="DOSform">${dos.clobString_DOSPS}</textarea>
                        </fieldset>
                         <fieldset class="form-group">
                            <label>場地交通資訊</label> <textarea rows="4" cols="50" name="dos_trans" form="DOSform">${dos.clobString_DOSTRANS}</textarea>
                        </fieldset>
                        
                        <c:if test="${dos != null}">
                        <label>場地運動種類</label> 
                        <c:forEach var="dosp"  varStatus="statusX" items="${dos_sport}">                            
                            <input type="radio" name="dos_sport_id" value="<c:out value='${dosp.DOS_SPORT_ID}' />"> ${dosp.DOS_SPORT_NAME}           
                        </c:forEach>
                        </c:if>
                        <c:if test="${dos == null}">
                        <label>場地運動種類</label> 
                        <c:forEach var="dosp"  varStatus="statusX" items="${dos_sport}">                            
                            <input type="radio" name="dos_sport_id" value="<c:out value='${dosp.DOS_SPORT_ID}' />"> ${dosp.DOS_SPORT_NAME}           
                        </c:forEach>
                        </c:if>
                        
                     	<!--<label>場地照片</label> 
                        <c:forEach var="dospic"  varStatus="statusX" items="${dos_picture}">
                       <input type="file" id="progressbarTWInput" accept="image/gif, image/jpeg, image/png"/>
                        <img src="data:image/jpg;base64,${dospic}" class="img-fluid" id="preview_progressbarTW_img"/>
                        </c:forEach>-->
                       
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