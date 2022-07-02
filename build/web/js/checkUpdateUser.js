function checkUser(){
    var arr = document.getElementsByTagName('input');
    var pass = arr[1].value;
    var fullname = arr[2].value;
    var role = arr[3].value;
    var status = arr[4].value;
    if(pass.length==0 || fullname.length==0){
        alert("Please fill all information of user!\n\Go to list of user and update again.");
        return;
    }
    if(isNaN(role)|| (role!=1 && role!=0)){
        alert("Please enter 1 for Admin or 0 for User!\n\Go to list of user and update again.");
        return;
    }
    if(isNaN(status) || status!=1){
        alert("Please enter 1 to enable this user!\n\Go to list of user and update again.");
        return;
    }
}

