breakDownApp.filter('gender', function(){
	return function(input){
		if(input == 'MALE'){
			return "Férfi";
		}else if(input == 'FEMALE'){
			return "Nő";
		}
	}
})