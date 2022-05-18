document.addEventListener('DOMContentLoaded', () => {
    document.querySelector(".tag-links").addEventListener("click", e => {
        if (e.target.className === 'tag-buttons') {
            sendTag(e.target.value);
        }
    });


        $('#send_article').click(function() {
        $.ajax({
            url:      "/articles",
            type:     "POST",
            dataType: "html",
            data: $("#send_article_textarea").serialize(),
            success: function (articleJson) {
                success();
                var article = $.parseJSON(articleJson);
                console.log(article);
            }
        });
    });

        function success() {
        $('#send_post_textarea').val('');
    }

    
})