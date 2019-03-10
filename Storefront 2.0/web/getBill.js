$(function() {
    $(document).on('click', '#checkout', function(){
        //Get the cart from servlet
        $.get('GetCart', function(response){
            //Parse the response
            var json = JSON.parse(response);

            //Track bill total
            var billTotal = 0;

            //Build the rows
            var rows = '';
            for(var i=0; i<json.cart.length; i++) {
                var rowTotal = (parseInt(json.cart[i].qty) * parseFloat(json.cart[i].price)).toFixed(2);
                billTotal += parseFloat(rowTotal);
                rows +=
                    '<tr>' +
                        '<td>' + json.cart[i].name + '</td>' +
                        '<td>' + json.cart[i].qty + '</td>' +
                        '<td class="right-align">$' +
                            rowTotal +
                        '</td>' +
                    '</tr>';
            }

            //Build the bill
            var modal =
                '<div class="modal" id="billModal">' +
                    '<div class="modal-dialog">' +
                        '<div class="modal-content">' +
                            '<div class="modal-header">' +
                                '<h4 class="modal-title">Review Your Order</h4>' +
                                '<button type="button" class="close" data-dismiss="modal">&times;</button>' +
                            '</div>' +
                            '<div class="modal-body">' +
                                '<table class="table table-borderless">' +
                                    '<thead>' +
                                        '<th>Product Name</th>' +
                                        '<th>Quantity</th>' +
                                        '<th class="right-align">Price</th>' +
                                    '</thead>' +
                                    '<tbody>' +
                                        rows +
                                        '<tr>' +
                                            '<td></td>' +
                                            '<td></td>' +
                                            '<th>$' + billTotal.toFixed(2) + '</th>' +
                                        '</tr>' +
                                    '</tbody>' +
                                '</table>' +
                                '<small class="tax">(+Tax & Shipping)</small>' +
                            '</div>' +
                            '<div class="modal-footer">' +
                                '<button class="btn btn-primary">' +
                                    '<span class="fa fa-credit-card"></span> Proceed to Payment' +
                                '</button>' +
                            '</div>' +
                        '</div>' +
                    '</div>' +
                '</div>';

            //Insert the modal and show it
            $('#bill').html(modal);
            $('#billModal').modal('show');
        });
   })
});