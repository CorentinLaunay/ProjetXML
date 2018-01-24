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

var identifiant, lang;
var Cris
//var $_GET = $_GET();

//http://mondomaine.tld/?name=geoffrey&age=42

$( document ).ready(function() {

    identifiant = $_GET('idCr');
    $.getJSON( "http://localhost:8082/api/centres/list", function( data ) {
        $( ".result" ).html( data );
        $.each(data,function(i, index ) {
            $.each(index,function(i, cr ) {
                var crid = cr.siid;
                if (crid == identifiant){
                    var lib = cr.libelle;
                    var lat = cr.adressegeographique.latitude;
                    var long = cr.adressegeographique.longitude;
                    var dateOuv = cr['dateOuverture']['dayOfWeek'] + " " + cr.dateOuverture.dayOfMonth + " " + cr.dateOuverture.month + " " + cr.dateOuverture.year;
                    var dateFerm = "";
                    if(cr['dateFermeture'] != null){
                        dateFerm = cr['dateFermeture']['dayOfWeek'] + " " + cr.dateFermeture.dayOfMonth + " " + cr.dateFermeture.month + " " + cr.dateFermeture.year; 
                    }
                    var adr = cr.adressegeographique.libelle+" "+ cr.adressegeographique.adresse+" "+cr.adressegeographique.cp+" "+cr.adressegeographique.ville;
                    var dcr, ds, da, vpcp;
                    cr.responsable.forEach(function(respo){
                        if(respo.fonction == "dcr"){
                            dcr = new Array(respo['personne']['nom'],respo['personne']['prenom']);
                        }else if(respo.fonction == "ds"){
                            ds = new Array(respo['personne']['nom'],respo['personne']['prenom']);
                        }else if(respo.fonction == "da"){
                            da = new Array(respo['personne']['nom'],respo['personne']['prenom']);
                        }else if(respo.fonction == "vpcp"){
                            vpcp = new Array(respo['personne']['nom'],respo['personne']['prenom']);
                        }
                    });
                    var sigle = cr.sigle;
                    var nb;
                    ajouterLibE(lib);
                    ajouterInfoE1(sigle);
                    ajouterInfoE2(dateOuv,dateFerm);
                    ajouterInfoE3(adr);
                    ajouterPersPrincipal(dcr, ds, da, vpcp);
                    chargementR()
                    //listId.push(crid);
                    Cris = cr;
                    initialiser(lat, long);

                }


            });
        });
    });
});

function loadChart(){
    // Load the Visualization API and the corechart package.
    google.charts.load('current', {'packages':['corechart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.charts.setOnLoadCallback(drawChart);   
}

// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawChart() {

    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Topping');
    data.addColumn('number', 'Slices');
    tabTheme.forEach(function(id){
        data.addRows([[id[1], id[2]]]);
    });


    // Set chart options
    var options = {'title':'Répartition des themes du Centre de recherche',

                   'height':400};

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
    chart.draw(data, options);
}

function loadChart1(){
    // Load the Visualization API and the corechart package.
    google.charts.load('current', {'packages':['corechart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.charts.setOnLoadCallback(drawChart1);   
}

// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawChart1() {

    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Topping');
    data.addColumn('number', 'Slices');
    tabDom.forEach(function(id){
        data.addRows([[id[1], id[2]]]);
    });


    // Set chart options
    var options = {'title':'Répartition des domaines du Centre de recherche',

                   'height':400};

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.PieChart(document.getElementById('chart_div1'));
    chart.draw(data, options);
}

var tabTheme = new Array();
var tabDom = new Array();
function chargementR(){
    crid = $_GET('idCr');
    var siid, siidEq, sigleEq;
    $.get( "http://localhost:8082/api/centres/equipes/total/", function( data ) {
        $.each(data,function(i, eq ) {
            eq['entite'].forEach(function(ent){
                if(ent['principal'] != null){
                    siid = ent['adressegeographique']['cri']['siid'];
                }  
            });
            if(crid == siid){
                console.log(eq);
                siidEq = eq.siid;
                sigleEq = eq.sigle;
                listerEquipe(siidEq, sigleEq);
                eq["theme"].forEach(function(th){
                    if (th["lang"] == "fr"){
                        var idTh =  th["siid"];
                        var txtTh =  th["value"];
                        var estPas = 1;
                        if(tabTheme.length){
                            tabTheme.forEach(function(id){
                                if(id[0] == idTh){
                                    id[2] += 1;
                                    estPas = 0;
                                }
                            });
                        }
                        if(estPas == 1){
                            tabTheme.push(new Array(idTh, txtTh, 1)); 
                        }
                    } 
                });
                eq["domaine"].forEach(function(th){
                    if (th["lang"] == "fr"){
                        var idTh =  th["siid"];
                        var txtTh =  th["value"];
                        var estPas = 1;
                        if(tabDom.length){
                            tabDom.forEach(function(id){
                                if(id[0] == idTh){
                                    id[2] += 1;
                                    estPas = 0;
                                }
                            });
                        }
                        if(estPas == 1){
                            tabDom.push(new Array(idTh, txtTh, 1)); 
                        }
                    } 
                });
            }
        });
        //console.log(tabTheme);
        loadChart();
        loadChart1();
    });
}

function initialiser(centreLat, centreLng, unZoom) {
    if(centreLat == null){
        centreLat = 43.696;
    }
    if(centreLng == null){
        centreLng = 7.289429;
    }

    if(unZoom == null){
        unZoom = 5;
    }
    var latlng = new google.maps.LatLng(centreLat, centreLng);

    var options = {
        center: latlng,
        zoom: unZoom,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    var carte = new google.maps.Map(document.getElementById("carte"), options);

    var siid = Cris.siid;
    if (siid == identifiant){
        var lib;
        var lat, long;
        lib = Cris.libelle
        lat = Cris.adressegeographique.latitude;
        long = Cris.adressegeographique.longitude;
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
    }

}

function ajouterInfoE1(sigle){
    var stringHTML = "<h6>Sigle : </h6><p>"+sigle+"</p>";
    $('#info-1').append(stringHTML);
}

function ajouterInfoE2(dateC, dateF){
    var str = "";
    if(dateF != ""){
        str = "<h6>Date de fermeture : </h6><p>"+dateF+"</p>";
    }
    var stringHTML = "<h6>Date d'ouverture : </h6><p>"+dateC+" </p>"+str;
    $('#info-2').append(stringHTML);
}

function ajouterInfoE3(adr){
    var stringHTML = "<h6>Adresse principal : </h6><p>"+adr+"</p>";
    $('#info-3').append(stringHTML);
}

function ajouterLibE(lib){
    var stringHTML = lib;
    $('#LibE').append(stringHTML);
}

function ajouterResumer(text){
    var stringHTML = text;
    $('#resume-Eq').append(stringHTML);
}

function ajouterPersPrincipal(tabDcr, tabDs, tabDa, tabVpcp){
    var stringLienExt = "<div class=\"col-3\">";
    stringLienExt += ajouterDCR(tabDcr)+"</div>";
    stringLienExt += "<div class=\"col-3\">"+ajouterDS(tabDs)+"</div>";
    stringLienExt += "<div class=\"col-3\">"+ajouterDA(tabDa)+"</div>";
    stringLienExt += "<div class=\"col-3\">"+ajouterVPCP(tabVpcp)+"</div>";
    $('#lien_structure_exterieure').append(stringLienExt);
}


function ajouterDCR(tabDcr){
    var str = "";
    var nom, prenom;
    if(tabDcr.length > 0){
        nom = tabDcr[0];
        prenom = tabDcr[1];
        str += "<h6>Directeur de Centre : </h6><p>"+nom+" "+prenom+" </p>";
    }else{
        str += "<h6>Directeur de Centre : </h6> Aucun Partenaire </p>";
    }
    return str;
}

function ajouterDS(tabDs){
    var str = "";
    var nom, prenom;
    if(tabDs.length > 0){
        nom = tabDs[0];
        prenom = tabDs[1];
        str += "<h6>Délégué Scientifique : </h6><p>"+nom+" "+prenom+" </p>";
    }else{
        str += "<h6>Délégué Scientifique : </h6> Aucun Partenaire </p>";
    }
    return str;
}

function ajouterDA(tabDa){
    var str = "";
    var nom, prenom;
    if(tabDa.length > 0){
        nom = tabDa[0];
        prenom = tabDa[1];
        str += "<h6>Délégué à l'Administration :</h6><p>"+nom+" "+prenom+" </p>";
    }else{
        str += "<h6>Délégué à l'Administration :</h6> Aucun Partenaire </p>";
    }
    return str;
}

function ajouterVPCP(tabVpcp){
    var str = "";
    var nom, prenom;
    if(tabVpcp.length > 0){
        nom = tabVpcp[0];
        prenom = tabVpcp[1];
        str += "<h6>Vice Président du Comité des Projets : </h6><p>"+nom+" "+prenom+" </p>";
    }else{
        str += "<h6>Vice Président du Comité des Projets : </h6> Aucun Partenaire </p>";
    }
    return str;
}

function listerEquipe(siidEq, sigleEq){
    var lien = "http://localhost:8000/ficheEquipe.html?idEq="+siidEq+"&lang=";
    var stringLienExt = "";
    stringLienExt += "<div class=\"\" id=\"info-eq-3\" style = \" padding: 15px; \"><a style=\"color: white;\" href=\""+lien+"fr\" >" + sigleEq + "</a><br></div><br>";
    $('#liste_des_eq').append(stringLienExt);
}