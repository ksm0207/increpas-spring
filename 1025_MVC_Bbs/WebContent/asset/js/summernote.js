$(function(){
	console.log("ready");
	$("#content").summernote({
		height: 200,
		leng: "ko-KR",
		focus: true, /* 커서를 미리 가져다 놓는다. */
		callbacks:{
			onImageUpload: function(files, editor){
				//이미지가 에디터에 추가될 때마다 수행하는 곳!
				//추가되어 들어온 이미지가 배열로 인식됨!
				for(var i=0; i<files.length; i++)
					sendImage(files[i], editor);//서버로 비동기식 통신으로
									//이미지를 서버로 업로드시킨다.
				console.log(files);
			}
		}
	});
	$("#content").summernote("lineHeight",.7);
});

function sendImage(file,editor){
	console.log("sendImage")
	let data = new FormData();
	
	data.append("file",file);
	console.log("data :" + data);
	
	$.ajax({
		url:"saveImage.do",
		data:data,
		dataType:"json",
		type:"post",
		contentType:false,
		processData:false,
		cache:false,
	})
	.done(function(data){
		alert("success"+ data.path + " " + data.fname);
		let path = data.path;
		let fname = data.fname;
		$("#content").summernote("editor.insertImage", path+"/"+fname);
	})
	.fail(function(data){
		
	});
}


function sendData(){
	console.log("sendData");
	
	document.forms[0].submit();
}