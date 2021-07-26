var main={
    init : function(){
        var _this = this;
        $('#join').on('click',function(){_this.join();});
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
                window.location.href ='/';
            }).fail(function(error){
                alert('회원가입 실패');
            });
        }
}
main.init();