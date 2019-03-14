$(function() {
    //Update filter icon
    $('#filters').on('shown.bs.collapse', function(){
        $('#filterArrow').removeClass('fa-angle-double-down').addClass('fa-angle-double-up');
    }).on('hidden.bs.collapse', function(){
        $('#filterArrow').removeClass('fa-angle-double-up').addClass('fa-angle-double-down');
    });

    //Trigger on form submit or field change
    $('#search').on('submit', function(e){
        search(e);
    });
    $('#searchField').on('change', function(e){
        search(e);
    });

    //Update filter checkboxes
    $('.filter').on('change', function(){
        //If this is not the check all button
        if($(this).data('show') !== 'All') {
            //Count how many are not checked
            var count = 0;
            $('.filter').each(function () {
                if($(this).data('show') !== 'All' && !($(this).prop('checked')))
                    count++;
            });

            //If all are checked, check the all box, else do not check it
            $('#show-all').prop('checked', count === 0);
        }
        //If this is the check all button
        else {
            //If this is checked, check all
            if($(this).prop('checked'))
                $('.filter').prop('checked', true);
            //If this is unchecked, uncheck all
            else
                $('.filter').prop('checked', false);
        }

        search();
    });

    //Hide all products then show relevant results
    var search = function(e) {
        if(e !== undefined) e.preventDefault();

        $('.product-card').each( function() {
            $(this).parent().hide();
            if($(this).data('title').toUpperCase().indexOf($('#searchField').val().toUpperCase()) !== -1){
                $(this).parent().show();
            }
        });
    }
});