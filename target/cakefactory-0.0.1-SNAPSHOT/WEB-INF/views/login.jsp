<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
    <head>
    <c:import url="/head-meta"></c:import>
    
    </head>
    <body>
    <c:import url="/head"></c:import>
    
    <form action="action_page.php">
  <div class="imgcontainer"></div>
<div class="container">
    <label><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>
<p>
    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
      <p>  
    <button type="submit">Login</button>
    <input type="checkbox" checked="checked"> Remember me
  </div>
<div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
</form>
</body>