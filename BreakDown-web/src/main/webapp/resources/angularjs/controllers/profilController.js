breakDownApp.controller('profilController', function($scope, $rootScope, $http, $location){
	if($rootScope.user == null){
		$location.path("/");
	}
	cityNames = [];
	cityNames = $rootScope.user.interestedCities; 
	$scope.users;
		$http({
			method : 'GET',
			url : 'getallusers'
		}).success(function(response){
			$scope.users = response;
		})
	
	$scope.openSettings = function(){
		$scope.modify = true;
		$scope.name = $rootScope.user.name;
		$scope.username = $rootScope.user.username;
		$scope.newPassword = $rootScope.user.password;
		$scope.cities = angular.copy(cityNames);
	};
	$scope.saveChanges = function(form){
		if(form.$invalid){
			return;
		}
		if(form.newPassword != form.newPasswordConf){
			$scope.modifyData.passwordConf.$setValidity("compareTo", false);
		}
		$http({
			method: 'POST',
			url : 'profil/modify',
			params : {
				userId : $rootScope.user.id,
				name : form.name.$modelValue,
				username : form.username.$modelValue,
				password : form.password.$modelValue,
				cities : form.cities.$modelValue
			}
		}).success(function(response){
			$rootScope.user = response;
		});
	}
	$scope.setOrg = function(isOrg, id){
		$http({
			method : 'POST',
			url : 'breaker/' + id + "/setrole",
			params : {
				org : isOrg,
				password : $rootScope.user.password,
				email : $rootScope.user.email
			}
		}).success(function(){
		})
	}
});