var main={
    init : function(){
        var _this = this;
        $('#join').on('click',function(){_this.join();});
        $('#update').on('click',function(){_this.update();});
    },
    join : function(){
            var data={
                userid: $('#userid').val(),
                pw: $('#pw').val(),
                name: $('#name').val()
            };
             $.ajax({
                type:'POST',
                url: '/api/join',
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function(){
                alert('회원가입 되었습니다.');
                window.location.href ='/login';
            }).fail(function(error){
                alert('아이디 중복');
            });
        },
      update : function(){
            var data={
                pw : $('#pw').val(),
                name : $('#name').val(),
                pwcheck :$('#pwcheck').val()
            };

            var id= $('#id').val();
            $.ajax({
                type : 'PUT',
                url : '/api/update/'+id,
                dateType : 'json',
                contentType : 'application/json; charset=utf-8',
                data : JSON.stringify(data)
            }).done(function(v){
                if(v==-1){
                    alert('비밀번호가 다릅니다.')
                    window.location.href='/update';
                }else{
                    alert('정보가 수정되었습니다.');
                    window.location.href='/update';
                }
            }).fail(function(error){
                alert('정보수정 실패');
            });
      }
}
main.init();