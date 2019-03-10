//Animate the cart icon
var animateCart = function(animate) {
    //Default value for animate
    if(animate === "" || animate === undefined) animate = true;

    //Count of items in cart
    var count = 0;

    //Get the cart from servlet
    $.get('GetCart', function(response){
        //Parse the response into an object
        var json = JSON.parse(response);

        //Get the count from the parsed object
        for(var i=0; i<json.cart.length; i++){
            count += json.cart[i].qty;
        }

        //Set the text to the count
        $('#cartCount').text(count);

        //Refresh the animation
        if(animate) {
            var el = $('#cartLink');
            el.addClass('animated shake');
            el.on('animationend', function () {
                el.removeClass('animated shake')
            });
        }
    });
};