function validazione(){
	
	var nome = document.getElementById('nome').value;
	var username = document.getElementById('username').value;
	var password = document.getElementById('password').value;
	console.log(nome + "-" + username + "-" + password);
	if (nome != '' & username != '' & password != '') {
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

