var fileId = ["file1type", "file2type", "file3type", "file4type", "file5type"];
var fileLable = ["file1Lable", "file2Lable", "file3Lable", "file4Lable", "file5Lable"];

for (i=0; i<5; i++) {
    $(document).ready(function (){
        $(fileId[i]).change(function (){
            var fileName = $(this)[0].file[0].name;
            var fileType = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
            if(!(fileType=='jpg'||fileType=='png'||fileType=='jpeg'
                ||fileType=='bmp'||fileType=='gif')){
                alert('확장자가 png, jpeg, bmp, gif 인 이미지 파일만 선택가느합니다.');
                $(fileId[i]).val('');
                document.getElementById(fileLable[i]).innerText = '업로드할 이미지 파일을 선택하세요!';
            } else {
            document.getElementById(fileLable[i]).innerText = file1name;
            }
        })
    })
}