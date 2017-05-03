breakDownApp.controller('breakerProfilController', function($scope, $http,
		$location) {
	var path = $location.url();
	$scope.userprofil;
	$http({
		method : 'GET',
		url : path.substr(1)
	}).success(function(response) {
		$scope.userprofil = response;
	})
	$http({
			method : 'GET',
			url : 'breaker/' + path.substr(7) + "/comps"
		}).success(function(response){
			$scope.comps = response;
		})
})