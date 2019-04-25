


/*digantApp
	.controller('wrmsController', 
			function($scope, $http, $timeout, $errHandlingService, $rootScope) {
		
		
		$scope.fetchAllWrmsDataBySiteId = function(siteId){
			$http({
					method: 'GET',
					url: '/digant/wrms/fetch/site/data?siteId='+siteId
				}).success(
						function(response){
							$scope.wrmsSite = response;
					
				}).error(function(error){
					$errHandlingService.checkStatusCode(error.status);
				})
		}
		
		$scope.fetchAllWrmsDataByImei = function(imeiNumber){
			$http({
					method: 'GET',
					url: '/digant/wrms/fetch/imei/data?imeiNumber='+imeiNumber
				}).success(
						function(response){
							$scope.wrmsImei = response;
					
				}).error(function(error){
					$errHandlingService.checkStatusCode(error.status);
				})
		}
		
		$scope.fetchAllWrmsDataByImei = function(){
			$http({
					method: 'GET',
					url: '/digant/wrms/fetch/all'
				}).success(
						function(response){
							$scope.wrmsAllData = response;
					
				}).error(function(error){
					$errHandlingService.checkStatusCode(error.status);
				})
		}

});
*/