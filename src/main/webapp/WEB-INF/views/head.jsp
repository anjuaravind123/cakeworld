<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false"%>
     
    <nav align="center" class="navbar navbar-inverse" style="background-color:#330055">
<div class="container-fluid"><font size="3">
<div class="navbar-header">
</div>
<a class="navbar-brand" href="${pageContext.request.contextPath}/index" >Home</a>
<a class="navbar-brand" href="${pageContext.request.contextPath}/aboutus" >About us</a>
<a class="navbar-brand" href="${pageContext.request.contextPath}/contactus" >Contact us</a>
<a class="navbar-brand" href="${pageContext.request.contextPath}/products" >Products</a>
<ul class="nav navbar-nav">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Cake Store <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/products?search=butterscotch">Butter scotch</a></li>
							<li><a href="${pageContext.request.contextPath}/products?search=vanila cake">Vanila cake</a></li>
							<li><a href="${pageContext.request.contextPath}/products?search=blackforest">Blackforest</a></li>
							<li><a href="${pageContext.request.contextPath}/products?search=chocolava">Chocolava</a></li>
						</ul></li>
 <%
    if (request.isUserInRole("ADMIN"))
    {
    	%>
		<a class="navbar-brand" href="${pageContext.request.contextPath}/category" >Categories</a>
		<%
    }
 %>
 <%
 if (request.isUserInRole("USER"))
    			{
    			%>
  				<a class="navbar-brand" href="${pageContext.request.contextPath}/initiateFlow" >View Cart</a>
  				<%
    			}
%>
						</ul>

			<ul class="nav navbar-nav navbar-right">
	      				
	      				
	      				<c:choose>
	      					<c:when test="${not empty pageContext.request.userPrincipal}">
	      						<li><span style="position: absolute; top: -5px; right: 5px; color: #FFFFFF;">${pageContext.request.userPrincipal.name}</span></li>
	      						<li><a href="${pageContext.request.contextPath}/logout">Log Out</a></li>
	      						
	      					</c:when>
	      					
	      					<c:otherwise>
	      						<li><a class="navbar-brand" href="${pageContext.request.contextPath}/loginpage">Login</a></li>
				        		<li><a class="navbar-brand" href="${pageContext.request.contextPath}/signup">Sign Up</a></li>
	      					</c:otherwise>
	      				</c:choose>
						
			        </ul>
						
  </div></div></nav>
  
  <footer style="position: fixed; bottom: 0px; width: 100%; background-color: #330055; color: #FFFFFF;
   text-align: center; height:50px; z-index: 50;">
   @cakefactory.com
   </footer>
  
  
    