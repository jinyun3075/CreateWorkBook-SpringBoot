var main={
    init : function(){
        var _this = this;
        $('#login').on('click',function(){_this.login();});
        $('#join').on('click',function(){_this.join();});
    },
    login : function(){
        var data={
            userId : $('#userId').val(),
            pw : $('#pw').val(),
        };

         $.ajax({
            type:'GET',
            url: '/api/login',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('로그인 되었습니다.');
            window.location.href ='/';
        }).fail(function(error){
            alert('로그인 실패');
        });
    },
    join : function(){
            var data={
                userId: $('#userId').val(),
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