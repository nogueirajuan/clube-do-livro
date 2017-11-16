var moduloDOM = (function () {
    var _textHTML = '<li class="clearfix" data-id="#id#" data-sender="#sender#"><div class="message-data"><span class="message-data-name"> <i class="fa fa-circle #person#"></i>#sender#</span></div><div class="message #person#-message">#text#</div></li>';

    // var messageList = document.querySelector('#chat-ul');
    function createTextHTML(id, text, sender, username) {
        console.log('id: ' + id);
        console.log('text: ' + text);
        console.log('sender: ' + sender);
        console.log('username: ' + username);
        var newText = _textHTML;
        if (sender === username) {
            //me-message
            newText = '<li class="clearfix" data-id="#id#" data-sender="#sender#"><div class="message-data align-right"><span class="message-data-name">#sender# </span> <i class="fa fa-circle #person#"></i></div><div class="message #person#-message float-right">#text#</div></li>';
        } else {
            //you-message
            newText = '<li class="clearfix" data-id="#id#" data-sender="#sender#"><div class="message-data"><span class="message-data-name"><i class="fa fa-circle #person#"></i> #sender#</span></div><div class="message #person#-message">#text#</div></li>';
        }
        newText = newText.replace(/#id#/g, id).replace(/#sender#/g, sender).replace(/#text#/g, text).replace(/#person#/g, sender === username ? 'me' : 'you');
        return newText;
    }

    function insertNewMessage(id, text, sender, username) {
        document.querySelector('#chat-ul').innerHTML += createTextHTML(id, text, sender, username);
        $('#scrolldiv').scrollTop($('#scrolldiv')[0].scrollHeight);
        $('#inputMensagem').val("");
    }

    return {
        insertNewMessage: insertNewMessage
    }

})();

var moduloAjax = (function () {
    var endpoint = 'http://localhost:9999';
    var urlEnviarMensagem = '/enviar-mensagem';
    var urlGetMensagens = '/get-mensagens?sender=nicolas&receiver=juan';

    function getMensagens(callback) {
        $.get(endpoint + urlGetMensagens, callback);
    }

    function salvarMensagem(sender, receiver, textoMsg) {
        var data = {sender: sender, receiver: receiver, content: textoMsg};
        // $.post(endpoint + urlEnviarMensagem, data, function (response) {
        //     console.log(sucesso);
        // })

        $.ajax ({
            url: endpoint + urlEnviarMensagem,
            type: "POST",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            success: function(){
                console.log('FOI, PORRA!');
            }
        });
    }

    return {
        getMensagens: getMensagens,
        salvarMensagem: salvarMensagem
    }

})();

var moduloApp = (function () {
    var username = 'nicolas';

    function verifyNewMessages(mensagens) {
        for (mensagem in mensagens) {
            if (!document.querySelector('[data-id="' + mensagens[mensagem].id + '"]')) {
                moduloDOM.insertNewMessage(mensagens[mensagem].id, mensagens[mensagem].content, mensagens[mensagem].sender, username)
            }
        }
    }

    var ajaxInterval = window.setInterval(function () {
        moduloAjax.getMensagens(verifyNewMessages)
    }, 500);

    var sender = document.querySelector('#sender').value;
    var receiver = document.querySelector('#receiver').value;
    document.querySelector('#btnEnviarMensagem').onclick = function () {
        var textoMsg = document.querySelector('#inputMensagem').value;
        console.log(sender + ', ' + receiver + ', ' + textoMsg);
        moduloAjax.salvarMensagem(sender, receiver, textoMsg);
    };
})();