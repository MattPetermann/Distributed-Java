$(function() {
    $('#search').on('submit', function(e){
        e.preventDefault();
        $('.product-card').each( function() {
            $(this).hide();
            if($(this).data('title').toUpperCase().indexOf($('#searchField').val().toUpperCase()) != -1){
                $(this).show();
            }
        });
    });
});