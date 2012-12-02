<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Admin Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="/sodaproject/starting/src/main/webapp/static/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="/sodaproject/starting/src/main/webapp/static/css/bootstrap-responsive.css" rel="stylesheet">

    <script src="/sodaproject/starting/src/main/webapp/static/js/jquery-1.7.1.min.js"></script>
    <script src="/sodaproject/starting/src/main/webapp/static/js/bootstrap.js"></script>
    <script>

      $(function(){

        $('.dropdown-toggle').dropdown()
      });
    </script>

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
              <li class="active"><a href="admin page.html">Administration</a></li>  
            </ul>
            </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row-fluid">

        <div class="span3">
          <div class="well sidebar-nav">

            <ul class="nav nav-list">
              <li class="nav-header">Admin Stuff</li>
              <li class="active"><a href="admin page.html">Main Page</a></li>
              <li><a href="#">Complaint Messages</a></li>
              <li><a href="#">Error Logs</a></li>
              <li><a href="#">System Messages</a></li>

            </ul>
          </div><!--/.well -->

          <div class="well sidebar-nav">

            <p><b>Snap statistics</b></p>
            <p>Online users:</p>
            <p>Daily traffic:</p>
            <p>New complaint messages:</p>
            <p>Active services offered:</p>
            <p>Active services requested:</p>

          </div><!--/.well -->
        </div><!--/span-->

        <div class="span9">
          <div class="row-fluid">
            <div class="span5">
              <h2>Most problematic users</h2>
                <table class="table">
                  <thead>
                    <tr>
                      <th>#</th>
                      <th>First Name</th>
                      <th>Last Name</th>
                      <th>Username</th>
                      <th>Abuse</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>Mark</td>
                      <td>Otto</td>
                      <td>@mdo</td>
                      <td>8</td>
                      <td><button class="btn btn-danger" type="button">Freeze Account</button></td>
                    </tr>
                    <tr>
                      <td>2</td>
                      <td>Jacob</td>
                      <td>Thornton</td>
                      <td>@fat</td>
                      <td>5</td>
                      <td><button class="btn btn-danger" type="button">Freeze Account</button></td>
                    </tr>
                    <tr>
                      <td>3</td>
                      <td>Larry</td>
                      <td>the Bird</td>
                      <td>@twitter</td>
                      <td>5</td>
                      <td><button class="btn btn-danger" type="button">Freeze Account</button></td>
                    </tr>
                    <tr>
                      <td>4</td>
                      <td>Larry</td>
                      <td>the Bird</td>
                      <td>@twitter</td>
                      <td>4</td>
                      <td><button class="btn btn-danger" type="button">Freeze Account</button></td>
                    </tr>
                    <tr>
                      <td>5</td>
                      <td>Larry</td>
                      <td>the Bird</td>
                      <td>@twitter</td>
                      <td>3</td>
                      <td><button class="btn btn-danger" type="button">Freeze Account</button></td>
                    </tr>
                  </tbody>
                </table>
            </div><!--/span-->
            <div class="span5">
              <h2>Most dissatisfied users</h2>
                <table class="table">
                  <thead>
                    <tr>
                      <th>#</th>
                      <th>First Name</th>
                      <th>Last Name</th>
                      <th>Username</th>
                      <th>Complaints</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>Mark</td>
                      <td>Otto</td>
                      <td>@mdo</td>
                      <td>10</td>
                      <td><button class="btn btn-warning" type="button">Send Message</button></td>
                    </tr>
                    <tr>
                      <td>2</td>
                      <td>Jacob</td>
                      <td>Thornton</td>
                      <td>@fat</td>
                      <td>9</td>
                      <td><button class="btn btn-warning" type="button">Send Message</button></td>
                    </tr>
                    <tr>
                      <td>3</td>
                      <td>Larry</td>
                      <td>the Bird</td>
                      <td>@twitter</td>
                      <td>7</td>
                      <td><button class="btn btn-warning" type="button">Send Message</button></td>
                    </tr>
                    <tr>
                      <td>4</td>
                      <td>Larry</td>
                      <td>the Bird</td>
                      <td>@twitter</td>
                      <td>5</td>
                      <td><button class="btn btn-warning" type="button">Send Message</button></td>
                    </tr>
                    <tr>
                      <td>5</td>
                      <td>Larry</td>
                      <td>the Bird</td>
                      <td>@twitter</td>
                      <td>3</td>
                      <td><button class="btn btn-warning" type="button">Send Message</button></td>
                    </tr>
                  </tbody>
                </table>
            </div><!--/span-->
          </div><!--/row-->

        </div><!--/span-->
      </div><!--/row--> 
      

      <hr>
      <footer>
        <p>&copy; Cmpe 451 Group Fall 2012</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
