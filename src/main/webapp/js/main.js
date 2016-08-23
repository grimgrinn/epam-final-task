var user = NaN;

$(document).ready(function(){
   console.log('doc is ready');

    user = {
        id: $(".user-name").data("user-id")
    };

    $('.wall-post-delete ').click(function(){
        var postId = $(this).parent().parent().data("post-id");
        console.log("post ot del -> " + postId);

        postDel(postId);
        return false;
    });

    $('.wall-post-update-unpushed').click(function(){
        $(this).parent().parent().find('.wall-post-body').prop('contenteditable', true);
        $(this).css('pointer-events','none');
        $(this).parent().parent().find('.wall-post-body').css('background-color','#fff');
        $(this).parent().parent().find('.send-update').css('display','block');

        return false;
    });

    $('.send-update').on('click', function(){
        var post = $(this).parent().find('.wall-post-body').html().trim();


        var postId = $(this).parent().data("post-id");
        console.log(post);
        console.log(postId);
        updatePost(post, postId);
        return false;
    });


});

function updatePost(post, postId) {
    var myDiv = $('.wall-post[data-post-id='+postId+']');
    var data = {
        userId: user.id,
        post: post,
    };
    console.log(data);
    $.ajax({
        url: "/restapi/posts/update/" + postId,
        data: data,
        type: "PUT",
        headers: {'Content-type': 'application/x-www-form-urlencoded'},
        success: function (updated) {
            myDiv.find('.wall-post-body').prop('contenteditable', false);
            myDiv.find('.wall-post-body').css('background', 'inherit');
            myDiv.find('.send-update').css('display','none');
            myDiv.find('.wall-post-update-unpushed').css('pointer-events','');
            console.log("success");
            console.log(updated);
        }
    });
}

function postDel(id){
    var divToDel = $('.wall-post[data-post-id='+id+']');
    $.ajax({
        url: "/restapi/posts/delete/"+id,
        type: "DELETE",
        success: function(deleted){
                // $(divToDel).detach();
                divToDel.detach();
                console.log("success del div ->" + divToDel);

        }
    });
}