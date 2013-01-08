<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Sign Up</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="/starting/static/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="/starting/static/css/bootstrap-responsive.css" rel="stylesheet">

    <script src="/starting/static/js/jquery-1.7.1.min.js"></script>
    <script src="/starting/static/js/bootstrap.js"></script>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>

      <script type="text/javascript">
          $(document).ready(function(){
              $('#avatarchooser').on('click',function(){
                  var avatarid = $('#avatars').find(':checked').val();
                  $('#useravatar').attr('src','/starting/static/img/'+avatarid+'.jpg');
                  $('#avatarId').attr('value',avatarid);
              })
          })
      </script>


  </head>

  <body>

  <%--<jsp:include page="header.jsp"></jsp:include>--%>

  <div class="hero-unit">
      
    <form class="form-horizontal" method="post" action="/starting/signup" accept-charset="UTF-8">
        <legend>Enter your information below</legend>
        <!-- name -->
        <div class="control-group">
          <label class="control-label" for="Name">Name</label>
          <div class="controls">
            <input type="text" id="Name" required="" name="name" placeholder="Name">
          </div>
        </div>
        <!-- surname -->
        <div class="control-group">
          <label class="control-label" for="Surname">Surname</label>
          <div class="controls">
            <input type="text" id="Surname" required="" name="surname" placeholder="Surname">
          </div>
        </div>
        <!-- email -->
        <div class="control-group">
          <label class="control-label" for="Email">E-mail</label>
          <div class="controls">
            <input type="email" id="Email" required="" name="email" placeholder="E-mail">
          </div>
        </div>
        <!-- password -->
        <div class="control-group">
          <label class="control-label" for="inputPassword">Password</label>
          <div class="controls">
            <input type="password" id="inputPassword" required="" name="password" placeholder="Password">
          </div>
        </div>
        <!-- password again -->
        <%--<div class="control-group">
          <div class="controls">
            <input type="password" id="inputPassword2" required="" name="password2" placeholder="Enter password again">
          </div>
        </div>
--%>
        <!-- Button to trigger modal -->
        <div class="control-group">
            <div class="controls">
                <img src="/starting/static/img/01.jpg" id="useravatar" class="img-rounded" width="70" height="70"/>
                <input type="hidden" id="avatarId" name="avatarId" value="01"/>
                <a href="#myModal" role="button" class="btn btn-link" data-toggle="modal">Choose...</a>
            </div>
        </div>
        <%--<div class="control-group">
            <div class="controls">
                <label class="checkbox">
                    <input type="checkbox"/> I agree to the <a href="">Terms & Conditions</a>
                </label>
                <br>
            </div>
        </div>--%>
                <button type="submit" class="btn btn-primary">Sign up</button>
    </form>

      <!-- Modal -->
        <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
                <h4 id="myModalLabel">Choose an avatar</h4>
            </div>
            <div class="modal-body" align="center">
                 <div id="avatars">
                    <input type="radio" name="radio" id="radio01" value="01" /><img src="/starting/static/img/01.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <input type="radio" name="radio" id="radio02" value="02" /><img src="/starting/static/img/02.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <input type="radio" name="radio" id="radio03" value="03" /><img src="/starting/static/img/03.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <input type="radio" name="radio" id="radio04" value="04" /><img src="/starting/static/img/04.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <input type="radio" name="radio" id="radio05" value="05" /><img src="/starting/static/img/05.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <br><br>
                    <input type="radio" name="radio" id="radio06" value="06" /><img src="/starting/static/img/06.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <input type="radio" name="radio" id="radio07" value="07" /><img src="/starting/static/img/07.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <input type="radio" name="radio" id="radio08" value="08" /><img src="/starting/static/img/08.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <input type="radio" name="radio" id="radio09" value="09" /><img src="/starting/static/img/09.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <input type="radio" name="radio" id="radio10" value="10" /><img src="/starting/static/img/10.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <br><br>
                    <input type="radio" name="radio" id="radio11" value="11" /><img src="/starting/static/img/11.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <input type="radio" name="radio" id="radio12" value="12" /><img src="/starting/static/img/12.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <input type="radio" name="radio" id="radio13" value="13" /><img src="/starting/static/img/13.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <input type="radio" name="radio" id="radio14" value="14" /><img src="/starting/static/img/14.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <input type="radio" name="radio" id="radio15" value="15" /><img src="/starting/static/img/15.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <br><br>
                    <input type="radio" name="radio" id="radio16" value="16" /><img src="/starting/static/img/16.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <input type="radio" name="radio" id="radio17" value="17" /><img src="/starting/static/img/17.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <input type="radio" name="radio" id="radio18" value="18" /><img src="/starting/static/img/18.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <input type="radio" name="radio" id="radio19" value="19" /><img src="/starting/static/img/19.jpg" class="img-rounded" alt="" width="70" height="70"/>
                    <input type="radio" name="radio" id="radio20" value="20" /><img src="/starting/static/img/20.jpg" class="img-rounded" alt="" width="70" height="70"/>
                 </div>
            </div>
            <div class="modal-footer"> 
                <a class="btn btn-primary" id="avatarchooser" data-dismiss="modal">OK</a>
                <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
            </div>           

        </div>
</div>

  
  </body>
</html>
