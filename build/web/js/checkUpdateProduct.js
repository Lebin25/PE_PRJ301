function check() {
    var arr = document.getElementsByTagName('input');
    var name = arr[1].value;
    var quantity = arr[2].value;
    var price = arr[3].value;
    var image = arr[4].value;
    if (name == "" || quantity == "" || price == "" || image == "") {
        alert("Please fill all information of product!\n\Go to list of product and update again.");
        return;
    }
    if (isNaN(quantity) || isNaN(price)) {
        alert("Please enter a NUMBER for Quatity and Price!\n\Go to list of product and update again.");
        return;
    }
}

