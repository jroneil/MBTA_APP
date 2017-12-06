<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script> 
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
 <script type="text/javascript" charset="utf8" src="/js/stop.js" ></script>
<title>Get Stops</title>
</head>
<body>

<div class="jumbotron">
  <div id="search"  class="container">
  <div class="row">
    <div class="col-md-12">
      <h3>Enter Location</h3>
    </div>
    </div>
    <div class="row">
      <div class="col-md-4">
        <label>Latitude
          <input type="text" class="form-control " id="lat" placeHolder="Enter Latitude" >
        </label>
        </div>
        <div class="col-md-4">
        <label>Longitude
          <input type="text" class="form-control " id="lon" placeHolder="Enter Longitude">
        </label>
        </div>
        <div class="col-md-4">
        <label>No Of Stops
          <input type="text" class="form-control " id="stop" placeHolder="Enter Stops">
        </label>
        </div>
        </div>
        <div class="row">
         <div class="col-md-4">
         <button id="search-btn" class="btn btn-primary">Search</button>
         </div>
         </div>
         <div class="row"  style="margin-top:10px">
         <div class="col-md-12">
           <table id="StopsTbl" class="stripe">
		
            </table>
            </div>
            </div>
        </div>
        </div>
       
       

</body>
</html>