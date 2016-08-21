$(document).ready(function(){
   console.log('doc is ready');

    var user = {
        id: $(".user-name").data("user-id")
    };

    $('.wall-post-update-unpushed').click(function(){
        $(this).parent().parent().find('.wall-post-body').prop('contenteditable', true);
        $(this).css('pointer-events','none');
        $(this).parent().parent().find('.wall-post-body').css('background-color','#fff');
        $(this).parent().parent().append('<a class="send-update" href="#">SendUpdate</a>');
        var post = $('.wall-post-update').parent().parent().find('.wall-post-body').html();
        var postId = $(this).parent().parent().data("post-id");

        console.log(post);
        console.log(postId);


    });

    function updatePost(post, postId) {
        $.ajax({
            url: "/restapi/posts/",
            data: {
                userId: user.id,
                post: post,
                postId: postId,
            },
            type: "GET",
            dataType: "json",
            success: function (updated) {
                console.log(data);
                console.log("success");
            }
        });
    }
});
