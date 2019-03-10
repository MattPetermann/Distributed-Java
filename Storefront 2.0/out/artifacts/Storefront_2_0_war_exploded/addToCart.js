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

    //Animate the cart icon
    var animateCart = function() {
        //Count of items in cart
        var count = 0;

        //Get the cart from servlet
        $.get('GetCart', function(response){
            //Parse the response into an object
            var json = JSON.parse(response);

            //Get the count from the parsed object
            for(var i=0; i<json.cart.length; i++){
                count += json.cart[i].qty;
                console.log(count);
            }

            //Set the text to the count
            $('#cartCount').text(count);

            //Refresh the animation
            var el = $('#cartLink');
            el.addClass('animated shake');
            el.on('animationend', function() { el.removeClass('animated shake') });
        });
    }
});