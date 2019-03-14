$(function() {
    //Update filter icon
    $('#show-filters').on('shown.bs.popover', function(){
        $('#filterArrow').removeClass('fa-angle-double-down').addClass('fa-angle-double-up');
    }).on('hidden.bs.popover', function(){
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
    $(document).on('change', '.filter', function(){
        //Update template
        if($(this).prop('checked')) {
            $($(this).data('control')).attr('checked', true);
            $($(this).data('control')).prop('checked', true);
        }
        else {
            $($(this).data('control')).removeAttr('checked');
            $($(this).data('control')).prop('checked', false);
        }

        //If this is not the check all button
        if($(this).data('show') !== 'All') {
            //Count how many items are not checked
            var count = 0;
            $('.filter').each(function () {
                if($(this).data('show') !== 'All' && !($(this).prop('checked')))
                    count++;
            });

            //If none are unchecked, check the all box, else do not check it
            //Also modify the template element
            if(count === 0) {
                $('.popover-body').find('#show-all').attr('checked', true).prop('checked', true);
                $('#show-all').attr('checked', true).prop('checked', true);
            }
            else {
                $('.popover-body').find('#show-all').removeAttr('checked').prop('checked', false);
                $('#show-all').removeAttr('checked').prop('checked', false);
            }
        }
        //If this is the check all button
        else {
            //If this is checked, check all
            if($(this).prop('checked')) {
                $('.filter').attr('checked', true).prop('checked', true);
            }
            //If this is unchecked, uncheck all
            else {
                $('.filter').removeAttr('checked').prop('checked', false);
            }
        }

        search();
    });
});

//Search for products based on term and filters
var search = function(e) {
    if(e !== undefined) e.preventDefault();

    //Loop over all product cards
    $('.product-card').each( function() {
        //Hide all
        $(this).parent().hide();

        //If this card matches the search term and filters
        if($(this).data('title').toUpperCase().indexOf($('#searchField').val().toUpperCase()) !== -1 &&
            fitsFilters($(this))){
            //Show this item
            $(this).parent().show();
        }
    });
};

//Check if the searched item matches filters
var fitsFilters = function(item) {
    //Track if this item fits the filters
    var applies = false;

    //Loop over filters
    $('.popover-body').find('.filter').each(function() {
        //If this filter is selected and matches the category of the item
        if($(this).prop('checked') && ($(this).data('show') === item.data('category'))) {
            applies = true;
        }
    });

    //Return whether this item fits the filters
    return applies;
};