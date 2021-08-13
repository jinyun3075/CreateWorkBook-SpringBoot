var main={
    init : function(){
        var _this = this;
        $('#create').on('click',function(){_this.create();});
        $('#createWork').on('click',function(){_this.createWork();});
        $('#next').on('click',function(){_this.next();});
        $('#pre').on('click',function(){_this.resolving();});
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
            }).done(function(id){
                alert('문제가 만들어졌습니다.');
                window.location.href ='/workbook/view/'+id;
            }).fail(function(error){
                alert('칸을 다 채워주세요');
            });

    },
    next : function(){
                    var data={
                        location : $('#location').val(),
                        val : $("input[name ='val_C']:checked").val(),
                        valCheck : $('#val').val(),
                        next : 1,
                    };

                    var book = $('#bookId').val();

                     $.ajax({
                        type : 'POST',
                        url : '/work/solving/view/next/'+book,
                        dataType : 'json',
                        contentType :'application/json; charset=utf-8',
                        data : JSON.stringify(data)
                    }).done(function(){
                            $('#v').children().remove;
                            $('#v').html($('#so'));
                        }).fail(function(error){
                        alert('실패');
                    });
    }
}
main.init();