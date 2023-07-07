

function comma(s){
	let result = s.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
	console.log(result);
	return result;
}


function comma_replace(s){
	let result = s.toString().replace(/,/g, "");
	console.log(result);
	return result;
}

function numpad(s) {
	//if (s.length == 1){
	//	s = '0' + s;
	//}
	var s0 = String(s)
	//console.log(s0.length);
	for (var i=s0.length; i < 2; i++) {
			s0 = '0' + s0;
//	console.log(s0);
	}
	return s0;
}