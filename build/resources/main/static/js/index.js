var main={
    init : function(){
        var _this = this;
        $('#login').on('click',function(){_this.login();});
        $('#join').on('click',function(){_this.join();});
        $('#logout').on('click',function(){_this.logout();});
    },
    login : function(){
        var data={
            userId : $('#userId').val(),
            pw : $('#pw').val(),
        };

         $.ajax({
            type:'post',
            url: '/login',
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
        },
        logout : function(){
                     $.ajax({
                        type:'GET',
                        url: '/api/logout',
                        dataType: 'json',
                        contentType:'application/json; charset=utf-8',

                    }).done(function(){
                        alert('로그아웃 완료.');
                        window.location.href ='/';
                    }).fail(function(error){
                        alert('로그아웃 실패');
                    });
                }
}
main.init();