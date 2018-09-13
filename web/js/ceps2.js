//<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"/></script>

$(document).ready(function () {
    $('#cep').keyup(function () {
        txcep = $("#cep").val();
        if (txcep.length >= 8) {
            var cep = txcep.replace(/[^0-9]/, '');
            if (cep) {
                var url = "https://viacep.com.br/ws/" + cep + "/json/?callback=?";
                $.ajax({
                    url: url,
                    dataType: 'jsonp',
                    crossDomain: true,
                    contentType: "application/json",
                    beforeSend: function () {
                        $("#mensagem").html(" Carregando ");
                    },
                    success: function (dados) {
                        $("#mensagem").html("");
                        $("#cep").val(dados.cep);
                        $("#rua").val(dados.logradouro);
                        $("#bairro").val(dados.bairro);
                        $("#cidade").val(dados.localidade);
                        $("#uf").val(dados.uf);
                    },
                    error: function () {
                        //$("#cep").val(txcep);
                        $("#mensagem").html(" Não encontrado! ");
                    }
                });
            } else {
                $("#mensagem").html("");
            }
        }
    });
});

