var main={
    init : function(){
        var _this = this;
        $('#create').on('click',function(){_this.create();});

    },
    create : function(){
            var data={
                title : $('#title').val(),
                sub : $('#sub').val(),
                userid:$('#userid').val()
            };

             $.ajax({
                type:'POST',
                url: '/work/create',
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data : JSON.stringify(data)
            }).done(function(){
                alert('문제집이 만들어 졌습니다!');
                window.location.href ='/workbook';
            }).fail(function(error){
                alert('만들기 실패');
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