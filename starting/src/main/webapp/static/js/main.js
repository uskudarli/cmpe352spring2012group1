function townUtil(){
$('#city').change(function(event){
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
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: { id: $id }
    }).success(function( msg ) {
            var arr=msg;
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