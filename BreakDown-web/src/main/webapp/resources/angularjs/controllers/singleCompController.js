breakDownApp.controller('singleCompController', function($scope, $location, $http, $rootScope){
	var url = $location.url();
	var signed = false;
	
	var alreadySigned = function(){
		if($rootScope.user == null || $scope.comp == null){
			return "Jelentkezek";
		}
		for(var i = 0;i < $rootScope.user.competitions.length;i++){
			if($rootScope.user.competitions[i].id == $scope.comp.id){
				return "Lejelentkezek";
			}
		}
		return "Jelentkezek";
	};
	
	$http({
		method : 'GET',
		url : url.substr(1,url.length)
	}).success(function(response){
		
		$scope.comp = response;
		$scope.signUpToggle = alreadySigned();
		$http({
			method : 'GET',
			url : 'comp/' + response.id + '/events'
		}).success(function(response){
			$scope.events = response;
		})
	});
	
	
	
	$scope.signUpDown = function(){
		$http({
			method : 'POST',
			url : 'comp/' + $scope.comp.id + '/signup',
			params : {
				email : $rootScope.user.email
			}
		}).success(function(response){
			$rootScope.user = response;
			$scope.signUpToggle = alreadySigned();
		})
	}
	
});