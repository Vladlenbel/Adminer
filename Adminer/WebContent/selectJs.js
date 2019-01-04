// Инициализация компонента при вводе фамилии на странице админки
$(document).ready(function() {
	var params = 'info=' + 'getLastName';
	var text = [];
	var requests = getLastName(params);
	
		text = getRequest(requests).split(',');
	var id = 0;
	
	var object ={};
	var array =[];
	
		for(var i = 0; i< text.length; i++){
			object = {
					id: text[i],
					text: text[i]
			}
			array.push(object);
		}
	
	var kol = 0;
	$("#userSurname").select2({
	   // minimumInputLength: 1,
	    placeholder: "Фамилия",
		allowClear: true,  
	    query: function (query) {
	        var data = {results: []}, i, j, s;
	            data.results.push({id: query.term, text: query.term,});
	            kol = query.term;
	            var s = 0;
	           // console.log(data);
	            for(var j = 0; j< array.length; j++){
	            	if (query.term.toLowerCase() == array[j].text.substring(0, kol.length).toLowerCase() ){
	            		var temp = array[s];
	            		array[s] = array[j];
	            		array[j] = temp;
	            		s++;
	            	}
	            }
	            
	            for(var j = 0; j< array.length; j++){	            	
	            	data.results.push(array[j]);
	            }
	                  
	        query.callback(data);
	        
	    }

	});
	
});

// Инициализация компонента при вводе имени на странице админки	
var params = 'info=' + 'getName';
var text = [];
var requests = getLastName(params);
	text = getRequest(requests).split(',');
//console.log(text);
var id = 0;

var object ={};
var arrays =[];

	for(var i = 0; i< text.length; i++){
		object = {
			id: text[i],
			text: text[i]
 //console.log(i);
		}
	arrays.push(object);
	}
//console.log(arrays);
var kol = 0;
$(document).ready(function() {
	$("#userName").select2({
	    //minimumInputLength: 1,
	    placeholder: "Имя",
		  allowClear: true,
		  
		  query: function (query) {
		        var data = {results: []}, i, j, s;
		            data.results.push({id: query.term, text: query.term,});
		            kol = query.term;
		            var s = 0;
		            for(var j = 0; j< arrays.length; j++){
		            	if (query.term.toLowerCase() == arrays[j].text.substring(0, kol.length).toLowerCase() ){
		            		var temp = arrays[s];
		            		arrays[s] = arrays[j];
		            		arrays[j] = temp;
		            		s++;
		            	}
		            }
		            
		            for(var j = 0; j< arrays.length; j++){	            	
		            	data.results.push(arrays[j]);
		            	
		            }
		                  
		        query.callback(data);
		        
		    }

		});
	
	/*$('#userName').on('change', function (e) {
		alert("Selected value is: "+$("#userName").select2("data").text);

		});*/

	});

/*$('#userName').on('change', function (e) {
	alert("Selected value is: "+$("#e5").select2("val"));

	});*/


var params = 'info=' + 'getPatronomic';
var patr = [];
var requests = getLastName(params);

patr = getRequest(requests).split(',');
var id = 0;
//console.log(text);
var objectPatr ={};
var arrayPatr =[];

for(var i = 0; i< patr.length; i++){
 objectPatr = {
			id:  patr[i],
			text: patr[i]
	}
	arrayPatr.push(objectPatr);
}

var kol = 0;
$(document).ready(function() {
	$("#userPatronomic").select2({
	    //minimumInputLength: 1,
	    placeholder: "Отчество",
		  allowClear: true,
		  
		  query: function (query) {
		        var data = {results: []}, i, j, s;
		            data.results.push({id: query.term, text: query.term,});
		            kol = query.term;
		            var s = 0;
		            for(var j = 0; j< arrayPatr.length; j++){
		            	if (query.term.toLowerCase() == arrayPatr[j].text.substring(0, kol.length).toLowerCase() ){
		            		var temp = arrayPatr[s];
		            		arrayPatr[s] = arrayPatr[j];
		            		arrayPatr[j] = temp;
		            		s++;
		            	}
		            }
		            
		            for(var j = 0; j< arrayPatr.length; j++){	            	
		            	data.results.push(arrayPatr[j]);
		            }
		                  
		        query.callback(data);
		        
		    }

		});
	
	/*$('#userPatronomic').on('change', function (e) {
		alert("Selected value is: "+$("#userPatronomic").select2("data").text);

		});*/

	});

/*$('#userPatronomicы').on('change', function (e) {
	alert("Selected value is: "+$("#e5").select2("val"));

	});
*/