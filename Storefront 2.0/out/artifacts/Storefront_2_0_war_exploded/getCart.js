$(function() {
   //Get the cart from servlet
    $.get("GetCart").then(function(response) {
        //Parse response to JSON format
        var json = JSON.parse(response);

        for(var i=0; i<json.cart.length; i++) {
            var id = json.cart[i].id;
            var name = json.cart[i].name;
            var qty = json.cart[i].qty;

            $('#cartList').append(
                '<tr>'+
                    '<td>' + (i+1) + '</td>'+
                    '<td>' + name + '</td>'+
                    '<td>'+
                        '<input class="form-control form-control-sm" '+
                                'type="number" '+
                                'min="1" '+
                                'step="1" '+
                                'value=' + qty + ' />'+
                    '</td>'+
                    '<td>'+
                        '<button class="btn btn-danger btn-sm delete">X</button>'+
                    '</td>'+
                '</tr>'
            );
        }

        if(json.cart.length === 0) {
            $('#empty').show();
            $('#cartTable').hide();
        }
    });
});