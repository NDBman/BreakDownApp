breakDownApp.controller("sideNavController", function($scope, $mdSidenav){
	$scope.toggleNav = function(){
		$mdSidenav('left')
			.toggle();
	}
	$scope.close = function(){
		$mdSidenav('left')
			.close();
	}
})