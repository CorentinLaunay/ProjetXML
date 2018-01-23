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
var tabSiidPrec, tabSiidPrecCarte;
var Equipe;
//var $_GET = $_GET();

//http://mondomaine.tld/?name=geoffrey&age=42

$( document ).ready(function() {
    identifiant = $_GET('idEq');
    lang = $_GET('lang');

    $.get( "http://localhost:8082/api/centres/equipes/total/", function( data ) {
        $.each(data,function(i, eq ) {
            var siid = eq['siid'];
            if (siid == identifiant && tabSiidPrec && tabSiidPrec[0] != siid){
                var lib;
                if(lang == 'fr'){
                    lib = eq['libellefr'];
                }else{
                    lib = eq['libelleen'];
                }
                var sigle = eq['sigle'];
                var dateC = eq['dateCreation'];
                var dateF = eq['dateFermeture'];
                var typeStr = eq['typestructure'];
                var domaine = eq['domaine'];
                var lien;
                var urlTeam = eq['urlTeam'].forEach(function(url){
                    if(url['lang'] == lang){
                        lien = url['value']; //devient value
                    }
                });
                var classif, domtext, thtext;
                domaine.forEach(function(dom){
                    if(dom['lang'] == lang){
                        classif = dom['classification'];
                        domtext = dom['value'];//devient value
                    }
                });

                eq['theme'].forEach(function(th){
                    if(th['lang'] == lang){
                        thtext = th['value'];//devient value
                    }
                });
                var entite = eq['entite'];
                var nbP, adr, lat, long,lienCr, resum, nomPrinc, prenomPrinc, tabPart = new Array(), tabAs = new Array(), tabAutre = new Array(), tabPersEnPlus = new Array();
                if (entite.length > 1){
                    entite.forEach(function(ent){
                        if(ent['principal'] != null){
                            adr = ent['adressegeographique']['libelle']+" "+ ent['adressegeographique']['adresse']+" "+ent['adressegeographique']['cp']+" "+ent['adressegeographique']['ville'];
                            lat = ent['adressegeographique']['latitude'];
                            long = ent['adressegeographique']['longitude'];
                            lienCr = ent['adressegeographique']['cri']['siid'];
                            heb = ent['hebergeur'];
                            nomPrinc = ent['personne']['nom'];
                            prenomPrinc = ent['personne']['prenom'];
                            if(ent['lienStructureExterieure']){
                                if(ent['lienStructureExterieure'].length){
                                    ent['lienStructureExterieure'].forEach(function(lienExt){
                                        if(lienExt['typeLien'] == 'Partenaire'){
                                            var libPart = lienExt['structureExterieure']['libelle']; 
                                            var typePart = lienExt['structureExterieure']['type'];
                                            var dateD = lienExt['dateDebut'];
                                            var dateF = lienExt['dateFin'];
                                            tabPart.push(new Array(libPart, typePart, dateD, dateF));
                                        } 
                                        else if(lienExt['typeLien'] == 'Associée'){
                                            var libAs = lienExt['structureExterieure']['libelle']; 
                                            var typeAs = lienExt['structureExterieure']['type'];
                                            var dateD = lienExt['dateDebut'];
                                            var dateF = lienExt['dateFin'];
                                            var nomDir = 'Inconnu', prenomDir = 'Inconnu';
                                            if(lienExt['structureExterieure'][typeAs.toLowerCase()]){
                                                var infoType = lienExt['structureExterieure'][typeAs.toLowerCase()];
                                                nomDir = infoType['directeur']['nom'];
                                                prenomDir = infoType['directeur']['prenom'];

                                            }
                                            tabAs.push(new Array(libAs, typeAs, dateD, dateF, nomDir, prenomDir));
                                        } 
                                        else if(lienExt['typeLien'] == '(Non renseigné)'){
                                            var lib = lienExt['structureExterieure']['libelle']; 
                                            var type = lienExt['structureExterieure']['type'];
                                            var dateD = lienExt['dateDebut'];
                                            var dateF = lienExt['dateFin'];
                                            var nomDir = 'Inconnu', prenomDir = 'Inconnu';
                                            if(lienExt['structureExterieure'][type.toLowerCase()]){
                                                var infoType = lienExt['structureExterieure'][type.toLowerCase()];
                                                nomDir = infoType['directeur']['nom'];
                                                prenomDir = infoType['directeur']['prenom'];
                                            }
                                            tabAutre.push(new Array(lib, type, dateD, dateF, nomDir, prenomDir));
                                        }
                                    });
                                }else{
                                    var lienExt = ent['lienStructureExterieure'];
                                    if(lienExt['typeLien'] == 'Partenaire'){
                                        var libPart = lienExt['structureExterieure']['libelle']; 
                                        var typePart = lienExt['structureExterieure']['type'];
                                        var dateD = lienExt['dateDebut'];
                                        var dateF = lienExt['dateFin'];
                                        tabPart.push(new Array(libPart, typePart, dateD, dateF));
                                    } 
                                    else if(lienExt['typeLien'] == 'Associée'){
                                        var libAs = lienExt['structureExterieure']['libelle']; 
                                        var typeAs = lienExt['structureExterieure']['type'];
                                        var dateD = lienExt['dateDebut'];
                                        var dateF = lienExt['dateFin'];
                                        var nomDir = 'Inconnu', prenomDir = 'Inconnu';
                                        if(lienExt['structureExterieure'][typeAs.toLowerCase()]){
                                            var infoType = lienExt['structureExterieure'][typeAs.toLowerCase()];
                                            nomDir = infoType['directeur']['nom'];
                                            prenomDir = infoType['directeur']['prenom'];

                                        }
                                        tabAs.push(new Array(libAs, typeAs, dateD, dateF, nomDir, prenomDir));
                                    } 
                                    else if(lienExt['typeLien'] == '(Non renseigné)'){
                                        var lib = lienExt['structureExterieure']['libelle']; 
                                        var type = lienExt['structureExterieure']['type'];
                                        var dateD = lienExt['dateDebut'];
                                        var dateF = lienExt['dateFin'];
                                        var nomDir = 'Inconnu', prenomDir = 'Inconnu';
                                        if(lienExt['structureExterieure'][type.toLowerCase()]){
                                            var infoType = lienExt['structureExterieure'][type.toLowerCase()];
                                            nomDir = infoType['directeur']['nom'];
                                            prenomDir = infoType['directeur']['prenom'];
                                        }
                                        tabAutre.push(new Array(lib, type, dateD, dateF, nomDir, prenomDir));
                                    }
                                }
                            }
                        }else{
                            var adrP = ent['adressegeographique']['libelle']+" "+ ent['adressegeographique']['adresse']+" "+ent['adressegeographique']['cp']+" "+ent['adressegeographique']['ville'];
                            var latP = ent['adressegeographique']['latitude'];
                            var longP = ent['adressegeographique']['longitude'];
                            var lienCrP = ent['adressegeographique']['cri']['siid'];
                            var hebP = ent['hebergeur'];
                            var nomP = ent['personne']['nom'];
                            var prenomP = ent['personne']['prenom'];
                            var tabPartP = new Array(), tabAsP = new Array(), tabAutreP = new Array();
                            if(ent['lienStructureExterieure']){
                                if(ent['lienStructureExterieure'].length){
                                    ent['lienStructureExterieure'].forEach(function(lienExt){
                                        if(lienExt['typeLien'] == 'Partenaire'){
                                            var libPart = lienExt['structureExterieure']['libelle']; 
                                            var typePart = lienExt['structureExterieure']['type'];
                                            var dateD = lienExt['dateDebut'];
                                            var dateF = lienExt['dateFin'];
                                            tabPartP.push(new Array(libPart, typePart, dateD, dateF));
                                        } 
                                        else if(lienExt['typeLien'] == 'Associée'){
                                            var libAs = lienExt['structureExterieure']['libelle']; 
                                            var typeAs = lienExt['structureExterieure']['type'];
                                            var dateD = lienExt['dateDebut'];
                                            var dateF = lienExt['dateFin'];
                                            var nomDir = 'Inconnu', prenomDir = 'Inconnu';
                                            if(lienExt['structureExterieure'][typeAs.toLowerCase()]){
                                                var infoType = lienExt['structureExterieure'][typeAs.toLowerCase()];
                                                nomDir = infoType['directeur']['nom'];
                                                prenomDir = infoType['directeur']['prenom'];

                                            }
                                            tabAsP.push(new Array(libAs, typeAs, dateD, dateF, nomDir, prenomDir));
                                        } 
                                        else if(lienExt['typeLien'] == '(Non renseigné)'){
                                            var lib = lienExt['structureExterieure']['libelle']; 
                                            var type = lienExt['structureExterieure']['type'];
                                            var dateD = lienExt['dateDebut'];
                                            var dateF = lienExt['dateFin'];
                                            var nomDir = 'Inconnu', prenomDir = 'Inconnu';
                                            if(lienExt['structureExterieure'][type.toLowerCase()]){
                                                var infoType = lienExt['structureExterieure'][type.toLowerCase()];
                                                nomDir = infoType['directeur']['nom'];
                                                prenomDir = infoType['directeur']['prenom'];
                                            }
                                            tabAutreP.push(new Array(lib, type, dateD, dateF, nomDir, prenomDir));
                                        }
                                    });
                                }else{
                                    var lienExt = ent['lienStructureExterieure'];
                                    if(lienExt['typeLien'] == 'Partenaire'){
                                        var libPart = lienExt['structureExterieure']['libelle']; 
                                        var typePart = lienExt['structureExterieure']['type'];
                                        var dateD = lienExt['dateDebut'];
                                        var dateF = lienExt['dateFin'];
                                        tabPartP.push(new Array(libPart, typePart, dateD, dateF));
                                    } 
                                    else if(lienExt['typeLien'] == 'Associée'){
                                        var libAs = lienExt['structureExterieure']['libelle']; 
                                        var typeAs = lienExt['structureExterieure']['type'];
                                        var dateD = lienExt['dateDebut'];
                                        var dateF = lienExt['dateFin'];
                                        var nomDir = 'Inconnu', prenomDir = 'Inconnu';
                                        if(lienExt['structureExterieure'][typeAs.toLowerCase()]){
                                            var infoType = lienExt['structureExterieure'][typeAs.toLowerCase()];
                                            nomDir = infoType['directeur']['nom'];
                                            prenomDir = infoType['directeur']['prenom'];

                                        }
                                        tabAsP.push(new Array(libAs, typeAs, dateD, dateF, nomDir, prenomDir));
                                    } 
                                    else if(lienExt['typeLien'] == '(Non renseigné)'){
                                        var lib = lienExt['structureExterieure']['libelle']; 
                                        var type = lienExt['structureExterieure']['type'];
                                        var dateD = lienExt['dateDebut'];
                                        var dateF = lienExt['dateFin'];
                                        var nomDir = 'Inconnu', prenomDir = 'Inconnu';
                                        if(lienExt['structureExterieure'][type.toLowerCase()]){
                                            var infoType = lienExt['structureExterieure'][type.toLowerCase()];
                                            nomDir = infoType['directeur']['nom'];
                                            prenomDir = infoType['directeur']['prenom'];
                                        }
                                        tabAutreP.push(new Array(lib, type, dateD, dateF, nomDir, prenomDir));
                                    }
                                }
                            }
                            tabPersEnPlus.push(new Array(nomP, prenomP, adrP, latP, longP,lienCrP, hebP, tabPartP, tabAsP, tabAutreP))
                        }
                    });
                }else{
                    entite = entite[0];
                    adr = entite['adressegeographique']['libelle']+" "+ entite['adressegeographique']['adresse']+" "+entite['adressegeographique']['cp']+" "+entite['adressegeographique']['ville'];
                    lat = entite['adressegeographique']['latitude'];
                    long = entite['adressegeographique']['longitude'];
                    lienCr = entite['adressegeographique']['cri']['siid'];
                    heb = entite['hebergeur'];
                    nomPrinc = entite['personne']['nom'];
                    prenomPrinc = entite['personne']['prenom'];
                    if(entite['lienStructureExterieure']){
                        if(entite['lienStructureExterieure'].length){
                            entite['lienStructureExterieure'].forEach(function(lienExt){
                                if(lienExt['typeLien'] == 'Partenaire'){
                                    var libPart = lienExt['structureExterieure']['libelle']; 
                                    var typePart = lienExt['structureExterieure']['type'];
                                    var dateD = lienExt['dateDebut'];
                                    var dateF = lienExt['dateFin'];
                                    tabPart.push(new Array(libPart, typePart, dateD, dateF));
                                } 
                                else if(lienExt['typeLien'] == 'Associée'){
                                    var libAs = lienExt['structureExterieure']['libelle']; 
                                    var typeAs = lienExt['structureExterieure']['type'];
                                    var dateD = lienExt['dateDebut'];
                                    var dateF = lienExt['dateFin'];
                                    var nomDir = 'Inconnu', prenomDir = 'Inconnu';
                                    if(lienExt['structureExterieure'][typeAs.toLowerCase()]){
                                        var infoType = lienExt['structureExterieure'][typeAs.toLowerCase()];
                                        nomDir = infoType['directeur']['nom'];
                                        prenomDir = infoType['directeur']['prenom'];

                                    }
                                    tabAs.push(new Array(libAs, typeAs, dateD, dateF, nomDir, prenomDir));
                                } 
                                else if(lienExt['typeLien'] == '(Non renseigné)'){
                                    var lib = lienExt['structureExterieure']['libelle']; 
                                    var type = lienExt['structureExterieure']['type'];
                                    var dateD = lienExt['dateDebut'];
                                    var dateF = lienExt['dateFin'];
                                    var nomDir = 'Inconnu', prenomDir = 'Inconnu';
                                    if(lienExt['structureExterieure'][type.toLowerCase()]){
                                        var infoType = lienExt['structureExterieure'][type.toLowerCase()];
                                        nomDir = infoType['directeur']['nom'];
                                        prenomDir = infoType['directeur']['prenom'];
                                    }
                                    tabAutre.push(new Array(lib, type, dateD, dateF, nomDir, prenomDir));
                                }
                            });
                        }else{
                            var lienExt = entite['lienStructureExterieure'];
                            if(lienExt['typeLien'] == 'Partenaire'){
                                var libPart = lienExt['structureExterieure']['libelle']; 
                                var typePart = lienExt['structureExterieure']['type'];
                                var dateD = lienExt['dateDebut'];
                                var dateF = lienExt['dateFin'];
                                tabPart.push(new Array(libPart, typePart, dateD, dateF));
                            } 
                            else if(lienExt['typeLien'] == 'Associée'){
                                var libAs = lienExt['structureExterieure']['libelle']; 
                                var typeAs = lienExt['structureExterieure']['type'];
                                var dateD = lienExt['dateDebut'];
                                var dateF = lienExt['dateFin'];
                                var nomDir = 'Inconnu', prenomDir = 'Inconnu';
                                if(lienExt['structureExterieure'][typeAs.toLowerCase()]){
                                    var infoType = lienExt['structureExterieure'][typeAs.toLowerCase()];
                                    nomDir = infoType['directeur']['nom'];
                                    prenomDir = infoType['directeur']['prenom'];

                                }
                                tabAs.push(new Array(libAs, typeAs, dateD, dateF, nomDir, prenomDir));
                            } 
                            else if(lienExt['typeLien'] == '(Non renseigné)'){
                                var lib = lienExt['structureExterieure']['libelle']; 
                                var type = lienExt['structureExterieure']['type'];
                                var dateD = lienExt['dateDebut'];
                                var dateF = lienExt['dateFin'];
                                var nomDir = 'Inconnu', prenomDir = 'Inconnu';
                                if(lienExt['structureExterieure'][type.toLowerCase()]){
                                    var infoType = lienExt['structureExterieure'][type.toLowerCase()];
                                    nomDir = infoType['directeur']['nom'];
                                    prenomDir = infoType['directeur']['prenom'];
                                }
                                tabAutre.push(new Array(lib, type, dateD, dateF, nomDir, prenomDir));
                            }
                        }
                    }
                }
                var resume = eq['resume'];
                resume.forEach(function(res){
                    if(res['lang'] == lang){
                        if(res['value'] != null){
                            resum = res['value'];
                        }   
                    }

                });
                ajouterPersPrincipal(nomPrinc, prenomPrinc, tabPart, tabAs, tabAutre);
                ajouterInfoE1(typeStr, classif, domtext, thtext);
                ajouterInfoE2(dateC,dateF, lien);
                ajouterInfoE3(adr, lienCr, heb);
                ajouterLibE(lib);
                ajouterResumer(resum);
                if(entite.length){
                    ajouterPers(tabPersEnPlus);
                }
            }
            tabSiidPrec = new Array(siid);
        });
        Equipe = data;
        initialiser();
    });
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
    Equipe.forEach(function(ent) {
        if(tabSiidPrecCarte && ent['siid'] != tabSiidPrecCarte[0] && ent['siid'] == identifiant){
            var lib = ent['libellefr'];
            var lat, long;
            var entite = ent['entite'];
            if (entite.length > 1){
                entite.forEach(function(ent){
                    if(ent['principal'] != null){
                        lat = ent['adressegeographique']['latitude'];
                        long = ent['adressegeographique']['longitude'];
                    }});
            }else{
                entite.forEach(function(ent){
                    lat = ent['adressegeographique']['latitude'];
                    long = ent['adressegeographique']['longitude'];
                });

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
        }
        tabSiidPrecCarte = new Array(ent['siid']);  
    });
}

function ajouterInfoE1(typeStruct, classif, text, theme){
    var stringHTML = "<h6>Type de structure: </h6><p>"+typeStruct+"</p><h6>Domaine : </h6><p>"+classif+" - "+text+"</p><h6>Theme : </h6><p>"+theme+"</p>";
    $('#info-1').append(stringHTML);
}

function ajouterInfoE2(dateC, dateF, lien){
    var lienlib;
    if(!lien){
        lien ="#";
        lienlib = "Inconnu";
    }else{
        lienlib = lien;
    }
    var stringHTML = "<h6>Date de création : </h6><p>"+dateC+" </p><h6>Date de fermeture : </h6><p>"+dateF+"</p><h6>Lien : </h6><a href="+lien+" >"+lienlib+"</a>";
    $('#info-2').append(stringHTML);
}

function ajouterInfoE3(adr, unlien, heb){
    var lien = "carteCentreRech.html#"+unlien;
    var stringHTML = "<h6>Adresse principal : </h6><p>"+adr+"<br> <a href="+lien+">Lien vers Centre de recherche </a></p><h6>Hebergeur : </h6><p>"+heb+"</p>";
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

function ajouterPersPrincipal(nom, prenom, tabPart, tabAs, tabAutre){
    var stringHTML = " "+nom+" "+prenom;
    $('#nomPrenPersoPrinc').append(stringHTML);
    var stringLienExt = "<div class=\"col-4\">";
    stringLienExt += ajouterPartenaire(tabPart)+"</div>";
    stringLienExt += "<div class=\"col-4\">"+ajouterAssocie(tabAs)+"</div>";
    stringLienExt += "<div class=\"col-4\">"+ajouterAutreLien(tabAutre)+"</div>";
    $('#lien_structure_exterieure').append(stringLienExt);
}
//nomP, prenomP, adrP, latP, longP,lienCrP, hebP, tabPartP, tabAsP, tabAutreP
function ajouterPers(tabPersonne){
    var stringHTML = "";
    tabPersonne.forEach(function(tab){
        var nom = tab[0];
        var prenom = tab[1];
        var adrP = tab[2];
        var lienCrP = tab[5];
        var hebP = tab[6];
        var tabPart = tab[7];
        var tabAs = tab[8];
        var tabAutre = tab[9];
        stringHTML += " <h5 style=\"text-align: center; padding-top: 10px\">Personne(s) : "+nom+" "+prenom+" </h5><br><div class=\"container-fluid\" ><div class=\"row\" id=\"lien_structure_exterieure_Pers\"><div class=\"col-3\"><h6>Adresse :</h6><p>"+adrP+" - "+lienCrP+"</p><h6>Hebergeur :</h6> <p>"+hebP+"</p></div><div class=\"col-3\">"+ajouterPartenaire(tabPart)+"</div><div class=\"col-3\">"+ajouterAssocie(tabAs)+" </div><div class=\"col-3\">"+ajouterAutreLien(tabAutre)+"</div></div></div>";
    });

    $('#infoPers').append(stringHTML);
    $('#infoPers').show();
}

function ajouterPartenaire(tabPart){
    var str = "";
    var libPart, typePart, dateD, dateF;
    if(tabPart.length > 0){
        tabPart.forEach(function(tab){
            libPart = tab[0];
            typePart = tab[1];
            dateD = tab[2];
            if(tab[3]){
                dateF = tab[3];
            }else{
                dateF = "Présent";
            }
            str += "<h6>Partenaire(s) : "+dateD+" - "+dateF+" </h6><p>"+libPart+" - "+typePart+" </p>";
        });
    }else{
        str += "<h6>Partenaire(s) : </h6> Aucun Partenaire </p>";
    }
    return str;
}

function ajouterAssocie(tabAs){
    var str = "";
    var libAs, typeAs, dateD, dateF, nomDir, prenomDir;
    if(tabAs.length > 0){
        tabAs.forEach(function(tab){
            libAs = tab[0];
            typeAs = tab[1];
            dateD = tab[2];
            if(tab[3]){
                dateF = tab[3];
            }else{
                dateF = "Présent";
            }
            nomDir = tab[4];
            prenomDir = tab[5];
            str += "<h6>Associé(s) : "+dateD+" - "+dateF+" </h6><p>Libelle : "+libAs+" <br>Type : "+typeAs+" <br> Directeur : "+nomDir+" - "+prenomDir+" </p>";
        });
    }else{
        str += "<h6>Associé(s) : </h6> Aucun Associé </p>";
    }
    return str;
}

function ajouterAutreLien(tabAutre){
    var str = "";
    var lib, type, dateD, dateF;
    if(tabAutre.length > 0){
        tabAutre.forEach(function(tab){
            lib = tab[0];
            type = tab[1];
            dateD = tab[2];
            if(tab[3]){
                dateF = tab[3];
            }else{
                dateF = "Présent";
            }
            str += "<h6>Autre(s) lien(s) : "+dateD+" - "+dateF+" </h6><p>"+lib+" - "+type+" </p>";
        });
    }else{
        str += "<h6>Autre(s) lien(s) : </h6> Aucun autre lien </p>";
    }
    return str;
}