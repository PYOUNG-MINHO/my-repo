<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet"/>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker3.css" rel="stylesheet"/>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>

<div class="container">
    <div class="col-sm-6" style="height:75px;">
       <div class='col-md-5'>
            <div class="form-group">
                <div>Start</div>

                <div class='input-group date' id='startDate'>
                    <input type='text' class="form-control" name="startDate" />
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        <div class='col-md-5'>
            <div class="form-group">
                <div>End</div>

                <div class='input-group date' id='endDate'>
                    <input type='text' class="form-control" name="org_endDate" />
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
jQuery('#startDate').datepicker({
  format: 'mm-dd-yyyy',
  endDate: '0d',
  autoclose: true
}).on("changeDate",function (e) {
  jQuery('#endDate').datepicker("setStartDate", e.date);
});
var d = new Date();
var now = new Date(d.getFullYear(), d.getMonth(), d.getDate());
$('#startDate').datepicker('update', now);

jQuery('#endDate').datepicker({
  format: 'mm-dd-yyyy',
  endDate: '0d',
  autoclose: true
}).on("changeDate",function (e) {
   jQuery('#startDate').datepicker("setEndDate", e.date);
});
$('#endDate').datepicker('update', now+10);

</script>
</body>
</html>