$(function(){
    $('#show-filters').popover({
        html : true,
        content: function() {
            return $('#filters').html();
        }
    });
});