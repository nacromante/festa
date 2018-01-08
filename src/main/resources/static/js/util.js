$(document).ready( function() {
	 $(".input-cpf").mask("999.999.999-99",{placeholder:"###.###.###-##"});
	 $(".input-data").mask("99/99/9999",{placeholder:"dd/mm/yyyy"});
	 $("#ipt-cep").mask("99999-999",{placeholder:"#####-###"});
	 
	 
	setTimeout(function() {
		$('.alert-success').fadeOut('fast');
	}, 5000);
	
	$('.anterior').click(function (){
		$('#form-cliente').attr('action',"/cliente/cadastro/anterior");
	});
	
	$('#ipt-cep').blur(function(){
		$("#ipt-cep").parent().removeClass("has-error");
		$(".form-group p").empty();
		var cep = $(this).val().replace("-","");
		if(cep != ""){
			$.getJSON("https://viacep.com.br/ws/"+ cep + "/json/?callback?", function(dados){
				if(!("erro" in dados)){
					$("#ipt-rua").val(dados.logradouro);
                    $("#ipt-bairro").val(dados.bairro);
                    $("#ipt-complemento").val(dados.complemento);
                    $("#ipt-cidade").val(dados.localidade);
                    $("#ipt-estado").val(dados.uf);
				}else{
					aplicaErro();
					limpaCampos();
				}
			})
		}
		
	});
	 
});

function aplicaErro(){
	$("#ipt-cep").parent().removeClass("has-error");
	$("#ipt-cep").parent().addClass("has-error");
	$(".form-group p").empty();
	$("#ipt-cep").parent().append("<p style='color:#a94442;'>CEP não encontrado</p>")
}

function limpaCampos(){
	$("#ipt-rua").val("");
	$("#ipt-numero").val("");
    $("#ipt-bairro").val("");
    $("#ipt-complemento").val("");
    $("#ipt-cidade").val("");
    $("#ipt-estado").val("");
}


