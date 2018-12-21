function upd() {
	alert("提交");
	$('#ff').form('submit', {
		url : SearchServlet,
		onSubmit : function() {
			alert("asd");
			// do some check
			// return false to prevent submit;
		},
		success : function(data) {
			alert(data)
		}
	});
}