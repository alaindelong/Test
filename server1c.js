"use strict"
var http = require('http');
var url = require('url');
var querystring = require('querystring');

var server = http.createServer(function(request,response){
	var params = querystring.parse(url.parse(request.url).query); //parse method uses unescape method
	response.writeHead(200,{"content-type":"text/html"});
	
	if('hello' in params){
		response.write("<html><head><meta charset='utf-8'/></head><body>");    
		response.write("<p>Bonjour "+params['hello']+"</p>");
		response.write("</body></html>");
	}
	else{
		response.write("vous devez entrer un nom\n");
	}
	response.end("");
});
server.listen(8080);
console.log("server running on port 8080");

/***************************************************
l'injection du code html est verifiée, si on entre dans le formulaire <b>alain</b> le serveur répond tel qu'elle et

le navigateur affiche le nom en gras.

le code javascript injecté dans la requete n'a pas été exécuté, car Chrome s'est aperçu que le code à exécuter dans 

la réponse était présent dans la requête. c'est une mésure de sécurité pour contrer les attaques de type XSS implémetée

par Chrome. 
***************************************************/