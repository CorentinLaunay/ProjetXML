/*var centreLat = 48.854733;
var centreLng = 2.350879;*/

var Equipe;

$( document ).ready(function() {

    var requestURLEquipe = 'bastri.json';
    var requestE = new XMLHttpRequest();
    requestE.open('GET', requestURLEquipe);
    requestE.responseType = 'json';
    requestE.send();
    requestE.onload = function() {
        Equipe = requestE.response;
        Equipe['structureinria'].forEach(function(eq){
            var libfr = eq['libellefr'];
            var sigle = eq['sigle'];
            var dateC = eq['date_creation'];
            var dateF = eq['date_fermeture'];
            var entite = eq['entite'];
            var siid = eq['@siid'];
            var nbP, adr, lat, long;
            var tabNomPre = new Array();
            if (entite.length ){
                entite.forEach(function(ent){
                    if(ent['@principal'] == "1"){
                        adr = ent['adressegeographique']['libelle']+" "+ ent['adressegeographique']['adresse']+" "+ent['adressegeographique']['cp']+" "+ent['adressegeographique']['ville'];
                        lat = ent['adressegeographique']['latitude'];
                        long = ent['adressegeographique']['longitude'];
                    }
                    if(ent['personne'] != null){
                        tabNomPre.push(new Array(ent['personne']['nom'], ent['personne']['prenom']));
                    }
                });

                nbP = entite.length;
            }else{
                adr = entite['adressegeographique']['libelle']+" "+ entite['adressegeographique']['adresse']+" "+entite['adressegeographique']['cp']+" "+entite['adressegeographique']['ville'];
                lat = entite['adressegeographique']['latitude'];
                long = entite['adressegeographique']['longitude'];
                nbP = 1;
                if(entite['personne'] != null){
                    tabNomPre.push(new Array(entite['personne']['nom'], entite['personne']['prenom']));
                }

            }

            //mettre date courante du systeme
            if(dateF < '2018-01-01'){
                ajouterContenuTabE(sigle, dateC, "OUI", nbP, lat, long); 
                ajouterContenuE(libfr, dateC, dateF, adr, siid);
            }
            else{
                ajouterContenuTabE(sigle, dateC, "NON", nbP, lat, long);
                ajouterContenuE(libfr, dateC, dateF, adr, siid);
            }
            ajouterContenuEqTab(tabNomPre, siid);

        });
        initialiser();
    }
});

function initialiser(centreLat, centreLng, unZoom) {

    if(centreLat == null){
        centreLat = 43.696;
    }

    if(centreLng == null){
        centreLng = 7.289429;
    }

    if(unZoom == null){
        unZoom = 4;
    }
    var latlng = new google.maps.LatLng(centreLat, centreLng);

    var options = {
        center: latlng,
        zoom: unZoom,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    var carte = new google.maps.Map(document.getElementById("carte"), options);
    Equipe['structureinria'].forEach(function(ent) {
        var lib = ent['libellefr'];
        var lat, long;
        var entite = ent['entite'];
        if (entite.length ){
                entite.forEach(function(ent){
                    if(ent['@principal'] == "1"){
                        lat = ent['adressegeographique']['latitude'];
                        long = ent['adressegeographique']['longitude'];
                    }});
            }else{
                lat = entite['adressegeographique']['latitude'];
                long = entite['adressegeographique']['longitude'];
            }
        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(lat, long),
            map: carte,
            title: lib
        });

        google.maps.event.addListener(marker,'click',function() {
            var infowindow = new google.maps.InfoWindow({
                content:lib
            });
            infowindow.open(carte,marker);
        });

    });


}

/*function initMap() {

    map = new google.maps.Map(document.getElementById('researchCentersMap'), {
      zoom: 2,
      center: new google.maps.LatLng(2.8,-187.3),
      mapTypeId: 'terrain'
    });
  // Create a <script> tag and set the USGS URL as the source.
  var script = document.createElement('script');
  // This example uses a local copy of the GeoJSON stored at http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.geojsonp
  script.src = 'https://developers.google.com/maps/documentation/javascript/examples/json/earthquake_GeoJSONP.js';
  document.getElementsByTagName('head')[0].appendChild(script);
}

// Loop through the results array and place a marker for each
// set of coordinates.
window.eqfeed_callback = function(results) {
  for (var i = 0; i < results.features.length; i++) {
    var coords = results.features[i].geometry.coordinates;
    var latLng = new google.maps.LatLng(coords[1],coords[0]);
    var marker = new google.maps.Marker({
      position: latLng,
      map: map
    });
  }
} */


function ajouterContenuE(libfrE, DateO, DateF, adr, idEq){
    var nom = "Cazals";
    var prenom = "Frederic";
    var nbPub = "2";
    var lienClick = "ficheEquipe.html?idEq="+idEq+"&lang=";
    var stringHTML = "<div class=\"col-6\"><br><h5>"+libfrE+"</h5><p><b>Date ouverture : </b>"+DateO+"  <br><b>Date Fermeture : </b>"+DateF+"<br><b>Adresse :</b> <br> "+adr+" <br><b>Plus d'informations : </b><br><div class=\"row\"><div class=\"col-6\"><a class=\"btn btn-secondary btn-block\" href="+lienClick+"fr"+">FR</a></div><div class=\"col-6\"><a class=\"btn btn-secondary btn-block\" href="+lienClick+"en"+">EN</a></div></div></p><table class=\"table table-responsive table-hover table-bordered  table-sm table-inverse\" style=\"text-align: center; color: white\"><thead><tr><th>Nom</th><th>Prénom</th><th>Nombre de publication</th><th>Rapport</th></tr></thead> <tbody id=\"contenuIComplTabE"+idEq+"\"></tbody></table></div>";
    $('#contenuIComplE').append(stringHTML);
}

function ajouterContenuEqTab(noms, idEq){
    var stringHTML = "";
    var nbPub = "2"; //a faire sauter car on veux savoir le nombre de publication total et pas que dans une équipe
    var lienClick = "fichePerso.html?idEq="+idEq;
    noms.forEach(function (nom){ //pour l'url il faut regarder comment est formule un $_Get
        stringHTML += "<tr><th scope=\"row\">"+nom[0]+"</th><td>"+nom[1]+"</td><td>"+nbPub+"</td><td><a style=\"color: white;\" href="+lienClick+">Cliquez ici</a></td></tr>";
    });

    $('#contenuIComplTabE'+idEq).append(stringHTML);
}

function ajouterContenuTabE(libfrE, dateO, ferm, nbMembE, latE, longE){
    var stringHTML = "<tr  onclick=\"initialiser("+latE+","+longE+" , 10)\"><th scope=\"row\">"+libfrE+"</th><td>"+nbMembE+"</td><td>"+dateO+"</td><td>"+ferm+"</td></tr>";
    $('#contenutabE').append(stringHTML);
}