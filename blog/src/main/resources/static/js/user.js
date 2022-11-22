let index = {
	init: function() {
		$("#btn-save").on("click", () => { //function(){} 대신 화살표를 쓴이유 : this를 바인딩 하기 위함
			this.save();
		});
		$("#btn-login").on("click", () => { //function(){} 대신 화살표를 쓴이유 : this를 바인딩 하기 위함
			this.login();
		});
	},

	save: function() {
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		console.log(data);
		//회원가입 수행 요청 -> 실행시 done, 실패시 fail
		$.ajax({ //ajax 사용 이유 : 요청에 대한 응답을 data(json)로 받기 위함 (html X) -> 앱, 웹 서버 동시사용가능  , 비동기통신
			type: "POST",
			url: "/blog/api/user",
			data: JSON.stringify(data), //user.js 9line let data 를 JSON 문자열로 변경하여 호출
			contentType: "application/json; charset=utf-8", //body데이터 타입
			dataType: "json" // 응답시 javascript로 응답
		}).done(function(response){
			alert("회원가입이 완료되었습니다.");
			location.href = "/blog";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
	},
	
	login: function() {
		let data = {
			username: $("#username").val(),
			password: $("#password").val()
		};

		$.ajax({ //ajax 사용 이유 : 요청에 대한 응답을 data(json)로 받기 위함 (html X) -> 앱, 웹 서버 동시사용가능  , 비동기통신
			type: "POST",
			url: "/blog/api/user/login",
			data: JSON.stringify(data), //user.js 9line let data 를 JSON 문자열로 변경하여 호출
			contentType: "application/json; charset=utf-8", //body데이터 타입
			dataType: "json" // 응답시 javascript로 응답
		}).done(function(response){
			alert("로그인이 완료되었습니다.");
			location.href = "/blog";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
	}
}
index.init();