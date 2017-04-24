breakDownApp.controller('logoutController',function($rootScope, $location){
	$rootScope.user = null;
	$location.path("/");
})