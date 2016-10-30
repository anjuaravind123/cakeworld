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

						
							<table style="width: 80%;" class="table center">
								
								<tr>
									<td colspan="2"><img src="${pageContext.request.contextPath}/${CategoryImage}"></img></td>
									
								</tr>
								
								
								<tr>
									<td><label>Catgeory Name:</label></td>
									<td>${CategoryName}</td>
									
								</tr>
								
							</table>
						
					</div>
				</div>
			</div>
		</div>
</body>