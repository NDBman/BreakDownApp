breakDownApp
.controller("regController", function($scope, $http, $location, $rootScope){
	if($rootScope.user != null){
		$location.path("/");
	}
	$scope.submittedForm = false;
	$scope.emailExits = false;
	$scope.now = new Date();
	$scope.maxDate = new Date($scope.now.getFullYear()-10,$scope.now.getMonth(),$scope.now.getDate());
	$scope.birthday = $scope.maxDate;
	$scope.passwordCheck = function(){
		if($scope.password == $scope.confirmPassword){
			$scope.dontMatch = false;
		}else{
			$scope.dontMatch = true;
		}
		
	};
	$scope.submit = function (form){
		if(form.$invalid)
			return;
		if(form.password.$modelValue != form.confirmPassword.$modelValue){
			$scope.reg.confirmPassword.$setValidity("compareTo", false);
			return;
		}
		$http({
			method: "POST",
			url: "reg",
			params: {
				name: form.name.$modelValue,
				username: form.username.$modelValue,
				email: form.email.$modelValue,
				password: form.password.$modelValue,
				birthday: form.birthday.$modelValue,
				gender: form.gender.$modelValue
			}
		})
		.success(function(){
			$location.path("regsuccess");
		})
		.error(function(){
			$scope.emailExits = true;
		});
	}
	
	
	
});