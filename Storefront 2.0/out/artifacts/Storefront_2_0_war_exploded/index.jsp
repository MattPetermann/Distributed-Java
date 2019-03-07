<%--
  Created by IntelliJ IDEA.
  User: mattp
  Date: 2/13/2019
  Time: 7:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
  <style><%@include file="./style.css"%></style>
  <title>Storefront</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarToggler">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="./"><span class="fa fa-home"></span> Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="products"><span class="fa fa-list"></span> Products</a>
      </li>
    </ul>
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="cart"><span class="fa fa-shopping-cart"></span> Cart (<span id="cartCount">0</span>)</a>
      </li>
    </ul>
  </div>
</nav>
<%
  String uri = request.getRequestURI();
  String pageName = uri.substring(uri.lastIndexOf("/")+1);
%>
<% if(pageName.equals("products")) { %>
    <%@ include file="./products.jsp" %>
<% } %>
<% if (pageName.equals("cart")) { %>
    <%@ include file="./cart.jsp" %>
<% } %>
<% if(pageName.equals("")) { %>
<%@ include file="./home.jsp" %>
<% } %>
</body>
</html>
