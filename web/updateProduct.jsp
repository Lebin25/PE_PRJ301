
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User Page</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="./js/checkUpdateProduct.js"></script>
    </head>
    <body>
        <form action="updateProduct" method="post" enctype="multipart/form-data" class="vh-100 gradient-custom">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                        <div class="card bg-dark text-white" style="border-radius: 1rem;">
                            <div class="card-body p-5 text-center">
                                <div class="mb-md-5 mt-md-4 pb-5">
                                    <h2 class="fw-bold mb-2 text-uppercase">Update Product</h2>
                                    <p class="text-white-50 mb-5">Please update information of product</p>
                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="productID">Product ID</label>
                                        <input name="productID" value="${pd.productID}" type="text" id="productID" class="form-control form-control-lg" readonly/>
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="productName">Product Name</label>
                                        <input name="productName" value="${pd.productName}" type="text" id="productName" class="form-control form-control-lg"/>
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="quantity">Quantity</label>
                                        <input name="quantity" value="${pd.quantity}" type="text" id="quantity" class="form-control form-control-lg" />
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="price">Price </label>
                                        <input name="price" value="${pd.price}" type="text" id="price" class="form-control form-control-lg" />
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="image">Image </label>
                                        <input type="file" name="image" id="image" class="form-control form-control-lg" />

                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="userCreate">User Create </label>
                                        <input name="userCreate" value="${pd.userCreate}" type="text" id="userCreate" class="form-control form-control-lg" readonly/>
                                    </div>
                                    
                                    <button onclick="check()" class="btn btn-outline-light btn-lg px-5" type="submit">Update</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>           
    </body>
</html>
