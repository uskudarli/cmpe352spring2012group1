function townUtil(){
$('#city').change(function(event){
    $('.towngif').removeAttr('hidden');
    var $id = $('#city').attr('selected','selected').val();
    $.ajax({
        type: "GET",
        url: "/starting/towns",
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: { id: $id }
    }).success(function( msg ) {
            var arr=msg;
            $('#town').removeAttr('disabled');
            $('#town')
                .find('option')
                .remove();
            $('#district')
                .find('option')
                .remove();
            $('#town').append('<option value='+'-1'+'>'+'Please Choose...'+'</option>');
            for (var i=0;i<arr.length;i++)
            {
                var $townid=arr[i].id;
                var $townname=arr[i].name;
                $('#town').append('<option value='+$townid+'>'+$townname+'</option>');
            }
            $('.towngif').attr('hidden','hidden');
        });
})
}

function submitValidation(){

    $('#createform').submit(function() {
        var $selectedTown = $('#town').find('option:selected').attr('value');
        var $selectedDistrict = $('#district').find('option:selected').attr('value');
        var $selectedCity = $('#city').find('option:selected').attr('value');
        var $time1 = $('input[name="timeinterval1"]').attr('value');
        var $time2 = $('input[name="timeinterval2"]').attr('value');
        var $time3 = $('input[name="timeinterval3"]').attr('value');
        var $time4 = $('input[name="timeinterval4"]').attr('value');
        var $time5 = $('input[name="timeinterval5"]').attr('value');
        var $time6 = $('input[name="timeinterval6"]').attr('value');
        var $time7 = $('input[name="timeinterval7"]').attr('value');
        var $time8 = $('input[name="timeinterval8"]').attr('value');
        var $time9 = $('input[name="timeinterval9"]').attr('value');
        var $time10 = $('input[name="timeinterval10"]').attr('value');
        var $time11 = $('input[name="timeinterval11"]').attr('value');
        var $time12 = $('input[name="timeinterval12"]').attr('value');
        var $time13 = $('input[name="timeinterval13"]').attr('value');
        var $time14 = $('input[name="timeinterval14"]').attr('value');

        if($('.myTag').find('span').text()==""){
            alert("Please insert tag");
            return false;
        }

        if($selectedCity=="-1" || $selectedCity==undefined){
            alert("please select city!");
            return false;
        }

        if($selectedTown=="-1" || $selectedTown==undefined){
            alert("please select town!");
            return false;
        }

        if($selectedDistrict=="-1" || $selectedDistrict==undefined){
            alert("please select district!");
            return false;
        }

        if((Date.parse("1-1-2000 " + $time1) > Date.parse("1-1-2000 " + $time2))){
            alert("Begin time can not be bigger than end time");
            return false;
       }
        if(Date.parse("1-1-2000 " + $time3) > Date.parse("1-1-2000 " + $time4)){
            alert("Begin time can not be bigger than end time");
            return false;
        }
         if(Date.parse("1-1-2000 " + $time5) > Date.parse("1-1-2000 " + $time6)){
            alert("Begin time can not be bigger than end time");
            return false;
        }
         if(Date.parse("1-1-2000 " + $time7) > Date.parse("1-1-2000 " + $time8)){
            alert("Begin time can not be bigger than end time");
            return false;
        }
         if(Date.parse("1-1-2000 " + $time9) > Date.parse("1-1-2000 " + $time10)){
            alert("Begin time can not be bigger than end time");
            return false;
        }
         if(Date.parse("1-1-2000 " + $time11) > Date.parse("1-1-2000 " + $time12)){
            alert("Begin time can not be bigger than end time");
            return false;
        }
         if(Date.parse("1-1-2000 " + $time13) > Date.parse("1-1-2000 " + $time14)){
            alert("Begin time can not be bigger than end time");
            return false;
        }

        return true;

    });

}

function districtUtil(){
$('#town').change(function(event){
    $('.districtgif').removeAttr('hidden');
    var $id = $('#town').attr('selected','selected').val();
    $.ajax({
        type: "GET",
        url: "/starting/districts",
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: { id: $id }
    }).success(function( msg ) {
            var arr=msg;
            $('#district').removeAttr('disabled');
            $('#district')
                .find('option')
                .remove()
            $('#district').append('<option value='+'-1'+'>'+'Please Choose...'+'</option>');
            for (var i=0;i<arr.length;i++)
            {
                var $districtid=arr[i].id;
                var $districtname=arr[i].name;
                $('#district').append('<option value='+$districtid+'>'+$districtname+'</option>');
            }
            $('.districtgif').attr('hidden','hidden');
        });
})
}

function ajaxSubmit(data, resSel, context) {
    function isProcessable() {
        return data.contentType && data.contentType.indexOf("multipart/form-data") == -1;
    }
    // todo 2nd parameter
    context.trigger("beforeAjaxSubmit");

    $.ajax({
        url:data.url,
        type:data.type,
        data:data.data,
        cache:false,
        contentType:data.contentType ? false : 'application/x-www-form-urlencoded',
        processData:isProcessable(),
        success:function (html, textStatus, jqXHR) {
            if(textStatus === 'success') {

                var $closest = $(context).closest(resSel);
                if(!$closest.length) {
                    $closest = $(resSel);
                }
                if(jqXHR.getResponseHeader("content-type") && jqXHR.getResponseHeader("content-type").indexOf("application/json") > -1) {
                    html = JSON.stringify(html) /*new Date().getSeconds()*/;
                }
                $closest.trigger("beforeAjaxSubmitReplace");

                var target = context.attr('data-target-insert');
                if(!target || target == 'replace') {
                    $closest.html(html);
                }
                else if(target == 'replaceWith') {
                    $closest.replaceWith(html);
                }
                else if(target == 'before') {
                    $closest.before(html);
                }
                else if(target == 'after') {
                    $closest.after(html);
                }
                else if(target == 'prepend') {
                    $closest.prepend(html);
                }
                else if(target == 'append') {
                    $closest.append(html);
                }
                $closest.trigger("afterAjaxSubmitReplace");
            }
        }
    });

    context.trigger("afterAjaxSubmit");
}



function bindAjaxForm() {
    $(document).on("submit", "form", function (event) {
        var $this = $(this);

            if($this.is("[data-response-target-sel]") || $this.is("[data-response-desc-target-sel]")) {
                ajaxSubmit({
                        url:$this.attr('action'),
                        type:$this.attr('method'),
                        data:( $this.attr('enctype') === 'multipart/form-data') ? new FormData($this[0]) : $this.serialize(),
                        contentType:$this.attr('enctype')
                    }, $this.attr("data-response-target-sel") || $this.attr("data-response-desc-target-sel")
                    , $this);
                return false;
            }
         else {
            return false;
        }
    })
}

function bindAnchorForFormSubmit() {
    $(document).on("click", "a", function (event) {
        var $this = $(this);
            if($this.is("[data-response-target-sel]")) {
                ajaxSubmit({
                        url:$this.attr("href"),
                        type:"GET",
                        data:{}
                    }, $this.attr("data-response-target-sel")
                    , $this);
                return false;
            }

            return true;

    });
}