breakDownApp.controller('profilController', function($scope, $rootScope, $http){
	cityNames = [];
	if($rootScope.user != null){
		cityNames = $rootScope.user.interestedCities; 
	}
	
	$scope.openSettings = function(){
		$scope.modify = true;
		$scope.name = $rootScope.user.name;
		$scope.username = $rootScope.user.username;
		$scope.newPassword = $rootScope.user.password;
		$scope.cities = angular.copy(cityNames);
	}
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
				userId : '1',
				name : form.name.$modelValue,
				username : form.username.$modelValue,
				password : form.password.$modelValue,
				cities : form.cities.$modelValue
			}
		}).success(function(response){
			$rootScope.user = response;
		});
	}
	
});