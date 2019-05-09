var digantApp = angular.module('digantApp', [ 'ngRoute', 'ngMaterial',
								'ngAnimate', 'ngAria' ]);


digantApp.controller('wrmsController', 
		function($scope, $http, $rootScope, $timeout, $mdDialog) {
	
					$scope.imei = new Array();
					$scope.isLoading = true;
					$scope.tempData = new Array();
					$scope.degreeCData = new Array();
					$scope.finalDegree = new Array();
					$scope.subArrray = new Array();
					$scope.amChartsMainArray = new Array(); 
					$scope.deviceImei = '';
					$scope.siteIds = '';
					$scope.tamperSiteIds = '';
					$scope.alarmsDropDown = '';
					$scope.date = new Date();
					$scope.tempData = new Array;
					$scope.signalStrength = new Array();
					
					
					
					$scope.fetchAlarmData = function() {
						$http({
							method : 'GET',
							url : '/digant/wrms/fetch/alaram/data'
						}).then(function(response) {
							$scope.alarmData = response.data;
							$scope.isLoading = false;
											
						
						}, function(error) {
							// $errHandlingService.checkStatusCode(error.status);
							console.log("error in alarm")
							$scope.isLoading = false;
						})
					}
				
					$scope.fetchDcLoadData = function() {
						$http({
							method : 'GET',
							url : '/digant/wrms/fetch/dcload/data'
						}).then(function(response) {
							$scope.dcLoadData = response.data;
							$scope.isLoading = false;
							$(document).ready(function() {
								$('#dcloadTable').DataTable({   
									
							})
							
						});
				
						}, function(error) {
							// $errHandlingService.checkStatusCode(error.status);
							console.log("error in dc load")
							$scope.isLoading = false;
						})
					}
				
					$scope.fetchTemperatureData = function() {
						$http({
							method : 'GET',
							url : '/digant/wrms/fetch/temperature/data'
						}).then(function(response) {
							$scope.temperatureData = response.data;
							$scope.isLoading = false;
							$scope.mainArrray = [];
							for(var i= 0; i < $scope.temperatureData.length; i++){
								$scope.dateValue = $scope.temperatureData[i].insertTime;
								$scope.degreeCValue = $scope.temperatureData[i].degreeC;
								$scope.imei = $scope.temperatureData[i].imei;
				
								$scope.main = [$scope.dateValue,$scope.degreeCValue,$scope.imei];
							
								$scope.amMain = {}
								$scope.amMain ["date"] = $scope.dateValue;
								$scope.amMain ["value"] = $scope.degreeCValue;
								
								$scope.tempData.push($scope.degreeCValue);
								
								$scope.amChartsMainArray.push($scope.amMain);
								
								$scope.tempTooltip = [];
								
								$scope.subArrray.push($scope.dateValue,$scope.degreeCValue,$scope.amMain);
								$scope.mainArrray.push($scope.main);
								
							}
							$(document).ready(function() {
								$('#tempTable').DataTable({
									         
								});					
						});
						}, function(error) {
							// $errHandlingService.checkStatusCode(error.status);
							console.log("error in temperature")
							$scope.isLoading = false;
						})
					}					
				
					$scope.fetchDeviceConfigData = function() {
						$http({
							method : 'GET',
							url : '/digant/wrms/fetch/deviceConfig/data'
						}).then(function(response) {
							$scope.deviceConfigData = response.data;
				
						}, function(error) {
							// $errHandlingService.checkStatusCode(error.status);
							console.log("error in device config")
						})
					}
				
					$scope.fetchFullSIteInfo = function(){
						$http({
							method : 'GET',
							url : '/digant/wrms/fetch/siteInfo',
						}).then(function(response) { 
							$scope.fullSiteInfo = response.data;
							$(document).ready(function() {
								 $('#alarmTable').DataTable( {   
									 
								 } );
								
							});		
						}, function(error) {
							console.log("error in tamper config");
						})
					}
					
					
					$scope.fetchDeviceInfoData = function() {
						$http({
							method : 'GET',
							url : '/digant/wrms/fetch/deviceInfo/data'
						}).then(function(response) {
				
							$scope.deviceInfoData = response.data;
							for(var i = 0; i < $scope.deviceInfoData.length ; i++){
								$scope.deviceInfoData[i].signal = $scope.signalStrength;
								$scope.signalStrength.push($scope.signalStrength);
							}
							
						}, function(error) {
							// $errHandlingService.checkStatusCode(error.status);
							console.log("error in device info")
						})
					}
			
					$scope.updateImeiConfig = function(){
						$http({
							method : 'POST',
							url : '/digant/wrms/imei/config',
							data: {
								"imei" : $scope.deviceImei,
								"siteId" : $scope.siteId,
								"siteName" : $scope.sitename,
								"circleName" : $scope.circleName								
								}
						}).then(function(response) { 
							$scope.imeiConfigData = response.data;
							
						}, function(error) {
							console.log("error in imei config");
						})
					}
					
					$scope.fetchSiteIds = function(){
						$http({
							method : 'GET',
							url : '/digant/wrms/fetch/siteId'
						}).then(function(response) {
							$scope.siteIdsData = response.data;
							
						}, function(error) {
							console.log("error in fetching siteIds");
						})
					}
					
					$scope.updateTamperConfig = function(){
						$http({
							method : 'POST',
							url : '/digant/wrms/alarm/config',
							data: {
								"siteId" : $scope.tamperSiteIds,
								"alaramName" : $scope.tamperAlarmName
								
								}
						}).then(function(response) { 
													
						}, function(error) {
							console.log("error in tamper config");
						})
					}
											
					  $scope.hide = function() {
					      $mdDialog.hide();
					    };

					    $scope.cancel = function() {
					      $mdDialog.cancel();
					    };
					
					    $scope.confirmConfiguration = function(progressItem){
							var confirm = $mdDialog.confirm()
					        .title('Alert')
					        .textContent('Do you really want to save ?')
					        .ok('yes')
					        .cancel('no');
							$mdDialog.show(confirm).then(function() {
								$scope.updateImeiConfig();
								return  true;
							}, function() {
								
								return false;
							});
							
						}
					
					
					$rootScope.openImeiConfigDialog = function(ev) {
						$mdDialog.show({
							controller : $rootScope.imeiConfigDialogController,
							templateUrl : '/fragment/imeiConfig.html',
							parent : angular.element(document.body),
							targetEvent : ev,
							clickOutsideToClose : true
						});
					}
				
					$rootScope.imeiConfigDialogController = function($scope, $rootScope,$mdDialog){
						
						
					}
					
					
					
					
					
			         
	
});
