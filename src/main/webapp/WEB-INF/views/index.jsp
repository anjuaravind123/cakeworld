<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
    <head>
    <c:import url="/head-meta"></c:import>
    
    </head>
    <body>
    <c:import url="/head"></c:import>
    <style>
 .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 50%;
      margin: auto;
  }
  </style>
  <div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="resources\images\o.jpg" alt="Cake" width="360" height="345">
      </div>
	  <div class="item">
        <img src="resources\images\c.jpg" alt="Cake" width="360" height="345">
      </div>
	  <div class="item">
        <img src="resources\images\a.jpg" alt="Cake" width="360" height="345">
      </div>
	  <div class="item">
        <img src="resources\images\sd.jpg" alt="Cake" width="360" height="345">
      </div>
	  </div>
	  
<!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

    <div class="jumbotron text-center">
</div>
  
<div class="container">
  <div class="row">
    <div class="col-sm-4">
    <a href="plum" ><img src="resources/images/pp.jpg" class="img-circle" alt="Cinque Terre" width="204" height="136"></a>
      <h3>Plum Cakes</h3>
      <p>Plum cake refers to a wide range of cakes made with either dried fruit (such as grapes, currants, raisins or prunes) or with fresh fruit.</p>
      </div>
    <div class="col-sm-4">
    <a href="blackforest"><img src="resources/images/b.jpg" class="img-circle" alt="Cinque Terre" width="204" height="136"></a>
      <h3>BlackForest Cakes</h3>
      <p>Black Forest gateau consists of several layers of chocolate sponge cake sandwiched with whipped cream and cherries. </p>
    </div>
    <div class="col-sm-4">
    <a href="chocolava"><img src="resources/images/sss.jpg" class="img-circle" alt="Cinque Terre" width="204" height="136"></a>
      <h3>Choco Lava Cakes</h3>
      <p>Rather than presenting only the cake itself in a ramekin or on a plate, the baker may choose to make it more appealing. </p>
    </div>
  </div>
</div>
    
    </body>
    <footer style="position: fixed; bottom: 0px; width: 100%; background-color: #330055; color: #FFFFFF;
   text-align: center; height:50px">
   @cakefactory.com
   </footer>