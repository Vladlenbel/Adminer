window.onload = function(){
	
	var inp_userSurname = document.querySelector('input[name = userSurname]');
	var inp_userName = document.querySelector('input[name = userName]');
	var inp_userPatronomic = document.querySelector('input[name = userPatronomic]');
	var inp_workId = document.querySelector('input[name = workId]');
	var inp_tableNumber = document.querySelector('input[name = tableNumber]');
	var inp_departament = document.querySelector('input[name = departament]');
	var inp_position = document.querySelector('input[name = position]');
	var inp_birthday= document.querySelector('input[name = birthday]');
	var inp_sound = document.querySelector('input[name = sound]');
	var inp_status = document.getElementById("status");
	var inp_typeWorkingHour = document.querySelector('input[name = typeWorkingHour]');
	var inp_idInTable = document.querySelector('input[name = idInTable]');
	



	
	
	document.querySelector('#addWorkBut').onclick = function(){
		var status;
		if ($("#status").select2("val")== ""){
			status = $("#status").select2("val");
		}
		else {
			status = $("#status").select2("data").text;
		}
		
		var typeCard = "";
		var radios = document.getElementsByName('typeCards');
		for (var i = 0, length = radios.length; i < length; i++){
			if (radios[i].checked){
				console.log(radios[i].value);
				typeCard = radios[i].value;
				break;
			}
		}
		
		var params = 'userSurname=' + $("#userSurname").select2("val") + 
		'&' + 'userName=' + $("#userName").select2("val") + 
		'&' + 'userPatronomic=' + $("#userPatronomic").select2("val") + 
		'&' + 'workId=' + $("#workId").select2("val") + 
		'&' + 'tableNumber=' + $("#tableNumber").select2("val") + 
		'&' + 'departament=' + $("#departament").select2("val") +
		'&' + 'position=' + $("#position").select2("val") +
		'&' + 'birthday=' + $("#birthday").select2("val") + 
		'&' + 'sound=' + $("#sound").select2("val") +
		'&' + 'typeWorkingHour=' + $("#typeWorkingHour").select2("val") +
		'&' + 'status=' + status +
		'&' + 'typeCard=' + typeCard +
		'&' + 'info=' + 'addWorker';
		ajaxPost(params);
	}
	
	document.querySelector('#editWorker').onclick = function(){
		var status;
		if ($("#status").select2("val")== ""){
			status = $("#status").select2("val");
		}
		else {
			status = $("#status").select2("data").text;
		}
		
		var typeCard = "";
		var radios = document.getElementsByName('typeCards');
		for (var i = 0, length = radios.length; i < length; i++){
			if (radios[i].checked){
				console.log(radios[i].value);
				typeCard = radios[i].value;
				break;
			}
		}
		
		var params = 'userSurname=' + $("#userSurname").select2("val") + 
		'&' + 'userName=' + $("#userName").select2("val") + 
		'&' + 'userPatronomic=' + $("#userPatronomic").select2("val") + 
		'&' + 'workId=' + $("#workId").select2("val") + 
		'&' + 'tableNumber=' + $("#tableNumber").select2("val") + 
		'&' + 'departament=' + $("#departament").select2("val") +
		'&' + 'position=' + $("#position").select2("val") +
		'&' + 'birthday=' + $("#birthday").select2("val") + 
		'&' + 'sound=' + $("#sound").select2("val") +
		'&' + 'typeWorkingHour=' + $("#typeWorkingHour").select2("val") +
		'&' + 'status=' + status +
		'&' + 'typeCard=' + typeCard +
		'&' + 'idInTable=' + $("#idInTable").select2("val") + 
		'&' + 'info=' + 'editWorker';
		ajaxPost(params);
	}
	
	document.querySelector('#showTable').onclick = function(){
		var status;
		if ($("#status").select2("val")== ""){
			status = $("#status").select2("val");
		}
		else {
			status = $("#status").select2("data").text;
		}
		
		var typeCard = "";
		var radios = document.getElementsByName('typeCards');
		for (var i = 0, length = radios.length; i < length; i++){
			if (radios[i].checked){
				console.log(radios[i].value);
				typeCard = radios[i].value;
				break;
			}
		}
		
		var params = 'userSurname=' + $("#userSurname").select2("val") + 
		'&' + 'userName=' + $("#userName").select2("val") + 
		'&' + 'userPatronomic=' + $("#userPatronomic").select2("val") + 
		'&' + 'workId=' + $("#workId").select2("val") + 
		'&' + 'tableNumber=' + $("#tableNumber").select2("val") + 
		'&' + 'departament=' + $("#departament").select2("val") +
		'&' + 'position=' + $("#position").select2("val") +
		'&' + 'birthday=' + $("#birthday").select2("val") + 
		'&' + 'sound=' + $("#sound").select2("val") +
		'&' + 'typeWorkingHour=' + $("#typeWorkingHour").select2("val") +
		'&' + 'status=' + status +
		'&' + 'typeCard=' + typeCard +
		'&' + 'info=' + 'showTable';
		ajaxPost(params);
	}
	
	
	/*отправить онформацию об отделе*/
	
	
	var inp_nameDepart = document.querySelector('input[name = nameDepart]');
	var inp_typeWorkTimeDepart = document.querySelector('input[name = typeWorkTimeDepart]');
	var inp_idDepInTable = document.querySelector('input[name = idDepInTable]');
	
	document.querySelector('#addDepBut').onclick = function(){
		var params = 'nameDepart=' + inp_nameDepart.value + 
		'&' +'typeWorkTimeDepart=' + inp_typeWorkTimeDepart.value + 
		'&' + 'info=' + 'addDepBut';
		ajaxPost(params);
	}
	
	document.querySelector('#editDeparInfo').onclick = function(){
		var params = 'nameDepart=' + inp_nameDepart.value + 
		'&' +'typeWorkTimeDepart=' + inp_typeWorkTimeDepart.value + 
		'&' +'idDepInTable=' + inp_idDepInTable.value +
		'&' + 'info=' + 'editDeparInfo';
		ajaxPost(params);
	}
	
	document.querySelector('#showTableDepar').onclick = function(){
		var params = 'info=' + 'showTableDepar';
		ajaxPost(params);
	}
	
	/*отправить информацию о типах рабочего времени*/
	
	var inp_startWorkHour = document.querySelector('input[name = startWorkHour]');
	var inp_finishWorkHour = document.querySelector('input[name = finishWorkHour]');
	var inp_dinnerStart = document.querySelector('input[name = dinnerStart]');
	var inp_dinnerFinish = document.querySelector('input[name = dinnerFinish]');
	var inp_idWorkHourInTable = document.querySelector('input[name = idWorkHourInTable]');
	
	document.querySelector('#addWorkHourBut').onclick = function(){
		var params = 'startWorkHour=' + inp_startWorkHour.value + 
		'&' +'finishWorkHour=' + inp_finishWorkHour.value + 
		'&' +'dinnerStart=' + inp_dinnerStart.value +
		'&' +'dinnerFinish=' + inp_dinnerFinish.value +
		'&' + 'info=' + 'addWorkHourBut';
		ajaxPost(params);
	}
	
	document.querySelector('#editWorkHourInfo').onclick = function(){
		var params = 'startWorkHour=' + inp_startWorkHour.value + 
		'&' +'finishWorkHour=' + inp_finishWorkHour.value +
		'&' +'dinnerStart=' + inp_dinnerStart.value +
		'&' +'dinnerFinish=' + inp_dinnerFinish.value +
		'&' +'idWorkHourInTable=' + inp_idWorkHourInTable.value +
		'&' + 'info=' + 'editWorkHourInfo';
		ajaxPost(params);
	}
	
	document.querySelector('#showTableWorkHour').onclick = function(){
		var params = 'info=' + 'showTableWorkHour';
		ajaxPost(params);
	}
	
    /*Добавить/изменить пользователя*/     
     	
	var inp_nameAuthor = document.querySelector('input[name = nameAuthor]');
	var inp_paswordAuthor = document.querySelector('input[name = paswordAuthor]');
	var inp_roleUserAuthor = document.querySelector('input[name = roleUserAuthor]');

	
	document.querySelector('#addAuthorBut').onclick = function(){
		var params = 'nameAuthor=' + inp_nameAuthor.value + 
		'&' +'paswordAuthor=' + inp_paswordAuthor.value + 
		'&' +'roleUserAuthor=' + inp_roleUserAuthor.value +
		'&' + 'info=' + 'addAuthorBut';
		ajaxPost(params);
	}
	
	document.querySelector('#editAuthorInfo').onclick = function(){
		var params = 'nameAuthor=' + inp_nameAuthor.value + 
		'&' +'paswordAuthor=' + inp_paswordAuthor.value +
		'&' +'roleUserAuthor=' + inp_roleUserAuthor.value +
		'&' + 'info=' + 'editAuthorInfo';
		ajaxPost(params);
	}
	
	document.querySelector('#showTableAuthor').onclick = function(){
		var params = 'info=' + 'showTableAuthor';
		ajaxPost(params);
	}
}

function ajaxPost(params){
	var request = new XMLHttpRequest();
	
	request.onreadystatechange = function(){
			if(request.readyState == 4 && request.status ==200){
				document.querySelector('#result').innerHTML = request.responseText;
			}
	}
	
	request.open('POST', 'AddWorker');
	request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	request.send(params);
}