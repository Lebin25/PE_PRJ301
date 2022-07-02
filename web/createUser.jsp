
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User Page</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <form action="createUser" method="post" class="vh-100 gradient-custom">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                        <div class="card bg-dark text-white" style="border-radius: 1rem;">
                            <div class="card-body p-5 text-center">
                                <div class="mb-md-5 mt-md-4 pb-5">
                                    <h2 class="fw-bold mb-2 text-uppercase">Create User</h2>
                                    <p class="text-white-50 mb-5">Please enter username and password!</p>
                                    <p class="text-danger">${messUsername}</p>
                                    <p class="text-danger">${messRole}</p>
                                    <p class="text-danger">${messFillAllInfo}</p>
                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="typeUsername">Username</label>
                                        <input name="user" type="text" id="typeUsername" class="form-control form-control-lg" />
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="typePasswordX">Password</label>
                                        <input name="pass" type="password" id="typePasswordX" class="form-control form-control-lg" />
                                    </div>
                                    
                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="fullname">Full Name </label>
                                        <input name="fullname" type="text" id="fullname" class="form-control form-control-lg" />
                                    </div>
                                    
                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="userrole">Role </label>
                                        <input name="role" type="text" placeholder="Type 0 to create a User, 1 to create an Admin" id="userrole" class="form-control form-control-lg" />
                                    </div>

                                    <button class="btn btn-outline-light btn-lg px-5" type="submit">Create</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
