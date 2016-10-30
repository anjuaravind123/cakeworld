<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<head>
<c:import url="/head-meta"></c:import>

</head>
<c:import url="/head"></c:import>
<body>
	
		<script type="text/css">
</script>
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-centered">
					<div class="table-responsive">

						<form:form action="AddProductToDB" method="POST" modelAttribute="Product" enctype="multipart/form-data">
							<table style="width: 80%;" class="table center">
								<tr>
									<td><form:label path="productName" for="productName">Product Name:</form:label></td>
									<td><form:input path="productName" type="text"
											class="form-control" id="productName" /></td>
									
								</tr>
								<tr>
									<td><form:label path="productCategory"
											for="productCategory">Product Category:</form:label></td>
									<td>
											
											<form:select path="productCategory" class="form-control select-menu">
											  
											  <c:if test="${not empty Categories}">
											  <c:forEach var="cat" items="${Categories}">
											  	<option value="${cat.categoryName}">${cat.categoryName}</option>
											  </c:forEach>
											  </c:if>
											  
											  <c:if test="${empty Categories}">
											  <option value="None">None</option>
											  </c:if>
											  								  
											</form:select>
											
											
									</td>
									
								</tr>
								<tr>
									<td><form:label path="productPrice" for="productPrice">product Price</form:label></td>
									<td><form:input path="productPrice" type="productPrice"
											class="form-control" id="productPrice" /></td>
									
								</tr>
								<tr>
									<td><form:label path="productQty" for="productQty">product Qty:</form:label></td>
									<td><form:input path="productQty" type="productQty"
											class="form-control" id="productQty" /></td>
									
								</tr>
								<tr>
									<td><form:label path="productFile" for="productFile">product Image:</form:label></td>
									<td><form:input path="productFile" type="file"
											class="form-control" id="productImage" /></td>
									
								</tr>
								<tr>
									<td><form:label path="productDescription"
											for="productDescription">product Description:</form:label></td>
									<td><form:input path="productDescription"
											type="productDescription" class="form-control"
											id="productDescription" /></td>
									
								</tr>
								<tr>
									<td colspan="2">
										<div class="row">
											<div class="col-md-2 col-md-offset-5">
												<button type="submit" class="btn btn-default">Submit</button>
											</div>
										</div>
									</td>
								</tr>
							</table>
						</form:form>
					</div>
				</div>
			</div>
		</div>
</body>