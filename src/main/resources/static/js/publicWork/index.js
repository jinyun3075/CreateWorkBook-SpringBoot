var main={
    init : function(){
        var _this = this;
        $('#create').on('click',function(){_this.create();});
        $('#createWork').on('click',function(){_this.createWork();});

    },
    create : function(){
            var data={
                title : $('#title').val(),
                sub : $('#sub').val()
            };

            var id = $('#userid').val();

             $.ajax({
                type : 'POST',
                url : '/work/WorkBookCreate/'+id,
                dataType : 'json',
                contentType :'application/json; charset=utf-8',
                data : JSON.stringify(data)
            }).done(function(){
                alert('문제집이 만들어 졌습니다!');
                window.location.href ='/workbook';
            }).fail(function(error){
                alert('만들기 실패');
            });
        },
    createWork : function(){
            var data={
                question : $('#question').val(),
                sel1 : $('#sel1').val(),
                sel2 : $('#sel2').val(),
                sel3 : $('#sel3').val(),
                sel4 : $('#sel4').val(),
                val : $("input[name ='select']:checked").val()
            };
            var bookId = $('#bookid').val();

            $.ajax({
                type : 'POST',
                url : '/work/WorkCreate/'+bookId,
                dataType : 'json',
                contentType :'application/json; charset=utf-8',
                data : JSON.stringify(data)
            }).done(function(){
                alert('문제생성');
                window.location.href ='/workbook';
            }).fail(function(error){
                alert('칸을 다 채워주세요');
            });

    }
}
main.init();