const products = [{name: 'Test Product', info: 'This is a test product.', icon: 'http://placehold.it/200x200', link: './items/product01.html'}];

$(function(){
    products.forEach(function(item){
        $('#products').append(
            '<div class="card product-card">\n' +
            '<img class="card-img-top" src=' + item.icon + '/>' +
            '  <div class="card-body">\n' +
            '    <h4 class="card-title">' + item.name + '</h4>\n' +
            '    <p class="card-text">' + item.info + '</p>\n' +
            '    <a href=' + item.link + ' class="btn btn-primary">View More</a>' +
            '    <button class="btn btn-success">Add to Cart</button>' +
            '  </div>\n' +
            '</div>'
        );
    });
});