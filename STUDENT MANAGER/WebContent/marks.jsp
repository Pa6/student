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
			title : 'Marks List',
			actions : {
				listAction : 'marksController?action=list',
				createAction : 'marksController?action=create',
				updateAction : 'marksController?action=update',
				deleteAction : 'marksController?action=delete'
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
				chemistry : {
					title : 'Chemistry',
					width : '30%',
					edit : true
				},
				physics : {
					title : 'Physics',
					width : '30%',
					edit : true
				},
				math : {
					title : 'Math',
					width : '30%',
					edit : true
				},
				french : {
					title : 'French',
					width : '30%',
					edit : true
				},
				english : {
					title : 'English',
					width : '30%',
					edit : true
				}
			}
		});
		$('#StudentTableContainer').jtable('load');
	});
</script>

</head>
<body>
<div style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">

		<h4>student Marks</h4>
		<div id="StudentTableContainer"></div>
	</div>
</body>
</html>