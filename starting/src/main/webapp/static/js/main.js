function townUtil(){
$('#city').change(function(event){
    var $id = $('#city').attr('selected','selected').val();
    $.ajax({
        type: "GET",
        url: "/starting/towns",
        data: { id: $id }
    }).success(function( msg ) {
            var arr=JSON.parse(msg);
            $('#town').removeAttr('disabled');
            $('#town')
                .find('option')
                .remove()
            $('#district')
                .find('option')
                .remove()
            for (var i=0;i<arr.length;i++)
            {
                var $townid=arr[i].id;
                var $townname=arr[i].name;
                $('#town').append('<option value='+$townid+'>'+$townname+'</option>');
            }
        });
})
}

function districtUtil(){
$('#town').change(function(event){
    var $id = $('#town').attr('selected','selected').val();
    $.ajax({
        type: "GET",
        url: "/starting/districts",
        data: { id: $id }
    }).success(function( msg ) {
            var arr=JSON.parse(msg);
            $('#district').removeAttr('disabled');
            $('#district')
                .find('option')
                .remove()
            for (var i=0;i<arr.length;i++)
            {
                var $districtid=arr[i].id;
                var $districtname=arr[i].name;
                $('#district').append('<option value='+$districtid+'>'+$districtname+'</option>');
            }
        });
})
}

