$(function() {
	fetch('./list.do?type=json&page=0')
		.then(function(response) {
			return response.json();
		})
		.then(function(articles) {
			var $ul = $('#list-articles');
			articles.forEach(function(art) {
				$ul.append('<li class="list-group-item">' 
						+ '<h3>' + art.title + '</h3>'
						+ '<p>' + art.content + '</p>'
						+ '<button class="del-btn" data-id="' + art.id + '">删除</button>'
						+ '</li>');
			})
		})
		.then(function() {
			$('ul .del-btn').on('click', function() {
				var $self = $(this);
				var id = $self.data('id');
				fetch('./del.do?ajax=true&id=' + id)
					.then(function(response) {
						return response.json();
					})
					.then(function(res) {
						if(res.ok === 1) {
							$self.parent().remove();
						}
					})
			})
		})
})
 评论 ( 0 )