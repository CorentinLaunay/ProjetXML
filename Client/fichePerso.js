function $_GET(param) {
	var vars = {};
	window.location.href.replace( location.hash, '' ).replace( 
		/[?&]+([^=&]+)=?([^&]*)?/gi, // regexp
		function( m, key, value ) { // callback
			vars[key] = value !== undefined ? value : '';
		}
	);

	if ( param ) {
		return vars[param] ? vars[param] : null;	
	}
	return vars;
}

var identifiant;

//var $_GET = $_GET();

//http://mondomaine.tld/?name=geoffrey&age=42

$( document ).ready(function() {
    identifiant = $_GET('id');
    console.log(identifiant);
    var date = new Date();
    var annee = date.getFullYear();
    var mois = ('0'+date.getMonth()+1).slice(-2);
    var jour = ('0'+date.getDate()).slice(-2);
    var dateNow = annee+"-"+mois+"-"+jour;
    console.log(dateNow);
    // doit apres avoir regarder que id de la personne est la bonne, le nom, prenom, nombre de publication, équipe dont il fait partie et s'il fait partie d'une équipe actuellement et liste des équipes dont il a fait partie
});