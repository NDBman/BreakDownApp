breakDownApp.directive("compareTo", [function(){
	return {
		require: "ngModel",
		scope: {
			otherValue: "=compareTo"
		},
		restrict: "A",
		link: function(scope,element, attributes, ngModel){
			ngModel.$validators.compareTo = function(modelValue){
				return modelValue == scope.otherValue.$modelValue;
			}
		} 
	}
}])