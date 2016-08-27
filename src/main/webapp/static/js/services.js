'use strict';

var fmServiceModule = angular.module('ryde.services', []);

fmServiceModule.service('backendService', 
	function($http, $rootScope){
		console.log("backendService");
		
		//Sample java script function to call REStful webservice
	    this.posts = function () {
	      return $http.get('http://jsonplaceholder.typicode.com/posts');
	    };
	}
);


