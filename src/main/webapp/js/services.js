'use strict';

var fmServiceModule = angular.module('ryde.services', []);

fmServiceModule.service('backendService', 
	function($http){
		console.log("backendService");
		
		//Sample java script function to call REStful webservice
	    this.posts = function () {
	      return $http.get('http://jsonplaceholder.typicode.com/posts');
	    };
	}
);

// Inventory service 
fmServiceModule.service('inventoryService', 
	function($resource){
		return $resource('vehicles/:id',{id:'@_id'},{
			update: {
				method: 'PUT'
			}
		});
	}
);

// Popup service
fmServiceModule.service('popupService',function($window){
		this.showPopup=function(message){
			return $window.confirm(message);
		}
	}
);