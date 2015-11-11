$().ready(function() {
    brFrame.init();
});

var brFrame = {};

brFrame.init = function () {
    createFrame();

    var loading = $("#loading");
    loading.hide();

    function createFrame() {
        var htmlModalStr = '<div id="book-reference-frame">';
        htmlModalStr += '<div id="loading"><p>Loading...</p></div>';
        var frag = document.createDocumentFragment();
        var temp = document.createElement('div');
        temp.innerHTML = htmlModalStr;
        frag.appendChild(temp);
        document.body.insertBefore(frag, document.body.lastChild);
    }
};