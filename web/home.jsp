
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Home Page</title>
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <style>
            body {
                margin: 0;
                font-family: Arial, Helvetica, sans-serif;
            }

            .topnav {
                overflow: hidden;
                background-color: #333;
                position: fixed;
                width: 100%;
                top: 0;
            }

            .topnav a {
                float: left;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
            }

            .topnav a:hover {
                background-color: #ddd;
                color: black;
            }

            .topnav a.active {
                background-color: #04AA6D;
                color: white;
            }


            .button {
                width: 50px;
                height: 25px;
                background: #4E9CAF;
                padding: 4px;
                text-align: center;
                border-radius: 5px;
                color: white;
                font-weight: bold;
                line-height: 25px;
                font-size: 12px;
            }
            .button:hover{
                text-decoration: none;
            }

            .action{
                width: 97px;
            }

            .p-5 {
                padding: 2rem!important;
            }
            .container{
                margin-top: 32px;
            }
        </style>
    </head>
    <body>
        <div class="topnav">
            <a class="active" href="#">Hello ${sessionScope.acc.username}</a>

            <c:if test="${sessionScope.acc == null}">
                <a href="login.jsp">Login / Sign Up</a>
            </c:if>
            <c:if test="${sessionScope.acc.role == 1}">
                <a href="createUser.jsp">Add Accounts</a>
                <a href="createProduct.jsp">Add Products</a>
            </c:if>
            <c:if test="${sessionScope.acc != null}">
                <a href="logout">Logout</a>
            </c:if>
        </div>
        <br/>
        <c:if test="${sessionScope.acc.role == 1}">
            <div class="container ">
                <div class="row ">
                    <div class="span12">
                        <table class="table table-striped table-condensed table-bordered">
                            <h3>Users List</h3>
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Password</th>
                                    <th>Full Name</th>
                                    <th>Role</th>
                                    <th>Status</th>
                                        <c:if test="${sessionScope.acc.role == 1}">
                                        <th>Action</th>
                                        </c:if>
                                </tr>
                            </thead>   
                            <tbody>
                                <c:forEach items="${listA}" var="a">
                                    <tr>
                                        <td >${a.username}</td>
                                        <td>${a.password}</td>
                                        <td>${a.fullname}</td>
                                        <td>
                                            <c:if test="${a.role==1}">Admin</c:if>
                                            <c:if test="${a.role==0}">User</c:if>
                                        </td>
                                        <td>
                                            <c:if test="${a.status==1}"><span class="label label-success">Active</span></c:if>
                                            <c:if test="${a.status==0}"><span class="label label-defalut">Disable</span></c:if>
                                        </td> 
                                        <td class="action">
                                            <c:if test="${sessionScope.acc.role == 1}">
                                                <c:if test="${a.username != sessionScope.acc.username}"><a class="button" href="delete?username=${a.username}">Delete</a></c:if> 
                                                <a class="button" href="updateUser?username=${a.username}">Update</a>
                                            </c:if>  
                                        </td>

                                    </tr> 
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${sessionScope.acc.role == 0}">
            <div class="container ">
                <div class="row ">
                    <div class="span12">
                        <table class="table table-striped table-condensed table-bordered">
                            <h3>Users List</h3>
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Password</th>
                                    <th>Full Name</th>
                                    <th>Role</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                            </thead>   
                            <tbody>
                                <c:forEach items="${listA}" var="a">
                                    <c:if test="${a.username == sessionScope.acc.username}">
                                        <tr>
                                            <td >${a.username}</td>
                                            <td>${a.password}</td>
                                            <td>${a.fullname}</td>
                                            <td>
                                                <c:if test="${a.role==1}">Admin</c:if>
                                                <c:if test="${a.role==0}">User</c:if>
                                            </td>
                                            <td>
                                                <c:if test="${a.status==1}"><span class="label label-success">Active</span></c:if>
                                                <c:if test="${a.status==0}"><span class="label label-defalut">Disable</span></c:if>
                                            </td> 
                                            <td class="action">
                                                    <a class="button" href="updateUser?username=${a.username}">Update</a>
                                            </td>
                                        </tr>   
                                    </c:if>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </c:if>
        <div class="container">
            <div class="row">
                <div class="span12">
                    <table class="table table-striped table-condensed table-bordered">
                        <h3>Products List</h3>
                        <thead>
                            <tr>
                                <th>Product ID</th>
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Image</th>
                                <th>User Create</th>
                                <th>Date Create</th>
                                    <c:if test="${sessionScope.acc.role == 1}">
                                    <th>Action</th>
                                    </c:if>
                            </tr>
                        </thead>   
                        <tbody>
                            <c:forEach items="${listP}" var="p">
                                <tr>
                                    <td>${p.productID}</td>
                                    <td>${p.productName}</td>
                                    <td>${p.quantity}</td>
                                    <td>${p.price}</td>
                                    <td><img src="images/${p.image}" width="150" height="150"></td>
                                    <td>${p.userCreate}</td>
                                    <td>${p.date}</td> 
                                    <td class="action">
                                        <c:if test="${sessionScope.acc.role == 1}">
                                            <a class="button" href="delete?productID=${p.productID}">Delete</a>
                                            <a class="button" href="updateProduct?productID=${p.productID}">Update</a>
                                        </c:if>  
                                    </td>
                                </tr>  
                            </c:forEach>     
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>


