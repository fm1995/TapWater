$(document).ready(
		function() {
			window.getEmps = function() {
				var vi = $("#volume_id").val();
				$.post("/SyProject/RdController/queryRdVolume", {
					"id" : vi
				}, function(t) {
					$("#areaName").val(t.syArea.areaName);
					$("#volumeName").val(t.volumeName);
				});
				$.post("load/selByRdEmp", function(x) {
					var sel = $("#sel");
					sel.empty();
					var total = x.length;
					for (var i = 0; i < total; i++) {
						sel.append("<option value='" + x[i].empId + "'>"
								+ x[i].empName + "</option>");
						var s = $(sel[0].options[i]).val();
						var curEmpId=$("#emp_id").val();
						if (s == curEmpId) {
							sel[0].options[i].selected = true;
						}
					}
				});
			}
			getEmps();

			window.upRdTask = function() {
				var vi = $("#volume_id").val();
				var ei = $("#sel").val();
				$.post("/SyProject/RdController/taskDistribute", {
					"volumeId" : vi,
					"empId" : ei
				}, function(x) {
					$('#facebox_setVolume_message').html(x);
					$.facebox({
						div : '#facebox_setVolume'
					});
				});

			};

			window.setCurrentDate = function() {
				var currentDate = new Date();
				var year = currentDate.getFullYear().toString();
				var month = currentDate.getMonth() + 1;
				if (month < 10)
					month = "0" + month;
				$("#yearMonth").val(year + month);
			}
			setCurrentDate();

		});