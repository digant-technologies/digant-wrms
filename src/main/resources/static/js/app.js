var digantApp = angular.module('digantApp', [ 'ngRoute', 'ngMaterial',
								'ngAnimate', 'ngAria' ]);




digantApp.controller('wrmsController', function($scope, $http, $rootScope, $timeout, $mdDialog) {
	
	
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
					
					
					
					$scope.fetchAlarmData = function() {
						$http({
							method : 'GET',
							url : '/digant/wrms/fetch/alaram/data'
						}).then(function(response) {
							$scope.alarmData = response.data;
							$scope.isLoading = false;
							$(document).ready(function() {
								
									 $('#alarmTable').DataTable( {    
										/* var table = $('#alarmTable').DataTable( {       
										        scrollX:        true,
										        scrollCollapse: true,
										        autoWidth:         true,  
										         paging:         true,       
										         "autoWidth": false,
										         "columnDefs": [
										        	    { "width": "100%", "targets": 1 }
										        	  ]*/

										    } );
										
									
								});						
						
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

								$scope.amChartsMainArray.push($scope.amMain);
								
								$scope.tempTooltip = [];
								
								$scope.subArrray.push($scope.dateValue,$scope.degreeCValue,$scope.amMain);
								$scope.mainArrray.push($scope.main);
								
							}
							$(document).ready(function() {
								$('#tempTable').DataTable({
									         
								});					
						});
							
	
							google.charts.load('current', {packages: ['corechart','bar']}); 
					         
							function drawChart(data) {
								// Define the chart to be drawn.					
								var data = new google.visualization.DataTable();
								data.addColumn( 'string', 'date');
								data.addColumn( 'number', 'degreeC');
								data.addColumn({type: 'string', role: 'tooltip'});
								 data.addRows($scope.mainArrray);
					            
					            // Set chart options
					            var options = {'title' : 'Temperature',
					            		 tooltip: {isHtml: true},
					                     legend: 'none',
					               hAxis: {
					                  title: 'Date'
					               },
					               vAxis: {
					                  title: 'DegreeC'
					               },   
					               'width':1400,
					               'height':400,
					               pointsVisible: true	  
					            };

					            // Instantiate and draw the chart.
					            $timeout(()=>{
					            	var chart = new google.visualization.ColumnChart(document.getElementById('container'));
						            chart.draw(data, options);
					            },20);
					         }
							 google.charts.setOnLoadCallback(drawChart);
							
							 
							 
							 am4core.ready(function() {

									// Themes begin
									am4core.useTheme(am4themes_animated);
									// Themes end

									// Create chart instance
									var chart = am4core.create("chartdiv", am4charts.XYChart);

									// Add data
									chart.data = $scope.amChartsMainArray;
									
									chart.dateFormatter.inputDateFormat = "yyyy-MM-dd";

									// Create axes
									var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
									var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

									// Create series
									var series = chart.series.push(new am4charts.LineSeries());
									series.dataFields.valueY = "value";
									series.dataFields.dateX = "date";
									series.tooltipText = "{value}"
									series.strokeWidth = 2;
									series.minBulletDistance = 15;

									// Drop-shaped tooltips
									series.tooltip.background.cornerRadius = 20;
									series.tooltip.background.strokeOpacity = 0;
									series.tooltip.pointerOrientation = "vertical";
									series.tooltip.label.minWidth = 40;
									series.tooltip.label.minHeight = 40;
									series.tooltip.label.textAlign = "middle";
									series.tooltip.label.textValign = "middle";

									// Make bullets grow on hover
									var bullet = series.bullets.push(new am4charts.CircleBullet());
									bullet.circle.strokeWidth = 2;
									bullet.circle.radius = 4;
									bullet.circle.fill = am4core.color("#fff");

									var bullethover = bullet.states.create("hover");
									bullethover.properties.scale = 1.3;

									// Make a panning cursor
									chart.cursor = new am4charts.XYCursor();
									chart.cursor.behavior = "panXY";
									chart.cursor.xAxis = dateAxis;
									chart.cursor.snapToSeries = series;

									// Create vertical scrollbar and place it before the value axis
									chart.scrollbarY = new am4core.Scrollbar();
									chart.scrollbarY.parent = chart.leftAxesContainer;
									chart.scrollbarY.toBack();

									// Create a horizontal scrollbar with previe and place it underneath the date axis
									chart.scrollbarX = new am4charts.XYChartScrollbar();
									chart.scrollbarX.series.push(series);
									chart.scrollbarX.parent = chart.bottomAxesContainer;

									chart.events.on("ready", function () {
									  dateAxis.zoom({start:0, end:1});
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
				
					$scope.fetchDeviceInfoData = function() {
						$http({
							method : 'GET',
							url : '/digant/wrms/fetch/deviceInfo/data'
						}).then(function(response) {
				
							$scope.deviceInfoData = response.data;
							
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
								"circleName" :$scope.circleName
								}
						}).then(function(response) { 
							$scope.imeiConfigData = response.data;
							
							$scope.selectedImei = window.sessionStorage
							.getItem('imei');
							
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
					
					$scope.updateAlarmConfig = function(){
						$http({
							method : 'POST',
							url : '/digant/wrms/alarm/config',
							data: {
								"siteId" : $scope.siteIds,
								"alarms" : $scope.alarm,
								"alarmName" : $scope.alarmName
								}
						}).then(function(response) { 
							
						}, function(error) {
							console.log("error in alarm config");
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
					
				
					$rootScope.imeiConfigDialogController = function($scope, $mdDialog){
						
				
						
					}
					
					$scope.openImeiConfigDialog = function(ev) {
						$mdDialog.show({
							controller : $rootScope.imeiConfigDialogController,
							templateUrl : '/fragment/imeiConfig.html',
							parent : angular.element(document.body),
							targetEvent : ev,
							clickOutsideToClose : true
						});
					}
					
					
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
			         
					
				
					

});
