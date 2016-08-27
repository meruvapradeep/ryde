'use strict';

// Configure application Module
var ryde = angular.module('ryde',[
  'ryde.controllers',
  'ryde.constants',
  'ryde.services',
  'ngRoute'

]);

// Configure routes for all views in fleetMagic application
ryde.config(
  function ($routeProvider) {
	$routeProvider
	.when('/',{
		templateUrl: 'static/partials/home.html',
		controller: 'HomeController'
	})
	.when('/home',{
		templateUrl: 'static/partials/home.html',
		controller: 'HomeController'
	})
	.when('/inventory',{
		templateUrl: 'static/partials/inventory.html',
		controller: 'InventoryController' 
	})
	.when('/customer',{
		templateUrl: 'static/partials/customer.html',
		controller: 'CustomerController' 
	})
});


