var digantApp = angular.module('digantApp', [ 'ngRoute', 'ngMaterial',
								'ngAnimate', 'ngAria' ]);




digantApp.controller('wrmsController', function($scope, $http, $rootScope, $timeout) {
	
	
					$scope.imei = new Array();
					$scope.isLoading = true;
					$scope.tempData = new Array();
					$scope.degreeCData = new Array();
					$scope.finalDegree = new Array();
					$scope.subArrray = new Array();
					$scope.amChartsMainArray = new Array(); 
					
					
					$scope.fetchAlarmData = function() {
						$http({
							method : 'GET',
							url : '/digant/wrms/fetch/alaram/data'
						}).then(function(response) {
							$scope.alarmData = response.data;
							$scope.isLoading = false;
							$(document).ready(function() {
								
//									 $('#alarmTable').DataTable( {    
										 var table = $('#alarmTable').DataTable( {       
										        scrollX:        true,
										        scrollCollapse: true,
										        autoWidth:         true,  
										         paging:         true,       
										         "autoWidth": false,
										         "columnDefs": [
										        	    { "width": "100%", "targets": 1 }
										        	  ]

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
								/*$scope.sampleImei.push($scope.dateValue);
								$scope.tempData['date'] = $scope.sampleImei;
								$scope.degreeCData.push($scope.degreeCValue);
								$scope.tempData['degreeC'] = $scope.degreeCData;
								
								$scope.sampleImei.push($scope.dateValue);
								$scope.degreeCData.push($scope.degreeCValue);*/
									
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
							
							
							
							
							//drawChart($scope.mainArrray);
							
							
							
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
							
							/*
							 * for(var i = 0; i < $scope.deviceInfoData.length; i++){
							 * $scope.deviceInfoData[i].signal = $scope.sampleImei;
							 *  // $scope.sampleImei.push($scope.imei);
							 *  }
							 */
						}, function(error) {
							// $errHandlingService.checkStatusCode(error.status);
							console.log("error in device info")
						})
					}
				
					
					
				
					
					
					
					
			          
			         
					
				
					// $( "#tab" ).load( "/greeting.html" );
				
					/*
					 * function load_home() { document.getElementById("tab").innerHTML='<object
					 * type="text/html" data="greeting.html" ></object>'; }
					 */
				
					/*
					 * google.charts.load('current', {'packages':['gauge']});
					 * google.charts.setOnLoadCallback(drawChart);
					 * 
					 * function drawChart() {
					 * 
					 * var data = google.visualization.arrayToDataTable([ ['Label', 'Value'],
					 * ['Memory', $scope.sampleImei], ['CPU', 55], ['Network', 68] ]);
					 * 
					 * var options = { width: 400, height: 120, redFrom: 90, redTo: 100,
					 * yellowFrom:75, yellowTo: 90, minorTicks: 5 };
					 * 
					 * var chart = new
					 * google.visualization.Gauge(document.getElementById('chart_div'));
					 * 
					 * chart.draw(data, options);
					 * 
					 * setInterval(function() { data.setValue(0, 1, 40 + Math.round(60 *
					 * Math.random())); chart.draw(data, options); }, 13000);
					 * setInterval(function() { data.setValue(1, 1, 40 + Math.round(60 *
					 * Math.random())); chart.draw(data, options); }, 5000);
					 * setInterval(function() { data.setValue(2, 1, 60 + Math.round(20 *
					 * Math.random())); chart.draw(data, options); }, 26000); }
					 */

});
