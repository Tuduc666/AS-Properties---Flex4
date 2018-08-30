/**
 * added JavaScript onclick to solve the IOS hover issue on mobile devices
 */

function showDropdown(id) {
	// initialize everything to not display, turn on only selected one to display
	document.getElementById('selectCitydrop').style.display = "none";
	document.getElementById('selectStatedrop').style.display = "none";
	document.getElementById('orderBydrop').style.display = "none";
	
	// this would crash the program when the user is already logged in, need try catch clause
	try {
	    document.getElementById('logindrop').style.display = "none";
	}
	catch(err) {                                          // catch handles the error
	    // document.getElementById("demo").innerHTML = err.message;      // err.message ->  adddlert is not defined
	}
	finally {
		if (id != "cleardrop")
			document.getElementById(id).style.display = "block";
	}
}