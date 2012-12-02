<%The user will be able to edit its login info through this page %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Edit Profile Page</title>
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

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="welcome.html">Soda</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li><a href="profile.html">Profile</a></li>
              <li><a href="search.html">Search for Services</a></li>
              <li><a href="service creation.htm">Offer/Request Services</a></li>
              <li><a href="help.html">Help</a></li>
			  <li><a href="help.html">Administration</a></li>
              <li class="active"><a href="admin page.html">EditProfile</a></li>  
            </ul>
            </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>  

<div class="hero-unit">

<form>
  <fieldset>
    <legend>Edit Login Info</legend>
    <label>New e-Mail</label>
    <input type="text" placeholder="Type something…">
 	<label>New Password</label>
    <input type="text" placeholder="Type something…">
    <label class="checkbox">
      <input type="checkbox"> Change eMail
    </label>
<label class="checkbox">
      <input type="checkbox"> Change password
    </label>
    <button type="submit" class="btn btn-primary">Submit</button>
  </fieldset>
</form>
</div>


      

    </div> <!-- /container -->

  </body>
</html>
