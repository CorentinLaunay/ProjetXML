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

var name = $_GET('name'),
    age = $_GET('age');

var $_GET = $_GET(),
    name = $_GET['name'],
    age = $_GET['age'];

//http://mondomaine.tld/?name=geoffrey&age=42