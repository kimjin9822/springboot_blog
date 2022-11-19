let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
	},

	save: function() {
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		console.log(data);
		$.ajax().done().fail(); //ajax 사용 이유 : 요청에 대한 응답을 data(json)를 받기 위함 (html X) , 비동기통신
	}
}
index.init();