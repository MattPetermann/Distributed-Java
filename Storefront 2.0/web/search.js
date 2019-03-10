$(function() {
    $('#search').on('submit', function(e){
        e.preventDefault();
        $('.product-card').each( function() {
            $(this).parent().hide();
            if($(this).data('title').toUpperCase().indexOf($('#searchField').val().toUpperCase()) != -1){
                $(this).parent().show();
            }
        });
    });
});