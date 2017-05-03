breakDownApp.controller('searchBreakersController', function($scope,$http,$location){
	$scope.breakers;
	$http({
		method : 'GET',
		url : 'breakers/all'
	}).success(function(response){
		$scope.breakers =response;
	})
	$scope.seeProfile = function(id){
		$location.path("/profil/" + id)
	}
})