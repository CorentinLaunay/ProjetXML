var Cris, JsEq;
var listP = new Array();
var listE = new Array();
var listId = new Array();

var j = 0;
$( document ).ready(function() {

    $.get( "http://localhost:8082/api/centres/list", function( data ) {
        $( ".result" ).html( data );
        $.each(data,function(i, cris ) {
            $.each(cris,function(i, cr ) {
                var siid = cr.siid;
                var idgef = cr.idgef;
                $.get( "http://localhost:8082/api/centres/equipes/nombre/"+idgef, function( nb ) {
                    ajouterNbEquipe(siid, nb);
                });
                var lib = cr.libelle;
                var lat = cr.adressegeographique.latitude;
                var long = cr.adressegeographique.longitude;
                var dateOuv = cr.dateOuverture.dayOfWeek + " " + cr.dateOuverture.dayOfMonth + " " + cr.dateOuverture.month + " " + cr.dateOuverture.year;
                var adr = cr.adressegeographique.libelle+" "+ cr.adressegeographique.adresse+" "+cr.adressegeographique.cp+" "+cr.adressegeographique.ville;
                var dcr = cr['responsable'][0]['personne']['nom']+" "+ cr['responsable'][0]['personne']['prenom'];
                var ds = cr['responsable'][1]['personne']['nom']+" "+ cr['responsable'][1]['personne']['prenom'];
                var da = cr['responsable'][2]['personne']['nom']+" "+ cr['responsable'][2]['personne']['prenom'];
                var vpcp = cr['responsable'][3]['personne']['nom']+" "+ cr['responsable'][3]['personne']['prenom'];
                var crid = cr['siid'];
                var nb;
                ajouterContenuTabCR(lib,lat,long,crid);
                ajouterContenuCR(crid,lib,dateOuv,adr, dcr,ds,da,vpcp);
                addInput(crid);
            });
            Cris = cris;
            initialiser();
        });

    });
});


/*var centreLat = 48.854733;
var centreLng = 2.350879;*/



function initialiser(centreLat, centreLng, unZoom) {

    if(centreLat == null){
        centreLat = 48.730719;
    }

    if(centreLng == null){
        centreLng = 2.1743768;
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

    Cris.forEach(function(cr) {
        var lib = cr['libelle'];
        var lat = cr['adressegeographique']['latitude'];
        var long = cr['adressegeographique']['longitude'];
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

/*
('DCR', 'Directeur de Centre');
('DS', 'Délégué Scientifique');
('DA', "Délégué à l'Administration");
('VPCP', 'Vice Président du Comité des Projets');
*/

function ajouterContenuCR(crid,libCR, dateO,adress,dcr,ds,da,vpcp){
    var lienE = "ficheCentre.html?idCr="+crid+"";
    var stringHTML = " <div class=\"col-3\" id="+crid+"><br><h5>"+libCR+"</h5><p><b>Date ouverture :</b>  "+dateO+"<br><b>Adresse :</b> <br>"+adress+"<br><b>Responsables : </b> <br>Directeur de Centre : "+dcr+" <br> Délégué Scientifique : "+ds+" <br> Délégué à l'Administration : "+da+" <br> Vice Président du Comité des Projets : "+vpcp+"</p><div class=\"row\"><div class=\"col-6\"></div><div class=\"col-6\"><a class=\"btn btn-secondary btn-block\" href="+lienE+">Plus</a></div></div></div>";
    $('#contenuIComplCR').append(stringHTML);
}

function ajouterContenuTabCR(libCR, latCr, long, crid){
    var nbE = "0";
    var nbP = "0";

    var stringHTML = "<tr  onclick=\"initialiser("+latCr+", "+long+", 10)\"><th id='"+crid+"' scope=\"row\">"+libCR+"</th>     <td id='nbEq"+crid+"'>"+nbE+"</td></tr>";
    $('#contenutabCR').append(stringHTML);
}
/*
function ajouterNbPersonne( val, id){
    $('#nbPers'+id).get(0).textContent = val;
}*/
function ajouterNbEquipe( id, val){
    $('#nbEq'+id).get(0).textContent = val;
}

function addInput(crid){
    if($('#cridCache').val() ==""){
        var val = crid;
    }
    else{
        var val = $('#cridCache').val() +";"+ crid;
    }
    $('#cridCache').val(val);
}

function recupId(){
    var val = $('#cridCache').val();
    ret = val.split(";");
    return ret;
}

function nbPFonctIdCr( idCr, nbP){
    if(listP[idCr]){
        listP[idCr] += nbP;
    }else{
        listP[idCr] = nbP; 
    }
}
function nbEFonctIdCr( idCr, nbP){
    if(listE[idCr]){
        listE[idCr] += nbP;
    }else{
        listE[idCr] = nbP; 
    }
}
