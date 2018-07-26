function validazione(){
	
	var nome = document.getElementById('nome').value;
	var cognome = document.getElementById('cognome').value;
	var username = document.getElementById('username').value;
	var password = document.getElementById('password').value;
	var indirizzo = document.getElementById('indirizzo').value;

	console.log(nome + "-" + cognome + "-" + username + "-" + password + "-" + indirizzo);
	if (nome != '' & cognome != '' & username != '' & password != '' & indirizzo != '') {
		return true;
	} else {
		document.getElementById('alert').style.display = 'block';
		
		return false;
	}

}
function validazioneLogin(){
	

	var username = document.getElementById('username').value;
	var password = document.getElementById('password').value;
	console.log(nome + "-" + username + "-" + password);
	if  (username != '' & password != '') {
		return true;
		
	} else {
		document.getElementById('alert').style.display = 'block';
		
		return false;
	}
}
	
	function mostraPassword(){

		
		var password = document.getElementById("password");
		console.log("abc")
		if  (password.type == "password") {
			
			password.type = "text";
			
		  } else {
		        password.type = "password";
		    }
			
		}
	$("#zoom_01").elevateZoom();
	
	
	
	function progressBar() {
	
		    var elem = document.getElementById("myBar"); 
		    var width = 1;
		    var id = setInterval(frame, 10);
		    function frame() {
		        if (width >= 100) {
		            clearInterval(id);
		        } else {
		            width++; 
		            elem.style.width = width + '%'; 
		        }
		    }
		}
	
	function controlloDisponibilita(){
		var quantitaDesiderata = document.getElementById("quantita").value;
		var quantitaDisponibile = document.getElementById("quantitaDisponibile").value;
		console.log('quantita');
		console.log('quantitaDisponibile');
		if(quantitaDesiderata <= quantitaDisponibile){
			
			return true;
	
		}else{

		document.getElementById('alert').style.display = 'block';

		return false;
		}
	}

		
	


