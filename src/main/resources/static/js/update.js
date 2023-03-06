// (1) 회원정보 수정
function update(userId, event) {
	event.preventDefault(); // 폼태그 액션을 막기!!
	let data = $("#profileUpdate").serialize(); // form 태그가 가지고 있는 input 값들
	// FormData: 파일 업로드를 포함한 다양한 데이터 타입을 전송할 수 있습니다.
	// serialize: 파일 업로드를 지원하지 않으며, 문자열 데이터만 전송할 수 있습니다.
	console.log(data);
	
	$.ajax({
		type: "put",
		url: `/api/user/${userId}`,
		data: data,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "json"
	}).done(res=>{ // HttpStatus 상태코드 200번대
		console.log("성공", res);	
		location.href = `/user/${userId}`
	}).fail(error =>{// HttpStatus 상태코드 200번대가 아닐 때
		if(error.data == null){
			alert(JSON.stringify(error.responseJSON.message));
		}else{
			alert(JSON.stringify(error.responseJSON.data));
		}
		
	});
	
}