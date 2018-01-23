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
$( document ).ready(function() {
    identifiant = $_GET('id');
    var nom, prenom, lib, siidEq, dateC, dateF;
    $.get( "http://localhost:8082/api/centres/personne/"+identifiant, function( data ) {
        $( ".result" ).html( data );
        $.each(data,function(i, pers ) {
            lib = pers.libellefr;
            siidEq = pers.siid;
            dateC = pers.dateCreation;
            dateF = pers.dateFermeture;
            domaine = pers.domaine[0].value;
            theme = pers.theme[0].value;
            ajouterLibP(pers.entite[0].personne.nom + " " + pers.entite[0].personne.prenom);
            ajouterEquipe(lib, domaine, theme, dateC, dateF, siidEq)
        });
    }); 
});

function ajouterLibP(lib){
    var stringHTML = lib;
    $('#LibP').html(stringHTML);
}

function ajouterEquipe(lib, dom, th, dateC, dateF, siidEq){
    var lien = "http://localhost:8000/ficheEquipe.html?idEq="+siidEq+"&lang=";
    var stringHTML = "<h5 style=\"text-align: center; padding-top: 10px\" id=\"nomEq\">Equipe : " + lib + "</h5><br>";
    $('#infoEquipe').append(stringHTML);
    var stringLienExt = "<div class=\"container-fluid\" >";
    stringLienExt +="<div class=\"row\" id=\"infoEq\">";
    stringLienExt +="<div class=\"col-4\" id=\"info-eq-1\"> <h6>Domaine :</h6> <p>" + dom + "</p> <h6>Theme : </h6><p>" + th + "</p> " ;     stringLienExt += "</div>"
    stringLienExt += "<div class=\"col-4\" id=\"info-eq-2\"> <h6>Date de création : </h6><p>" + dateC + "</p><h6>Date de fin : </h6><p>" + dateF + "</p>";
    stringLienExt +=  "</div>";
    stringLienExt += "<div class=\"col-4\" id=\"info-eq-3\"> <h6>Lien de l'équipe : </h6>Français : <a style=\"color: white;\" href=\""+lien+"fr\" >"+lien+"fr</a><br>Anglais : <a style=\"color: white;\" href=\""+lien+"en\" >"+lien+"en</a></div></div></div>";
    $('#infoEquipe').append(stringLienExt);
}
