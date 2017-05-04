breakDownApp.filter('role',function(){
	return function(input){
		if(input == 'ADMIN'){
			return 'Adminisztrátor';
		} else if(input == 'ORGANIZER'){
			return 'Szervező';
		}else if(input == 'USER'){
			return 'Felhasználó';
		}
	}
})