<!DOCTYPE>
<html>
<head>
<title>STUDENT MANAGER</title>
<!-- Include one of jTable styles. -->
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#StudentTableContainer').jtable({
			title : 'Students List',
			actions : {
				listAction : 'Controller?action=list',
				createAction : 'Controller?action=create',
				updateAction : 'Controller?action=update',
				deleteAction : 'Controller?action=delete'
			},
			fields : {
				studentId : {
					title : 'Student Id',
					width : '30%',
					key : true,
					list : true,
					edit : false,
					create : true
				},
				name : {
					title : 'Name',
					width : '30%',
					edit : true
				},
				department : {
					title : 'Department',
					width : '30%',
					edit : true
				},
				emailId : {
					title : 'Email',
					width : '20%',
					edit : true
				},
				status : {
					title : 'Status',
					width : '20%',
					edit : true
				},
				username : {
					title : 'Username',
					width : '20%',
					edit : true
				},
				password : {
					title : 'Password',
					width : '20%',
					edit : false
				}
			}
		});
		$('#StudentTableContainer').jtable('load');
	});
</script>

</head>
<body>
<div style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">

		<h4>My student system</h4>
		<div id="StudentTableContainer"></div>
	</div>
	
	<a href="marks.jsp">View Marks</a>
</body>
</html>