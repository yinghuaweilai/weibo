$(function() {
	var filechooser = document.getElementById('filechooser');
	var previewer = document.getElementById('previewer');
	filechooser.onchange = function() {
		var file = this.files[0];
		var reader = new FileReader();
		reader.onload = function() {
			previewer.src = this.result;
		}
		reader.readAsDataURL(file);
	}
	
	$('#username').on('blur', function() {
		$.post('./check.do', {username: $('#username').val()}, function(data) {
			if(data.ok === 0) {
				$('#username').closest('.form-group')
					.addClass('has-error has-feedback');
				$('#username').parent()
					.append('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>')
			} else {
				$('#username').closest('.form-group')
					.addClass('has-success has-feedback');
				$('#username').parent()
					.append('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
			}
		})
	})
})
