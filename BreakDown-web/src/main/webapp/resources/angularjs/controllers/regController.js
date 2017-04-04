breakDownApp
.controller("regController", function($scope, $http, $location){
	$scope.submittedForm = false;
	$scope.birthday = new Date();
	$scope.emailExits = false;
	
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