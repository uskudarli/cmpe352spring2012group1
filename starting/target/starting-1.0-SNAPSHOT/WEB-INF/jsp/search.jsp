
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Soda Profile</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="brand" href="#">Soda</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li><a href="home.html">Home</a></li>
              <li class="active"><a href="profile.jsp">Profile</a></li>
              <li><a href="search.jsp">Search for Services</a></li>
              <li><a href="offer.jsp">Offer Services</a></li>
              <li><a href="help.html">Help</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">
      <form class="navbar-search">
        <div class="row">
          <div class="span12" align="center">
          <select name="city">
            <option value="34">Istanbul</option>
            <option value="35">Izmir</option>
            <option value="06">Ankara</option>
          </select>
          <select name="town">
            <option value="34">Istanbul</option>
            <option value="35">Izmir</option>
            <option value="06">Ankara</option>
          </select>
          <select name="district">
            <option value="34">Istanbul</option>
            <option value="35">Izmir</option>
            <option value="06">Ankara</option>
          </select>
        </div>
        </div>
        <br>
        <div class="row">
        <div class="span12" align="center">
        <button type="submit" class="btn">I'm Feeling Lucky</button>
        <br>
        <br>
        <input type="text " placeholder="Search">
        <br>
        <br>
        <button type="submit" class="btn">Search</button>
        </div>
        </div>
      </form>
      
      <br>
      <hr class="bs-docs-separator"></hr>
      <footer>
        <p>&copy; Cmpe451 Group1 Fall2012</p>
      </footer>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap-transition.js"></script>
    <script src="assets/js/bootstrap-alert.js"></script>
    <script src="assets/js/bootstrap-modal.js"></script>
    <script src="assets/js/bootstrap-dropdown.js"></script>
    <script src="assets/js/bootstrap-scrollspy.js"></script>
    <script src="assets/js/bootstrap-tab.js"></script>
    <script src="assets/js/bootstrap-tooltip.js"></script>
    <script src="assets/js/bootstrap-popover.js"></script>
    <script src="assets/js/bootstrap-button.js"></script>
    <script src="assets/js/bootstrap-collapse.js"></script>
    <script src="assets/js/bootstrap-carousel.js"></script>
    <script src="assets/js/bootstrap-typeahead.js"></script>

  </body>
</html>
