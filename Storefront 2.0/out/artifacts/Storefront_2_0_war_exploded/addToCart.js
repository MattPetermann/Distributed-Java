$(function() {
    //Quick add adds one of the selected item to cart
    $('.quickAdd').on('submit', function(e) {
        e.preventDefault();
        add($(this), 1);
    });

    //Full add adds a specified number of the selected item to cart
    $('.fullAdd').on('submit', function(e){
        e.preventDefault();
        add($(this), $(this).serializeArray()[0].value);
        $($(this).data('modal')).modal('hide');
    });

    //Proxy to servlet
    var add = function(form, qty) {
        $.get("AddToCart", {productId: form.data('id'), quantity: qty}).then(animateCart);
    };
});