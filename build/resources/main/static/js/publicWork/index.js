var main={
    init : function(){
        var _this = this;
        $('#create').on('click',function(){_this.create();});

    },
    create : function(){
            var data={
                title : $('#title').val(),
                sub : $('#sub').val()
            };

            var id = $('#userid').val();

             $.ajax({
                type : 'POST',
                url : '/work/create/'+id,
                dataType : 'json',
                contentType :'application/json; charset=utf-8',
                data : JSON.stringify(data)
            }).done(function(){
                alert('문제집이 만들어 졌습니다!');
                window.location.href ='/workbook';
            }).fail(function(error){
                alert('만들기 실패');
            });
        }
}
main.init();