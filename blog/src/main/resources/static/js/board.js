let index = {
	init: function() {
		$("#btn-save").on("click", () => { //function(){} 대신 화살표를 쓴이유 : this를 바인딩 하기 위함
			this.save();
		});
		$("#btn-delete").on("click", () => { 
			this.deleteById();
		});
	},

	save: function() {
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};
		
		$.ajax({ //ajax 사용 이유 : 요청에 대한 응답을 data(json)로 받기 위함 (html X) -> 앱, 웹 서버 동시사용가능  , 비동기통신
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data), //user.js 9line let data 를 JSON 문자열로 변경하여 호출
			contentType: "application/json; charset=utf-8", //body데이터 타입
			dataType: "json" // 응답시 javascript로 응답
		}).done(function(response){
			alert("글쓰기가 완료되었습니다.");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
	},
	
	deleteById: function() {
		let id = $("#id").text();
		
		$.ajax({ 
			type: "DELETE",
			url: "/api/board/"+id,
			dataType: "json" 
		}).done(function(response){
			alert("삭제가 완료되었습니다.");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
	}
}
index.init();