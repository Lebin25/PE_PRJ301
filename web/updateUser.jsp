
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User Page</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="./js/checkUpdateUser.js"></script>
    </head>
    <body>
        <form action="updateUser" method="post" class="vh-100 gradient-custom">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                        <div class="card bg-dark text-white" style="border-radius: 1rem;">
                            <div class="card-body p-5 text-center">
                                <div class="mb-md-5 mt-md-4 pb-5">
                                    <h2 class="fw-bold mb-2 text-uppercase">Update User</h2>
                                    <p class="text-white-50 mb-5">Please update information of user</p>
                                    <p class="text-danger">${messStatus}</p>
                                    <p class="text-danger">${messRole}</p>
                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="typeUsername">Username</label>
                                        <input name="user" value="${ac.username}" type="text" id="typeUsername" class="form-control form-control-lg" readonly/>
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="typePasswordX">Password</label>
                                        <input name="pass" value="${ac.password}" type="password" id="typePasswordX" class="form-control form-control-lg" />
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="fullname">Full Name </label>
                                        <input name="fullname" value="${ac.fullname}" type="text" id="fullname" class="form-control form-control-lg" />
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="userrole">Role </label>
                                        <input name="role" value="${ac.role}" type="text" placeholder="Type 0 to create a User, 1 to create an Admin" id="userrole" class="form-control form-control-lg" />
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="userstatus">Status </label>
                                        <c:if test="${ac.username == sessionScope.acc.username}">
                                            <input name="status" value="${ac.status}" type="text" placeholder="Type 0 to disable user, 1 to active user" id="userstatus" class="form-control form-control-lg" readonly/>
                                        </c:if>
                                        <c:if test="${ac.username != sessionScope.acc.username}">
                                            <input name="status" value="${ac.status}" type="text" placeholder="Type 0 to disable user, 1 to active user" id="userstatus" class="form-control form-control-lg" />
                                        </c:if>
                                    </div>

                                    <button onclick="checkUser()" class="btn btn-outline-light btn-lg px-5" type="submit">Update</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
