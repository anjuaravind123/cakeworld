<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
    <head>
     <c:import url="/head-meta"></c:import>
   
   
    <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script><link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>


<script type="text/javascript">

  function checkForm(form)
  {
    if(form.username.value == "") {
      alert("Error: Username cannot be blank!");
      form.username.focus();
      return false;
    }
    re = /^\w+$/;
    if(!re.test(form.username.value)) {
      alert("Error: Username must contain only letters, numbers and underscores!");
      form.username.focus();
      return false;
    }
	
	if(form.emailid.value==""){
	  alert("Error: Email cannot be blank!");
	  form.emailid.focus();
	  return false;
	}
    
    re = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!re.test(form.emailid.value)) {
		alert('Please provide a valid email address');
		form.emailid.focus();
    return false;
	}
	
	if(form.mobile.value==""){
		alert("Error: Mobile No cannot be blank!");
		form.mobile.focus();
		return false;
	}
	
	if(form.mobile.value.length < 10 || form.mobile.value.length > 10){
		alert("Mobile No. is not valid, Please Enter 10 Digit Mobile No.")
		form.mobile.focus();
		return false;
	}
	
	re = /^[7-9]{1}[0-9]{9}/;  
	if(!re.test(form.mobile.value))  
     {    
       alert("Not a valid Mobile Number");  
       form.mobile.focus();
	   return false;  
     }
	
	if(form.pwd1.value != "" && form.pwd1.value == form.pwd2.value) {
      if(form.pwd1.value.length < 6) {
        alert("Error: Password must contain at least six characters!");
        form.pwd1.focus();
        return false;
      }
      if(form.pwd1.value == form.username.value) {
        alert("Error: Password must be different from Username!");
        form.pwd1.focus();
        return false;
      }
      re = /[0-9]/;
      if(!re.test(form.pwd1.value)) {
        alert("Error: password must contain at least one number, one lowercase letter, one uppercase letter and one symbol (! @ # $ % ^ & * _)!");
        form.pwd1.focus();
        return false;
      }
      re = /[a-z]/;
      if(!re.test(form.pwd1.value)) {
        alert("Error: password must contain at least one number, one lowercase letter, one uppercase letter and one symbol (! @ # $ % ^ & * _)!");
        form.pwd1.focus();
        return false;
      }
      re = /[A-Z]/;
      if(!re.test(form.pwd1.value)) {
        alert("Error: password must contain at least one number, one lowercase letter, one uppercase letter and one symbol (! @ # $ % ^ & * _)!");
        form.pwd1.focus();
        return false;
      }
      re = /[!@#$%^&*_]/;
      if(!re.test(form.pwd1.value)) {
        alert("Error: password must contain at least one number, one lowercase letter, one uppercase letter and one symbol (! @ # $ % ^ & * _)!");
        form.pwd1.focus();
        return false;
	  }
	  } else {
      alert("Error: Please check that you've entered and confirmed your password!");
      form.pwd1.focus();
      return false;
    }
    alert("You have Successfully created an account");
    return true;
  }
  

</script>
</head>
<body>
    <c:import url="/head"></c:import>
    
<form ... onsubmit="return checkForm(this);">
<div align="center">
<p>Username: <input type="text" name="username"></p>
<p>Email Id: <input type="text" name="emailid"></p>
<p>Date Of Birth: <input type="text" id="datepicker"></p>
<p>Mobile No: <input type="text" name="mobile"></p>
<p>Password: <input type="password" name="pwd1"></p>
<p>Confirm Password: <input type="password" name="pwd2"></p>
<p><a href="cake.html"><input type="submit" value="Register"></a></p>
</div>
</form>
</body>
    