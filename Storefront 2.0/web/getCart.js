$(function() {
   //Get the cart from servlet
    $.get("GetCart").then(function(response) {
        renderCart(response);
    });
});

var renderCart = function(jsonString) {
    //Parse response to JSON format
    var json = JSON.parse(jsonString);

    //Get the list section and empty it
    var cartList = $('#cartList');
    cartList.html('');

    //Fill the list section
    for(var i=0; i<json.cart.length; i++) {
        var id = json.cart[i].id;
        var name = json.cart[i].name;
        var qty = json.cart[i].qty;

        cartList.append(
            '<tr>'+
                '<td>' + (i+1) + '</td>'+
                '<td>' + name + '</td>'+
                '<td>'+
                    '<input class="form-control form-control-sm quantityChange" '+
                            'type="number" '+
                            'min="1" '+
                            'step="1" '+
                            'value=' + qty +
                            ' data-edit=' + id + ' />'+
                '</td>'+
                '<td>'+
                    '<button class="btn btn-danger btn-sm delete" data-remove="' + id + '">X</button>'+
                '</td>'+
            '</tr>'
        );
    }

    //Display proper items
    if(json.cart.length === 0) {
        $('#empty').show();
        $('#cartTable').hide();
        $('#checkout').hide();
    }
};