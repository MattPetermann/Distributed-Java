$(function() {
    //Update filter icon
    $('#filters').on('shown.bs.collapse', function(){
        $('#filterArrow').removeClass('fa-angle-double-down').addClass('fa-angle-double-up');
    });
    $('#filters').on('hidden.bs.collapse', function(){
        $('#filterArrow').removeClass('fa-angle-double-up').addClass('fa-angle-double-down');
    });

    //Trigger on form submit or field change
    $('#search').on('submit', function(e){
        search(e);
    });
    $('#searchField').on('change', function(e){
        search(e);
    });

    //Hide all products then show relevant results
    var search = function(e) {
        e.preventDefault();
        $('.product-card').each( function() {
            $(this).parent().hide();
            if($(this).data('title').toUpperCase().indexOf($('#searchField').val().toUpperCase()) != -1){
                $(this).parent().show();
            }
        });
    }
});